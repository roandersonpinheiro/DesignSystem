package com.roanderson.design_compose.utils

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun CpfValidationScreen() {
    var cpfText by remember { mutableStateOf(TextFieldValue()) }
    var isValidCpf by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = cpfText,
            onValueChange = {
                cpfText = it
                isValidCpf = validateCpf(it)
            },
            label = { Text("CPF") },
            isError = !isValidCpf,
            textStyle = MaterialTheme.typography.body1,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (isValidCpf) {
            Text("CPF válido", color = Color.Green)
        } else if (cpfText.text.isNotEmpty()) {
            Text("CPF inválido", color = Color.Red)
        }
    }
}

fun validateCpf(cpf: String): Boolean {
    val cleanCpf = cpf.replace(Regex("[^\\d]"), "")

    if (cleanCpf.length != 11) {
        return false
    }

    // Implement your CPF validation logic here
    // You can use a CPF validation library or implement the algorithm manually

    // Example of a simple manual validation algorithm (not recommended for production)
    var sum = 0
    for (i in 0 until 9) {
        sum += cleanCpf[i].toString().toInt() * (10 - i)
    }
    var digit1 = 11 - (sum % 11)
    if (digit1 >= 10) {
        digit1 = 0
    }

    // Similar logic for the second digit
    // ...

    return cleanCpf.endsWith(digit1.toString() + digit2.toString())
}
