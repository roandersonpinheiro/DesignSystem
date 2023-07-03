package com.roanderson.design_compose.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OvalButton(){
    OutlinedButton(
        onClick = { },
        border = BorderStroke(1.dp, Color.Red),
        shape = RoundedCornerShape(50), // = 50% percent
        // or shape = CircleShape
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
    ){
        Text( text = "Save" )
    }
}