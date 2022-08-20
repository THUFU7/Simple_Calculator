package com.example.simple_calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    lateinit var firstNumber: EditText
    lateinit var secondNumber: EditText
    lateinit var addition: Button
    lateinit var subtraction: Button
    lateinit var division: Button
    lateinit var multiplication: Button
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstNumber = findViewById(R.id.first_number)
        secondNumber = findViewById(R.id.second_number)
        addition = findViewById(R.id.addition)
        subtraction = findViewById(R.id.subtraction)
        division = findViewById(R.id.division)
        multiplication = findViewById(R.id.multiplication)
        result = findViewById(R.id.answer)

        addition.setOnClickListener(){
            add()
        }
        subtraction.setOnClickListener(){
            subtract()
        }
        division.setOnClickListener(){
            divide()
        }
        multiplication.setOnClickListener(){
            multiply()
        }
    }

    fun add() {
        if (inputIsNotEmpty()) {
            val input1 = firstNumber.text.toString().trim().toBigDecimal()
            val input2 = secondNumber.text.toString().trim().toBigDecimal()
            result.text = input1.add(input2).toString()
        }
    }

    fun subtract() {
        if (inputIsNotEmpty()) {
            val input1 = firstNumber.text.toString().trim().toBigDecimal()
            val input2 = secondNumber.text.toString().trim().toBigDecimal()
            result.text = input1.subtract(input2).toString()
        }
    }

    fun divide() {
        if (inputIsNotEmpty()) {
            val input1 = firstNumber.text.toString().trim().toBigDecimal()
            val input2 = secondNumber.text.toString().trim().toBigDecimal()
            if (input2.compareTo(BigDecimal.ZERO) == 0) {
                secondNumber.error = "INVALID INPUT"
            } else {
                result.text = input1.divide(input2, 2, RoundingMode.HALF_UP).toString()
            }
        }
    }

    fun multiply() {
        if (inputIsNotEmpty()) {
            val input1 = firstNumber.text.toString().trim().toBigDecimal()
            val input2 = secondNumber.text.toString().trim().toBigDecimal()
            result.text = input1.multiply(input2).toString()
        }
    }

    fun inputIsNotEmpty(): Boolean {
        var b = true
        if (firstNumber.text.toString().trim().isEmpty()) {
            firstNumber.error = "REQUIRED"
            b = false
        }
        if (secondNumber.text.toString().trim().isEmpty()) {
            secondNumber.error = "REQUIRED"
            b = false
        }
        return b
    }
}