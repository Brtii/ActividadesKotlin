package com.berti.calcimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.text.format

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }//---------------------------------------------------------------------------------

        val txtUsrResult = findViewById<TextView>(R.id.txtUsrResult)
        val imgResult = findViewById<ImageView>(R.id.imgResult)
        val txtUsrName = findViewById<TextView>(R.id.txtNameM2)
        val txtUsrWeight = findViewById<TextView>(R.id.txtWeightM2)
        val txtUsrHeight = findViewById<TextView>(R.id.txtHeightM2)
        val btnDelete = findViewById<Button>(R.id.btnBorrarM2)
        val txtClasif = findViewById<TextView>(R.id.txtClasifM2)

        val usuario = intent.getStringExtra("kName")
        val pesolb = intent.getStringExtra("kWeight")
        val altura = intent.getStringExtra("kHeight")

        val prefs = getSharedPreferences("datosUsuario", MODE_PRIVATE)

        val clave = prefs.getInt("pClave", 0)
        val editor = prefs.edit()

        fun calcIMC (usrWeight: String, usrHeight: String): Double {
            val peso = usrWeight.toDouble()*0.4536
            val altura = usrHeight.toDouble()
            val imc = (peso / (altura*altura))
            return imc
        }

        fun clasif (imc: Double):String{
            var strClasif = "..."
            if (imc < 18.5 )
                strClasif = getString(R.string.strBajoPeso)
            else if (imc >= 18.5 && imc <= 24.9)
                strClasif = getString(R.string.strNormal)
            else if (imc > 24.9 && imc <= 29.9)
                strClasif = getString(R.string.strSobrep)
            else
                strClasif = getString(R.string.strObes)

            return strClasif
        }

        if (clave == 1) { // 1 si hay datos guardados
            val pUsrName = prefs.getString("pUser", "...")
            val pUsrWeight = prefs.getString("pWeight", "...")
            val pUsrHeight = prefs.getString("pHeight", "...")
            val getIMC = calcIMC(pUsrWeight.toString(), pUsrHeight.toString())
            val imc = calcIMC(pUsrWeight.toString(), pUsrHeight.toString())


            txtUsrResult.text = "Hola $pUsrName, tu índice de masa corporal es: ${String.format("%.2f", imc)}"
            if (imc < 18.5) {
                imgResult.setImageResource(R.drawable.bajo_peso)
            } else if (imc >= 18.5 && imc <= 24.9) {
                imgResult.setImageResource(R.drawable.normal)
            }
            else if (imc > 24.9 && imc <= 29.9) {
                imgResult.setImageResource(R.drawable.sobrepeso)
            }
            else {
                imgResult.setImageResource(R.drawable.obesidad)
            }
            txtClasif.text = clasif(getIMC)
            txtUsrName.text = "Usuario: $pUsrName"
            txtUsrWeight.text = "Peso: $pUsrWeight"
            txtUsrHeight.text = "Altura: $pUsrHeight"

            //txtUsrHeight.text = "Altura: ${prefs.getString("pHeight", "...")}"
        } else {
            editor.putInt("pClave", 1)
            editor.putString("pUser", usuario)
            editor.putString("pWeight", pesolb)
            editor.putString("pHeight", altura)
            editor.apply()

            val getIMC = calcIMC(pesolb.toString(), altura.toString())

            txtUsrResult.text ="Hola $usuario, tu índice de masa corporal es: ${String.format("%.2f", getIMC)}"
            //txtUsrResult.text = "Hola $usuario, tu índice de masa corporal es: $getIMC"
            if (getIMC < 18.5) {
                imgResult.setImageResource(R.drawable.bajo_peso)
            } else if (getIMC >= 18.5 && getIMC <= 24.9) {
                imgResult.setImageResource(R.drawable.normal)
            }
            else if (getIMC > 24.9 && getIMC <= 29.9) {
                imgResult.setImageResource(R.drawable.sobrepeso)
            }
            else {
                imgResult.setImageResource(R.drawable.obesidad)
            }

            txtClasif.text = clasif(getIMC)
            txtUsrName.text = "Usuario: $usuario"
            txtUsrWeight.text = "Peso: $pesolb"
            txtUsrHeight.text = "Altura: $altura m"

        }
        btnDelete.setOnClickListener {
            editor.clear().apply() //Limpiar y guardar
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }




    }
}