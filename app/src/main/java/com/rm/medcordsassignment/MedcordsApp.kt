package com.rm.medcordsassignment

import android.app.Application
import com.rm.medcordsassignment.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasActivityInjector

class MedcordsApp :DaggerApplication(), HasActivityInjector{
    private val applicationInjector = DaggerAppComponent.builder()
        .application(this)
        .build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return applicationInjector
    }


}