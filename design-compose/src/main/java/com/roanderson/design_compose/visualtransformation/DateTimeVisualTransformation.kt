import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.TextFieldValue
import java.text.SimpleDateFormat
import java.util.Locale

class DateTimeVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
     
        val input = text.text.replace("[^0-9]".toRegex(), "") 

  
        val formatted = StringBuilder()
        for (i in input.indices) {
            if (i > 0 && i % 2 == 0 && i < 8) {
                formatted.append("/")
            }
            if (i == 8) {
                formatted.append(" ") 
            }
            if (i > 8 && (i - 8) % 2 == 0 && i < 14) {
                formatted.append(":") 
            }
            formatted.append(input[i])
        }

        return TransformedText(AnnotatedString(formatted.toString()), OffsetMapping.Identity)
    }
}
