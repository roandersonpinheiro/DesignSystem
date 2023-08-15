package com.roanderson.design_compose.utils

fun insertionSort(arr: IntArray) {
    for (i in 1 until arr.size) {
        val currentElement = arr[i]
        var j = i - 1
        
        while (j >= 0 && arr[j] > currentElement) {
            arr[j + 1] = arr[j]
            j--
        }
        
        arr[j + 1] = currentElement
    }
}

fun main() {
    val array = intArrayOf(5, 2, 9, 1, 5, 6)
    println("Original Array: ${array.joinToString()}")
    
    insertionSort(array)
    
    println("Sorted Array: ${array.joinToString()}")
}
