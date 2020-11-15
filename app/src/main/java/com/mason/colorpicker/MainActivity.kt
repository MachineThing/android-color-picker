package com.mason.colorpicker

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

fun intToHex(int: Int):String {
    var hexCol = Integer.toHexString(int)
    if (hexCol.length == 1) {
        return "0$hexCol"
    } else {
        return hexCol
    }
}

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
        if (seekBar == findViewById<SeekBar>(R.id.seekR)) { // If it's the red slider
            redCol = progress
        } else if (seekBar == findViewById<SeekBar>(R.id.seekG)) { // If it's the green slider
            greenCol = progress
        } else { // If it's the blue slider
            blueCol = progress
        }
        val hexText = findViewById<TextView>(R.id.hexView)
        val colorView = findViewById<RelativeLayout>(R.id.colorView)
        val redText = findViewById<TextView>(R.id.labelR)
        val greenText = findViewById<TextView>(R.id.labelG)
        val blueText = findViewById<TextView>(R.id.labelB)
        hexText.text = "#${intToHex(redCol)}${intToHex(greenCol)}${intToHex(blueCol)}"
        hexText.setBackgroundColor(Color.argb(255, redCol, greenCol, blueCol))
        colorView.setBackgroundColor(Color.argb(255, redCol, greenCol, blueCol))

        // Check if we need to make text color white
        if (redCol < 128 && greenCol < 128 && blueCol < 128) {
            // Color is dark, use white
            hexText.setTextColor(Color.argb(255, 255, 255, 255))
            redText.setTextColor(Color.argb(255, 255, 255, 255))
            greenText.setTextColor(Color.argb(255, 255, 255, 255))
            blueText.setTextColor(Color.argb(255, 255, 255, 255))
        } else {
            // Color is light, use black
            hexText.setTextColor(Color.argb(255, 0, 0, 0))
            redText.setTextColor(Color.argb(255, 0, 0, 0))
            greenText.setTextColor(Color.argb(255, 0, 0, 0))
            blueText.setTextColor(Color.argb(255, 0, 0, 0))
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        // Only required due to implements
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        // Only required due to implements
    }
}