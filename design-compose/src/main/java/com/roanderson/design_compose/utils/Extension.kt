package com.roanderson.design_compose.utils

import kotlin.random.Random


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
fun MutableList<Int>.radixSort() {
    if (this.isEmpty()) {
        return
    }

    val maxNumber = this.maxOrNull() ?: return
    var divisor = 1

    while (maxNumber / divisor > 0) {
        countingSortByDigit(divisor)
        divisor *= 10
    }
}

fun MutableList<Int>.countingSortByDigit(divisor: Int) {
    val output = MutableList(size) { 0 }
    val countingArray = Array(10) { 0 }

    forEach { num ->
        val digit = (num / divisor) % 10
        countingArray[digit]++
    }

    for (i in 1 until countingArray.size) {
        countingArray[i] += countingArray[i - 1]
    }

    for (i in size - 1 downTo 0) {
        val num = this[i]
        val digit = (num / divisor) % 10
        output[countingArray[digit] - 1] = num
        countingArray[digit]--
    }

    output.copyInto(this)
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

