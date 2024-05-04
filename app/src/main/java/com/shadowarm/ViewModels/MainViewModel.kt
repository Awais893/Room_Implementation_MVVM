package com.shadowarm.ViewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.shadowarm.dataclass.QuoteData

class MainViewModel(private val context: Context) : ViewModel() {
    private var quoteList: Array<QuoteData> = emptyArray()
    private var index = 0

    init {
        quoteList = loadquotefromJson()
    }

    private fun loadquotefromJson(): Array<QuoteData> {
        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<QuoteData>::class.java)
    }

    fun getQuote() = quoteList[index]
    fun nextQuote() = quoteList[++index % quoteList.size]
    fun previousQuote() = quoteList[--index + quoteList.size]


}