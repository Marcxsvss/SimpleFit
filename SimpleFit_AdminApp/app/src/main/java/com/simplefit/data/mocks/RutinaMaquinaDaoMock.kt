package com.simplefit.data.mocks

import javax.inject.Inject

class RutinaMaquinaDaoMock @Inject constructor() {
    private var rutinasMaquinas = mutableListOf(
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 2,
            dia = "J"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 3,
            dia = "J"

        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 6,
            dia = "J"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 10,
            dia = "M"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 12,
            "M"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 7,
            "M"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 14,
            "L"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 15,
            "L"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 17,
            "L"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 18,
            "L"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 19,
            "L"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 21,
            "J"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 22,
            "J"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 25,
            "M"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 26,
            "M"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 27,
            "X"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 30,
            "X"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 33,
            "X"
        ),



    )

    fun get(): MutableList<RutinaMaquinaMock> = rutinasMaquinas
    fun get(rutinaid: Int): MutableList<RutinaMaquinaMock?> =
        rutinasMaquinas.filter { rm -> rm.rutinaid == rutinaid }.toMutableList()


//    fun update(rutinaMaquina: RutinaMaquinaMock) {
//        val position = rutinaMaquina.indexOf(get(rutinaMaquina.email))
//        rutinaMaquina[position] = rutinaMaquina
//    }
}