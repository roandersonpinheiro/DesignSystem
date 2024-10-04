import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.TextRange

class RenavamVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val originalText = text.text

        
        val cleanedText = originalText.filter { it.isDigit() }

      
        val formattedText = when {
            cleanedText.length <= 3 -> cleanedText
            cleanedText.length <= 6 -> "${cleanedText.take(3)}.${cleanedText.drop(3)}"
            cleanedText.length <= 9 -> "${cleanedText.take(3)}.${cleanedText.drop(3).take(3)}.${cleanedText.drop(6)}"
            cleanedText.length > 9 -> "${cleanedText.take(3)}.${cleanedText.drop(3).take(3)}.${cleanedText.drop(6).take(3)}-${cleanedText.drop(9)}"
            else -> cleanedText
        }

      
        val cursorPosition = if (originalText.length > formattedText.length) {
            TextRange(formattedText.length)
        } else {
            TextRange(originalText.length)
        }

        return TransformedText(AnnotatedString(formattedText), cursorPosition)
    }
}
