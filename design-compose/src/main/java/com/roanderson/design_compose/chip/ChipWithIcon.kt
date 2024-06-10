package com.roanderson.design_compose.chip

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipWithIcon(
    text: String,
    icon: Int,
    onClick: () -> Unit
) {
    AssistChip(
        onClick = onClick,
        label = { Text(text) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.padding(end = 4.dp)
            )
        },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = Color.LightGray,
            labelColor = Color.Black,
            leadingIconColor = Color.Black
        )
    )
}