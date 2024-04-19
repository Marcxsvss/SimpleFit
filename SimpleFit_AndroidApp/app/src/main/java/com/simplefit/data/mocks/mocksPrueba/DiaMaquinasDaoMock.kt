package com.simplefit.data.mocks.mocksPrueba

import javax.inject.Inject

class DiaMaquinasDaoMock @Inject constructor()
{
    private var diaMaquinas = mutableListOf(
        DiaMaquinasMock(
            diaid = 1,
            maquinaid = 1
        ),
        DiaMaquinasMock(
            diaid = 1,
            maquinaid = 1
        ),
        DiaMaquinasMock(
            diaid = 1,
            maquinaid = 1
        ),
        DiaMaquinasMock(
            diaid = 1,
            maquinaid = 1
        ),
        DiaMaquinasMock(
            diaid = 1,
            maquinaid = 1
        ),
        DiaMaquinasMock(
            diaid = 1,
            maquinaid = 1
        ),
    )

    fun get(): MutableList<DiaMaquinasMock> = diaMaquinas
    fun get(diaid: Int): DiaMaquinasMock? = diaMaquinas.find { d -> d.diaid == diaid }
    fun get(diaid: Int, maquinaid: Int): DiaMaquinasMock? = diaMaquinas.find { d -> d.diaid == diaid && d.maquinaid == maquinaid }
    fun update(user: DiaMaquinasMock) {
        val position = diaMaquinas.indexOf(get(user.diaid, user.maquinaid))
        diaMaquinas[position] = user
    }
}