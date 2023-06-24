package com.roanderson.design_compose.texts

import android.graphics.fonts.FontFamily
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun TextExample(){
     Column {
            Text("Just Text")
            Text("Text with cursive font")
            Text(
                text = "Text with LineThrough",
                style = TextStyle(textDecoration = TextDecoration.LineThrough)
            )
            Text(
                text = "Text with underline",
                style = TextStyle(textDecoration = TextDecoration.Underline)
            )
            Text(
                text = "Text with underline, linethrough and bold",
                style = TextStyle(
                    textDecoration = TextDecoration.combine(
                        listOf(
                            TextDecoration.Underline,
                            TextDecoration.LineThrough
                        )
                    ), fontWeight = FontWeight.Bold
                )
            )
        }
}