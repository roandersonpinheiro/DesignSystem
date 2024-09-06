package com.roanderson.design_compose.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import kotlin.math.sqrt
import java.nio.file.Files
import kotlin.random.Random
import java.util.*
import android.util.Base64
import androidx.compose.runtime.Composable
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.ObjectOutputStream
import java.io.Serializable
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.security.MessageDigest
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime
import java.io.*
import java.text.DecimalFormat
import kotlin.experimental.and
import java.util.Date
import java.util.Calendar
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale


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
    val inputStream = FileInputStream(this)
    val byteArray = ByteArray(this.length().toInt())
    inputStream.read(byteArray)
    inputStream.close()

    return Base64.encodeToString(byteArray, Base64.DEFAULT)
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

fun <T> List<T>.concatenateWith(otherList: List<T>): List<T> {
    return this + otherList
}
fun calculatePercentage(number: Double, percentage: Double): Double {
    return (percentage / 100) * number
}
fun captureLetters(input: String): String {
    val regex = Regex("[a-zA-Z]+")
    val matches = regex.findAll(input)
    val result = StringBuilder()

    for (match in matches) {
        result.append(match.value)
    }

    return result.toString()
}

fun String.removeAllWhitespaces(): String {
    return this.replace("\\s+".toRegex(), "")
}

fun String.removeDuplicateWhitespaces(): String {
    return this.replace("\\s+".toRegex(), " ")
}

fun addMatrices(matrix1: Array<IntArray>, matrix2: Array<IntArray>): Array<IntArray> {
    val rows = matrix1.size
    val columns = matrix1[0].size
    val result = Array(rows) { IntArray(columns) }

    for (i in 0 until rows) {
        for (j in 0 until columns) {
            result[i][j] = matrix1[i][j] + matrix2[i][j]
        }
    }

    return result
}


@Throws(IOException::class)
fun Serializable.serialize(): String {
    val serialObj = ByteArrayOutputStream()
    val objStream = ObjectOutputStream(serialObj)
    objStream.writeObject(this)
    objStream.close()
    return encodeBytes(serialObj.toByteArray())
}

@Throws(IOException::class, ClassNotFoundException::class)
fun String?.deserialize(): Any? {
    if (this.isNullOrEmpty()) return null
    val serialObj = ByteArrayInputStream(decodeBytes(this))
    val objStream = ObjectInputStream(serialObj)
    return objStream.readObject()
}

private fun encodeBytes(bytes: ByteArray): String {
    val strBuf = StringBuffer()
    for (i in bytes.indices) {
        strBuf.append(((bytes[i].toInt() shr 4 and 0xF) + 'a'.toInt()).toChar())
        strBuf.append(((bytes[i] and 0xF) + 'a'.toInt()).toChar())
    }
    return strBuf.toString()
}

private fun decodeBytes(str: String): ByteArray {
    val bytes = ByteArray(str.length / 2)
    var i = 0
    while (i < str.length) {
        var c = str[i]
        bytes[i / 2] = (c - 'a' shl 4).toByte()
        c = str[i + 1]
        bytes[i / 2] = bytes[i / 2].plus(((c - 'a'))).toByte()
        i += 2
    }
    return bytes
}
infix fun Date.daysBetween(otherDate: Date): Long {
    val calendar1 = Calendar.getInstance()
    val calendar2 = Calendar.getInstance()
    calendar1.time = this
    calendar2.time = otherDate
    return (calendar2.timeInMillis - calendar1.timeInMillis) / (24 * 60 * 60 * 1000)
}

fun <T> List<T>.combine(vararg otherLists: List<T>): List<T> {
    val combinedList = mutableListOf<T>()
    

    combinedList.addAll(this)
    
    for (list in otherLists) {
        combinedList.addAll(list)
    }
    
    return combinedList
}
fun <K, V> cobinedHashMaps(map1: HashMap<K, V>, map2: HashMap<K, V>): HashMap<K, V> {
    val resultado = HashMap(map1)
    resultado.putAll(map2)
    return resultado
}
fun filterEvenNumbers(list: List<Int>): List<Int> {
    return list.filter { it % 2 == 0 }
}
fun List<String>.filterByLength(length: Int): List<String> {
    return this.filter { it.length == length }
}
inline fun <reified T> List<T>.filterDistinct(selector: (T) -> Any): List<T> {
    val seen = HashSet<Any>()
    return filter { seen.add(selector(it)) }
}
fun Double.roundToDecimals(decimals: Int): Double {
    require(decimals >= 0) { "O número de casas decimais deve ser não negativo." }

    val factor = 10.0.pow(decimals)
    return (this * factor).roundToInt() / factor
}
fun <T> List<T>.filterOn(condition: (T) -> Boolean): List<T> {
    return this.filter { item -> condition(item) }
}
fun String.isAnagram(other: String): Boolean {
    val text1 = this.replace("\\s".toRegex(), "").toLowerCase()
    val text2 = other.replace("\\s".toRegex(), "").toLowerCase()
    return text1.toCharArray().sorted() == text2.toCharArray().sorted()
}
fun List<Int>.calculateSum(): Int {
    return this.sum()
}


fun <T> List<T>.intercalar(other: List<T>): List<T> {
    val result = mutableListOf<T>()
    val iterator1 = this.iterator()
    val iterator2 = other.iterator()

    while (iterator1.hasNext() || iterator2.hasNext()) {
        if (iterator1.hasNext()) {
            result.add(iterator1.next())
        }
        if (iterator2.hasNext()) {
            result.add(iterator2.next())
        }
    }

    return result
}
fun fibonacci(n: Int): Int {
    return if (n <= 1) {
        n
    } else {
        fibonacci(n - 1) + fibonacci(n - 2)
    }
}
fun multiplyLists(list1: List<Int>, list2: List<Int>): List<Int> {
    if (list1.size != list2.size) {
        throw IllegalArgumentException("Lists must have the same size")
    }

    val result = mutableListOf<Int>()

    for (i in list1.indices) {
        result.add(list1[i] * list2[i])
    }

    return result
}


fun fillMatrix(rows: Int, cols: Int, value: Int): List<List<Int>> {
    return (0 until rows).map { row ->
        (0 until cols).map { col -> value }
    }
}
fun linearSearch(list: List<Int>, target: Int): Int {
  for (index in 0 until list.size) {
    if (list[index] == target) {
      return index
    }
  }

  return -1
}
fun convertArrayListToMap(arrayList: ArrayList<Pair<String, Int>>): Map<String, Int> {
    return arrayList.associateBy({ it.first }, { it.second })
}
fun <T> splitArray(array: Array<T>, partSize: Int): List<List<T>> {
    require(partSize > 0) { "Part size must be greater than zero." }

    val parts = mutableListOf<List<T>>()

    for (i in 0 until array.size step partSize) {
        val part = array.sliceArray(i until (i + partSize).coerceAtMost(array.size))
        parts.add(part.toList())
    }

    return parts
}
fun calcularPorcentagem(x: Double, y: Double): Double {
    if (y < 0.0 || y > 100.0) {
        throw IllegalArgumentException("A porcentagem deve estar entre 0 e 100.")
    }

    return (y / 100.0) * x
}

fun calculateLCM(a: Int, b: Int): Int {
    return (a * b) / calculateGCD(a, b)
}

fun calculateGCD(a: Int, b: Int): Int {
    var num1 = a
    var num2 = b
    while (num2 != 0) {
        val temp = num2
        num2 = num1 % num2
        num1 = temp
    }
    return num1
}
fun calculateHypotenuse(leg1: Double, leg2: Double): Double {
    val sumOfSquares = leg1 * leg1 + leg2 * leg2
    val hypotenuse = sqrt(sumOfSquares)
    return hypotenuse
}
 
 fun calculateRoots(a: Double, b: Double, c: Double): String {
    // Calculate the discriminant (b^2 - 4ac)
    val discriminant = b * b - 4 * a * c

    // Determine the nature and number of roots based on the discriminant
    return when {
        discriminant > 0 -> {
            // Two distinct real roots
            val root1 = (-b + sqrt(discriminant)) / (2 * a)
            val root2 = (-b - sqrt(discriminant)) / (2 * a)
            "Two distinct real roots: $root1 and $root2"
        }
        discriminant == 0.0 -> {
            // One real root (coincident roots)
            val root = -b / (2 * a)
            "One real root (coincident roots): $root"
        }
        else -> {
            // No real roots (imaginary roots)
            val realPart = -b / (2 * a)
            val imaginaryPart = sqrt(-discriminant) / (2 * a)
            "No real roots (imaginary roots): $realPart + $imaginaryPart i and $realPart - $imaginaryPart i"
        }
    }
}

fun printTruthTable(variable1: String, variable2: String, operators: List<String>) {
    // Imprime cabeçalho da tabela
    println("| $variable1 | $variable2 | ${operators.joinToString(" | ")} | !A | !B |")

    // Imprime linha de separação
    println("|---|---|${"---|".repeat(operators.size + 2)}")

    // Gera tabela verdade
    for (value1 in listOf(true, false)) {
        for (value2 in listOf(true, false)) {
            val results = operators.map { operator ->
                evaluateExpression(value1, value2, operator)
            }
            val resultNOT1 = !value1
            val resultNOT2 = !value2

            // Imprime linha da tabela
            println("| $value1 | $value2 | ${results.joinToString(" | ")} |   $resultNOT1   |   $resultNOT2   |")
        }
    }
}

fun evaluateExpression(value1: Boolean, value2: Boolean, operator: String): Boolean {
    return when (operator) {
        "&&" -> value1 && value2
        "||" -> value1 || value2
        "xor" -> value1 xor value2
        "->" -> !value1 || value2
        else -> throw IllegalArgumentException("Operador desconhecido: $operator")
    }
}
inline fun <reified T : Any> T?.orElse(defaultValue: T): T {
    return this ?: defaultValue
}

fun getRandomNumber(min: Int, max: Int): Int {
    return (min..max).random()
}
fun binarySearchRecursive(arr: IntArray, target: Int, low: Int, high: Int): Int {
    if (low > high) {
        return -1 // Element not found
    }

    val mid = (low + high) / 2

    return when {
        arr[mid] == target -> mid
        arr[mid] < target -> binarySearchRecursive(arr, target, mid + 1, high)
        else -> binarySearchRecursive(arr, target, low, mid - 1)
    }
}
fun newtonRaphson(squareRootOf: Double, epsilon: Double): Double {
    var approximation = squareRootOf / 2.0
    while (Math.abs(approximation * approximation - squareRootOf) > epsilon) {
        approximation = 0.5 * (approximation + squareRootOf / approximation)
    }
    return approximation
}
fun knapsack(weights: IntArray, values: IntArray, capacity: Int): Int {
    val n = weights.size
    val dp = Array(n + 1) { IntArray(capacity + 1) }

    for (i in 0..n) {
        for (w in 0..capacity) {
            if (i == 0 || w == 0) {
                dp[i][w] = 0
            } else if (weights[i - 1] <= w) {
                dp[i][w] = maxOf(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w])
            } else {
                dp[i][w] = dp[i - 1][w]
            }
        }
    }

    return dp[n][capacity]
}

fun String.ellipsize(maxLength: Int): String {
    return if (length > maxLength) {
        substring(0, maxLength - 3) + "..."
    } else {
        this
    }
}

fun isLeapYear(year: Int): Boolean {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
}


@Composable
fun String.formatCPF(): String {
    return if (this.length == 11) {
        "${this.substring(0, 3)}.${this.substring(3, 6)}.${this.substring(6, 9)}-${this.substring(9, 11)}"
    } else {
        this
    }
}

@Composable
fun String.formatCNPJ(): String {
    return if (this.length == 14) {
        "${this.substring(0, 2)}.${this.substring(2, 5)}.${this.substring(5, 8)}/${this.substring(8, 12)}-${this.substring(12, 14)}"
    } else {
        this
    }
}



fun List<Int>.pickRandomNumbers(quantity: Int): List<Int> {
    require(quantity <= size) { "The quantity of numbers to pick cannot be greater than the size of the list" }

    val pickedNumbers = mutableListOf<Int>()
    val availableNumbers = this.toMutableList()

    repeat(quantity) {
        val randomIndex = Random.nextInt(availableNumbers.size)
        val pickedNumber = availableNumbers.removeAt(randomIndex)
        pickedNumbers.add(pickedNumber)
    }

    return pickedNumbers
}
fun createMatrix(rows: Int, cols: Int): Array<Array<Int>> {
    var counter = 1
    val matrix = Array(rows) { Array(cols) { 0 } }

    for (i in 0 until rows) {
        for (j in 0 until cols) {
            matrix[i][j] = counter
            counter++
        }
    }

    return matrix
}
fun centimetersToMeters(centimeters: Double): Double {
    return centimeters / 100.0
}

fun metersToCentimeters(meters: Double): Double {
    return meters * 100.0
}
fun checkPermission(activity: Activity, permission: String): Boolean {
    return ContextCompat.checkSelfPermission(
        activity,
        permission
    ) == PackageManager.PERMISSION_GRANTED
}
fun requestPermission(activity: Activity, permission: String, requestCode: Int) {
    ActivityCompat.requestPermissions(activity, arrayOf(permission), requestCode)
}
fun getCurrentMonthAsString(): String {
    val calendar = Calendar.getInstance()
    val month = calendar.get(Calendar.MONTH) + 1
    return month.toString()
}

fun <K, V, R> Map<K, V>.mapValues(transform: (Map.Entry<K, V>) -> R): List<R> {
    return this.map { entry -> transform(entry) }
}
fun String.replaceLastChar(newChar: Char): String {
    if (this.isNotEmpty()) {
        return this.substring(0, this.length - 1) + newChar
    }
    return this
}
