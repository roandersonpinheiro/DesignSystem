package com.roanderson.design_compose.utils

fun selectionSort(arr: IntArray) {
    val n = arr.size

    for (i in 0 until n - 1) {
        var minIndex = i
        for (j in i + 1 until n) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j
            }
        }
        if (minIndex != i) {
            val temp = arr[i]
            arr[i] = arr[minIndex]
            arr[minIndex] = temp
        }
    }
}

fun main() {
    val arr = intArrayOf(64, 25, 12, 22, 11)
    println("Array original: ${arr.joinToString()}")
    
    selectionSort(arr)
    
    println("Array ordenado: ${arr.joinToString()}")
}
