package com.roanderson.design_compose.utils

fun floodFill(matrix: Array<IntArray>, startX: Int, startY: Int, newColor: Int) {
    val oldColor = matrix[startX][startY]
    if (oldColor == newColor) {
        return
    }

    val rows = matrix.size
    val cols = matrix[0].size

    val queue = ArrayDeque<Pair<Int, Int>>()
    queue.add(Pair(startX, startY))

    val directions = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    while (queue.isNotEmpty()) {
        val (x, y) = queue.remove()

        if (matrix[x][y] != oldColor) {
            continue
        }

        matrix[x][y] = newColor

        for (dir in directions) {
            val newX = x + dir.first
            val newY = y + dir.second

            if (newX in 0 until rows && newY in 0 until cols && matrix[newX][newY] == oldColor) {
                queue.add(Pair(newX, newY))
            }
        }
    }
}

fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 1, 1, 1, 1),
        intArrayOf(1, 1, 1, 0, 0),
        intArrayOf(1, 0, 0, 1, 1),
        intArrayOf(1, 0, 1, 1, 1),
        intArrayOf(1, 1, 1, 1, 1)
    )

    val startX = 2
    val startY = 2
    val newColor = 2

    floodFill(matrix, startX, startY, newColor)

    for (row in matrix) {
        for (cell in row) {
            print("$cell ")
        }
        println()
    }
}
