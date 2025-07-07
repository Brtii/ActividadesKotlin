package com.berti.actividadpassword

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//-------------------------------------------------------------------------------------

        val imgResult = findViewById<ImageView>(R.id.imgResult)
        val txtResult = findViewById<TextView>(R.id.txtResult)
        val inputPass = intent.getStringExtra("pass")

        if (inputPass != null && inputPass.length >= 8) {
            imgResult.setImageResource(R.drawable.seguro)
            txtResult.text = "Contraseña segura"
        }
        else if (inputPass != null && inputPass.length > 0) {
            txtResult.text = "Contraseña debil"
            imgResult.setImageResource(R.drawable.inseguro)
        }
        else if (inputPass != null && inputPass == "") {
            txtResult.text = "Debes ingresar una contraseña"
            imgResult.setImageResource(R.drawable.inseguro)
        }
        else{
            txtResult.text = "Debes ingresar una contraseña!"
            imgResult.setImageResource(R.drawable.inseguro)
        }

    }

}