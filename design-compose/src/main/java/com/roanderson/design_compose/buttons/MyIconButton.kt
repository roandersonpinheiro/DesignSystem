package com.roanderson.design_compose.buttons

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyIconButton(){
    IconButton(modifier = Modifier.
    then(Modifier.size(24.dp)),
        onClick = { }) {
        Icon(
            Icons.Filled.Search,
            "contentDescription",
            tint = Color.White)
    }
}