package com.raywenderlich.android.busso.network

import android.app.Application
import com.google.gson.GsonBuilder
import com.raywenderlich.android.busso.conf.BUSSO_SERVER_BASE_URL
import com.raywenderlich.android.busso.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private val CACHE_SIZE = 100 * 1024L // 100K

@Module
class NetworkModule {
    // 1
    @Provides
    @ApplicationScope
    fun provideCache(application: Application): Cache =
        Cache(application.cacheDir, CACHE_SIZE)

    // 2
    @Provides
    @ApplicationScope
    fun provideHttpClient(cache: Cache): OkHttpClient =
        OkHttpClient.Builder()
            .cache(cache)
            .build()

    // 3
    @Provides
    @ApplicationScope
    fun provideBussoEndPoint(httpClient: OkHttpClient): BussoEndpoint {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BUSSO_SERVER_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()
                )
            )
            .client(httpClient)
            .build()
        return retrofit.create(BussoEndpoint::class.java)
    }
}
