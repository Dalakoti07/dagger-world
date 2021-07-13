package com.raywenderlich.android.busso.di

import android.app.Activity
import com.raywenderlich.android.busso.di.scope.ActivityScope
import com.raywenderlich.android.busso.ui.view.main.MainPresenter
import com.raywenderlich.android.busso.ui.view.main.MainPresenterImpl
import com.raywenderlich.android.busso.ui.view.splash.SplashPresenter
import com.raywenderlich.android.busso.ui.view.splash.SplashPresenterImpl
import com.raywenderlich.android.busso.ui.view.splash.SplashViewBinder
import com.raywenderlich.android.busso.ui.view.splash.SplashViewBinderImpl
import com.raywenderlich.android.ui.navigation.Navigator
import com.raywenderlich.android.ui.navigation.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [ActivityModule.Bindings::class])
class ActivityModule {

    @Module
    interface Bindings {
        @Binds
        fun bindSplashPresenter(impl: SplashPresenterImpl): SplashPresenter

        @Binds
        fun bindSplashViewBinder(impl: SplashViewBinderImpl): SplashViewBinder

        @Binds
        fun bindMainPresenter(impl: MainPresenterImpl): MainPresenter
    }

    @Provides
    @ActivityScope
    fun provideNavigator(activity: Activity): Navigator = NavigatorImpl(activity)
}
