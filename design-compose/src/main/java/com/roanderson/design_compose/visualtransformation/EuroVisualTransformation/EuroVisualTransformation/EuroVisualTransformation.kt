import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.basicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.TextFieldValue

class EuroVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val formattedText = text.text.replace(Regex("\\D"), "") 
            .let { value ->
                if (value.isEmpty()) "0.00" else String.format("%.2f", value.toDouble() / 100)
            }

        val finalText = "$formattedText €"
        return TransformedText(AnnotatedString(finalText), OffsetMapping.Identity)
    }
}

@Composable
fun EuroTextField(value: TextFieldValue, onValueChange: (TextFieldValue) -> Unit) {
    BasicTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        visualTransformation = remember { EuroVisualTransformation() },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        )
    )
}
