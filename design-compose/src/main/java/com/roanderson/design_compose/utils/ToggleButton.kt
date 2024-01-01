package com.roanderson.design_compose.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ToggleButton(
    isChecked: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(56.dp)
            .background(if (isChecked) MaterialTheme.colors.onPrimary else Color.Gray)
            .clickable { onToggle(!isChecked) }
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = null,
            modifier = Modifier.size(48.dp)
        )
    }
}
