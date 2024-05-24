package com.simplefit.data.mocks

import javax.inject.Inject

class ConsejosDaoMock@Inject constructor() {

    private var listaConsejos = mutableListOf(
        ConsejosMock(1, "Para hipertrofia, es necesario realizar ejercicios de fuerza con un peso que te permita hacer entre 8 y 12 repeticiones"),
        ConsejosMock(2, "En definicion, tu rendimiento bajará, pero no te preocupes, es normal"),
        ConsejosMock(3, "La intensidad también es importante, no solo el volumen de entrenamiento"),
        ConsejosMock(4, "Haz de 3-4 ejercicios por músculo, más, producirán sobreentrenamiento no crecimiento"),
        ConsejosMock(5, "Prioriza la técnica antes que el peso, podrías lesionarte"),
        ConsejosMock(6, "Si tienes molestias con un ejercicio, baja el peso o cambia de ejercicio"),
        ConsejosMock(7, "Descansa entre 1-2 minutos entre series, más, no permitirá que tu músculo se recupere"),
        ConsejosMock(8, "La comida y el sueño es lo más importante para el crecimiento y la recuperación muscular"),
        ConsejosMock(9, "La ingesta de cabohidratos es importante para tener energía en tus entrenamientos"),
        ConsejosMock(10, "Utiliza nuestras rutinas para tener un entrenamiento completo y equilibrado")
    )
    fun get(): MutableList<ConsejosMock> = listaConsejos
}
