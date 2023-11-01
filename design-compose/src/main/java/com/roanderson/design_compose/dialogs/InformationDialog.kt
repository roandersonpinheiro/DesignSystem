package com.roanderson.design_compose.dialogs

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InformationDialog(
    showDialog: Boolean,
    onCloseDialog: () -> Unit,
    title: String,
    message: String
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onCloseDialog() },
            title = { Text(text = title, fontSize = 20.sp) },
            text = { Text(text = message) },
            buttons = {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { onCloseDialog() },
                        modifier = Modifier
                            .padding(8.dp)
                            .width(100.dp)
                    ) {
                        Text(text = "OK")
                    }
                }
            }
        )
    }
}
