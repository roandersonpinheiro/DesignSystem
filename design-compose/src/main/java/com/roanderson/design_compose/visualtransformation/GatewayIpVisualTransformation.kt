import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class GatewayIpVisualTransformation : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {
    
        val trimmed = text.text.take(18)

      
        val transformedText = buildString {
            var ipSectionCounter = 0 
            for (i in trimmed.indices) {
                append(trimmed[i])
               
                if (i != 0 && (i + 1) % 4 == 0 && ipSectionCounter < 3) {
                    append(".")
                    ipSectionCounter++
                }
                
                if (i == 11 && trimmed.contains("/").not()) {
                    append("/")
                }
            }
        }

       
        val gatewayOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                if (offset <= 12) return offset + (offset / 4)
                return offset + (offset / 4) + 1 
            }

            override fun transformedToOriginal(offset: Int): Int {
                if (offset <= 12) return offset - (offset / 4)
                return offset - (offset / 5) - 1 
            }
        }

        return TransformedText(AnnotatedString(transformedText), gatewayOffsetTranslator)
    }
}
