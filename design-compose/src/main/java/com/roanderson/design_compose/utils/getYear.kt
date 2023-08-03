package com.roanderson.design_compose.utils

import java.util.Calendar

fun getYear(): Int {
    val calendar = Calendar.getInstance()
    return calendar.get(Calendar.YEAR)
}