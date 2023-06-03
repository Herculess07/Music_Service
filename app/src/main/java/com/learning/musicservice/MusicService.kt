package com.learning.musicservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MusicService :Service() {
    private lateinit var player: MediaPlayer
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this,Settings.System.DEFAULT_RINGTONE_URI)
        player.setLooping(true)
        player.start()
        return START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}