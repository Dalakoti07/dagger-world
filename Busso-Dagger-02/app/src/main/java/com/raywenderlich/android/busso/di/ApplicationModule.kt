package com.raywenderlich.android.busso.di

import com.raywenderlich.android.busso.network.NetworkModule
import dagger.Module

@Module(includes = [
    LocationModule::class,
    NetworkModule::class
])
object ApplicationModule
