package com.roanderson.design_compose.icons

import android.widget.Toast
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun MyUI() {
    val contextForToast = LocalContext.current.applicationContext

    IconButton(
        onClick = {
            Toast.makeText(contextForToast, "Click!", Toast.LENGTH_SHORT).show()
        }
    ) {
        Icon(imageVector = Icons.Outlined.Add, contentDescription = "")
    }
}
