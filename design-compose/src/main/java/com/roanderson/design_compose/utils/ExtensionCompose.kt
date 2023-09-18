package com.roanderson.design_compose.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.myCustomMargin(
    start: Dp = 0.dp,
    top: Dp = 0.dp,
    end: Dp = 0.dp,
    bottom: Dp = 0.dp
): Modifier {
    return this.then(
        Modifier.padding(
            start = start,
            top = top,
            end = end,
            bottom = bottom
        )
    )
}