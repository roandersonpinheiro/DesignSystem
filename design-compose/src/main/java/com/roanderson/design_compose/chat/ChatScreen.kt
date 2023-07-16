package com.roanderson.design_compose.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ChatScreen() {
    val messages = remember { mutableStateListOf<String>() }
    val newMessage = remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(messages) { message ->
                Text(text = message, modifier = Modifier.padding(8.dp))
            }
        }

        Row(modifier = Modifier.padding(8.dp)) {
            TextField(
                value = newMessage.value,
                onValueChange = { newMessage.value = it },
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {
                    messages.add(newMessage.value)
                    newMessage.value = ""
                },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = "Enviar")
            }
        }
    }
}
