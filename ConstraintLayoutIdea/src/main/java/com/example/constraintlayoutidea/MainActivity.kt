package com.example.constraintlayoutidea

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // when START button is tapped, call function to randomly generate pattern
        val startButton = findViewById<Button>(R.id.startButton)
        startButton.setOnClickListener {
            val areaNum = newPattern()
            val countdown = findViewById<TextView>(R.id.countdown)
            // 3 sec countdown
            object : CountDownTimer(3000, 1000) {
                @SuppressLint("SetTextI18n")
                override fun onTick(millisUntilFinished: Long) {
                    startButton.visibility = View.INVISIBLE
                    countdown.visibility = View.VISIBLE
                    val secs = (millisUntilFinished / 1000) + 1
                    countdown.text = "$secs seconds left"
                }

                override fun onFinish() {
                    reset()
                    countdown.visibility = View.GONE
                }
            }.start()

            tapButtons(areaNum)
        }

        // when RESET button is tapped, call function to reset code
        val resetButton = findViewById<Button>(R.id.resetButton)
        resetButton.setOnClickListener {
            reset()
        }
    }

    // Tap buttons
    private fun tapButtons(areaNum: List<Int>) {
        var count = 0

        val area1 = findViewById<View>(R.id.area1)
        val area2 = findViewById<View>(R.id.area2)
        val area3 = findViewById<View>(R.id.area3)
        val area4 = findViewById<View>(R.id.area4)
        val area5 = findViewById<View>(R.id.area5)
        val area6 = findViewById<View>(R.id.area6)
        val area7 = findViewById<View>(R.id.area7)
        val area8 = findViewById<View>(R.id.area8)
        val area9 = findViewById<View>(R.id.area9)

        val clickableViews: List<View> =
                listOf(area1, area2, area3, area4, area5, area6, area7, area8, area9)

        for (item in clickableViews) {
            item.setOnClickListener {
                val index = clickableViews.indexOf(item)
                if ((index + 1) in areaNum) {
                    if (count == areaNum.size) {
                        object : CountDownTimer(2000, 1000) {
                            override fun onTick(millisUntilFinished: Long) {
                                findViewById<View>(R.id.success).visibility = View.VISIBLE
                            }

                            override fun onFinish() {
                                findViewById<View>(R.id.success).visibility = View.GONE
                                reset()
                            }
                        }.start()

                    }
                    else {
                        item.setBackgroundResource(android.R.color.holo_orange_light)
                        count += 1
                    }

                }
                else {
                    item.setBackgroundResource(android.R.color.holo_red_light)

                    object : CountDownTimer(2000, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            findViewById<View>(R.id.wrong).visibility = View.VISIBLE
                        }

                        override fun onFinish() {
                            findViewById<View>(R.id.wrong).visibility = View.GONE
                            reset()
                        }
                    }.start()


                }
            }
        }
    }

    // generate pattern randomly
    private fun newPattern(): List<Int> {

        var areaNum: List<Int> = mutableListOf()

        val area1 = findViewById<View>(R.id.area1)
        val area2 = findViewById<View>(R.id.area2)
        val area3 = findViewById<View>(R.id.area3)
        val area4 = findViewById<View>(R.id.area4)
        val area5 = findViewById<View>(R.id.area5)
        val area6 = findViewById<View>(R.id.area6)
        val area7 = findViewById<View>(R.id.area7)
        val area8 = findViewById<View>(R.id.area8)
        val area9 = findViewById<View>(R.id.area9)

        val num = Random().nextInt(8) + 1 // can never be 0

        for (i in 0..num) {
            val digit = Random().nextInt(8) + 1
            areaNum = areaNum + digit
            when (digit) {
                1 -> area1.setBackgroundResource(android.R.color.holo_orange_light)
                2-> area2.setBackgroundResource(android.R.color.holo_orange_light)
                3 -> area3.setBackgroundResource(android.R.color.holo_orange_light)
                4 -> area4.setBackgroundResource(android.R.color.holo_orange_light)
                5 -> area5.setBackgroundResource(android.R.color.holo_orange_light)
                6 -> area6.setBackgroundResource(android.R.color.holo_orange_light)
                7 -> area7.setBackgroundResource(android.R.color.holo_orange_light)
                8 -> area8.setBackgroundResource(android.R.color.holo_orange_light)
                9 -> area9.setBackgroundResource(android.R.color.holo_orange_light)
            }
        }

        return areaNum
    }

    // reset
    private fun reset() {

        findViewById<Button>(R.id.startButton).visibility = View.VISIBLE

        val area1 = findViewById<View>(R.id.area1)
        val area2 = findViewById<View>(R.id.area2)
        val area3 = findViewById<View>(R.id.area3)
        val area4 = findViewById<View>(R.id.area4)
        val area5 = findViewById<View>(R.id.area5)
        val area6 = findViewById<View>(R.id.area6)
        val area7 = findViewById<View>(R.id.area7)
        val area8 = findViewById<View>(R.id.area8)
        val area9 = findViewById<View>(R.id.area9)

        area1.setBackgroundResource(android.R.color.holo_blue_light)
        area2.setBackgroundResource(android.R.color.holo_blue_light)
        area3.setBackgroundResource(android.R.color.holo_blue_light)
        area4.setBackgroundResource(android.R.color.holo_blue_light)
        area5.setBackgroundResource(android.R.color.holo_blue_light)
        area6.setBackgroundResource(android.R.color.holo_blue_light)
        area7.setBackgroundResource(android.R.color.holo_blue_light)
        area8.setBackgroundResource(android.R.color.holo_blue_light)
        area9.setBackgroundResource(android.R.color.holo_blue_light)

    }
}