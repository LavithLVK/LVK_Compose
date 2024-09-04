package com.example.lvk_todo.screens.quotes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.lvk_todo.models.Quote

@Composable
fun QuotesList(quotes: Array<Quote>, onClick: (quote: Quote) -> Unit) {

    LazyColumn(content = {
        items(quotes) { item ->
            QuotesListItem(text = item.bio, author = item.name) { quote ->
                onClick.invoke(quote)
            }
        }
    })
}