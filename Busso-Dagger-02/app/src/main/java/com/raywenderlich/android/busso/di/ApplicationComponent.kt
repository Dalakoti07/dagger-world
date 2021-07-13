package com.raywenderlich.android.busso.di

import android.app.Application
import com.raywenderlich.android.busso.di.scope.ApplicationScope
import com.raywenderlich.android.busso.network.BussoEndpoint
import com.raywenderlich.android.location.api.model.LocationEvent
import dagger.BindsInstance
import dagger.Component
import io.reactivex.Observable
import javax.inject.Singleton

@Component(modules = [ApplicationModule::class])
@ApplicationScope
interface ApplicationComponent {

    // 1
    fun locationObservable(): Observable<LocationEvent>
    // 2
    fun bussoEndpoint(): BussoEndpoint

    @Component.Factory
    interface Builder {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}
