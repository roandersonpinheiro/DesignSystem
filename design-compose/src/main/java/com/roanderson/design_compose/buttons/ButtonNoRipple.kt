package com.roanderson.design_compose.buttons

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonNoRipple(context: Context = LocalContext.current.applicationContext) {

    // This is used to disable the ripple effect
    val interactionSource = remember {
        MutableInteractionSource()
    }

    Box(
        modifier = Modifier
            .padding(start = 32.dp, end = 32.dp)
            .background(color = Color.Red)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(
                indication = null, // Assign null to disable the ripple effect
                interactionSource = interactionSource
            ) {
                Toast
                    .makeText(context, "No Ripple Click", Toast.LENGTH_SHORT)
                    .show()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "No Ripple",
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
    }
}