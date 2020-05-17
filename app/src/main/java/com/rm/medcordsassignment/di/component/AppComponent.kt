package com.rm.medcordsassignment.di.component

import android.app.Application
import com.rm.medcordsassignment.MedcordsApp
import com.rm.medcordsassignment.di.ViewModelModule
import com.rm.medcordsassignment.di.module.ActivityBuilder
import com.rm.medcordsassignment.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AndroidInjectionModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        ActivityBuilder::class
    )
)
interface AppComponent:AndroidInjector<MedcordsApp> {
    override fun inject(application: MedcordsApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }


}