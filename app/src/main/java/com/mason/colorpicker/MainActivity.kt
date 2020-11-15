package com.mason.colorpicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redCol = findViewById<SeekBar>(R.id.seekR)
        val greenCol = findViewById<SeekBar>(R.id.seekG)
        val blueCol = findViewById<SeekBar>(R.id.seekB)
        val hexText = findViewById<TextView>(R.id.hexView)

        redCol.setOnSeekBarChangeListener(this)
        greenCol.setOnSeekBarChangeListener(this)
        blueCol.setOnSeekBarChangeListener(this)

    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        if (fromUser) {

        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        // Only required due to implements
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        // Only required due to implements
    }
}