import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class DollarVisualTransformation : VisualTransformation {
    override fun filter(text: androidx.compose.ui.text.AnnotatedString): TransformedText {
      
        val transformedText = "$" + text.text

      
        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return offset + 1 
            }

            override fun transformedToOriginal(offset: Int): Int {
                return (offset - 1).coerceAtLeast(0)
            }
        }

  
        return TransformedText(androidx.compose.ui.text.AnnotatedString(transformedText), offsetMapping)
    }
}
