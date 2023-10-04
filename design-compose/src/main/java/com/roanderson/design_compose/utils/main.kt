package com.roanderson.design_compose.utils

import java.util.Timer
import java.util.TimerTask

fun main() {
    startTimer()
}

fun startTimer() {
    val timer = Timer()

    val task = object : TimerTask() {
        override fun run() {
            println("Temporizador executado!")
        }
    }

    timer.scheduleAtFixedRate(task, 0, 1000)
}
