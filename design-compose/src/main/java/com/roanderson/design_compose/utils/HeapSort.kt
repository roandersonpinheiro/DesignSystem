package com.roanderson.design_compose.utils

fun heapify(arr: IntArray, n: Int, i: Int) {
    var largest = i
    val left = 2 * i + 1
    val right = 2 * i + 2

    if (left < n && arr[left] > arr[largest]) {
        largest = left
    }

    if (right < n && arr[right] > arr[largest]) {
        largest = right
    }

    if (largest != i) {
        val swap = arr[i]
        arr[i] = arr[largest]
        arr[largest] = swap

        heapify(arr, n, largest)
    }
}

fun heapSort(arr: IntArray) {
    val n = arr.size

    // Construir o heap máximo
    for (i in n / 2 - 1 downTo 0) {
        heapify(arr, n, i)
    }

    // Extrair elementos do heap
    for (i in n - 1 downTo 1) {
        val temp = arr[0]
        arr[0] = arr[i]
        arr[i] = temp

        heapify(arr, i, 0)
    }
}

fun main() {
    val arr = intArrayOf(12, 11, 13, 5, 6, 7)
    val n = arr.size

    println("Array original:")
    println(arr.joinToString(", "))

    heapSort(arr)

    println("Array ordenado usando Heap Sort:")
    println(arr.joinToString(", "))
}
