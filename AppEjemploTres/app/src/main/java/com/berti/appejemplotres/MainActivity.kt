package com.berti.appejemplotres

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var txtInput = findViewById<EditText>(R.id.txtInput)
        var txtResult = findViewById<TextView>(R.id.txtResult)
        var btnConsult = findViewById<Button>(R.id.btnConsult)
        calculo(txtInput, txtResult, btnConsult)


    }
    fun calculo(txtInput : EditText, txtResult: TextView, btnConsult: Button){
        btnConsult.setOnClickListener {
            var inputInt: Int = txtInput.text.toString().toInt()
            if (inputInt > 0){
                txtResult.setText("El número es positivo")
                txtResult.setTextColor(Color.GREEN)
            } else if (inputInt < 0){
                txtResult.setText("El número es negativo")
                txtResult.setTextColor(Color.RED)
            } else {
                txtResult.setText("Cero no es ni positivo ni negativo")
                txtResult.setTextColor(Color.BLUE)
            }

        }
    }



}