package com.riadul.advancedandroid.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.databinding.ActivityCoroutineMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutineMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoroutineMainBinding
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_coroutine_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_coroutine_main)

//        CoroutineScope(Dispatchers.IO).launch {
//            Log.i("Coroutines", "Main Thread: ${Thread.currentThread().name}")
//        }
//
//        CoroutineScope(Dispatchers.Main).launch{
//            Log.i("Coroutines", "Main Thread: ${Thread.currentThread().name}")
//        }

        CoroutineScope(Main).launch {
            Log.i("Coroutines", "Calculating...")
            val stoke1 = async(IO) {
                getStock1()
            }
            val stoke2 = async(IO) {
                getStock2()
            }
            val total = stoke1.await() + stoke2.await()

            Toast.makeText(applicationContext, "Total is $total", Toast.LENGTH_SHORT).show()
            Log.i("Coroutines", "Total is: $total")
        }

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }

        binding.btnDownloadUserData.setOnClickListener {
            CoroutineScope(Main).launch{
                binding.tvUserMessage.text = UserDataManager().getTotalUserCount().toString()
            }
//            CoroutineScope(IO).launch {
//                downloadUserData()
//            }
        }
    }

    private suspend fun downloadUserData() {
        for (i in 1..200000){
            //println("Downloading user $i in ${Thread.currentThread().name}")
            withContext(Main) {
                binding.tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
                delay(1000)
            }
        }
    }

    private suspend fun getStock1(): Int{
        delay(10000)
        Log.i("Coroutines", "Stock 1: returned")
        return 55000
    }

    private suspend fun getStock2(): Int{
        delay(8000)
        Log.i("Coroutines", "Stock 2: returned")
        return 35000
    }
}