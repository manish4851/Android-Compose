package com.example.composepractice

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepractice.ui.theme.ComposePracticeTheme
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data: Quotes = getQuotes(this)
        setContent {
            ComposePracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn(){
                        items(data.quotes){
                            ListItem(it.quote,it.author)
                        }
                    }
                }
            }
        }
    }
}
fun getQuotes(context: Context): Quotes {
    lateinit var jsonString: String
    try {
        jsonString = context.assets.open("quotes-data.json")
            .bufferedReader()
            .use { it.readText() }
        Log.d("Flash", "inside try$jsonString")
    } catch (ioException: IOException) {
        Log.d("Manish", ioException.toString())
    }
    Log.d("Flash", "out side try$jsonString")
    val listDataType = object : TypeToken<Quotes>() {}.type
    return Gson().fromJson(jsonString, listDataType)
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        Greeting("Android")
    }
}