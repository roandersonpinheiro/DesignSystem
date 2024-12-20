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
import android.app.ActivityManager
import android.content.Context
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
String): Boolean {
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







val String.md5: String
    get() {
        val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
        return bytes.joinToString("") {
            "%02x".format(it)
        }
    }



fun generatePassword(length: Int): String {
    val charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+"
    return (1..length)
        .map { charset.random() }
        .joinToString("")
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

fun calculateHypotenuse(leg1: Double, leg2: Double): Double {
    val sumOfSquares = leg1 * leg1 + leg2 * leg2
    val hypotenuse = sqrt(sumOfSquares)
    return hypotenuse
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


fun Context.isActivityInStack(activityClass: Class<*>): Boolean {
    val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
    val tasks = activityManager.getRunningTasks(Int.MAX_VALUE)

    for (task in tasks) {
        if (task.topActivity?.className == activityClass.name) {
            return true
        }
    }
    return false
}

const val ZERO = 0
const val ONE = 1
const val HUNDRED = 100

fun Int?.orZero() = this ?: ZERO
fun Double?.orZero() = this ?: ZERO.toDouble()
fun String?.orZero() = this ?: "0"

fun Int?.isNegative() = this.orZero() < ZERO

fun Int?.isPositive() = this.orZero() > ZERO

fun Double?.isNegative() = this.orZero() < ZERO.toDouble()

fun Double?.isPositive() = this.orZero() > ZERO.toDouble()

fun Double?.toMoney(): String {
    return NumberFormat.getCurrencyInstance(Locale.getDefault()).format(this)
}

fun Double?.toFormat(): String {
    return String.format("%.2f", this)
}

fun Boolean?.orFalse() = this ?: false

fun Boolean?.orTrue() = this ?: true

fun Modifier.defaultPadding(): Modifier {
    return this.padding(16.dp)
}
fun Modifier.longClickableWithRipple(onLongClick: () -> Unit) = composed {
    this.pointerInput(Unit) {
        detectTapGestures(onLongPress = { onLongClick() })
    }.indication(
        interactionSource = MutableInteractionSource(),
        indication = rememberRipple(bounded = true)
    )
}

fun Modifier.customBorder(color: Color = Color.Blue, borderWidth: Float = 2f): Modifier {
    return this
        .border(width = borderWidth.dp, color = color)
        .background(Color.LightGray) // Exemplo de fundo para contraste
}
fun Modifier.customShadow(
    color: Color = Color.Black,
    radius: Dp = 8.dp,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 4.dp
): Modifier {
    return this.shadow(
        elevation = radius,
        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
        ambientColor = color,
        spotColor = color
    )
        .offset(x = offsetX, y = offsetY)
}    


fun Modifier.roundedBorder(
    color: Color = Color.Gray,
    width: Dp = 2.dp,
    cornerRadius: Dp = 8.dp,
): Modifier = this.then(
    border(width, color, RoundedCornerShape(cornerRadius))
)


fun Modifier.gradientBackground(
    colors: List<Color>,
    startX: Float = 0f,
    startY: Float = 0f,
    endX: Float = 1000f,
    endY: Float = 1000f,
): Modifier = this.then(
    background(
        brush = Brush.linearGradient(
            colors = colors,
            start = androidx.compose.ui.geometry.Offset(startX, startY),
            end = androidx.compose.ui.geometry.Offset(endX, endY),
            tileMode = TileMode.Clamp
        )
    )
)
fun Modifier.paddingHorizontal(horizontal: Dp): Modifier = this.then(
    padding(start = horizontal, end = horizontal)
)
fun Modifier.shake(
    shakeDistance: Dp = 10.dp,
    shakeDuration: Int = 300,
): Modifier = composed {
    var isShaking by remember { mutableStateOf(false) }

    val offsetX by animateFloat(
        initialValue = 0f,
        targetValue = shakeDistance.value,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = shakeDuration
                0f at 0
                shakeDistance.value at shakeDuration / 4
                -shakeDistance.value at shakeDuration / 2
                shakeDistance.value at 3 * shakeDuration / 4
                0f at shakeDuration
            },
            repeatMode = RepeatMode.Restart
        )
    )

    if (isShaking) {
        this.then(Modifier.translate(x = offsetX.dp))
    } else {
        this
    }
}

fun Modifier.rotating(
    durationMillis: Int = 1000,
    initialRotation: Float = 0f,
    targetRotation: Float = 360f
): Modifier = composed {
    val infiniteTransition = rememberInfiniteTransition()
    val rotation by infiniteTransition.animateFloat(
        initialValue = initialRotation,
        targetValue = targetRotation,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    this.rotate(rotation)
}


fun Modifier.pulse(
    minScale: Float = 0.9f, 
    maxScale: Float = 1.2f,  
    durationMillis: Int = 1000, 
): Modifier = composed {
    val infiniteTransition = rememberInfiniteTransition()

  
    val scale by infiniteTransition.animateFloat(
        initialValue = minScale,
        targetValue = maxScale,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = durationMillis,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    this.scale(scale)  
}
fun Modifier.blur(
    blurRadius: Dp = 10.dp  // Raio do desfoque
): Modifier = this.graphicsLayer {
    shadowElevation = blurRadius.toPx()
    shape = androidx.compose.foundation.shape.RectangleShape
    clip = true
}

fun Modifier.clickableWithRipple(
    rippleColor: Color = Color.Gray,
    rippleRadius: Dp = 24.dp,
    onClick: () -> Unit
): Modifier = this.then(
    clickable(
        indication = rememberRipple(color = rippleColor, radius = rippleRadius),
        interactionSource = remember { MutableInteractionSource() },
        onClick = onClick
    )
)
fun Modifier.shadowed(
    shadowColor: Color = Color.Black,
    shadowRadius: Dp = 8.dp,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 4.dp,
    opacity: Float = 0.5f
): Modifier = this.graphicsLayer {
    shadowElevation = shadowRadius.toPx()
    shape = androidx.compose.foundation.shape.RectangleShape
    clip = true
    renderEffect = androidx.compose.ui.graphics.RenderEffect.createBlurEffect(
        shadowRadius.toPx(), shadowRadius.toPx(), androidx.compose.ui.graphics.TileMode.Decal
    )
    alpha = opacity
    translationX = offsetX.toPx()
    translationY = offsetY.toPx()
}
fun Modifier.borderWithRadius(
    borderColor: Color = Color.Black,
    borderWidth: Dp = 2.dp,
    cornerRadius: Dp = 8.dp,
    shape: Shape = RoundedCornerShape(cornerRadius)
): Modifier = this.border(
    border = BorderStroke(borderWidth, borderColor),
    shape = shape
)


