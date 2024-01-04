package com.riadul.advancedandroid.dependancy_injection

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule(private val memorySize: Int) {

    @Provides
    fun providesMemoryCard() : MemoryCard{
        Log.i("MYTAG", "Memory Size is $memorySize")
        return MemoryCard()
    }
}