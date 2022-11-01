package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var text1:TextView
    private var operation  = " "
    private var operand1 = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        text1 = findViewById(R.id.textView)




    }

    fun onclick(clickedview: View) {
        if (clickedview is TextView){
            var number = clickedview.text.toString()


            if (text1.text.toString()== "0"){
                text1.text=""
            }
            text1.text =text1.text.toString()+ number

        }


    }

    fun operationClick(clickedview: View) {
        if (clickedview is TextView){
            operation = clickedview.text.toString()

            operand1 = text1.text.toString().toDouble()
            text1.text = "0"
        }

    }

    fun equalsClick(clickedview: View) {

        var operand2 = text1.text.toString().toDouble()
        if (operation == " "){
            text1.text = text1.text.toString()
        }else {
            when (operation) {

                "+" -> text1.text = (operand1 + operand2).toString()
                "-" -> text1.text = (operand1 - operand2).toString()
                "*" -> text1.text = (operand1 * operand2).toString()
                "/" -> text1.text = (operand1 / operand2).toString()

            }
            operation = " "
            var newnumber = text1.text.toString()
            if (newnumber.substring(newnumber.length - 2, newnumber.length) == ".0") {
                text1.text = newnumber.substring(0, newnumber.length - 2)
            }
        }

    }

    fun cleartxt(view: View) {
        text1.text = "0"
        operand1 = 0.0
    }

    fun delete(view: View) {
        var newoperand1 = operand1.toString().substring(0,operand1.toString().length-2)

        var txt = text1.text.toString()

        if (txt.length == 1 && operand1 ==0.0) {
            text1.text = "0"
        }else if (txt.length == 1){
            text1.text = newoperand1
            operand1 = 0.0


        }else {
            text1.text = txt.substring(0, txt.length - 1)
        }
    }

    fun dotclick(view: View) {
        var dotexists = false
        var txt = text1.text.toString()
        for (i in 0 until txt.length  ){
            if (txt[i]=='.'){
                dotexists = true
            }
        }
        if (dotexists == false){
            text1.text = txt + '.'
        }

    }


}







