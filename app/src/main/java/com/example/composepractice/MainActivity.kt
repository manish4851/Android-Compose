package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {

    private val player by lazy {
        AndroidAudioPlayer(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    PlayButton(player = player)
                }
            }
        }
    }
}

@Composable
fun PlayButton(player: AudioPlayer) {
    Icon(
        painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = "icon",
        Modifier
            .clip(CircleShape)
            .background(Color.Green)
            .clickable {
                player.playFile(R.raw.audio)
            }
    )
}