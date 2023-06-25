package com.roanderson.design_compose.texts

import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

@Composable
fun Example() {
    NormalTextField(label = "Email") {
        Icon(
            imageVector = Icons.Outlined.Email,
            contentDescription = null
        )
    }
}

@Composable
fun NormalTextField(
    label: String,
    Icon: @Composable (() -> Unit)
) {
    val (text, setText) = mutableStateOf("")
    TextField(
        leadingIcon = Icon,
        value = text,
        onValueChange = setText,
        label = { Text(text = label) }
    )
}