package com.shady8.lightmeter

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlin.math.log2
import kotlin.math.roundToInt

class LightMeter(context: Context) : SensorEventListener {
    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
    private var onUpdate: ((String) -> Unit)? = null

    fun startListening(callback: (String) -> Unit) {
        onUpdate = callback
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent) {
        val lux = event.values[0]
        val ev = log2(lux / 2.5)
        val stopDiff = (ev - 14).roundToInt()
        val display = if (stopDiff == 0) "0 stop" else "${if (stopDiff > 0) "+" else ""}$stopDiff stop"
        onUpdate?.invoke(display)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}