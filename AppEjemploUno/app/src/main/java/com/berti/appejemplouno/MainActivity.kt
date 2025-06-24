package com.berti.appejemplouno

import android.os.Bundle
import android.widget.Button
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
        //----------------------------------------------------------------------------------------
    val txtSaludo = findViewById<TextView>(R.id.txtSaludo) //Encontrar vista por id <tag donde esta el id>
    val btnHi = findViewById<Button>(R.id.btnHi) // R.id.elidDelElementoALLamar
    val btnBye = findViewById<Button>(R.id.btnBye)
        // Llamamos a la funcio
        cambioDeSaludo(txtSaludo, btnHi, btnBye)

    }

    fun cambioDeSaludo(textito: TextView, b1: Button, b2: Button){
        val saludoHi = "Bienvenido a mi aplicacion"
        val saludoBye = "Fue un gusto haberte conocido :("

        b1.setOnClickListener {
            textito.text = saludoHi // nombre del parametro, propiedad text y luego el texto a mostrar
        }
        b2.setOnClickListener {
            textito.text = saludoBye
        }
    }

}