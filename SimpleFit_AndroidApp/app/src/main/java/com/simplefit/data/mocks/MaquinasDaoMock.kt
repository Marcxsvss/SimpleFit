package com.simplefit.data.mocks

import java.sql.Blob
import javax.inject.Inject

class MaquinasDaoMock @Inject constructor() {
    private val rutinasMaquinas = RutinaMaquinaDaoMock().get()
    private var listaMaquinas = mutableListOf(
        MaquinasMock(
            maquinaid = 0,
            nombre = "Press en Maquina",
            musculo = "Pectoral",
            imagen = "",
            descripcion = "Ejercicio focalizado en entrenar todas las fibras del pectoral, tanto superiores, mediales como inferiores"
        ),
        MaquinasMock(
            maquinaid = 1,
            nombre = "Fondos en paralelas",
            musculo = "Pectoral",
            imagen = "",
            descripcion = "Este ejercicio es muy completo, ya que trabaja el pectoral inferior, el tríceps y los hombros, te ayudará a prevenir lesiones y ganar mucha fuerza de empuje"
        ),
        MaquinasMock(
            maquinaid = 2,
            nombre = "Press en maquina inclinado",
            musculo = "Pectoral",
            imagen = "",
            descripcion = "El ejercicio trabajo de forma muy especifica el pectoral superior, el cual es el que da esa redondez al pecho"
        ),
        MaquinasMock(
            maquinaid = 3,
            nombre = "Press inclinado en multipower",
            musculo = "Pectoral",
            imagen = "",
            descripcion = "Este ejercicio sería una variante del press banca, pero con la ventaja de que al ser en multipower, la barra va guiada por unos raíles, lo que nos permite centrarnos en el movimiento y no en la estabilidad de la barra."
        ),
        MaquinasMock(
            maquinaid = 4,
            nombre = "Press inclinado con mancuernas",
            musculo = "Pectoral",
            imagen = "",
            descripcion = "Esta variante de press, nos permite mayor rango de movimiento y mayor comodidad al poder situar las muñecas en distintas posiciones, lo que nos permite trabajar de forma más completa el pectoral superior."
        ),
        MaquinasMock(
            maquinaid = 5,
            nombre = "Pek dek maquina",
            musculo = "Pectoral",
            imagen = "",
            descripcion = "El pek dek en maquina es un ejercicio muy completo para trabajar el pectoral, ya que nos permite aislar el movimiento y centrarnos en la contracción y el estiramiento del pectoral."
        ),
        MaquinasMock(
            maquinaid = 6,
            nombre = "Pek dek polea",
            musculo = "Pectoral",
            imagen = "",
            descripcion = "Es una variante de pek dek, pero el agarre y la posicion del cuerpo puede ser ajustada a tus necesidades"
        ),
        MaquinasMock(
            maquinaid = 7,
            nombre = "Pull over polea alta",
            musculo = "Espalda",
            imagen = "",
            descripcion = ""
        ),
        MaquinasMock(
            maquinaid = 7,
            nombre = "Jalón prono",
            musculo = "Espalda",
            imagen = "",
            descripcion = ""
        ),
        MaquinasMock(
            maquinaid = 7,
            nombre = "Jalón supino",
            musculo = "Espalda",
            imagen = "",
            descripcion = ""
        ),
        MaquinasMock(
            maquinaid = 7,
            nombre = "Jalón neutro",
            musculo = "Espalda",
            imagen = "",
            descripcion = ""
        ),
        MaquinasMock(
            maquinaid = 7,
            nombre = "Dominadas",
            musculo = "Espalda",
            imagen = "",
            descripcion = ""
        ),
        MaquinasMock(
            maquinaid = 7,
            nombre = "Remo Barra T",
            musculo = "Espalda",
            imagen = "",
            descripcion = ""
        ),
        MaquinasMock(
            maquinaid = 7,
            nombre = "Remo en Polea",
            musculo = "Espalda",
            imagen = "",
            descripcion = ""
        ),
        MaquinasMock(
            maquinaid = 7,
            nombre = "Remo en Hammer",
            musculo = "Espalda",
            imagen = "",
            descripcion = ""
        ),

    )

    fun get(): MutableList<MaquinasMock> = listaMaquinas

    fun get(rutinaid: Int): MutableList<MaquinasMock> {
        val rutinaMaquina = RutinaMaquinaDaoMock().get(rutinaid)
        val maquinas = mutableListOf<MaquinasMock>()
        rutinaMaquina.forEach { rm ->
            val maquina = listaMaquinas.find { m -> m.maquinaid == rm?.maquinaid }
            maquinas.add(maquina!!)
        }
        return maquinas
    }
//    fun get(maquinaid: Int): MaquinasMock? = maquinas.find { m -> m.maquinaid == maquinaid }
//    fun update(maquina: MaquinasMock) {
//        val position = maquinas.indexOf(get(maquina.maquinaid))
//        maquinas[position] = maquina
//    }
}
