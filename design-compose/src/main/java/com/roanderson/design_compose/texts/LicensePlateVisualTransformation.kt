import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class LicensePlateVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
      
        val trimmed = if (text.text.length >= 7) text.text.substring(0, 7) else text.text
        val out = StringBuilder()

        for (i in trimmed.indices) {
            if (i == 3) out.append("-")
            out.append(trimmed[i])
        }

    
        val licensePlateOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return if (offset <= 3) offset else offset + 1
            }

            override fun transformedToOriginal(offset: Int): Int {
                return if (offset <= 3) offset else offset - 1
            }
        }

        return TransformedText(AnnotatedString(out.toString()), licensePlateOffsetTranslator)
    }
}
