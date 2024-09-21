import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.TextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

class PhoneNumberVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val digits = text.text.filter { it.isDigit() }
        val builder = StringBuilder()
        var index = 0

        if (digits.isNotEmpty()) {
            builder.append("(")
            while (index < digits.length && index < 3) {
                builder.append(digits[index])
                index++
            }
            if (digits.length >= 3) {
                builder.append(") ")
            }
        }
        if (digits.length > 3) {
            while (index < digits.length && index < 6) {
                builder.append(digits[index])
                index++
            }
            if (digits.length >= 6) {
                builder.append("-")
            }
        }
        if (digits.length > 6) {
            while (index < digits.length && index < 10) {
                builder.append(digits[index])
                index++
            }
        }

        val transformed = builder.toString()

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                if (offset <= 0) return offset
                if (offset <= 3) return offset + 1 // "("
                if (offset <= 6) return offset + 3 // ") "
                if (offset <= 10) return offset + 4 // "-"
                return transformed.length
            }

            override fun transformedToOriginal(offset: Int): Int {
                if (offset <= 1) return offset
                if (offset <= 4) return offset - 1
                if (offset <= 9) return offset - 3
                if (offset <= 14) return offset - 4
                return 10
            }
        }

        return TransformedText(AnnotatedString(transformed), offsetMapping)
    }
}

@Composable
fun PhoneNumberInput() {
    var phone by remember { mutableStateOf("") }

    TextField(
        value = phone,
        onValueChange = { input ->
            // Filter out non-digit characters
            phone = input.filter { it.isDigit() }
        },
        label = { Text("Phone Number") },
        visualTransformation = PhoneNumberVisualTransformation(),
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun PhoneNumberInputPreview() {
    PhoneNumberInput()
}
