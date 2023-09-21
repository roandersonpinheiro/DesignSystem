package com.roanderson.design_compose.utils

import android.app.Activity
import android.widget.Toast

fun Activity.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Activity.finishActivity() {
    finish()
}

