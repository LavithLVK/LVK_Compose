package com.example.lvk_todo.screens.sideEffects

import android.util.Log
import android.view.ViewTreeObserver
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Composable
fun DisposableEffectExample() {

    KeyBoardComposable()
    TextField(value = "", onValueChange = {})
}

@Composable
fun KeyBoardComposable() {
    val view = LocalView.current

    DisposableEffect(key1 = Unit) {
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val insets = ViewCompat.getRootWindowInsets(view)
            val isKeyBoardVisible = insets?.isVisible(WindowInsetsCompat.Type.ime())
            Log.d("Disposable Effect - ", isKeyBoardVisible.toString())
        }
        view.viewTreeObserver.addOnGlobalLayoutListener(listener)

        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }
    }

}