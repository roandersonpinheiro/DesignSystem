@Composable
fun CustomCard(
    title: String,
    content: @Composable () -> Unit,
    footer: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(16.dp)
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(padding)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            content()
            Spacer(modifier = Modifier.height(8.dp))
            footer()
        }
    }
}
