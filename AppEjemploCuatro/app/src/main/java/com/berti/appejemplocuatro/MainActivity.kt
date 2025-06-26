package com.berti.appejemplocuatro

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.math.roundToLong

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
        var txtFaren = findViewById<TextView>(R.id.txtFaren)
        var btnConvert = findViewById<Button>(R.id.btnConvert)
        calculo(txtInput, txtFaren, btnConvert)
    }

    fun calculo (txtInput: EditText, txtFaren: TextView, btnConvert: Button){
        btnConvert.setOnClickListener {
            var celsius: Int = txtInput.text.toString().toInt()
            var faren: Double = (celsius * 1.8) + 32
            val faren2digits:Double = String.format("%.2f", faren).toDouble()
            txtFaren.setText("$celsius grados Celsius son $faren2digits grados Farenheit")

        }
    }
}