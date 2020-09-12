package com.example.l4s_renda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var second = 10
    var tapCount = 0

    val timer : CountDownTimer = object : CountDownTimer(10000,1000){
        override fun onFinish() {
            startButton.isVisible = true
            tapButton.setBackgroundResource(R.drawable.background_rounded_circle_gray)
            second = 10
            tapCount = 0
        }

        override fun onTick(p0: Long) {
            tapButton.setBackgroundResource(R.drawable.background_rounded_circle)
            second -= 1
            timeText.text = second.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener {
            countText.text = tapCount.toString()
            startButton.isVisible = false
            timer.start()
        }

        tapButton.setOnClickListener {
            if (second < 10){
                tapCount += 1
                countText.text = tapCount.toString()
            }

        }
    }
}