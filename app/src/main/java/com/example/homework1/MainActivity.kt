package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var result: String = "Ответ:"
        set(value) {
            answer?.text = value
            field = value
        }

    private var name: EditText? = null
    private var et_age: EditText? = null
    private var et_height: EditText? = null
    private var et_weight: EditText? = null
    private var button: Button? = null
    private var answer: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.et_name)
        et_age = findViewById(R.id.et_age)
        et_height = findViewById(R.id.et_height)
        et_weight = findViewById(R.id.et_weight)
        button = findViewById(R.id.btn_counting)
        answer = findViewById(R.id.tv_answer)

        button?.setOnClickListener {
            val age = et_age?.text.toString().toInt()
            val height = et_height?.text.toString().toInt()
            val weight = et_weight?.text.toString().toDouble()
            if (age > 0 && age < 150 && height > 0
                && height < 250 && weight > 0 && weight < 250)
            {
                val total = calculate(
                    age,
                    height,
                    weight
                )
                result = "Ответ: ${name?.text} - $total"
            }
            else
                result = "Данные введены некорректно."
        }
    }

    private fun calculate(age: Int, height: Int, weight: Double) : Double {
        return age * height / weight
    }
}