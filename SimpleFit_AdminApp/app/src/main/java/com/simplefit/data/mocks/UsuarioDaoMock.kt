package com.pmdm.recetas.data.mocks

import javax.inject.Inject

class UsuarioDaoMock @Inject constructor() {
    private var users = mutableListOf(
        UsuarioMock(
            email = "marcos@gmail.com",
            dni = "12323544Y",
            password = "12345678",
            nombre = "marcos",
            altura = "184",
            peso = "84",
            edad = "16-28",
            sexo = "Masculino",
            somatotipo = "ectomorfo",
            rutinaState = 2
        ),
    )

    fun get(): MutableList<UsuarioMock> = users
    fun get(email: String): UsuarioMock? = users.find { u -> u.email == email }
    fun update(user: UsuarioMock) {
        val position = users.indexOf(get(user.email))
        users[position] = user
    }
}