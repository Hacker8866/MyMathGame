    package com.example.mymathgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isInvisible
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.startBtn)
        val linear1: LinearLayout = findViewById(R.id.Llayout2)
        val linear2: LinearLayout = findViewById(R.id.natija1)
        val linear3: LinearLayout = findViewById(R.id.natija2)



        val buttonA = findViewById<Button>(R.id.btn1)
        val buttonB = findViewById<Button>(R.id.btn2)
        val buttonC = findViewById<Button>(R.id.btn3)
        val buttonD = findViewById<Button>(R.id.btn4)

        val tvNotRight = findViewById<TextView>(R.id.notRight)
        val tvRight = findViewById<TextView>(R.id.right1)
        val btnRefresh = findViewById<Button>(R.id.refresh)

        //val btn = findViewById<Button>(R.id.notRight)

        var son1: Int
        var son2: Int = 0
        var amal: Int
        var umumiy = 0

        val buttons = ArrayList<Button>()
        buttons.add(buttonA)
        buttons.add(buttonB)
        buttons.add(buttonC)
        buttons.add(buttonD)

        var k = 0
        val count = findViewById<TextView>(R.id.countTv)

        fun mathGameFun() {
            umumiy++
            count.text = umumiy.toString()
            if (umumiy == 11) {
                umumiy--
                tvNotRight.text = (umumiy - k).toString()
                tvRight.text = k.toString()
                linear2.visibility = View.VISIBLE
                linear3.visibility = View.VISIBLE
                btnRefresh.setOnClickListener {
                    k = 0
                    umumiy = 0
                    count.text = umumiy.toString()
                    linear2.visibility = View.GONE
                    linear3.visibility = View.GONE
                    mathGameFun()
                }
            }
            son1 = (1..99).random()
            son2 = (1..99).random()
            amal = (1..4).random()

            val tv1 = findViewById<TextView>(R.id.tv1)
            val amal1 = findViewById<TextView>(R.id.amal)
            val tv2 = findViewById<TextView>(R.id.tv2)

            var result = 0

            when (amal) {
                1 -> {
                    result = son1 + son2
                    tv1.text = son1.toString()
                    amal1.text = "+"
                    tv2.text = result.toString()
                }
                2 -> {
                    if (son1 > son2) {
                        result = son1 - son2
                        tv1.text = son1.toString()
                        amal1.text = "-"
                        tv2.text = result.toString()
                    } else {
                        result = son1 + son2
                        tv1.text = son1.toString()
                        amal1.text = "+"
                        tv2.text = result.toString()
                    }
                }
                3 -> {
                    if (son1 % son2 == 0) {
                        result = son1 / son2
                        tv1.text = son1.toString()
                        amal1.text = "/"
                        tv2.text = result.toString()
                    } else {
                        result = son1 * son2
                        tv1.text = son1.toString()
                        amal1.text = "*"
                        tv2.text = result.toString()
                    }
                }
                4 -> {
                    result = son1 * son2
                    tv1.text = son1.toString()
                    amal1.text = "*"
                    tv2.text = result.toString()
                }
            }

            var javob1 = (son2 - 20..son2 + 20).random()
            var javob2 = (son2 - 20..son2 + 20).random()
            var javob3 = (son2 - 20..son2 + 20).random()

            val answers = ArrayList<Int>()

            while (true){
                if (javob1 > 0 && javob2 > 0 && javob3 > 0 && javob1 != son2 && javob2 != son2 && javob3 != son2 && javob1 != javob2 && javob2 != javob3 && javob1 != javob3) {
                    answers.add(son2)
                    answers.add(javob1)
                    answers.add(javob2)
                    answers.add(javob3)
                    break
                }else{
                    javob1 = (son2 - 20..son2 + 20).random()
                    javob2 = (son2 - 20..son2 + 20).random()
                    javob3 = (son2 - 20..son2 + 20).random()
                }
            }


            val arr = ArrayList<Int>()
            arr.addAll(answers.shuffled())



            for (i in buttons.indices) {
                buttons[i].text = arr[i].toString()
            }
        }

        buttonA.setOnClickListener {
            if (buttonA.text == son2.toString()) {
                k++
                mathGameFun()
            } else {
                mathGameFun()
            }
        }
        buttonB.setOnClickListener {
            println(son2)
            if (buttonB.text == son2.toString()) {
                k++
                mathGameFun()
            } else {
                mathGameFun()
            }
        }
        buttonC.setOnClickListener {
            if (buttonC.text == son2.toString()) {
                k++
                mathGameFun()
            } else {
                mathGameFun()
            }
        }
        buttonD.setOnClickListener {
            if (buttonD.text == son2.toString()) {
                k++
                mathGameFun()
            } else {
                mathGameFun()
            }
        }
        button1.setOnClickListener {
            linear1.visibility = View.GONE
            mathGameFun()
        }
    }
}