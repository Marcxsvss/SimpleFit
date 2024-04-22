package com.simplefit.data.mocks.mocksPrueba

import javax.inject.Inject

class DiasSemanaDaoMock @Inject constructor() {
    private var diasSemana = mutableListOf(
        DiasSemanaMock(
            diaid = 1,
            nombre_dia = "Lunes",
            rutinaid = 1
        ),
    )

    fun get(): MutableList<DiasSemanaMock> = diasSemana
    fun get(rutinaid: Int): DiasSemanaMock? = diasSemana.find { d -> d.rutinaid == rutinaid }
    /*fun update(user: DiasSemanaMock) {
        val position = diasSemana.indexOf(get(user.email))
        diasSemana[position] = user
    }*/
}