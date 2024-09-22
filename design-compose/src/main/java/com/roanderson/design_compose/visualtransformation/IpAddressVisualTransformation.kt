import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping

class IpAddressVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = text.text.take(12)

        
        val transformedText = buildString {
            for (i in trimmed.indices) {
                append(trimmed[i])
                if ((i + 1) % 3 == 0 && i != trimmed.lastIndex) {
                    append(".")
                }
            }
        }

        val ipOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return if (offset <= 3) offset else offset + (offset - 1) / 3
            }

            override fun transformedToOriginal(offset: Int): Int {
                return if (offset <= 3) offset else offset - (offset - 1) / 4
            }
        }

        return TransformedText(AnnotatedString(transformedText), ipOffsetTranslator)
    }
}
