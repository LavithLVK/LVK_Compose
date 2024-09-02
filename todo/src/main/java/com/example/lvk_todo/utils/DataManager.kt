package com.example.lvk_todo.utils

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.lvk_todo.models.Quote
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Quote>()
    val isDataLoaded = mutableStateOf(false)

    val curentQuote = mutableStateOf<Quote?>(null)

    val currentPageState = mutableStateOf(Constants.QuotesPages.LISTING)

    fun loadAssets(context: Context, fileName: String) {

        val inputStream = context.assets.open(fileName)
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?) {
        if (currentPageState.value == Constants.QuotesPages.LISTING) {
            curentQuote.value = quote
            currentPageState.value = Constants.QuotesPages.DETAILS
        } else {
            currentPageState.value = Constants.QuotesPages.LISTING
        }
    }
}