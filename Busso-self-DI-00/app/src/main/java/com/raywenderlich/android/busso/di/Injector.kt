package com.raywenderlich.android.busso.di

interface Injector<A> {
    fun inject(target: A)
}
