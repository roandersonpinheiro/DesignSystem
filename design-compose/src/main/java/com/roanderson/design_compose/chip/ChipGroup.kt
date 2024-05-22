package com.roanderson.design_compose.chip

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChipGroup(
    chips: List<String>,
    onChipSelected: (String) -> Unit = {},
) {
    Column {
        chips.forEach { chipName ->
            Chip(
                name = chipName,
                isSelected = false,
                onSelectionChanged = { onChipSelected(it) }
            )
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}