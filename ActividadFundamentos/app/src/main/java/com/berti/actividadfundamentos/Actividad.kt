package com.berti.actividadfundamentos

fun main(){
    // 10 val
    val nombre = "Otto"
    val apellido:String = "Temaj"
    println("$nombre $apellido")
    val year = 2025
    println(year)
    val edad = 31
    println("Edad $edad anios")
    val dia:String = "Miercoles"
    println("Que dia es hoy? Hoy es $dia")
    val genero: Char = 'H'
    println("Genero $genero")
    val estatura:Double = 1.69
    println("Mido $estatura metros")
    val grupoSanguineo:String = "B+"
    println("Grupo sanguineo es: " + grupoSanguineo)
    val nacionalidad = "Guatemalteco"
    println(nacionalidad)
    val casado = false
    println("Casado? $casado")
    //10 var
    var comida:String = "Costillas en bbq"
    println("De que tengo ganas? " + comida)
    var bebida = "Naranjada"
    println("Sale una $bebida?")
    var mascota:String = "perro"
    println(mascota)
    var nombreMascota = "Chester"
    println("Mi $mascota se llama $nombreMascota")
    var idiomas:Int = 2
    println("Hablo $idiomas idiomas")
    var mes  = "Junio"
    println("mes")
    var brazos:Int = 2
    println("Cuantos brazos tienen los humanos? $brazos")
    var musica= "Rock"
    println(musica)
    var noche = true
    println("Es de noche? $noche")
    var hobbie:String = "gaming"
    println(hobbie)

    val presentacion = "Hola, me llamo $nombre, tengo $edad anios, y soy $nacionalidad, " +
            "mi comida favorita es $comida y tengo un $mascota llamado $nombreMascota"
    println(presentacion)

    println("\nFuncion de retorno Kotlin:\n ${returnKotlin()} ")
    println("\nFuncion que retorna un saludo:\n ${saludar("Policarpio")} ")
    println("\nFuncion que retorna una suma:\n ${suma(2,3)} ")
    println("\nFuncion que retorna una division:\n ${division(32,5)} ")
    println("\nFuncion que retorna una multiplicacion:\n     " +  multi(2,3,4))
}

    fun returnKotlin(): String{
        val lenguage:String = "Kotlin"
        return lenguage
    }

    fun saludar(nombre:String):String{
        val saludo = "Hola $nombre, mucho gusto!!!"
        return saludo
    }

    fun suma(num1:Int, num2:Int):Int{
        return num1+num2
    }

    fun division(dividendo:Int, divisor:Int):Double{
        val resultado:Double = (dividendo.toDouble()/divisor.toDouble())
        return resultado
    }

    fun multi(num1:Int, num2:Int, num3:Int):Int{
        val resultado = (num1 * num2 * num3)
        return resultado
    }