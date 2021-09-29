package com.example.oopdemo

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log

interface ICustomSensor{
    fun SensorAvarageAcceleration(avg : Float)
}

class CustomSensor(var sensorManager : SensorManager, var listener : ICustomSensor) :
    SensorEventListener {

    var counter : Int = 0
    var xSum : Float = 0.0F

    init {
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        Log.v("TONIW", "onSensorChanged ${counter}")
        counter++
        var xAccelometer = p0!!.values[0]
        xSum +=xAccelometer
        if(counter == 10){

            var ka = xSum / counter
            counter = 0
            xSum = 0.0F
            listener.SensorAvarageAcceleration(xSum)
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        Log.v("TONIW", "onAccuracyChanged")
    }
}