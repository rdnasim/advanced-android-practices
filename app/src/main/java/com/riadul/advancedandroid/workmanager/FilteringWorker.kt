package com.riadul.advancedandroid.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class FilteringWorker(context: Context, params: WorkerParameters) : Worker(context, params) {


    override fun doWork(): Result {
        return try {
            for (i in 0..3000) {
                Log.i("MYTAG", "Filtering $i")
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}