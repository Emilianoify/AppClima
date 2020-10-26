package com.stay.hearthweather.data.models

class Main(temp:Double, feels_like:Double, humidity:Int, temp_min:Double,temp_max:Double) {
    var temp:Double = 0.0
    var feels_like:Double = 0.0
    var humidity:Int = 0
    var temp_min = 0.0
    var temp_max = 0.0
    init{
        this.temp = temp
        this.feels_like = feels_like
        this.humidity = humidity
        this.temp_min = temp_min
        this.temp_max = temp_max
    }
}