import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.OffsetMapping

class DateTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val cleaned = text.text.replace(Regex("[^\\d]"), "")
        val formatted = StringBuilder()

      
        for (i in cleaned.indices) {
            if (i == 2 || i == 4) {
                formatted.append('/')
            }
            formatted.append(cleaned[i])
        }

        return TransformedText(AnnotatedString(formatted.toString()), OffsetMapping.Identity)
    }
}
