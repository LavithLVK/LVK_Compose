package com.example.lvk_todo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lvk_todo.models.Quote

@Composable
fun QuotesListItem(text: String, author: String, onClick: (quote: Quote) -> Unit) {

    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .padding(10.dp)
            .clickable { onClick.invoke(Quote(text, author)) },
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(40.dp)
                    .padding(top = 4.dp)
                    .rotate(180f)
                    .background(Color.Black),
                alignment = Alignment.TopStart,
                contentDescription = "Quote",
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = text,
                    modifier = Modifier.padding(bottom = 5.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .background(Color.LightGray)
                        .fillMaxWidth(.4f)
                ) {
                }
                Text(
                    text = author, modifier = Modifier.padding(top = 5.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.ExtraLight
                )

            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun QuoteListItemPreview() {
    QuotesListItem(
        "afsasf sfdsdgd fhgsfsdgsdg sdgsdgsdghs ghsdgsdhdfhgdfh sdgsdgdfhdfh asfsagdsdhgdfh",
        "Addref Ghazzar"
    ) {}
}