package com.rm.medcordsassignment.di.module

import com.rm.medcordsassignment.presenter.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder{

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity


}