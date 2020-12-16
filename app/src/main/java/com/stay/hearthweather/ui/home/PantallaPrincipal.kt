package com.stay.hearthweather.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.stay.hearthweather.R
import com.stay.hearthweather.data.models.Ciudad
import com.stay.hearthweather.data.network.Network
import java.lang.Exception

class PantallaPrincipal : AppCompatActivity() {

    var tvclima: TextView? = null
    var tvtemperatura: TextView? = null
    var tvciudad: TextView? = null
    var tvstermica: TextView? = null
    var tvhumedad: TextView? = null
    var tvminima: TextView? = null
    var tvmaxima: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)
        val ciudad = intent.getStringExtra("com.stay.hearthweather.ciudades.CIUDAD")
        if(Network.hayRed(this)){
            solicitudVolley("http://api.openweathermap.org/data/2.5/weather?id=$ciudad&appid=d02f73286a8d2122b690e1b7895a68f5&lang=sp&units=metric")
        }else{
            Toast.makeText(this, "No hay red", Toast.LENGTH_LONG).show()
        }

        tvciudad = findViewById(R.id.tvciudad)
        tvclima = findViewById(R.id.tvclima)
        tvtemperatura = findViewById(R.id.tvtemperatura)
        tvstermica= findViewById(R.id.tvstermica)
        tvhumedad= findViewById(R.id.tvhumedad)
        tvminima= findViewById(R.id.tvminima)
        tvmaxima= findViewById(R.id.tvmaxima)
    }
    @SuppressLint("SetTextI18n")
    private fun solicitudVolley(url:String){
        val queue = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET, url, {
                response ->  try{
            Log.d("solicitudVolley", response)
            val gson = Gson()
            val ciudad = gson.fromJson(response, Ciudad::class.java)
            tvciudad?.text = ciudad.name
            tvclima?.text = ciudad.weather?.get(0)?.description
            tvtemperatura?.text = ciudad.main?.temp.toString() + "°"
            tvstermica?.text= "Sensación termica: " + ciudad.main?.feels_like.toString() + "°"
            tvhumedad?.text= "Humedad: " + ciudad.main?.humidity.toString() + "%"
            tvminima?.text = ciudad.main?.temp_min.toString() + "°/"
            tvmaxima?.text = ciudad.main?.temp_max.toString() + "°"
            Log.d("GSON", ciudad.name)
        }catch (e: Exception){

        }
        }, {  })

        queue.add(solicitud)
    }
}