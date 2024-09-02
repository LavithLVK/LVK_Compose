package com.example.lvk_todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.lvk_todo.screens.QuoteDetailScreen
import com.example.lvk_todo.screens.QuotesListScreen
import com.example.lvk_todo.utils.Constants
import com.example.lvk_todo.utils.DataManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            DataManager.loadAssets(applicationContext, "quotes.json")
        }

        setContent {

//            ListScreen()
//            StateHostingScreen()
            launchQuotesScreen()


        }
    }

}

@Composable
fun launchQuotesScreen() {
    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPageState.value == Constants.QuotesPages.LISTING) {
            QuotesListScreen(quotes = DataManager.data) { quote ->
                DataManager.switchPages(quote)
            }
        } else {
            val quote = DataManager.curentQuote.value
            quote?.let { QuoteDetailScreen(it) }
        }
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}
