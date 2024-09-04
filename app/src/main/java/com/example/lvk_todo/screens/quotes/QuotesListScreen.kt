package com.example.lvk_todo.screens.quotes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.lvk_todo.models.Quote

@Composable
fun QuotesListScreen(quotes: Array<Quote>, onClick: (quote: Quote) -> Unit) {

    Column {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(10.dp),
            style = MaterialTheme.typography.headlineMedium
        )
        QuotesList(quotes = quotes) { quote ->
            onClick.invoke(quote)
        }
    }
}