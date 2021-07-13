package com.raywenderlich.android.busso.di

import android.app.Activity
import com.raywenderlich.android.busso.di.scope.ActivityScope
import com.raywenderlich.android.busso.ui.view.main.MainActivity
import com.raywenderlich.android.busso.ui.view.splash.SplashActivity
import com.raywenderlich.android.ui.navigation.Navigator
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
@ActivityScope
interface ActivityComponent {

    fun inject(activity: SplashActivity)

    fun inject(activity: MainActivity)

    //Define navigator() as the factory method for Navigator.
    // This is also necessary to make Navigator visible to its dependent @Component.
    fun navigator(): Navigator

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: Activity,
            applicationComponent: ApplicationComponent
        ): ActivityComponent
    }
}
