import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.OffsetMapping

class CreditCardVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
       
        val trimmed = text.text.filter { it.isDigit() }.take(16)
        val sb = StringBuilder()

        for (i in trimmed.indices) {
            sb.append(trimmed[i])
            
            if ((i + 1) % 4 == 0 && i != trimmed.length - 1) {
                sb.append(" ")
            }
        }

        val formattedText = AnnotatedString(sb.toString())

        return TransformedText(
            text = formattedText,
            offsetMapping = object : OffsetMapping {
                override fun originalToTransformed(offset: Int): Int {
                  
                    return offset + offset / 4
                }

                override fun transformedToOriginal(offset: Int): Int {
                  
                    return offset - offset / 5
                }
            }
        )
    }
}
