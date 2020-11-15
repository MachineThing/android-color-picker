package com.mason.colorpicker

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    var redCol = 255
    var greenCol = 255
    var blueCol = 255

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val redSlider = findViewById<SeekBar>(R.id.seekR)
        val greenSlider = findViewById<SeekBar>(R.id.seekG)
        val blueSlider = findViewById<SeekBar>(R.id.seekB)

        redSlider.setOnSeekBarChangeListener(this)
        greenSlider.setOnSeekBarChangeListener(this)
        blueSlider.setOnSeekBarChangeListener(this)

    }

    @SuppressLint("SetTextI18n")
    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        if (fromUser) { // Check if it's actually from the user
            if (seekBar == findViewById<SeekBar>(R.id.seekR)) { // If it's the red slider
                redCol = progress
            } else if (seekBar == findViewById<SeekBar>(R.id.seekG)) { // If it's the green slider
                greenCol = progress
            } else { // If it's the blue slider
                blueCol = progress
            }
            val hexText = findViewById<TextView>(R.id.hexView)
            hexText.text = "#" + Integer.toHexString(redCol) + Integer.toHexString(greenCol) + Integer.toHexString(blueCol)
            hexText.setBackgroundColor(Color.argb(255, redCol, greenCol, blueCol))
            // Check if we need to make text color white
            if (redCol < 113 && greenCol < 113 && blueCol < 113) {
                // Color is dark, use white
                hexText.setTextColor(Color.argb(255, 255, 255, 255))
            } else {
                // Color is light, use black
                hexText.setTextColor(Color.argb(255, 0, 0, 0))
            }
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        // Only required due to implements
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        // Only required due to implements
    }
}