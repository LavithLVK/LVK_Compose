package com.example.lvk_todo.screens.sideEffects

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LaunchEffectExample() {

    var counter = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = Unit) {

        Log.d("Launched Effect - ", "Started")

        try {
            for (i in 1..10) {
                counter.value++
                delay(1000)
            }

        } catch (ex: Exception) {
            Log.d("Launched Effect - ", "Exception - ${ex.message.toString()}")
        }
    }

    var text = "Counter is now - ${counter.value}"
    if (counter.value == 10) {
        text = "Counter Stopped"
    }
    Log.d("Launched Effect -", "counter - ${counter.value}")
    Text(text = text)

}

@Composable
fun RememberCoroutineScopeExample() {

    val counter = remember { mutableStateOf(0) }

    val scope = rememberCoroutineScope()


    var text = "Counter is now - ${counter.value}"
    if (counter.value == 10) {
        text = "Counter Stopped"
    }
    Text(text = text)

    Button(onClick = {
        scope.launch {
            try {
                Log.d("Coroutine Scope -", "Started")
                for (i in 1..10) {
                    counter.value++
                    delay(1000)
                }
            } catch (ex: Exception) {
                Log.d("Coroutine Scope -", "Exception ${ex.message.toString()}")
            }
        }
    }) {
        Text(text = "start")
    }

}

fun a() {
    Log.d("Side Effect - ", "From A function")
}

fun b() {
    Log.d("Side Effect - ", "From B function")
}

@Composable
fun RememberUpdateStateExample() {

    val functionState = remember {
        mutableStateOf(::a)
    }

    Button(onClick = {
        Log.d("Remember Update State- ", "Function updated")
        functionState.value = ::b
    }) {
        Text(text = "Update Function")
    }
    ShowUpdatedState(functionState.value)
}

@Composable
fun ShowUpdatedState(onTimeOut: () -> Unit) {

    val currentTimeOut by rememberUpdatedState(onTimeOut)//if we comment this the log will print a()

    LaunchedEffect(key1 = true) {
        delay(5000)
        currentTimeOut()
    }

}