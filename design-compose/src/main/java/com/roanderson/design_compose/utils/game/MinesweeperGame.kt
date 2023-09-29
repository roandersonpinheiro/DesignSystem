package com.roanderson.design_compose.utils.game

import kotlin.random.Random

class MinesweeperGame(val size: Int, private val numMines: Int) {
    private val board: Array<Array<Int>> = Array(size) { Array(size) { 0 } }

    init {
        placeMines()
    }

    private fun placeMines() {
        val random = Random
        var minesRemaining = numMines

        while (minesRemaining > 0) {
            val row = random.nextInt(size)
            val col = random.nextInt(size)

            if (board[row][col] != -1) {
                board[row][col] = -1
                minesRemaining--
            }
        }
    }

    fun play(row: Int, col: Int): Boolean {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            println("Invalid coordinates.")
            return false
        }

        if (board[row][col] == -1) {
            println("You hit a mine! Game over!")
            return true
        }

        val minesAround = countMinesAround(row, col)
        board[row][col] = minesAround
        println("Mines around: $minesAround")
        return false
    }

    private fun countMinesAround(row: Int, col: Int): Int {
        val directions = arrayOf(-1, 0, 1)

        var minesAround = 0
        for (dx in directions) {
            for (dy in directions) {
                val newRow = row + dx
                val newCol = col + dy

                if (newRow in 0 until size && newCol in 0 until size) {
                    if (board[newRow][newCol] == -1) {
                        minesAround++
                    }
                }
            }
        }

        return minesAround
    }

    fun printBoard() {
        for (row in 0 until size) {
            for (col in 0 until size) {
                if (board[row][col] == -1) {
                    print("X ")
                } else {
                    print("${board[row][col]} ")
                }
            }
            println()
        }
    }
}

fun main() {
    val minesweeper = MinesweeperGame(5, 5)

    while (true) {
        println("Enter row and column to play (e.g., 2 3): ")
        val input = readLine()
        if (input == "exit") {
            break
        }

        val (row, col) = input?.split(" ")?.map { it.toInt() } ?: continue

        if (minesweeper.play(row, col)) {
            minesweeper.printBoard()
            break
        }

        minesweeper.printBoard()
    }
}
