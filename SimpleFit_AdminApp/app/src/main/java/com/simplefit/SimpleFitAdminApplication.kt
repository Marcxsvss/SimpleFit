package com.simplefit

import android.app.Application

import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class SimpleFitAdminApplication: Application (){

    override fun onCreate() {

        super.onCreate()

    }
}