//package com.kinoyamboladmin.ui.features.movieform
//
//import android.util.Log
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.kinoyamboladmin.R
//import com.kinoyamboladmin.data.GenderRepository
//import com.kinoyamboladmin.data.LanguageRepository
//import com.kinoyamboladmin.data.MovieRepository
//import com.kinoyamboladmin.data.ScheduleRepository
//import com.kinoyamboladmin.data.services.storage.StorageServiceImplementation
//import com.kinoyamboladmin.models.Language
//import com.kinoyamboladmin.models.Movie
//import com.kinoyamboladmin.models.Schedule
//import com.kinoyamboladmin.ui.features.GenderUiState
//import com.kinoyamboladmin.ui.features.ScheduleUiState
//import com.kinoyamboladmin.ui.features.toGenderUiState
//import com.kinoyamboladmin.ui.features.toScheduleUiState
//import com.kinoyamboladmin.utilities.error_handling.InformationStateUiState
//import com.kinoyamboladmin.utilities.texts.UiText
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
//import java.time.LocalDate
//import java.time.LocalTime
//import javax.inject.Inject
//import kotlin.properties.Delegates
//
//@HiltViewModel
//class MovieFormViewModel @Inject constructor(
//    private val movieRepository: MovieRepository,
//    private val genderRepository: GenderRepository,
//    private val languageRepository: LanguageRepository,
//    private val movieValidator: MovieValidator,
//    private val scheduleRepository: ScheduleRepository,
//    private val storageService: StorageServiceImplementation
//) : ViewModel() {
//    class MovieViewModelException(message: String) : Exception(message)
//
//    private var editingContactExistingState: Boolean = false
//    var genreList: List<GenderUiState> by mutableStateOf(emptyList())
//    var movieState: MovieUiState by mutableStateOf(MovieUiState())
//        private set
//    private var movieStateObserver: MovieUiState by Delegates.observable(MovieUiState()) { _, oldValue, newValue ->
//        movieState = newValue.copy(
//            selectedSchedule = newValue.schedules
//                .filter { it.language.name == newValue.selectedLanguage }
//                .flatMap { schedule ->
//                    schedule.movieSchedule.toList()
//                }
//                .sortedBy { it.first }
//        )
//    }
//    var isSaving: Boolean by mutableStateOf(false)
//        private set
//    var movieValidationState by mutableStateOf(MovieValidationUiState())
//        private set
//    var showDatePickerDialogState by mutableStateOf(false)
//        private set
//    var showTimePickerDialogState by mutableStateOf(false)
//        private set
//    var showInformationErrorScheduleDialogState by mutableStateOf(false)
//        private set
//    var informationState: InformationStateUiState by mutableStateOf(InformationStateUiState.Hidden())
//        private set
//
//    init {
//        loadGenders()
//        if (!editingContactExistingState) initializeNewMovie() // When you create a new Movie
//    }
//
//    private fun clearState() {
//        movieStateObserver = MovieUiState()
//        movieValidationState = MovieValidationUiState()
//        showDatePickerDialogState = false
//        showTimePickerDialogState = false
//        showInformationErrorScheduleDialogState = false
//    }
//
//    private fun initializeNewMovie() {
//        viewModelScope.launch {
//            val languages: List<Language> = languageRepository.get()
//            val schedules: List<Schedule> = languages.map { language ->
//                Schedule(
//                    id = LocalTime.now().toString(),
//                    language = language,
//                    movieSchedule = hashMapOf()
//                )
//            }
//            movieStateObserver = movieStateObserver.copy(
//                schedules = schedules.map { it.toScheduleUiState() },
//                selectedLanguage = schedules.first().language.name
//            )
//        }
//    }
//
//    fun setMovie(movieId: String) {
//        viewModelScope.launch {
//            val movie: Movie = movieRepository.get(movieId)
//                ?: throw MovieViewModelException("Movie not found with id: $movieId")
//            movieStateObserver = movie.toMovieUiState()
//            movieValidationState = movieValidator.validate(movieStateObserver)
//        }
//        editingContactExistingState = true
//    }
//
//    private suspend fun getGenders(): List<GenderUiState> =
//        genderRepository.get().map { it.toGenderUiState() }
//
//    private fun loadGenders() {
//        viewModelScope.launch {
//            genreList = getGenders()
//        }
//    }
//
//    private fun canChangeSchedules(): Boolean =
//        (movieStateObserver.schedules.all { it.movieSchedule.size <= 1 } && editingContactExistingState) || !editingContactExistingState
//
//    private fun onConfirmDateDialog(date: LocalDate) {
//        val newSchedules: MutableList<ScheduleUiState> = movieStateObserver.schedules.toMutableList()
//        val newSchedule: ScheduleUiState =
//            newSchedules.find { it.language.name == movieStateObserver.selectedLanguage }
//                ?: throw MovieViewModelException("Didn't find the selected language")
//        val indexSchedule: Int = newSchedules.indexOf(newSchedule)
//
//        if (movieStateObserver.selectedDate == null) {
//            // Save new date in the schedule
//            newSchedule.movieSchedule[date] = emptyList()
//        } else {
//            // Modified existing date in the schedule
//            newSchedule.movieSchedule[date] = newSchedule.movieSchedule[movieStateObserver.selectedDate]!!
//            newSchedule.movieSchedule.remove(movieStateObserver.selectedDate!!)
//        }
//        newSchedules[indexSchedule] = newSchedule
//        movieStateObserver = movieStateObserver.copy(schedules = newSchedules, selectedDate = date)
//        movieValidationState = movieValidationState.copy(
//            scheduleValidation = movieValidator.scheduleValidator.validate(movieStateObserver.schedules)
//        )
//    }
//
//    private fun onRemoveDate() {
//        val newSchedules: MutableList<ScheduleUiState> = movieStateObserver.schedules.toMutableList()
//        val newSchedule: ScheduleUiState =
//            newSchedules.find { it.language.name == movieStateObserver.selectedLanguage }
//                ?: throw MovieViewModelException("Didn't find the selected language")
//        val index: Int = newSchedules.indexOf(newSchedule)
//
//        movieStateObserver.selectedDate?.let {
//            newSchedule.movieSchedule.remove(movieStateObserver.selectedDate!!)
//            newSchedules[index] = newSchedule
//            movieStateObserver = movieStateObserver.copy(schedules = newSchedules, selectedDate = null)
//        }
//    }
//
//    private fun onConfirmHourDialog(hour: LocalTime) {
//        val newSchedules: MutableList<ScheduleUiState> = movieStateObserver.schedules.toMutableList()
//        val newSchedule: ScheduleUiState =
//            newSchedules.find { it.language.name == movieStateObserver.selectedLanguage }
//                ?: throw MovieViewModelException("Didn't find the selected language")
//        val indexSchedule: Int = newSchedules.indexOf(newSchedule)
//        val newHours: MutableList<LocalTime> =
//            newSchedule.movieSchedule[movieStateObserver.selectedDate!!]?.toMutableList() ?: mutableListOf()
//
//        if (movieStateObserver.selectedHour != null) newHours.remove(movieStateObserver.selectedHour)
//        newHours.add(hour)
//        newSchedule.movieSchedule[movieStateObserver.selectedDate!!] = newHours
//        newSchedules[indexSchedule] = newSchedule
//        movieStateObserver = movieStateObserver.copy(schedules = newSchedules, selectedHour = hour)
//    }
//
//    private fun onRemoveHour() {
//        val newSchedules: MutableList<ScheduleUiState> = movieStateObserver.schedules.toMutableList()
//        val newSchedule: ScheduleUiState =
//            newSchedules.find { it.language.name == movieStateObserver.selectedLanguage }
//                ?: throw MovieViewModelException("Didn't find the selected language")
//        val indexSchedule: Int = newSchedules.indexOf(newSchedule)
//
//        movieStateObserver.selectedDate?.let {
//            val newHours: MutableList<LocalTime> =
//                newSchedule.movieSchedule[movieStateObserver.selectedDate!!]?.toMutableList()
//                    ?: mutableListOf()
//
//            newHours.remove(movieStateObserver.selectedHour)
//            newSchedule.movieSchedule[movieStateObserver.selectedDate!!] = newHours
//            newSchedules[indexSchedule] = newSchedule
//            movieStateObserver = movieStateObserver.copy(schedules = newSchedules, selectedHour = null)
//        }
//    }
//
//    private suspend fun uploadImages(movie: Movie) {
//        storageService.uploadImage(movie.image)
//        movie.lettersImage?.let {
//            storageService.uploadImage(it)
//        }
//    }
//
//    private suspend fun updateOrInsertMovie(movie: Movie) {
//        if (editingContactExistingState) {
//            movieRepository.update(movie)
//            scheduleRepository.update(movie.schedules)
//        } else {
//            movieRepository.insert(movie)
//            scheduleRepository.insert(movie.schedules)
//        }
//    }
//
//    private fun onSaveMovie() {
//        val movieValidationState = movieValidator.validate(movieStateObserver)
//
//        if (!movieValidationState.hasError) {
//            viewModelScope.launch {
//                isSaving = true
//                var movie: Movie = if (editingContactExistingState) movieStateObserver.toMovie() else movieStateObserver.toMovie().copy(id = LocalTime.now().toString())
//
//                uploadImages(movie)
//                movie = movie.copy(
//                    image = if(!storageService.existsImage(movie.image)) storageService.downloadImage(movie.image)!! else movie.image,
//                    lettersImage = if(movie.lettersImage != null && !storageService.existsImage(movie.lettersImage!!)) storageService.downloadImage(movie.lettersImage!!) else movie.lettersImage
//                )
//                updateOrInsertMovie(movie)
//                informationState = InformationStateUiState.Success(
//                    message = UiText.StringResource(R.string.movie_saved)
//                )
//                if(!editingContactExistingState) clearState()
//                isSaving = false
//            }
//        } else {
//            informationState = InformationStateUiState.Error(
//                message = movieValidationState.errorMessage!!,
//                onDismiss = { informationState = InformationStateUiState.Hidden() }
//            )
//            Log.e(
//                "MovieFormViewModel",
//                "Error saving movie: ${movieValidationState.errorMessage}"
//            )
//        }
//    }
//
//    fun onMovieFormEvent(event: MovieFormEvent) {
//        when (event) {
//            is MovieFormEvent.OnChangeFrontPage -> {
//                movieStateObserver = movieStateObserver.copy(image = event.image)
//            }
//
//            is MovieFormEvent.OnChangeLettersImage -> {
//                movieStateObserver = movieStateObserver.copy(lettersImage = event.image)
//            }
//
//            is MovieFormEvent.OnChangeName -> {
//                movieStateObserver = movieStateObserver.copy(name = event.name)
//                movieValidationState = movieValidationState.copy(
//                    nameValidation = movieValidator.nameValidator.validate(event.name)
//                )
//            }
//
//            is MovieFormEvent.OnChangeDescription -> {
//                movieStateObserver = movieStateObserver.copy(description = event.description)
//                movieValidationState = movieValidationState.copy(
//                    validationDescription = movieValidator.validatorDescription.validate(event.description)
//                )
//            }
//
//            is MovieFormEvent.OnChangeGenders -> {
//                val newGenders: MutableList<GenderUiState> = movieStateObserver.genders.toMutableList()
//                if (newGenders.find { it.id == event.gender.id } != null) newGenders.remove(event.gender) else newGenders.add(
//                    event.gender
//                )
//                movieStateObserver = movieStateObserver.copy(genders = newGenders)
//                movieValidationState = movieValidationState.copy(
//                    gendersValidation = movieValidator.gendersValidator.validate(
//                        movieStateObserver.genders.joinToString("") { it.name.toString() }
//                    )
//                )
//            }
//
//            is MovieFormEvent.OnChangeTrailerLink -> {
//                movieStateObserver = movieStateObserver.copy(trailerLink = event.trailerLink)
//                movieValidationState = movieValidationState.copy(
//                    trailerValidation = movieValidator.trailerValidator.validate(event.trailerLink)
//                )
//            }
//
//            is MovieFormEvent.OnChangePrice -> {
//                movieStateObserver = movieStateObserver.copy(price = event.price)
//                movieValidationState = movieValidationState.copy(
//                    priceValidation = movieValidator.priceValidator.validate(event.price)
//                )
//            }
//
//            is MovieFormEvent.OnChangeLanguage -> {
//                movieStateObserver = movieStateObserver.copy(
//                    selectedLanguage = event.language,
//                    selectedDate = null,
//                    selectedHour = null
//                )
//            }
//
//            is MovieFormEvent.OnChangeDuration -> {
//                movieStateObserver = movieStateObserver.copy(duration = event.duration)
//                movieValidationState = movieValidationState.copy(
//                    durationValidation = movieValidator.durationValidator.validate(event.duration)
//                )
//            }
//
//            is MovieFormEvent.OnChangeDate -> {
//                movieStateObserver = movieStateObserver.copy(
//                    selectedDate = if (movieStateObserver.selectedDate == event.date) null else event.date,
//                    selectedHour = null
//                )
//            }
//
//            is MovieFormEvent.OnShowDialogDate -> {
//                // Can change schedules if the movie is new or all schedules have only one date and you can add new dates in any moment
//                if (canChangeSchedules() || !event.isEditing) {
//                    showDatePickerDialogState = true
//                } else {
//                    showInformationErrorScheduleDialogState = true
//                }
//            }
//
//            is MovieFormEvent.OnDismissDialogDate -> {
//                showDatePickerDialogState = false
//            }
//
//            is MovieFormEvent.OnConfirmDateDialog -> {
//                onConfirmDateDialog(event.date)
//            }
//
//            is MovieFormEvent.OnRemoveDate -> {
//                if (canChangeSchedules()) {
//                    onRemoveDate()
//                } else {
//                    showInformationErrorScheduleDialogState = true
//                }
//            }
//
//            is MovieFormEvent.OnChangeHour -> {
//                movieStateObserver =
//                    movieStateObserver.copy(selectedHour = if (movieStateObserver.selectedHour == event.hour) null else event.hour)
//            }
//
//            is MovieFormEvent.OnShowDialogHour -> {
//                if (canChangeSchedules() || !event.isEditing) {
//                    showTimePickerDialogState = true
//                } else {
//                    showInformationErrorScheduleDialogState = true
//                }
//            }
//
//            is MovieFormEvent.OnDismissDialogHour -> {
//                showTimePickerDialogState = false
//            }
//
//            is MovieFormEvent.OnRemoveHour -> {
//                if (canChangeSchedules()) {
//                    onRemoveHour()
//                } else {
//                    showInformationErrorScheduleDialogState = true
//                }
//            }
//
//            is MovieFormEvent.OnConfirmHourDialog -> {
//                onConfirmHourDialog(event.hour)
//            }
//
//            is MovieFormEvent.OnShowErrorDialog -> {
//                showInformationErrorScheduleDialogState = !showInformationErrorScheduleDialogState
//            }
//
//            is MovieFormEvent.OnSaveMovie -> {
//                onSaveMovie()
//            }
//        }
//    }
//}