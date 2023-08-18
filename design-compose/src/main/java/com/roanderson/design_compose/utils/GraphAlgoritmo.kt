package com.roanderson.design_compose.utils

class GraphAlgoritmo(val vertices: Int) {
    val adjacencyList: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    fun addEdge(source: Int, destination: Int) {
        adjacencyList.computeIfAbsent(source) { mutableListOf() }.add(destination)
        adjacencyList.computeIfAbsent(destination) { mutableListOf() }.add(source)
    }
}

fun greedyColoring(graph: Graph): Map<Int, Int> {
    val colors: MutableMap<Int, Int> = mutableMapOf()

    for (vertex in 0 until graph.vertices) {
        val usedColors: MutableSet<Int> = mutableSetOf()

        // Check colors of adjacent vertices and mark them as used
        graph.adjacencyList[vertex]?.forEach { neighbor ->
            colors[neighbor]?.let { usedColors.add(it) }
        }

        // Find the first available color
        val availableColor = generateSequence(1) { it + 1 }.first { it !in usedColors }
        colors[vertex] = availableColor
    }

    return colors
}

fun main() {
    val graph = Graph(5)
    graph.addEdge(0, 1)
    graph.addEdge(0, 2)
    graph.addEdge(1, 2)
    graph.addEdge(1, 3)
    graph.addEdge(2, 3)
    graph.addEdge(3, 4)

    val vertexColors = greedyColoring(graph)

    println("Vertex Colors:")
    vertexColors.forEach { (vertex, color) ->
        println("Vertex $vertex: Color $color")
    }
}
