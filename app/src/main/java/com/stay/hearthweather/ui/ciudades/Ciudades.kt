package com.stay.hearthweather.ui.ciudades

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.stay.hearthweather.ui.home.PantallaPrincipal
import com.stay.hearthweather.R
import com.stay.hearthweather.helpers.SharedApp
import com.stay.hearthweather.ui.home.PantallaPrincipal2

class Ciudades : AppCompatActivity() {

    val TAG = "com.stay.hearthweather.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)
        val bBuenosAires = findViewById<Button>(R.id.bBuenosAires)
        val bMoscu = findViewById<Button>(R.id.bMoscu)
        val bCopenhague = findViewById<Button>(R.id.bCopenhague)
        val bOttawa = findViewById<Button>(R.id.bOttawa)
        val bMadrid = findViewById<Button>(R.id.bMadrid)
        val bWashintong = findViewById<Button>(R.id.bWashington)

        bBuenosAires.setOnClickListener(View.OnClickListener {
            goToActivity("3435910")

        })
        bMoscu.setOnClickListener(View.OnClickListener {
            goToActivity("524901")

        })
        bCopenhague.setOnClickListener(View.OnClickListener {
            goToActivity("2618425")
        })
        bOttawa.setOnClickListener(View.OnClickListener {
            goToActivity("6094817")

        })
        bMadrid.setOnClickListener(View.OnClickListener {
            goToActivity("3117735")

        })
        bWashintong.setOnClickListener(View.OnClickListener {
            goToActivity("4140963")

        })
    }

    private fun goToActivity(codigoCiudad:String?) {
        if (SharedApp.prefs.selectedOption) {
            if (SharedApp.prefs.opcion == "Lluviosos") {
                val intentActivity = Intent(this, PantallaPrincipal2::class.java)
                intentActivity.putExtra(TAG, codigoCiudad)
                startActivity(intentActivity)
            }
            else if (SharedApp.prefs.opcion == "Soleados"){
                val intentActivity = Intent(this, PantallaPrincipal::class.java)
                intentActivity.putExtra(TAG, codigoCiudad)
                startActivity(intentActivity)
            }
        }
    }
}