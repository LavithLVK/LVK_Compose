package com.example.lvk_todo

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.lvk_todo.screens.login.LoginScreen
import com.example.lvk_todo.screens.sideEffects.LaunchEffectExample
import com.example.lvk_todo.screens.quotes.QuoteDetailScreen
import com.example.lvk_todo.screens.quotes.QuotesListScreen
import com.example.lvk_todo.screens.sideEffects.DerivedOfExample
import com.example.lvk_todo.screens.sideEffects.RememberCoroutineScopeExample
import com.example.lvk_todo.utils.Constants
import com.example.lvk_todo.utils.QuotesDataManager
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

//            ListScreen()
//            StateHostingScreen()
//            LaunchQuotesScreen(applicationContext)
//            LaunchCoroutineScopeExamples()
//            RememberUpdateStateExample()
//            DisposableEffectExample()
//            LaunchProduceStateAndDerivedOfExamples()

            LoginScreen()

        }
    }

}

@Composable
fun LaunchQuotesScreen(context: Context) {
    LaunchedEffect(key1 = Unit) {
        delay(3000)
        QuotesDataManager.loadAssets(context)
    }
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
            contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(
                text = "Loading...", style = MaterialTheme.typography.headlineMedium
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