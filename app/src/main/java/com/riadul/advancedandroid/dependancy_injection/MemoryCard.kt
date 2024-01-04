package com.riadul.advancedandroid.dependancy_injection

import android.util.Log
import javax.inject.Inject

class MemoryCard{
    init {
        Log.i("MYTAG", "Memory Card Constructed")
    }

    fun getSpaceAvailable(){
        Log.i("MYTAG", "Memory Space Available")
    }
}