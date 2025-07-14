package com.berti.calcimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//----------------------------------------------------------------------------------

        val txtTitle = findViewById<TextView>(R.id.txtTitle)
        val txtHi = findViewById<TextView>(R.id.txtHi)
        val inputUser = findViewById<EditText>(R.id.inputName)
        val inputWeight = findViewById<EditText>(R.id.inputWeight)
        val inputHeight = findViewById<EditText>(R.id.inputHeight)
        val btnCalculate = findViewById<Button>(R.id.btnCalc)
        val btnVisualize = findViewById<Button>(R.id.btnView)

        val prefs = getSharedPreferences("datosUsuario", MODE_PRIVATE)
        val clave = prefs.getInt("pClave", 0)
        if (clave == 0){ // 0 si no hay nada guardado
            btnVisualize.isVisible = false
            txtTitle.text = getString(R.string.strIngresar)
            btnCalculate.setOnClickListener {
                if (!inputUser.text.toString().isEmpty() && !inputWeight.text.toString().isEmpty() && !inputHeight.text.toString().isEmpty()){
                    val intent = Intent(this, MainActivity2::class.java)
                    val usrName  = inputUser.text.toString()
                    val usrWeight  = inputWeight.text.toString()
                    val usrHeight  = inputHeight.text.toString()
                    intent.putExtra("kName", usrName)
                    intent.putExtra("kWeight", usrWeight)
                    intent.putExtra("kHeight", usrHeight)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Debes ingresar los datos solicidatos!", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            btnCalculate.isVisible = false
            //txtTitle.text = getString(R.string.strVisualize)
            txtHi.text = getString(R.string.strVisualize)
            inputUser.isVisible = false
            inputWeight.isVisible = false
            inputHeight.isVisible = false
            btnCalculate.isVisible = false
            btnVisualize.isVisible = true
            btnVisualize.setOnClickListener {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }

        }


    }
}