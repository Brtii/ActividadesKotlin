package com.berti.actividadestructuras

fun main(){
    //puedeVotar()
    //numeros(2,30)
    //positivo()
    //nota(16)
    //cicloFor()
    //cicloWhile(24)
    //cicloDoWhile()
    //arreglo()
    lista()
}

fun puedeVotar(){
    println("Ingresa tu edad (solo numeros): ")
    val edad = readln().toInt()
    if (edad >= 18)
        println("Felicidades! Puedes votar")
    else
        println("Aun no estas en edad de votar, vuelve en ${18 - edad.toInt()} años!")
}

fun numeros(num1: Int, num2: Int){
    if (num1 > num2) {
        println("$num1 es mayor que $num2")
    } else if (num1 == num2){
        println("$num1 es igual a $num2")
    } else {
        println("$num2 es mayor que $num1")
    }

}

fun positivo(){
    println("Ingresa un numero entero positivo o negativo: ")
    var num = readln()

    if (num.toIntOrNull() != null ){
        if (num.toInt() > 0){
            println("$num es positivo")
        } else if (num.toInt() < 0){
            println("$num es negativo")
        } else {
            println("$num no es positivo ni negativo")
        }
    } else {
        println("Error: Debes ingresar un entero válido")
    }
}

fun nota(nota:Int?){
    //Analizar la nota de un estudiante
    if (nota == null){
        println("La nota es nula")
    } else{
        val resultado = when(nota){
            in 0 .. 5 -> "Reprobado" // in para definir rangos
            6,7 -> "Regular"
            8,9 -> "Bueno"
            10 -> "Aprobado"
            else -> "Nota inválida"
        }
        println("La nota del alumno es $nota, el resultado es $resultado")
    }
}

fun cicloFor(){
    for (i in 1 .. 100){
        println("Número $i")
    }
}

fun cicloWhile(num: Int){
    var contador = num
    while (contador <= 50){
        println("Número $contador")
        contador++
    }
}

fun cicloDoWhile(){
    var intentos = 1
    do {
        println("Intento No. $intentos")
        intentos++
    }while (intentos <=5)

}
fun arreglo(){
    val frutas = arrayOf("manzana", "fresa", "mango", "uva")
    for (i in frutas)
        print("$i, ")
}

fun lista(){
    val animales = listOf("león", "cocodrilo", "avestruz", "tiburón")
    for (i in animales){
        println(i)
    }
}