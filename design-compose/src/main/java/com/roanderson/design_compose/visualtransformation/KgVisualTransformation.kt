import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.VisualTransformation

class KgVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val newText = "${text.text} kg"
        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return offset
            }

            override fun transformedToOriginal(offset: Int): Int {
                return offset.coerceAtMost(text.text.length)
            }
        }
        return TransformedText(AnnotatedString(newText), offsetMapping)
    }
}
