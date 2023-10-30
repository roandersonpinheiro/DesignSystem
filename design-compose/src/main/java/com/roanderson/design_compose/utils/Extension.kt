package com.roanderson.design_compose.utils

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
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
import java.security.MessageDigest
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Calendar


fun Date.isFuture(): Boolean {
    return this > Date()
}

fun <T> List<T>.orDefault(defaultList: List<T>): List<T> {
    return ifEmpty { defaultList }
}

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

fun <T : Any> ArrayList<T>.refreshList(items: List<T>): ArrayList<T> {
    this.clear()
    this.addAll(items)
    return this
}

fun <T : Any> ArrayList<T>.addOnlyNewItems(items: List<T>): ArrayList<T> {
    items.forEach { if (!this.contains(it)) this.add(it) }
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
    val sharedPreferences: SharedPreferences =
        getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString(TOKEN_KEY, token)
    editor.apply()
}

fun Context.getToken(): String? {
    val sharedPreferences: SharedPreferences =
        getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
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
            "${digitsOnly.substring(0, 3)}.${digitsOnly.substring(3, 6)}.${
                digitsOnly.substring(
                    6,
                    9
                )
            }-${digitsOnly.substring(9)}"
        } else {
            this
        }
    } else {
        return if (digitsOnly.length == 14) {
            "${digitsOnly.substring(0, 2)}.${digitsOnly.substring(2, 5)}.${
                digitsOnly.substring(
                    5,
                    8
                )
            }/${digitsOnly.substring(8, 12)}-${digitsOnly.substring(12)}"
        } else {
            this
        }
    }
}

fun String.formatPlate(): String {

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

fun dataExpirou(dataExpiracao: String): Boolean {
    try {
        val formatoData = SimpleDateFormat("dd/MM/yyyy")
        val dataAtual = Date()
        val dataExpiracaoFormatada = formatoData.parse(dataExpiracao)

        return dataAtual.after(dataExpiracaoFormatada)
    } catch (e: Exception) {
        e.printStackTrace()
        return false
    }
}

val String.md5: String
    get() {
        val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
        return bytes.joinToString("") {
            "%02x".format(it)
        }
    }

fun String.isValidEmail(): Boolean {
    val emailRegex = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")
    return emailRegex.matches(this)
}


fun Int.factorial(): Int {
    return if (this <= 1) 1 else this * (this - 1).factorial()
}

fun multiplyMatrices(matrixA: Array<Array<Int>>, matrixB: Array<Array<Int>>): Array<Array<Int>> {
    val numRowsA = matrixA.size
    val numColsA = matrixA[0].size
    val numRowsB = matrixB.size
    val numColsB = matrixB[0].size

    if (numColsA != numRowsB) {
        throw IllegalArgumentException("\"The number of columns in matrix A must be equal to the number of rows in matrix B")
    }

    val result = Array(numRowsA) { Array(numColsB) { 0 } }

    for (i in 0 until numRowsA) {
        for (j in 0 until numColsB) {
            for (k in 0 until numColsA) {
                result[i][j] += matrixA[i][k] * matrixB[k][j]
            }
        }
    }

    return result
}

fun generatePassword(length: Int): String {
    val charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+"
    return (1..length)
        .map { charset.random() }
        .joinToString("")
}

@OptIn(ExperimentalTime::class)
fun offExpiration() {
    val offerExpirationTimeInSeconds = 534_600.seconds
    offerExpirationTimeInSeconds.toComponents { days, hrs, mins, secs, nanoSecs ->
        println("Your offer about to expire in")
        println("${days} days : ${hrs} hrs : ${mins} mins")
    }
}

fun List<Int>.average(): Double {
    return if (isEmpty()) 0.0 else sum().toDouble() / size
}

fun String.limitLength(maxLength: Int, ellipsis: String = "..."): String {
    return if (length <= maxLength) this else substring(0, maxLength - ellipsis.length) + ellipsis
}

fun <T> List<T?>.isNullOrEmptyWithNulls(): Boolean {
    for (item in this) {
        if (item != null) {
            return false
        }
    }
    return true
}

fun List<Int>.filterEvenNumbers(): List<Int> {
    return this.filter { it % 2 == 0 }
}

fun Int.isEven(): Boolean {
    return this % 2 == 0

}

fun List<Int>.maxElement(): Int? {
    return if (isEmpty()) null else this.maxOrNull()
}

fun String.isPalindrome(): Boolean {
    val cleanString = this.replace(Regex("[^A-Za-z0-9]"), "").toLowerCase()
    return cleanString == cleanString.reversed()
}

fun String.blankSpaceRemover(): String {
    return this.replace(" ", "")
}

fun <T> List<T>.splitIntoParts(partSize: Int): List<List<T>> {
    val parts = mutableListOf<List<T>>()
    for (i in 0 until size step partSize) {
        parts.add(subList(i, minOf(i + partSize, size)))
    }
    return parts
}

fun Date.calculateAge(): Int {
    val calendar = Calendar.getInstance()
    val today = calendar.time
    val dob = this

    calendar.time = dob
    val dobYear = calendar.get(Calendar.YEAR)
    calendar.time = today
    val todayYear = calendar.get(Calendar.YEAR)

    return todayYear - dobYear
}

fun List<Int>.findMax(): Int {
    require(this.isNotEmpty()) { "A lista não pode estar vazia" }
    return this.maxOrNull() ?: 0
}

fun Int.cube(): Int {
    return this * this * this
}

fun File.isEmptyDirectory(): Boolean {
    return isDirectory && listFiles()?.isEmpty() == true
}

fun <T, K> List<T>.groupByKey(keySelector: (T) -> K): Map<K, List<T>> {
    return groupBy(keySelector)
}

fun Context?.isOnline(): Boolean {
    this?.apply {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }
    return false
}
fun celsiusToFahrenheit(celsius: Double): Double {
    return celsius * 9 / 5 + 32
}
fun <T> List<T>.concatenateWith(otherList: List<T>): List<T> {
    return this + otherList
}
