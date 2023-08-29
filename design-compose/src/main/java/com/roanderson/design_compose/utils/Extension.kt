package com.roanderson.design_compose.utils


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
fun <T : Comparable<T>> Array<T>.heapSort() {
    buildMaxHeap()

    for (i in size - 1 downTo 1) {
        swap(0, i)
        maxHeapify(0, i)
    }
}

private fun <T : Comparable<T>> Array<T>.buildMaxHeap() {
    val n = size
    for (i in (n / 2 - 1) downTo 0) {
        maxHeapify(i, n)
    }
}

private fun <T : Comparable<T>> Array<T>.maxHeapify(index: Int, heapSize: Int) {
    val left = 2 * index + 1
    val right = 2 * index + 2
    var largest = index

    if (left < heapSize && this[left] > this[largest]) {
        largest = left
    }
    if (right < heapSize && this[right] > this[largest]) {
        largest = right
    }

    if (largest != index) {
        swap(index, largest)
        maxHeapify(largest, heapSize)
    }
}

private fun <T : Comparable<T>> Array<T>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}