package com.roanderson.design_compose.utils

fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = partition(arr, low, high)
        quickSort(arr, low, pivotIndex - 1)
        quickSort(arr, pivotIndex + 1, high)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1

    for (j in low until high) {
        if (arr[j] < pivot) {
            i++
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }

    val temp = arr[i + 1]
    arr[i + 1] = arr[high]
    arr[high] = temp

    return i + 1
}

fun main() {
    val arr = intArrayOf(64, 34, 25, 12, 22, 11, 90)
    val n = arr.size

    quickSort(arr, 0, n - 1)

    println("Array ordenado:")
    for (element in arr) {
        println(element)
    }
}
