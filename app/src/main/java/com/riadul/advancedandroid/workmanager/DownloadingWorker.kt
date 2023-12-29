package com.riadul.advancedandroid.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat
import java.util.Date

class DownloadingWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        return try {
            for (i in 0..3000) {
                Log.i("MYTAG", "Downloading $i")
            }

            val time = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = time.format(Date())

            Log.i("MYTAG", "Completed $currentDate")

            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}