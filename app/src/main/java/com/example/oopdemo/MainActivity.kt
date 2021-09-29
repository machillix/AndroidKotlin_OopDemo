package com.example.oopdemo

import android.content.Context
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import com.example.oopdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ICustomSensor {

    private lateinit var binding: ActivityMainBinding
    lateinit var customSendor : CustomSensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var ladaVehicle = Vehicle("Lada")
        ladaVehicle.model_public = "Samara"


        var corollaVehicle = Vehicle("Toyota")
        corollaVehicle.model_set_get = ""


        var amazonVehicle = Vehicle("Volvo")
        //amazonVehicle.model_private = ""

        var unoVehicle = Vehicle("Fiat", "Uno")
        Log.v("ToniWesterlund", "${unoVehicle.model_private}")


        var puntoVehicle = Vehicle("Fiat", )
        Log.v("ToniWesterlund", "${puntoVehicle.model_private}")

        customSendor = CustomSensor(getSystemService(Context.SENSOR_SERVICE) as SensorManager, this)
    }

    override fun SensorAvarageAcceleration(avg: Float) {
        Log.v("ToniWesterlund", "${avg}")
    }
}