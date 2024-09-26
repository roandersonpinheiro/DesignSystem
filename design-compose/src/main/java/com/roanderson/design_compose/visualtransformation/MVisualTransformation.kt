class MVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val newText = "${text.text} m"
        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int = offset
            override fun transformedToOriginal(offset: Int): Int = offset.coerceAtMost(text.text.length)
        }
        return TransformedText(AnnotatedString(newText), offsetMapping)
    }
}
