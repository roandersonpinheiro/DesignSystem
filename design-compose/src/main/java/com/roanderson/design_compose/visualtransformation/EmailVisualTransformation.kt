import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.VisualTransformation

class EmailVisualTransformation : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {
       
        val atIndex = text.text.indexOf('@')

     
        if (atIndex == -1) {
            return TransformedText(text, OffsetMapping.Identity)
        }

       
        val maskedText = AnnotatedString("*".repeat(atIndex) + text.text.substring(atIndex))

    
        return TransformedText(maskedText, OffsetMapping.Identity)
    }
}
