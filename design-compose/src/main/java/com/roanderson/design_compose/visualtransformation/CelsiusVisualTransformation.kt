import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class CelsiusVisualTransformation : VisualTransformation {
    override fun filter(text: androidx.compose.ui.text.AnnotatedString): TransformedText {
      
        val transformedText = text.text + "°C"

      
        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return offset
            }

            override fun transformedToOriginal(offset: Int): Int {
                return offset.coerceAtMost(text.length)
            }
        }

        return TransformedText(androidx.compose.ui.text.AnnotatedString(transformedText), offsetMapping)
    }
}
