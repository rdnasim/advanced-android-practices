package com.riadul.advancedandroid.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.databinding.ActivityWorkManagerMainBinding
import java.util.concurrent.TimeUnit

class WorkManagerMainActivity : AppCompatActivity() {

    companion object {
        const val KEY_COUNT_VALUE = "key_count"
    }

    lateinit var binding: ActivityWorkManagerMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_work_manager_main)

        binding.startButton.setOnClickListener {
            //setOneTimeWorkRequest()
            setPeriodicWorkRequest()
        }
    }

    private fun setOneTimeWorkRequest() {
        val workManager = WorkManager.getInstance(applicationContext)

        val data: Data = Data.Builder()
            .putInt(KEY_COUNT_VALUE, 125)
            .build()
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .setConstraints(constraints)
            .setInputData(data)
            .build()

        val filteringRequest = OneTimeWorkRequest.Builder(FilteringWorker::class.java)
            .build()
        val compressingRequest = OneTimeWorkRequest.Builder(CompressingWorker::class.java)
            .build()
        val downloadingRequest = OneTimeWorkRequest.Builder(DownloadingWorker::class.java)
            .build()

        val paralleWorks = mutableListOf<OneTimeWorkRequest>()
        paralleWorks.add(downloadingRequest)
        paralleWorks.add(filteringRequest)

        workManager
            .beginWith(paralleWorks)
            .then(compressingRequest)
            .then(uploadRequest)
            .enqueue()



        workManager.getWorkInfoByIdLiveData(uploadRequest.id)
            .observe(this) {
                binding.textView.text = it.state.name
                if (it.state.isFinished) {
                    val dataOutput = it.outputData
                    val message = dataOutput.getString(UploadWorker.KEY_WORKER)
                    Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun setPeriodicWorkRequest() {
        val periodicWorkRequest = PeriodicWorkRequest.Builder(DownloadingWorker::class.java, 15, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(this).enqueue(periodicWorkRequest)

    }
}