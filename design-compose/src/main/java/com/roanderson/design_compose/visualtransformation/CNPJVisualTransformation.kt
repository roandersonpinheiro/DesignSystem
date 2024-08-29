package com.roanderson.design_compose.visualtransformation

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class CNPJVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val formatted = buildString {
            for (i in text.text.indices) {
                append(
                    when (i) {
                        2, 5 -> "."
                        8 -> "/"
                        12 -> "-"
                        else -> text.text[i]
                    }
                )
            }
        }

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return when {
                    offset <= 2 -> offset
                    offset <= 5 -> offset + 1
                    offset <= 8 -> offset + 2
                    offset <= 12 -> offset + 3
                    else -> offset + 4
                }
            }

            override fun transformedToOriginal(offset: Int): Int {
                return when {
                    offset <= 3 -> offset
                    offset <= 7 -> offset - 1
                    offset <= 11 -> offset - 2
                    offset <= 16 -> offset - 3
                    else -> offset - 4
                }
            }
        }

        return TransformedText(AnnotatedString(formatted), offsetMapping)
    }
}
