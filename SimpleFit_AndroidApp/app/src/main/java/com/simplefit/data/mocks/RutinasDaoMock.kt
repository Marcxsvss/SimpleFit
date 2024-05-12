package com.simplefit.data.mocks

import com.pmdm.recetas.data.mocks.UsuarioMock
import javax.inject.Inject

class RutinasDaoMock @Inject constructor(){
    private var rutinas = mutableListOf(
        RutinasMock(
            rutinaid = 1,
            titulo = "Split Routine",
            descripcion = "Es una forma común de dividir los grupos musculares a lo largo de la semana para darles tiempo para recuperarse y permitir un entrenamiento enfocado para cada grupo muscular. ",
            frecuencia = 1,
            diasdescanso = 3,
            dificultad = "Intermedio"
        ),
        RutinasMock(
            rutinaid = 2,
            titulo = "BÁSICA COMPLETA",
            descripcion = "Rutina de intermedios",
            frecuencia = 2,
            diasdescanso = 2,
            dificultad = "Principiante"
        ),
        RutinasMock(
            rutinaid = 3,
            titulo = "BÁSICO COMPLETO",
            descripcion = "Rutina de avanzados",
            frecuencia = 1,
            diasdescanso = 1,
            dificultad = "Avanzado"
        ),

    )

    fun get(): MutableList<RutinasMock> = rutinas
    fun get(userid: String): MutableList<RutinasMock> = rutinas
    fun get(rutinaid: Int): RutinasMock? = rutinas.find { u -> u.rutinaid == rutinaid }
    fun update(rutina: RutinasMock) {
        val position = rutinas.indexOf(get(rutina.rutinaid))
        rutinas[position] = rutina
    }
}
