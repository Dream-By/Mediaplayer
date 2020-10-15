package com.example.mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit private var mMediaPlayer: MediaPlayer
    lateinit var seek_Bar:SeekBar
    private var endTime: Int = 0
    private var playTime: Int = 0
    private var onTime: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMediaPlayer = MediaPlayer.create(this,R.raw.fast_and_furious)

        val playButton : ImageButton = findViewById(R.id.btnPlay)
        val pauseButton : ImageButton = findViewById(R.id.btnPause)

        seek_Bar = findViewById(R.id.seekBar)
        seek_Bar.isClickable = false
        pauseButton.isEnabled = true

        playButton.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"Audio is playing",Toast.LENGTH_LONG).show()
            mMediaPlayer.start()
            endTime = mMediaPlayer.duration
            playTime = mMediaPlayer.currentPosition
            seek_Bar.max = endTime
            onTime = 1
            seek_Bar.progress = playTime

            playButton.isEnabled = false
            pauseButton.isEnabled = true
        })

        pauseButton.setOnClickListener(View.OnClickListener {
            mMediaPlayer.pause()
            pauseButton.isEnabled = false
            playButton.isEnabled = true
            Toast.makeText(applicationContext, "Audio Paused", Toast.LENGTH_SHORT).show()
        })



    }
}