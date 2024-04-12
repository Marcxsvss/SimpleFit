package com.simplefit.data.mocks

import com.pmdm.recetas.data.mocks.UsuarioMock
import javax.inject.Inject

class RutinasDaoMock @Inject constructor(){
    private var rutinas = mutableListOf(
        RutinasMock(
            id = 1,
            titulo = "Rutina 1",
            descripcion = "Rutina de principiantes",
            objetivo = "Perdida de peso",
            frecuencia = 1,
        ),
        RutinasMock(
            id = 2,
            titulo = "Rutina 2",
            descripcion = "Rutina de intermedios",
            objetivo = "Hipertrofia",
            frecuencia = 2,
        ),
        RutinasMock(
            id = 3,
            titulo = "Rutina 3",
            descripcion = "Rutina de avanzados",
            objetivo = "Mantenimiento",
            frecuencia = 1,
        ),

    )

    fun get(): MutableList<RutinasMock> = rutinas
    fun get(id: Int): RutinasMock? = rutinas.find { u -> u.id == id }
    fun update(rutina: RutinasMock) {
        val position = rutinas.indexOf(get(rutina.id))
        rutinas[position] = rutina
    }
}
