package com.shadowarm.roomimplementation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.shadowarm.ViewModels.MainViewModel
import com.shadowarm.ViewModels.ViewModelFactory
import com.shadowarm.dataclass.QuoteData


class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
     lateinit var quote:TextView
     lateinit var author:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
          quote=findViewById<TextView>(R.id.quoteTv)
          author=findViewById<TextView>(R.id.authorTv)

//        mainViewModel=ViewModelProvider(this,ViewModelFactory(applicationContext)).get(MainViewModel::class.java)
        // Assuming this code is inside an Activity or Fragment

        mainViewModel = ViewModelProvider(this, ViewModelFactory(application))[MainViewModel::class.java]
        SetQuote(mainViewModel.getQuote())

    }
    fun SetQuote(quoteData: QuoteData){
        quote.text=quoteData.quotes
        author.text=quoteData.author
    }

    fun onNext(view: View) {
        SetQuote(mainViewModel.nextQuote())
    }
    fun onPrevious(view: View) {
        SetQuote(mainViewModel.previousQuote())
    }
}