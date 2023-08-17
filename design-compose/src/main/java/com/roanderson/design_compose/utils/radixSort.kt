package com.roanderson.design_compose.utils

fun radixSort(arr: IntArray) {
    val maxNum = arr.maxOrNull() ?: return

    var exp = 1
    val n = arr.size
    val output = IntArray(n)
    
    while (maxNum / exp > 0) {
        val count = IntArray(10) { 0 }

        for (i in 0 until n) {
            count[(arr[i] / exp) % 10]++
        }

        for (i in 1 until 10) {
            count[i] += count[i - 1]
        }

        for (i in n - 1 downTo 0) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i]
            count[(arr[i] / exp) % 10]--
        }

        for (i in 0 until n) {
            arr[i] = output[i]
        }

        exp *= 10
    }
}

fun main() {
    val arr = intArrayOf(170, 45, 75, 90, 802, 24, 2, 66)
    println("Original array: ${arr.joinToString()}")

    radixSort(arr)

    println("Sorted array: ${arr.joinToString()}")
}
