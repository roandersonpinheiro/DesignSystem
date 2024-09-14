import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.AnnotatedString
import java.text.NumberFormat
import java.util.Locale

class MoneyVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
       
        val formattedText = formatCurrency(text.text)
        return TransformedText(AnnotatedString(formattedText), OffsetMapping.Identity)
    }

    private fun formatCurrency(input: String): String {
        return try {
       
            val cleanString = input.replace("[^\\d]".toRegex(), "")
            val parsed = cleanString.toDouble() / 100 // Divida para obter casas decimais
            NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(parsed)
        } catch (e: Exception) {
            input 
        }
    }
}
