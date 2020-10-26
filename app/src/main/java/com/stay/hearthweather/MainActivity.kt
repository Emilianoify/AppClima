package com.stay.hearthweather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.stay.hearthweather.helpers.SharedApp
import com.stay.hearthweather.ui.ciudades.Ciudades

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val soleados = findViewById<Button>(R.id.soleados)
        val lluviosos = findViewById<Button>(R.id.lluviosos)
        if (SharedApp.prefs.selectedOption){
            goToActivity(SharedApp.prefs.opcion)
        }
        soleados.setOnClickListener(View.OnClickListener {
            goToActivity("Soleados")

        })

        lluviosos.setOnClickListener(View.OnClickListener {
        goToActivity("Lluviosos")
        })

    }
    private  fun goToActivity(opcion:String?){
        SharedApp.prefs.opcion = opcion
        SharedApp.prefs.selectedOption = true
        val lluviosos = Intent(this, Ciudades::class.java)
        startActivity(lluviosos)
    }
}
