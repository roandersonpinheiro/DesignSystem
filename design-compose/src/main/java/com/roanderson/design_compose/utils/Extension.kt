package com.roanderson.design_compose.utils

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.ByteArrayOutputStream
import java.io.File
import java.nio.file.Files
import java.util.*


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
// Defina uma chave para o token
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

