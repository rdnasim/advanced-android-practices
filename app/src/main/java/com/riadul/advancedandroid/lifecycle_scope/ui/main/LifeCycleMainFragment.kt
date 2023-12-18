package com.riadul.advancedandroid.lifecycle_scope.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.riadul.advancedandroid.R

class LifeCycleMainFragment : Fragment() {

    companion object {
        fun newInstance() = LifeCycleMainFragment()
    }

    private lateinit var viewModel: LifeCycleMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LifeCycleMainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main_life_cycle, container, false)
    }

}