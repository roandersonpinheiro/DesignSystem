package com.roanderson.design_compose.utils

import kotlin.math.pow
import kotlin.math.sqrt

data class City(val x: Int, val y: Int)

fun calculateDistance(city1: City, city2: City): Double {
    val xDiff = city1.x - city2.x
    val yDiff = city1.y - city2.y
    return sqrt(xDiff.toDouble().pow(2.0) + yDiff.toDouble().pow(2.0))
}

fun calculateTotalDistance(path: List<City>): Double {
    var totalDistance = 0.0
    for (i in 0 until path.size - 1) {
        totalDistance += calculateDistance(path[i], path[i + 1])
    }
    totalDistance += calculateDistance(path.last(), path.first())
    return totalDistance
}

fun permute(cities: List<City>, start: Int, end: Int, permutations: MutableList<List<City>>) {
    if (start == end) {
        permutations.add(cities.toList())
    } else {
        for (i in start until end + 1) {
            cities.swap(start, i)
            permute(cities, start + 1, end, permutations)
            cities.swap(start, i)
        }
    }
}

fun List<City>.swap(i: Int, j: Int): List<City> {
    val result = this.toMutableList()
    val temp = result[i]
    result[i] = result[j]
    result[j] = temp
    return result
}

fun main() {
    val cities = listOf(
        City(0, 0),
        City(1, 3),
        City(4, 6),
        City(8, 2),
        City(6, 5)
    )

    val permutations = mutableListOf<List<City>>()
    permute(cities, 0, cities.size - 1, permutations)

    var shortestDistance = Double.MAX_VALUE
    var shortestPath = listOf<City>()

    for (path in permutations) {
        val distance = calculateTotalDistance(path)
        if (distance < shortestDistance) {
            shortestDistance = distance
            shortestPath = path
        }
    }

    println("Shortest path: $shortestPath")
    println("Shortest distance: $shortestDistance")
}
