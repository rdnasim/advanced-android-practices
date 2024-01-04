package com.riadul.advancedandroid.dependancy_injection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.riadul.advancedandroid.R
import javax.inject.Inject

class DIMainActivity : AppCompatActivity() {

    @Inject
    lateinit var smartPhone: SmartPhone
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dimain)

        (application as SmartPhoneApplication).smartPhoneComponent.inject(this)
        smartPhone.makeCallWithRecording()

//        DaggerSmartPhoneComponent.create().getSmartPhone().makeCallWithRecording()
//        DaggerSmartPhoneComponent.create().inject(this)
//        smartPhone.makeCallWithRecording()


    }
}