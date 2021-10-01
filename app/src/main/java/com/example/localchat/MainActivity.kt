package com.example.localchat

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private var pointTotal = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateButtonNums()
    }

    fun leftOnClick(view: View){
        if (checkBiggerNum("left")){
            pointTotal++
        }
        else{
            pointTotal--
        }
        setPoints()
        generateButtonNums()

    }

    fun rightOnClick(view: View){
        if (checkBiggerNum("right")){
            pointTotal++
        }
        else{
            pointTotal--
        }
        setPoints()
        generateButtonNums()
    }

    fun generateButtonNums(){
        val leftButtonVal = findViewById<Button>(R.id.leftButton)
        val rightButtonVal = findViewById<Button>(R.id.rightButton)
        leftButtonVal.text = Random().nextInt(100).toString()
        rightButtonVal.text = Random().nextInt(100).toString()

    }

    fun checkBiggerNum(selection: String): Boolean {

        val leftButtonVal = findViewById<Button>(R.id.leftButton)
        val rightButtonVal = findViewById<Button>(R.id.rightButton)

        if (leftButtonVal.text.toString().toInt() > rightButtonVal.text.toString().toInt()){
            return selection == "left"
        }
        return selection == "right"
    }

    fun setPoints(){
        val pointCounter = findViewById<TextView>(R.id.scoreId)
        pointCounter.text = "Points: ${pointTotal.toString()}"
    }
}