package com.roanderson.design_compose.banner

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Banner(
    text: String,
    button1Text: String? = null,
    button2Text: String? = null,
    button1ClickListener: (() -> Unit)? = null,
    button2ClickListener: (() -> Unit)? = null,
) {
    Column {
        Text(
            text = text,
            modifier = Modifier.padding(16.dp),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    bottom = 8.dp,
                ),
            horizontalArrangement = Arrangement.End,
        ) {
            button1Text?.let {
                TextButton(
                    onClick = if (button1ClickListener != null) {
                        button1ClickListener
                    } else {
                        {}
                    }
                ) {
                    Text(
                        text = button1Text,
                    )
                }
            }
            button2Text?.let {
                TextButton(
                    onClick = if (button2ClickListener != null) {
                        button2ClickListener
                    } else {
                        {}
                    }
                ) {
                    Text(
                        text = button2Text,
                    )
                }
            }
        }
        Divider()
    }
}

//@Composable
//fun BannerUsage() {
//    Banner(
//        text = "There was a problem processing a transaction on your credit card.",
//        button1Text = "FIX IT",
//        button2Text = "LEARN MORE",
//    )
//}