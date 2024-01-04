package com.riadul.advancedandroid.dependancy_injection

import android.util.Log

interface Battery {

    fun getPower(){
        Log.i("MYTAG", "Battery power is available")
    }
}