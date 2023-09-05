package com.roanderson.design_compose.utils

fun cifraDeCesar(texto: String, deslocamento: Int): String {
    val resultado = StringBuilder()

    for (caractere in texto) {
        if (caractere.isLetter()) {
            val maiuscula = caractere.isUpperCase()
            val letraDeslocada = (caractere.toInt() + deslocamento - if (maiuscula) 'A'.toInt() else 'a'.toInt()) % 26
            val letraCifrada = (letraDeslocada + if (letraDeslocada < 0) 26 else 0) + if (maiuscula) 'A'.toInt() else 'a'.toInt()
            resultado.append(letraCifrada.toChar())
        } else {
            resultado.append(caractere)
        }
    }

    return resultado.toString()
}

fun decifraCifraDeCesar(textoCifrado: String, deslocamento: Int): String {
    return cifraDeCesar(textoCifrado, -deslocamento)
}

fun main() {
    val textoOriginal = "Hello, World!"
    val deslocamento = 3

    val textoCifrado = cifraDeCesar(textoOriginal, deslocamento)
    println("Texto cifrado: $textoCifrado")

    val textoDecifrado = decifraCifraDeCesar(textoCifrado, deslocamento)
    println("Texto decifrado: $textoDecifrado")
}
