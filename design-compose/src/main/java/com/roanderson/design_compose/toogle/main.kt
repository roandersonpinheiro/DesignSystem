package com.roanderson.design_compose.toogle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable

@Composable
fun ToggleComponent() {
    val isChecked = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Switch(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MaterialTheme.colors.primary,
                checkedTrackColor = MaterialTheme.colors.primary.copy(alpha = 0.4f)
            )
        )
    }
}