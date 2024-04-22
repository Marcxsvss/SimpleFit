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
            descripcion = "Ejercicio que focaliza el estimulo en el dorsal ancho, el cual aporta la amplitud a la espalda"
        ),
        MaquinasMock(
            maquinaid = 8,
            nombre = "Jalón al pecho",
            musculo = "Espalda",
            imagen = "",
            descripcion = "Este ejercicio puede ser realizado con agarre prono, supino y neurtro, lo que nos permite trabajar de forma más completa la espalda"
        ),
        MaquinasMock(
            maquinaid = 9,
            nombre = "Dominadas",
            musculo = "Espalda",
            imagen = "",
            descripcion = "Trabaja toda la musculatura de la espalda e incluye biceps y antebrazos"
        ),
        MaquinasMock(
            maquinaid = 10,
            nombre = "Remo Barra T",
            musculo = "Espalda",
            imagen = "",
            descripcion = "Este ejercicio se focaliza en la parte superior, la cual aporta densidad a la espalda"
        ),
        MaquinasMock(
            maquinaid = 11,
            nombre = "Remo en Polea",
            musculo = "Espalda",
            imagen = "",
            descripcion = "Con este ejercicio puedes enfocar los distintos musculos de la espalda, dependiendo de la posición del cuerpo y el agarre"
        ),
        MaquinasMock(
            maquinaid = 12,
            nombre = "Remo en Hammer",
            musculo = "Espalda",
            imagen = "",
            descripcion = "La Hammer permite enfocar densidad y ampliud en el mismo movimiento"
        ),

        MaquinasMock(
            maquinaid = 13,
            nombre = "Elevacion frontal polea",
            musculo = "Deltoides anterior",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el deltoides anterior"
        ),
        MaquinasMock(
            maquinaid = 14,
            nombre = "Press militar macuernas",
            musculo = "Deltoides anterior",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el deltoides anterior"
        ),
        MaquinasMock(
            maquinaid = 15,
            nombre = "Press militar multipower",
            musculo = "Deltoides anterior",
            imagen = "",
            descripcion = "Ejercicio enfocado en trapecio y deltoides anterior, con la guia de la multipower"
        ),
        MaquinasMock(
            maquinaid = 16,
            nombre = "Elevacion lateral maquina",
            musculo = "Deltoides lateral",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el deltoides lateral"
        ),
        MaquinasMock(
            maquinaid = 17,
            nombre = "Elevacion polea unilateral",
            musculo = "Deltoides lateral",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el deltoides lateral"
        ),
        MaquinasMock(
            maquinaid = 18,
            nombre = "elevacion lateral mancuernas",
            musculo = "Deltoides lateral",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el deltoides lateral"
        ),
        MaquinasMock(
            maquinaid = 19,
            nombre = "Face pull polea",
            musculo = "Deltoides posterior",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el deltoides lateral"
        ),
        MaquinasMock(
            maquinaid = 20,
            nombre = "Aperturas Invertidas en máquina contractora",
            musculo = "Deltoides posterior",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el deltoides lateral"
        ),
        MaquinasMock(
            maquinaid = 21,
            nombre = "Extension triceps en polea",
            musculo = "Triceps",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el triceps"
        ),
        MaquinasMock(
            maquinaid = 22,
            nombre = "Extension triceps unilateral polea",
            musculo = "Triceps",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el triceps"
        ),
        MaquinasMock(
            maquinaid = 23,
            nombre = "Curl mancuerna",
            musculo = "Biceps",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el triceps"
        ),
        MaquinasMock(
            maquinaid = 24,
            nombre = "Curl polea",
            musculo = "Biceps",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el triceps"
        ),
        MaquinasMock(
            maquinaid = 25,
            nombre = "Curl barra Z",
            musculo = "Biceps",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el triceps"
        ),
        MaquinasMock(
            maquinaid = 26,
            nombre = "Predicador Polea",
            musculo = "Biceps",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el triceps"
        ),
        MaquinasMock(
            maquinaid = 27,
            nombre = "Extensión cuadriceps",
            musculo = "Cuadriceps",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el cuadriceps"
        ),
        MaquinasMock(
            maquinaid = 28,
            nombre = "Sentadilla",
            musculo = "Cuadriceps",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el cuadriceps"
        ),
        MaquinasMock(
            maquinaid = 29,
            nombre = "Haka",
            musculo = "Cuadriceps",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el cuadriceps"
        ),
        MaquinasMock(
            maquinaid = 30,
            nombre = "Prensa",
            musculo = "Cuadriceps",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el cuadriceps"
        ),
        MaquinasMock(
            maquinaid = 31,
            nombre = "Extension de tobillo",
            musculo = "Gemelo",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el gemelo"
        ),
        MaquinasMock(
            maquinaid = 32,
            nombre = "Maquina gemelo",
            musculo = "Gemelo",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el gemelo"
        ),
        MaquinasMock(
            maquinaid = 33,
            nombre = "Curl de femoral",
            musculo = "Femoral",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el femoral"
        ),
        MaquinasMock(
            maquinaid = 34,
            nombre = "Hip trust",
            musculo = "Gluteo",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el gluteo"
        ),
        MaquinasMock(
            maquinaid = 35,
            nombre = "Maquina de abduccion",
            musculo = "Gluteo",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el gluteo"
        ),
        MaquinasMock(
            maquinaid = 36,
            nombre = "Patada en polea",
            musculo = "Gluteo",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el gluteo"
        ),
        MaquinasMock(
            maquinaid = 37,
            nombre = "Sentadilla bulgara",
            musculo = "Gluteo",
            imagen = "",
            descripcion = "Ejercicio que focaliza el estimulo en el gluteo"
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
