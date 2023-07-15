package com.roanderson.design_compose.checkbox

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun CheckboxComponent() {
    // Lembre-se do estado atual do checkbox
    val isChecked = remember { mutableStateOf(false) }

    Row(modifier = Modifier.padding(16.dp)) {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = "Checkbox",
            fontSize = 16.sp,
            color = if (isChecked.value) Color.Black else Color.Gray
        )
    }
}
