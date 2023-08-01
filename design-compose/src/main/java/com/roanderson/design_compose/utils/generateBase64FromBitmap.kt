package com.roanderson.design_compose.utils

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream

fun generateBase64FromBitmap(bitmap: Bitmap): String {
    val outputStream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
    val byteArray = outputStream.toByteArray()
    val base64String = Base64.encodeToString(byteArray, Base64.DEFAULT)
    return base64String
}