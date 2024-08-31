package com.roanderson.design_compose.visualtransformation

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.VisualTransformation

class CepVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.text.length >= 8) text.text.substring(0, 8) else text.text
        val out = buildString {
            for (i in trimmed.indices) {
                if (i == 5) append("-")
                append(trimmed[i])
            }
        }

        val cepOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                if (offset <= 5) return offset
                if (offset <= 8) return offset + 1
                return 9
            }

            override fun transformedToOriginal(offset: Int): Int {
                if (offset <= 5) return offset
                if (offset <= 9) return offset - 1
                return 8
            }
        }

        return TransformedText(AnnotatedString(out), cepOffsetTranslator)
    }
}
