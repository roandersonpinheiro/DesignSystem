package com.roanderson.design_compose.utils

class BellmanFord(val vertices: Int, val edges: MutableList<Edge>) {
    data class Edge(val source: Int, val destination: Int, val weight: Int)

    fun bellmanFord(startVertex: Int) {
        val distances = IntArray(vertices) { if (it == startVertex) 0 else Int.MAX_VALUE }
        val parents = IntArray(vertices) { -1 }

        for (i in 1 until vertices) {
            for (edge in edges) {
                val u = edge.source
                val v = edge.destination
                val w = edge.weight
                if (distances[u] != Int.MAX_VALUE && distances[u] + w < distances[v]) {
                    distances[v] = distances[u] + w
                    parents[v] = u
                }
            }
        }

        for (edge in edges) {
            val u = edge.source
            val v = edge.destination
            val w = edge.weight
            if (distances[u] != Int.MAX_VALUE && distances[u] + w < distances[v]) {
                println("Graph contains negative weight cycle")
                return
            }
        }

        println("Vertex\tDistance\tPath")
        for (i in 0 until vertices) {
            print("$i\t\t${distances[i]}\t\t")
            printPath(i, parents)
            println()
        }
    }

    private fun printPath(currentVertex: Int, parents: IntArray) {
        if (currentVertex == -1) return
        printPath(parents[currentVertex], parents)
        print("$currentVertex ")
    }
}
