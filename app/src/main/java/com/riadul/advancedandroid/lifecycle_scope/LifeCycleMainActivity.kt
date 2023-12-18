package com.riadul.advancedandroid.lifecycle_scope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.riadul.advancedandroid.R
import com.riadul.advancedandroid.databinding.ActivityLifeCycleMainBinding
import com.riadul.advancedandroid.lifecycle_scope.ui.main.LifeCycleMainFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LifeCycleMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityLifeCycleMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_life_cycle_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_life_cycle_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LifeCycleMainFragment.newInstance())
                .commitNow()
        }

        lifecycleScope.launch {
            delay(5000)
            binding.progressBar.visibility = View.VISIBLE
            delay(10000)
            binding.progressBar.visibility = View.GONE
        }
    }
}