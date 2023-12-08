package com.riadul.advancedandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.riadul.advancedandroid.databinding.FragmentNavDemo1SecondBinding

class NavDemo1SecondFragment : Fragment() {

    private lateinit var binding: FragmentNavDemo1SecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nav_demo1_second, container, false)

        val input = arguments?.getString("user_input")
        binding.textView2.text = input.toString()

        return binding.root
    }
}