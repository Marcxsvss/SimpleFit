package com.simplefit.data.mocks

import javax.inject.Inject

class RutinaMaquinaDaoMock @Inject constructor() {
    private var rutinasMaquinas = mutableListOf(
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 1,
            series = 3,
            repeticiones = "8-12"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 2,
            series = 3,
            repeticiones = "8-12"
        ),
        RutinaMaquinaMock(
            rutinaid = 1,
            maquinaid = 3,
            series = 3,
            repeticiones = "8-12"
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