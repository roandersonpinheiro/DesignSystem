package com.roanderson.design_compose.stringresources

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.sp

@Composable
fun textMultiStyle(
    originalText: String,
    customTextList: List<TextWithStyle>
): AnnotatedString {
    var annotatedString = buildAnnotatedString { append(originalText) }

    customTextList.forEach { textExcerpt ->
        annotatedString = buildAnnotatedString {
            val startIndex = annotatedString.indexOf(textExcerpt.customText)
            val endIndex = startIndex + textExcerpt.customText.length
            append(annotatedString)
            addStyle(
                style = textExcerpt.style.toSpanStyle(),
                start = startIndex,
                end = endIndex
            )
        }
    }
    return annotatedString
}

data class TextWithStyle(
    val customText: String,
    val style: TextStyle
)

@Composable
private fun Preview() {
    Text(
        text = textMultiStyle(
            originalText = "Quero esse trecho normal, esse em negrito, esse normal e esse em negrito laranja",
            customTextList = listOf(
                TextWithStyle(
                    customText = "esse em negrito",
                    style = TextStyle(fontSize = 16.sp)
                ),
                TextWithStyle(
                    customText = "esse em negrito laranja",
                    style = TextStyle(fontSize = 16.sp)
                ),
            )
        ),
    )
}