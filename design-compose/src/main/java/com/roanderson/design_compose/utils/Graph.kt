package com.roanderson.design_compose.utils

import java.util.*

class Graph {
    private val vertices: Int
    private val adjacencyList: MutableMap<Int, MutableList<Pair<Int, Int>>> = mutableMapOf()

    constructor(vertices: Int) {
        this.vertices = vertices
    }

    fun addEdge(source: Int, destination: Int, weight: Int) {
        adjacencyList.computeIfAbsent(source) { mutableListOf() }.add(Pair(destination, weight))
        adjacencyList.computeIfAbsent(destination) { mutableListOf() }.add(Pair(source, weight))
    }

    fun shortestPath(startVertex: Int): List<Int> {
        val distances = IntArray(vertices) { Int.MAX_VALUE }
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        distances[startVertex] = 0
        pq.add(Pair(startVertex, 0))

        while (pq.isNotEmpty()) {
            val (currentVertex, currentDistance) = pq.poll()

            if (currentDistance > distances[currentVertex]) {
                continue
            }

            for ((neighbor, weight) in adjacencyList[currentVertex] ?: emptyList()) {
                val distance = currentDistance + weight
                if (distance < distances[neighbor]) {
                    distances[neighbor] = distance
                    pq.add(Pair(neighbor, distance))
                }
            }
        }

        return distances.toList()
    }
}

fun main() {
    val graph = Graph(5)

    graph.addEdge(0, 1, 4)
    graph.addEdge(0, 2, 1)
    graph.addEdge(1, 3, 1)
    graph.addEdge(2, 1, 2)
    graph.addEdge(2, 3, 5)
    graph.addEdge(3, 4, 3)

    val startVertex = 0
    val shortestDistances = graph.shortestPath(startVertex)

    println("Shortest distances from vertex $startVertex:")
    for (i in shortestDistances.indices) {
        println("Vertex $i: ${shortestDistances[i]}")
    }
}
