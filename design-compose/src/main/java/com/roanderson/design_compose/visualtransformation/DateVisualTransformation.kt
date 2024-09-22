class DateVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val digits = text.text.filter { it.isDigit() }
        val builder = StringBuilder()

        for (i in digits.indices) {
            when (i) {
                2, 4 -> builder.append("/")
            }
            builder.append(digits[i])
        }

        val transformed = builder.toString()

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return when {
                    offset <= 2 -> offset
                    offset <= 4 -> offset + 1 
                    offset <= 8 -> offset + 2 
                    else -> transformed.length
                }
            }

            override fun transformedToOriginal(offset: Int): Int {
                return when {
                    offset <= 2 -> offset
                    offset <= 5 -> offset - 1 
                    offset <= 10 -> offset - 2
                    else -> digits.length
                }
            }
        }

        return TransformedText(AnnotatedString(transformed), offsetMapping)
    }
}
