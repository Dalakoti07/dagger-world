package com.raywenderlich.android.busso.di

import com.raywenderlich.android.busso.ui.view.busarrival.BusArrivalPresenter
import com.raywenderlich.android.busso.ui.view.busarrival.BusArrivalPresenterImpl
import com.raywenderlich.android.busso.ui.view.busarrival.BusArrivalViewBinder
import com.raywenderlich.android.busso.ui.view.busarrival.BusArrivalViewBinderImpl
import com.raywenderlich.android.busso.ui.view.busstop.BusStopListPresenter
import com.raywenderlich.android.busso.ui.view.busstop.BusStopListPresenterImpl
import com.raywenderlich.android.busso.ui.view.busstop.BusStopListViewBinder
import com.raywenderlich.android.busso.ui.view.busstop.BusStopListViewBinderImpl
import dagger.Binds
import dagger.Module

@Module
interface FragmentModule {

    @Binds
    fun bindBusStopListViewBinder(impl: BusStopListViewBinderImpl): BusStopListViewBinder

    @Binds
    fun bindBusStopListPresenter(impl: BusStopListPresenterImpl): BusStopListPresenter

    @Binds
    fun bindBusStopListViewBinderListener(impl: BusStopListPresenterImpl): BusStopListViewBinder.BusStopItemSelectedListener

    @Binds
    fun bindBusArrivalPresenter(impl: BusArrivalPresenterImpl): BusArrivalPresenter

    @Binds
    fun bindBusArrivalViewBinder(impl: BusArrivalViewBinderImpl): BusArrivalViewBinder
}
