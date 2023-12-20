package com.riadul.advancedandroid.room_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.databinding.ActivityRoomMainBinding
import com.riadul.advancedandroid.room_demo.db.Subscriber
import com.riadul.advancedandroid.room_demo.db.SubscriberDatabase
import com.riadul.advancedandroid.room_demo.db.SubscriberRepository

class RoomMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoomMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel
    private lateinit var adapter: RoomRecycleViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_main)

        val dao = SubscriberDatabase.getInstance(applicationContext).subscriberDAO
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)

        subscriberViewModel = ViewModelProvider(this, factory)[SubscriberViewModel::class.java]
        binding.roomMainViewModel = subscriberViewModel
        binding.lifecycleOwner = this

        initRecycleView()

        subscriberViewModel.message.observe(this) { it ->
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun initRecycleView() {
        binding.subscriberRecycleView.layoutManager = LinearLayoutManager(this)
        adapter = RoomRecycleViewAdapter{ selectedItem: Subscriber -> listItemClicked(selectedItem) }
        binding.subscriberRecycleView.adapter = adapter
        displaySubscribersList()
    }

    private fun displaySubscribersList() {
        subscriberViewModel.subscribers.observe(this) {
            Log.d("TAG", it.toString())

            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }
    }

    private fun listItemClicked(subscriber: Subscriber) {
        //Toast.makeText(this, "Selected name is ${subscriber.name}", Toast.LENGTH_SHORT).show()
        subscriberViewModel.initUpdateAndDelete(subscriber)

    }
}