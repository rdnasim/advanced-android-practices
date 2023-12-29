package com.riadul.advancedandroid.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.riadul.advancedandroid.workmanager.WorkManagerMainActivity.Companion.KEY_COUNT_VALUE
import java.text.SimpleDateFormat
import java.util.Date

class UploadWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    companion object {
        const val KEY_WORKER = "key_worker"
    }

    override fun doWork(): Result {
        return try {
            val count = inputData.getInt(KEY_COUNT_VALUE, 0)
            for (i in 0 until count) {
                Log.i("MYTAG", "Uploading $i")
            }

            val time = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = time.format(Date())

            val outputData = Data.Builder()
                .putString(KEY_WORKER, currentDate)
                .build()

            Result.success(outputData)
        } catch (e: Exception) {
            Result.failure()
        }
    }
}