package com.roanderson.design_compose.fields

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun MaskedTextField(
    modifier: Modifier = Modifier,
    value: String,
    mask: String,
    onValueChange: (String) -> Unit
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue(value)) }

    BasicTextField(
        modifier = modifier
            .border(1.dp, Color.Gray)
            .background(Color.White),
        value = textFieldValue,
        onValueChange = {
            val formattedText = applyMask(it.text, mask)
            textFieldValue = TextFieldValue(text = formattedText, selection = it.selection)
            onValueChange(formattedText)
        },
        textStyle = LocalTextStyle.current.copy(color = Color.Black),
    )
}

private fun applyMask(input: String, mask: String): String {
    var inputIndex = 0
    var maskIndex = 0
    val result = StringBuilder()

    while (maskIndex < mask.length && inputIndex < input.length) {
        when (mask[maskIndex]) {
            '#' -> {
                result.append(input[inputIndex])
                inputIndex++
            }

            else -> result.append(mask[maskIndex])
        }
        maskIndex++
    }

    return result.toString()
}

//MaskedTextField(
//value = "12345678901", // O valor inicial (pode ser vazio)
//mask = "###.###.###-##", // Máscara para CPF
//onValueChange = {
//    formattedValue ->
//    // Faça algo com o valor formatado do CPF
//}
//)
//
//MaskedTextField(
//value = "12345678000123", // O valor inicial (pode ser vazio)
//mask = "##.###.###/####-##", // Máscara para CNPJ
//onValueChange = {
//    formattedValue ->
//    // Faça algo com o valor formatado do CNPJ
//}
//)
