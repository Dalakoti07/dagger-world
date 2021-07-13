package com.raywenderlich.android.busso.di

import com.raywenderlich.android.busso.di.scope.FragmentScope
import com.raywenderlich.android.busso.ui.view.busarrival.BusArrivalFragment
import com.raywenderlich.android.busso.ui.view.busstop.BusStopFragment
import dagger.Component

@Component(
    modules = [FragmentModule::class],
    dependencies = [ActivityComponent::class, ApplicationComponent::class] // 1
)
@FragmentScope // 2
interface FragmentComponent {

    fun inject(fragment: BusStopFragment) // 3

    fun inject(fragment: BusArrivalFragment) // 3

    @Component.Factory
    interface Factory {
        // 4
        fun create(
            applicationComponent: ApplicationComponent,
            activityComponent: ActivityComponent
        ): FragmentComponent
    }
}
