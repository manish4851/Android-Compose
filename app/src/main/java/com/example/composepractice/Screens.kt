package com.example.composepractice

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListItem(quote:String, author:String){
    Column(Modifier.width(IntrinsicSize.Max)) {
            Text(quote,Modifier.padding(8.dp), fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Text(author,Modifier.padding(8.dp))
            Box(modifier = Modifier.border(2.dp, Color.Black,
                RectangleShape).fillMaxWidth())
    }
}