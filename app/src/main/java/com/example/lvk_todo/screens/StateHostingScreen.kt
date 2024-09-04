package com.example.lvk_todo.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StateHostingScreen() {

    val count: MutableState<Int> = rememberSaveable { mutableStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        NotificationCounter(count.value) { count.value++ }
        MessageBar(count = count.value)
    }

}

@Composable
fun NotificationCounter(count: Int, incrementCount: () -> Unit) {

    Column {
        Text(text = "You have sent $count notifications")
        Button(onClick = { incrementCount.invoke() }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Send Notification")
        }
    }
}

@Composable
fun MessageBar(count: Int) {

    Card(elevation = CardDefaults.cardElevation(4.dp), modifier = Modifier.padding(10.dp)) {
        Text(text = " Messages Sent So far - $count", modifier = Modifier.padding(10.dp))
    }
}