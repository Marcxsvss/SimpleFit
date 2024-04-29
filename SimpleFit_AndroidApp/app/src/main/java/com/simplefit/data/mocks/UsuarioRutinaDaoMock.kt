package com.simplefit.data.mocks

import javax.inject.Inject

class UsuarioRutinaDaoMock @Inject constructor() {
    private var usuarioRutina = mutableListOf(
        UsuarioRutinaMock(
            userid = "marcos@gmail.com",
            rutinaid = 1,
            nombre = "Rutina 1",

        ),
        UsuarioRutinaMock(
            userid = "marcos@gmail.com",
            rutinaid = 2,
            nombre = "Rutina 2",

        ),
        UsuarioRutinaMock(
            userid = "marcos@gmail.com",
            rutinaid = 3,
            nombre = "Rutina 3",

        )
    )

    fun get(): MutableList<UsuarioRutinaMock> = usuarioRutina
    fun get(userid: String): MutableList<UsuarioRutinaMock> = usuarioRutina
//    fun get(rutinaid: Int): RutinasMock? = rutinas.find { u -> u.rutinaid == rutinaid }
//    fun update(rutina: RutinasMock) {
//        val position = rutinas.indexOf(get(rutina.rutinaid))
//        rutinas[position] = rutina
//    }
}



