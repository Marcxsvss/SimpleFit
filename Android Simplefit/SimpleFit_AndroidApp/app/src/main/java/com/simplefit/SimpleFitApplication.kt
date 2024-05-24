package com.simplefit

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class SimpleFitApplication: Application (){

    override fun onCreate() {

        super.onCreate()

    }
}