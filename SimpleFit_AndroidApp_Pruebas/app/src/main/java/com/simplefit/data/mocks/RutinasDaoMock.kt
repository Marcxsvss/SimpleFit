package com.simplefit.data.mocks

import com.pmdm.recetas.data.mocks.UsuarioMock
import javax.inject.Inject

class RutinasDaoMock @Inject constructor(){
    private var rutinas = mutableListOf(
        RutinasMock(
            rutinaid = 1,
            userid = "marcos@gmail.com",
            titulo = "Rutina 1",
            descripcion = "Rutina de principiantes",
            objetivo = "Definicion",
            frecuencia = 1,
        ),
        RutinasMock(
            rutinaid = 2,
            userid = "marcos@gmail.com",
            titulo = "Rutina 2",
            descripcion = "Rutina de intermedios",
            objetivo = "Hipertrofia",
            frecuencia = 2,
        ),
        RutinasMock(
            rutinaid = 3,
            userid = "marcos@gmail.com",
            titulo = "Rutina 3",
            descripcion = "Rutina de avanzados",
            objetivo = "Mantenimiento",
            frecuencia = 1,
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
