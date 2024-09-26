import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText

class CmVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val newText = "${text.text} cm"
        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int = offset
            override fun transformedToOriginal(offset: Int): Int = offset.coerceAtMost(text.text.length)
        }
        return TransformedText(AnnotatedString(newText), offsetMapping)
    }
}
