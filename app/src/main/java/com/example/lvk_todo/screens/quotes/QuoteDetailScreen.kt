package com.example.lvk_todo.screens.quotes

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lvk_todo.models.Quote
import com.example.lvk_todo.utils.QuotesDataManager

@Preview
@Composable
fun QuoteDetailViewPreview() {
    QuoteDetailScreen(
        Quote(
            "afsasf sfdsdgd fhgsfsdgsdg sdgsdgsdghs ghsdgsdhdfhgdfh sdgsdgdfhdfh asfsagdsdhgdfh",
            "Addref Ghazzar"
        )
    )
}

@Composable
fun QuoteDetailScreen(quote: Quote) {

    BackHandler {
        QuotesDataManager.switchPages(null)
    }

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(Color.Gray, Color.White)
                )
            )
    ) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(4.dp),
            modifier = Modifier
                .padding(20.dp),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Image(
                    imageVector = Icons.Filled.FormatQuote, contentDescription = "Quote",
                    colorFilter = ColorFilter.tint(Color.Black),
                    modifier = Modifier
                        .size(70.dp)
                        .rotate(180f)
                )
                Text(
                    text = quote.bio,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .background(Color.LightGray)
                        .fillMaxWidth(.4f)
                        .padding(top = 10.dp)

                )
                Text(
                    text = quote.name,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(10.dp)
                )
            }

        }
    }
}