import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.AnnotatedString

class BankAccountVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val cleaned = text.text.replace(Regex("[^\\d]"), "") 
        val formatted = StringBuilder()

        
        for (i in cleaned.indices) {
            when (i) {
                0, 3, 6 -> if (i < cleaned.length) formatted.append('.')
                9 -> if (i < cleaned.length) formatted.append('-')
            }
            if (i < cleaned.length) formatted.append(cleaned[i])
        }

        return TransformedText(AnnotatedString(formatted.toString()), OffsetMapping.Identity)
    }
}
