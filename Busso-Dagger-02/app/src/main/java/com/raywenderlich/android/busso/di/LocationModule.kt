package com.raywenderlich.android.busso.di

import android.app.Application
import android.content.Context
import android.location.LocationManager
import com.raywenderlich.android.busso.di.scope.ApplicationScope
import com.raywenderlich.android.busso.permission.GeoLocationPermissionCheckerImpl
import com.raywenderlich.android.location.api.model.LocationEvent
import com.raywenderlich.android.location.api.permissions.GeoLocationPermissionChecker
import com.raywenderlich.android.location.rx.provideRxLocationObservable
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import javax.inject.Singleton

@Module
class LocationModule {
    // 1
    @ApplicationScope
    @Provides
    fun provideLocationManager(application: Application): LocationManager =
        application.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    // 2
    @ApplicationScope
    @Provides
    fun providePermissionChecker(application: Application): GeoLocationPermissionChecker =
        GeoLocationPermissionCheckerImpl(application)

    // 3
    @Provides
    fun provideLocationObservable(
        locationManager: LocationManager,
        permissionChecker: GeoLocationPermissionChecker
    ): Observable<LocationEvent> = provideRxLocationObservable(locationManager, permissionChecker)
}
