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
            cargo = 1,
            foto = "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6HqfAet//9oADAMBAAIAAwAAABD777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777rHl3r777777777777777777777777777777G73337n777777777777777777777777777717333336377777777777777777777777777r733333329v7777777777777777777777776X333333330z7777777777777777777777775z333333332r7777777777777777777777777z333333333x7777777777777777777777777T3333333335b777777777777777777777777T333333333p77777777777777777777777743333333333b7777777777777777777777777773333333if777777777777777777777777763733333rz77777777777777777777777777747XTz6h3777777777777777777777777777777757777777777777777777777777777777777/3nXf77777777777777777777777777777Q7//AM8/e8z+++++++++++++++++++++++6l/wDfffffffff7dvvvvvvvvvvvvvvvvvvvvurPPfffffffffffXu/vvvvvvvvvvvvvvvvvvvPffffffffffffffXvvvvvvvvvvvvvvvvvvlfvfffffffffffffffTtvvvvvvvvvvvvvvvqPvfffffffffffffffffefvvvvvvvvvvvvvvpvffffffffffffffffffevvvvvvvvvvvvvvqPvfffffffffffffffffffVfvvvvvvvvvvvvrffffffffffff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"
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
            rutinaState = 9,
            cargo = 2,
            foto = null
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
            cargo = 1,
            foto = null
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
            cargo = 3,
            foto = null
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
            rutinaState = 7,
            cargo = 2,
            foto = null
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
            cargo = 1,
            foto = null
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
            cargo = 3,
            foto = null
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
            rutinaState = 5,
            cargo = 2,
            foto = null
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
            cargo = 1,
            foto = null
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
            cargo = 3,
            foto = null
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
            rutinaState = 2,
            cargo = 2,
            foto = null
        )
    )

    fun get(): MutableList<UsuarioMock> = users
    fun get(email: String): UsuarioMock? = users.find { u -> u.email == email }
    fun update(user: UsuarioMock) {
        val position = users.indexOf(get(user.email))
        users[position] = user
    }
}