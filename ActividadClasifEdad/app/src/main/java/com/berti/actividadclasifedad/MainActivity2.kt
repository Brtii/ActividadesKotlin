package com.berti.actividadclasifedad

import android.media.Image
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
        }//----------------------------------------------------------------

        val imgResultado = findViewById<ImageView>(R.id.imgResult)
        val txtResultado = findViewById<TextView>(R.id.txtResult)
        val edad = intent.getStringExtra("date")

        if (edad != null && edad.toInt() < 13) {
            txtResultado.text = "Eres un nino"
            imgResultado.setImageResource(R.drawable.baby)
        } else if (edad != null && edad.toInt() <= 17) {
            txtResultado.text = "Eres un adolescente"
            imgResultado.setImageResource(R.drawable.teenager)
        } else if (edad != null && edad.toInt() >= 18) {
            txtResultado.text = "Eres un adulto"
            imgResultado.setImageResource(R.drawable.adult)
        } else {
            txtResultado.text = "Debes Ingresar una fecha!"
        }



    }
}