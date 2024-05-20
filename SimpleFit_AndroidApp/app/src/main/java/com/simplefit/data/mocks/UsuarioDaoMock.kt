package com.pmdm.recetas.data.mocks

import javax.inject.Inject

class UsuarioDaoMock @Inject constructor() {
    private var users = mutableListOf(
        UsuarioMock(
            email = "marcos@gmail.com",
            password = "12345678",
            nombre = "marcos",
            altura = "184",
            peso = "84",
            edad = "16-28",
            sexo = "Masculino",
            somatotipo = "ectomorfo",
            rutinaState = 2,
            cargo = 1
        ),
        UsuarioMock(
            email = "ana@hotmail.com",
            password = "password123",
            nombre = "Ana",
            altura = "165",
            peso = "60",
            edad = "18-30",
            sexo = "Femenino",
            somatotipo = "mesomorfo",
            rutinaState = 1,
            cargo = 2
        ),
        UsuarioMock(
            email = "pablo@yahoo.com",
            password = "mypassword",
            nombre = "Pablo",
            altura = "175",
            peso = "78",
            edad = "20-32",
            sexo = "Masculino",
            somatotipo = "endomorfo",
            rutinaState = 3,
            cargo = 1
        ),

        UsuarioMock(
            email = "maria@gmail.com",
            password = "maria1234",
            nombre = "Maria",
            altura = "170",
            peso = "65",
            edad = "22-34",
            sexo = "Femenino",
            somatotipo = "ectomorfo",
            rutinaState = 2,
            cargo = 3
        ),

        UsuarioMock(
            email = "carlos@gmail.com",
            password = "carlos987",
            nombre = "Carlos",
            altura = "180",
            peso = "80",
            edad = "24-36",
            sexo = "Masculino",
            somatotipo = "mesomorfo",
            rutinaState = 1,
            cargo = 2
        ),

        UsuarioMock(
            email = "luisa@yahoo.com",
            password = "luisa456",
            nombre = "Luisa",
            altura = "160",
            peso = "55",
            edad = "26-38",
            sexo = "Femenino",
            somatotipo = "endomorfo",
            rutinaState = 3,
            cargo = 1
        ),

        UsuarioMock(
            email = "pedro@hotmail.com",
            password = "pedro123",
            nombre = "Pedro",
            altura = "185",
            peso = "90",
            edad = "28-40",
            sexo = "Masculino",
            somatotipo = "ectomorfo",
            rutinaState = 2,
            cargo = 3
        ),

        UsuarioMock(
            email = "sofia@gmail.com",
            password = "sofia789",
            nombre = "Sofia",
            altura = "175",
            peso = "68",
            edad = "18-30",
            sexo = "Femenino",
            somatotipo = "mesomorfo",
            rutinaState = 1,
            cargo = 2
        ),

        UsuarioMock(
            email = "juan@yahoo.com",
            password = "juan321",
            nombre = "Juan",
            altura = "170",
            peso = "75",
            edad = "20-32",
            sexo = "Masculino",
            somatotipo = "endomorfo",
            rutinaState = 3,
            cargo = 1
        ),

        UsuarioMock(
            email = "laura@hotmail.com",
            password = "laura654",
            nombre = "Laura",
            altura = "168",
            peso = "62",
            edad = "22-34",
            sexo = "Femenino",
            somatotipo = "ectomorfo",
            rutinaState = 2,
            cargo = 3
        ),

        UsuarioMock(
            email = "andres@gmail.com",
            password = "andres987",
            nombre = "Andres",
            altura = "178",
            peso = "85",
            edad = "24-36",
            sexo = "Masculino",
            somatotipo = "mesomorfo",
            rutinaState = 1,
            cargo = 2
        )
    )

    fun get(): MutableList<UsuarioMock> = users
    fun get(email: String): UsuarioMock? = users.find { u -> u.email == email }
    fun update(user: UsuarioMock) {
        val position = users.indexOf(get(user.email))
        users[position] = user
    }
}