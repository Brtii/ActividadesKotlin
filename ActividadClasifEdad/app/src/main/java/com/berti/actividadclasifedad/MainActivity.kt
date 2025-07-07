package com.berti.actividadclasifedad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//-----------------------------------------------------------------------------------
        val txtToday = findViewById<TextView>(R.id.txtDayNumber)
        val txtMonth= findViewById<TextView>(R.id.txtMonth)
        val inputDOB = findViewById<EditText>(R.id.inputDOB)
        val btnCalcular = findViewById<Button>(R.id.btnCalculate)
        val dateToday = LocalDate.now()

        val dayFormatter = DateTimeFormatter.ofPattern("dd")
        val mesFormatter = DateTimeFormatter.ofPattern("MMM")
        val hoy = dateToday.format(dayFormatter)
        val mes = dateToday.format(mesFormatter)
        txtToday.text = hoy
        txtMonth.text = mes

        btnCalcular.setOnClickListener {
            val DOB = inputDOB.text.toString().trim()
            val edad = calcularEdad(DOB)
            //declarar intent
            val intent = Intent(this, MainActivity2::class.java)
            //datos a enviar
            intent.putExtra("date", edad)
            startActivity(intent)
        }



    }

    fun calcularEdad(fechaNac: String): String {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val fechaNac = LocalDate.parse(fechaNac, formatter)
        val fechaHoy = LocalDate.now()

        val edad = Period.between(fechaNac, fechaHoy).years
        return edad.toString()
    }

}