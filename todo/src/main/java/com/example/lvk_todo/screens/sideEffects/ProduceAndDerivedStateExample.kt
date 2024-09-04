package com.example.lvk_todo.screens.sideEffects

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


@Composable
fun ProduceStateExample() {

    val state = produceState(initialValue = 0) {
        while (value <= 9) {
            delay(1000)
            value += 1

        }
    }

    Text(text = state.value.toString(), modifier = Modifier.padding(10.dp))

}

@Composable
fun ProduceStateLoader() {

    val loaderDegree = produceState(initialValue = 0) {
        while (true) {
            delay(25)
            value = (value + 10) % 360
        }
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)) {

        Row {
            Image(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Loader Image",
                Modifier
                    .size(40.dp)
                    .rotate(loaderDegree.value.toFloat())
            )
            Text(text = "Loading....", modifier = Modifier.padding(10.dp))
        }

    }

}

@Composable
fun DerivedOfExample() {

    val number = remember { mutableStateOf(3) }
    val index = produceState(initialValue = 1) {
        while (value < 10) {
            delay(1000)
            value += 1
        }
    }

    val calc = remember {

        derivedStateOf {
            "${number.value}*${index.value} = ${number.value * index.value}"
        }
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)) {
        Text(text = calc.value, style = MaterialTheme.typography.headlineLarge)

    }

}