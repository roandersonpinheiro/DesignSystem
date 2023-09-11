package com.roanderson.design_compose.fields

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun CreditCardTextField(
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }

    BasicTextField(
        value = text,
        onValueChange = {
            val newText = it.filter { char -> char.isDigit() }
            text = applyCreditCardMask(newText)
            onValueChange(newText)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
            }
        ),
        textStyle = TextStyle(color = Color.Black),
        modifier = modifier
    )
}

private fun applyCreditCardMask(text: String): String {
    val maskedText = StringBuilder()
    for (i in text.indices) {
        maskedText.append(text[i])
        if ((i + 1) % 4 == 0 && i < text.length - 1) {
            maskedText.append("-")
        }
    }
    return maskedText.toString()
}
