package com.riadul.advancedandroid.dependancy_injection

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MemoryCardModule::class, NCBatteryModule::class])
interface SmartPhoneComponent {
    fun getSmartPhone(): SmartPhone
    fun inject(diMainActivity: DIMainActivity)
}