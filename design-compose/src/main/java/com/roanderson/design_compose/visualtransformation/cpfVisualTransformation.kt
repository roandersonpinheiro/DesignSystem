package com.roanderson.design_compose.visualtransformation

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

fun cpfVisualTransformation(): VisualTransformation {
    return VisualTransformation { text ->

        val digits = text.text.filter { it.isDigit() }

        val formatted = StringBuilder()
        for (i in digits.indices) {
            formatted.append(digits[i])
            if (i == 2 || i == 5) {
                formatted.append('.')
            } else if (i == 8) {
                formatted.append('-')
            }
        }
        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return when {
                    offset <= 2 -> offset
                    offset <= 5 -> offset + 1
                    offset <= 8 -> offset + 2
                    offset <= 11 -> offset + 3
                    else -> 14
                }
            }

            override fun transformedToOriginal(offset: Int): Int {
                return when {
                    offset <= 3 -> offset
                    offset <= 7 -> offset - 1
                    offset <= 11 -> offset - 2
                    offset <= 14 -> offset - 3
                    else -> 11
                }
            }
        }

        TransformedText(AnnotatedString(formatted.toString()), offsetMapping)
    }
}
