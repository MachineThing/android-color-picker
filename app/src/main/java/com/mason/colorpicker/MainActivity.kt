package com.mason.colorpicker

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

fun intToHex(int: Int):String {
    val hexCol = Integer.toHexString(int)
    return if (hexCol.length == 1) {
        "0$hexCol"
    } else {
        hexCol
    }
}

class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private var redCol = 255
    private var greenCol = 255
    private var blueCol = 255

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide();

        // Bind sliders to custom onProgressChanged function

        val redSlider = findViewById<SeekBar>(R.id.seekR)
        val greenSlider = findViewById<SeekBar>(R.id.seekG)
        val blueSlider = findViewById<SeekBar>(R.id.seekB)

        redSlider.setOnSeekBarChangeListener(this)
        greenSlider.setOnSeekBarChangeListener(this)
        blueSlider.setOnSeekBarChangeListener(this)

    }

    @SuppressLint("SetTextI18n")
    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        when (seekBar) {
            findViewById<SeekBar>(R.id.seekR) -> { // If it's the red slider
                redCol = progress
            }
            findViewById<SeekBar>(R.id.seekG) -> { // If it's the green slider
                greenCol = progress
            }
            else -> { // If it's the blue slider
                blueCol = progress
            }
        }

        // Change colors and text

        val hexText = findViewById<TextView>(R.id.hexView)
        val colorView = findViewById<RelativeLayout>(R.id.colorView)
        val textLayout = findViewById<LinearLayout>(R.id.textLayout)
        hexText.text = "#${intToHex(redCol)}${intToHex(greenCol)}${intToHex(blueCol)}"
        hexText.setBackgroundColor(Color.argb(255, redCol, greenCol, blueCol))
        colorView.setBackgroundColor(Color.argb(128, redCol, greenCol, blueCol))
        textLayout.setBackgroundColor(Color.argb(255, redCol, greenCol, blueCol))

        // Check if we need to make text color white
        if (redCol < 128 && greenCol < 128 && blueCol < 128) {
            // Color is dark, use white
            hexText.setTextColor(Color.argb(255, 255, 255, 255))
        } else {
            // Color is light, use black
            hexText.setTextColor(Color.argb(255, 0, 0, 0))
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        // Only required due to implements
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        // Only required due to implements
    }
}