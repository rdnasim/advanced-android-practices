package com.riadul.advancedandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.riadul.advancedandroid.coroutine.CoroutineMainActivity
import com.riadul.advancedandroid.data_binding.DataBinding2Activity
import com.riadul.advancedandroid.data_binding.DataBinding3Activity
import com.riadul.advancedandroid.databinding.ActivityMainBinding
import com.riadul.advancedandroid.lifecycle_scope.LifeCycleMainActivity
import com.riadul.advancedandroid.nav.demo1.NavDemo1Activity
import com.riadul.advancedandroid.notification.NotificationMainActivity
import com.riadul.advancedandroid.recycle_view.RecycleViewMainActivity
import com.riadul.advancedandroid.retrofit.RetrofitMainActivity
import com.riadul.advancedandroid.room_demo.RoomMainActivity
import com.riadul.advancedandroid.room_migration.RoomMigrationMainActivity
import com.riadul.advancedandroid.two_way_data_binding.TwoWayDBActivity
import com.riadul.advancedandroid.view_model.ViewModelD1Activity
import com.riadul.advancedandroid.view_model.ViewModelD2Activity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonDataBind3.setOnClickListener {
             startActivity(Intent(this, DataBinding3Activity::class.java))
        }

        binding.buttonDataBind2.setOnClickListener {
            startActivity(Intent(this, DataBinding2Activity::class.java))
        }

        binding.buttonViewModel1.setOnClickListener {
            startActivity(Intent(this, ViewModelD1Activity::class.java))
        }

        binding.buttonViewModel2.setOnClickListener {
            startActivity(Intent(this, ViewModelD2Activity::class.java))
        }

        binding.buttonTwoWayDB.setOnClickListener {
            startActivity(Intent(this, TwoWayDBActivity::class.java))
        }

        binding.buttonNavDemo1.setOnClickListener {
            startActivity(Intent(this, NavDemo1Activity::class.java))
        }

        binding.buttonRecycleView.setOnClickListener {
            startActivity(Intent(this, RecycleViewMainActivity::class.java))
        }

        binding.buttonCoroutine.setOnClickListener {
            startActivity(Intent(this, CoroutineMainActivity::class.java))
        }

        binding.buttonLifeCycle.setOnClickListener {
            startActivity(Intent(this, LifeCycleMainActivity::class.java))
        }

        binding.buttonRoom.setOnClickListener {
            startActivity(Intent(this, RoomMainActivity::class.java))
        }

        binding.buttonRoomMigration.setOnClickListener {
            startActivity(Intent(this, RoomMigrationMainActivity::class.java))
        }

        binding.buttonRetrofit.setOnClickListener {
            startActivity(Intent(this, RetrofitMainActivity::class.java))
        }

        binding.buttonNotification.setOnClickListener {
            startActivity(Intent(this, NotificationMainActivity::class.java))
        }
    }
}