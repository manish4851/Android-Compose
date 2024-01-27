package com.example.composepractice

import android.content.Context
import android.media.MediaPlayer

class AndroidAudioPlayer(private val context: Context) : AudioPlayer {
    private var player: MediaPlayer? = null
    override fun playFile(resId: Int) {
        if (player?.isPlaying == true){
            stop()
        }
        MediaPlayer.create(context,resId).apply {
            player = this
            start()
        }
    }

    override fun stop() {
        player?.stop()
        player?.release()
        player = null
    }
}