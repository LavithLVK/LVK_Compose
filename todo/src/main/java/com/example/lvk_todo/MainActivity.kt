package com.example.lvk_todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.lvk_todo.screens.sideEffects.DisposableEffectExample
import com.example.lvk_todo.screens.sideEffects.LaunchEffectExample
import com.example.lvk_todo.screens.QuoteDetailScreen
import com.example.lvk_todo.screens.QuotesListScreen
import com.example.lvk_todo.screens.sideEffects.DerivedOfExample
import com.example.lvk_todo.screens.sideEffects.ProduceStateExample
import com.example.lvk_todo.screens.sideEffects.ProduceStateLoader
import com.example.lvk_todo.screens.sideEffects.RememberCoroutineScopeExample
import com.example.lvk_todo.utils.Constants
import com.example.lvk_todo.utils.QuotesDataManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        CoroutineScope(Dispatchers.IO).launch {
//            delay(3000)
//            QuotesDataManager.loadAssets(applicationContext)
//        }

        setContent {

//            ListScreen()
//            StateHostingScreen()
//            LaunchQuotesScreen()
//            LaunchCoroutineScopeExamples()
//            RememberUpdateStateExample()
//            DisposableEffectExample()

            LaunchProduceStateAndDerivedOfExamples()


        }
    }

}

@Composable
fun LaunchQuotesScreen() {
    if (QuotesDataManager.isDataLoaded.value) {
        if (QuotesDataManager.currentPageState.value == Constants.QuotesPages.LISTING) {
            QuotesListScreen(quotes = QuotesDataManager.data) { quote ->
                QuotesDataManager.switchPages(quote)
            }
        } else {
            val quote = QuotesDataManager.curentQuote.value
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

@Composable
fun LaunchCoroutineScopeExamples() {
    Column {
        LaunchEffectExample()
        RememberCoroutineScopeExample()
    }
}

@Composable
fun LaunchProduceStateAndDerivedOfExamples() {
//    ProduceStateExample()
//    ProduceStateLoader()
    DerivedOfExample()
}