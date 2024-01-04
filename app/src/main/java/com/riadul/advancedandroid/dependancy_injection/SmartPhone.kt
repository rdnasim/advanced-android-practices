package com.riadul.advancedandroid.dependancy_injection

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SmartPhone @Inject constructor (battery: Battery, simCard: SIMCard, memoryCard: MemoryCard) {

    init {
        battery.getPower()
        simCard.getConnection()
        memoryCard.getSpaceAvailable()

        Log.i("MYTAG", "SmartPhone Constructed")
    }

    fun makeCallWithRecording(){
        Log.i("MYTAG", "Calling with recording")
    }
}