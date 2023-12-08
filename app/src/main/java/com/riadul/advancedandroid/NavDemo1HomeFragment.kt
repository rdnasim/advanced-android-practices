package com.riadul.advancedandroid

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.riadul.advancedandroid.databinding.FragmentNavDemo1HomeBinding

class NavDemo1HomeFragment : Fragment() {
    private lateinit var binding: FragmentNavDemo1HomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_nav_demo1_home, container, false)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_nav_demo1_home, container, false)

        binding.button2.setOnClickListener {
            if (!TextUtils.isEmpty(binding.editText.text)) {
                val bundle = bundleOf("user_input" to binding.editText.text.toString())
                it.findNavController().navigate(R.id.action_navDemo1HomeFragment_to_navDemo1SecondFragment, bundle)
            } else {
                binding.editText.error = "Field cannot be empty"
            }
        }

        return binding.root
    }
}