package com.roanderson.design_compose.decoration

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TextFields() {
    Scaffold(
        modifier = Modifier
    ) { contentPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            var input by remember { mutableStateOf("Hi there") }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
            ) {
                BasicTextField(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(horizontal = 12.dp)
                        .border(width = 1.5.dp, color = Color.Black, RoundedCornerShape(12.dp)),
                    value = input,
                    textStyle = MaterialTheme.typography.h4,
                    onValueChange = {
                        input = it
                    },
                    maxLines = 1,
                    decorationBox = { innerTextField ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,

                            ) {
                            Text(text = "Hi enter your text...")
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier
                            ) {
                                Icon(
                                    Icons.Rounded.Person,
                                    contentDescription = "",
                                    Modifier
                                        .padding(8.dp)
                                        .size(30.dp)

                                )

                                innerTextField()

                                Icon(
                                    Icons.Rounded.Check,
                                    contentDescription = "",
                                    Modifier
                                        .padding(8.dp)
                                        .size(30.dp)
                                )

                            }
                        }

                    }
                )
            }
        }

    }
}
