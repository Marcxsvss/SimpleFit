package com.simplefit.data.mocks

import javax.inject.Inject

class UsuarioRutinaDaoMock @Inject constructor() {
    private var usuarioRutina = mutableListOf(
        UsuarioRutinaMock(
            userid = "marcos@gmail.com",
            rutinaid = 1
        ),
        UsuarioRutinaMock(
            userid = "marcos@gmail.com",
            rutinaid = 2


        ),
        UsuarioRutinaMock(
            userid = "marcos@gmail.com",
            rutinaid = 3


        )
    )
    fun get(): MutableList<UsuarioRutinaMock> = usuarioRutina
    fun get(userid: String): MutableList<UsuarioRutinaMock> = usuarioRutina

}



