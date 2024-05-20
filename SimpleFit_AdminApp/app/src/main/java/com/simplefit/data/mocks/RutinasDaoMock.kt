package com.simplefit.data.mocks

import com.pmdm.recetas.data.mocks.UsuarioMock
import javax.inject.Inject

class RutinasDaoMock @Inject constructor() {
    private var rutinas = mutableListOf(
        RutinasMock(
            rutinaid = 2,
            titulo = "Bro Split",
            descripcion = "Se enfoca en un grupo muscular específico cada día.",
            frecuencia = 5,
            diasDescanso = 2,
            dificultad = "Avanzada"
        ),

        RutinasMock(
            rutinaid = 3,
            titulo = "5x5",
            descripcion = "Se centra en realizar 5 series de 5 repeticiones de ejercicios compuestos pesados.",
            frecuencia = 3,
            diasDescanso = 4,
            dificultad = "Intermedia"
        ),

        RutinasMock(
            rutinaid = 4,
            titulo = "PHAT",
            descripcion = "Combina entrenamiento de potencia y entrenamiento de hipertrofia.",
            frecuencia = 5,
            diasDescanso = 2,
            dificultad = "Avanzada"
        ),

        RutinasMock(
            rutinaid = 5,
            titulo = "PHUL",
            descripcion = "Similar a PHAT, pero se divide en entrenamientos de potencia y hipertrofia para la parte superior e inferior del cuerpo.",
            frecuencia = 4,
            diasDescanso = 3,
            dificultad = "Avanzada"
        ),

        RutinasMock(
            rutinaid = 6,
            titulo = "FST-7",
            descripcion = "Se centra en estirar la fascia muscular para promover el crecimiento muscular.",
            frecuencia = 5,
            diasDescanso = 2,
            dificultad = "Avanzada"
        ),

        RutinasMock(
            rutinaid = 7,
            titulo = "GVT",
            descripcion = "Implica hacer 10 series de 10 repeticiones para un ejercicio específico.",
            frecuencia = 3,
            diasDescanso = 4,
            dificultad = "Avanzada"
        ),

        RutinasMock(
            rutinaid = 9,
            titulo = "Full Body Workout",
            descripcion = "Rutina para entrenar todo el cuerpo en cada sesión",
            frecuencia = 3,
            diasDescanso = 2,
            dificultad = "Principiante"
        ),

        RutinasMock(
            rutinaid = 10,
            titulo = "Split Routine",
            descripcion = "Es una forma común de dividir los grupos musculares a lo largo de la semana para darles tiempo para recuperarse y permitir un entrenamiento enfocado para cada grupo muscular.",
            frecuencia = 4,
            diasDescanso = 3,
            dificultad = "Intermedio"
        )

    )

    fun get(): MutableList<RutinasMock> = rutinas
    fun get(userid: String): MutableList<RutinasMock> = rutinas
    fun get(rutinaid: Int): RutinasMock? = rutinas.find { u -> u.rutinaid == rutinaid }
    fun update(rutina: RutinasMock) {
        val position = rutinas.indexOf(get(rutina.rutinaid))
        rutinas[position] = rutina
    }
}
