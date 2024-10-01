import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.OffsetMapping

class TimeVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val formattedText = formatTime(text.text)
        return TransformedText(AnnotatedString(formattedText), OffsetMapping.Identity)
    }

    private fun formatTime(input: String): String {
        val digits = input.filter { it.isDigit() }
        return when (digits.length) {
            0 -> ""
            1 -> "${digits[0]}:"
            2 -> "${digits[0]}${digits[1]}:"
            3 -> "${digits[0]}${digits[1]}:${digits[2]}"
            4 -> "${digits[0]}${digits[1]}:${digits[2]}${digits[3]}"
            else -> "${digits.substring(0, 2)}:${digits.substring(2, 4)}"
        }.take(5) 
    }
}
