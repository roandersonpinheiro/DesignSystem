package com.roanderson.design_compose.utils

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.lang.Math.sqrt
import java.nio.file.Files
import java.util.*
import android.util.Base64
import java.text.NumberFormat
import java.text.SimpleDateFormat


fun Array<Int>.bubbleSort() {
    val n = size
    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            if (this[j] > this[j + 1]) {
                val temp = this[j]
                this[j] = this[j + 1]
                this[j + 1] = temp
            }
        }
    }
}
fun List<Int>.quicksort(): List<Int> {
    if (size <= 1) {
        return this
    }

    val pivot = this[size / 2]
    val equal = filter { it == pivot }
    val less = filter { it < pivot }
    val greater = filter { it > pivot }

    return less.quicksort() + equal + greater.quicksort()
}
fun String.sortAlphabetically() = toCharArray().apply { sort() }

fun <T:Any> ArrayList<T>.refreshList(items: List<T>): ArrayList<T> {
    this.clear()
    this.addAll(items)
    return this
}
fun <T:Any> ArrayList<T>.addOnlyNewItems(items: List<T>): ArrayList<T> {
    items.forEach { if(!this.contains(it)) this.add(it) }
    return this
}
fun Random.nextRandomLetter(): Char {
    val alphabet = ('a'..'z').toList()
    return alphabet[this.nextInt(alphabet.size)]
}
fun <T> List<T>.shuffle(): List<T> {
    val shuffledList = this.toMutableList()
    val random = java.util.Random()

    for (i in shuffledList.size - 1 downTo 1) {
        val j = random.nextInt(i + 1)
        val temp = shuffledList[i]
        shuffledList[i] = shuffledList[j]
        shuffledList[j] = temp
    }

    return shuffledList
}
@RequiresApi(Build.VERSION_CODES.O)
fun File.toBase64(): String {
    val bytes = Files.readAllBytes(this.toPath())
    val base64 = Base64.getEncoder().encodeToString(bytes)
    return base64
}

private const val TOKEN_KEY = "token_key"

fun Context.saveToken(token: String) {
    val sharedPreferences: SharedPreferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString(TOKEN_KEY, token)
    editor.apply()
}

fun Context.getToken(): String? {
    val sharedPreferences: SharedPreferences = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    return sharedPreferences.getString(TOKEN_KEY, null)
}
class DoubleWrapper(val value: Double)
fun DoubleWrapper.calculateBhaskara(a: Double, b: Double, c: Double): Pair<Double?, Double?> {
    val discriminant = b * b - 4 * a * c

    if (discriminant < 0) {
        return Pair(null, null) // Não há raízes reais
    }

    val root1 = (-b + sqrt(discriminant)) / (2 * a)
    val root2 = (-b - sqrt(discriminant)) / (2 * a)

    return Pair(root1, root2)
}
fun String.base64ToFile(filePath: String): Boolean {
    try {
        val decodedBytes = Base64.decode(this, Base64.DEFAULT)
        val outputStream = FileOutputStream(filePath)
        outputStream.write(decodedBytes)
        outputStream.close()
        return true
    } catch (e: Exception) {
        e.printStackTrace()
        return false
    }
}

inline fun <T : Any, R> T?.withNotNull(block: (T) -> R): R? {
    return this?.let(block)
}
//usage
//val nullableValue: String? = null
//nullableValue.withNotNull { value ->
//}

fun Int.toFormattedString(): String {
    return NumberFormat.getInstance().format(this)
}

fun Long.toFormattedString(): String {
    return NumberFormat.getInstance().format(this)
}

fun Date.toFormattedString(): String {
    return SimpleDateFormat.getDateInstance().format(this)
}
inline fun <T> T.applyIf(condition: Boolean, block: T.() -> Unit): T {
    return if (condition) {
        this.apply(block)
    } else {
        this
    }
}

data class Item(val name: String, val status: String)

fun orderItemsByStatus(items: List<Item>): List<Item> {
    return items.sortedWith(compareBy({ it.status != "Pending" }, { it.status }))
}

fun main() {
    val items = listOf(
        Item("Item 1", "Pending"),
        Item("Item 2", "Completed"),
        Item("Item 3", "In Progress"),
        Item("Item 4", "Pending"),
        Item("Item 5", "Completed")
    )

    val orderedItems = orderItemsByStatus(items)

    orderedItems.forEach {
        println("${it.name} - ${it.status}")
    }
}
fun String.formatCpfOrCnpj(isCpf: Boolean): String {
    val digitsOnly = this.filter { it.isDigit() }

    if (isCpf) {
        return if (digitsOnly.length == 11) {
            "${digitsOnly.substring(0, 3)}.${digitsOnly.substring(3, 6)}.${digitsOnly.substring(6, 9)}-${digitsOnly.substring(9)}"
        } else {
            this
        }
    } else {
        return if (digitsOnly.length == 14) {
            "${digitsOnly.substring(0, 2)}.${digitsOnly.substring(2, 5)}.${digitsOnly.substring(5, 8)}/${digitsOnly.substring(8, 12)}-${digitsOnly.substring(12)}"
        } else {
            this
        }
    }
}fun String.formatPlate(): String {

    val placaSemCaracteresEspeciais = this.replace("[^a-zA-Z0-9]".toRegex(), "")

    if (placaSemCaracteresEspeciais.length < 3) {
        return placaSemCaracteresEspeciais.toUpperCase()
    }


    val letras = placaSemCaracteresEspeciais.substring(0, 3)
    val numeros = placaSemCaracteresEspeciais.substring(3, placaSemCaracteresEspeciais.length - 1)
    val letrasFinais = placaSemCaracteresEspeciais.substring(placaSemCaracteresEspeciais.length - 1)


    return "${letras.toUpperCase()}${numeros}${letrasFinais.toUpperCase()}"
}

fun Random.nextPassword(length: Int): String {
    val charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    return (1..length)
        .map { charset.random() }
        .joinToString("")
}
fun Random.nextMatrix(n: Int): Array<Array<Int>> {
    val matrix = Array(n) { Array(n) { 0 } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            matrix[i][j] = this.nextInt()
        }
    }
    return matrix
}




