package com.raywenderlich.android.busso.di

import androidx.appcompat.app.AppCompatActivity
import com.raywenderlich.android.ui.navigation.NavigatorImpl

// 1
const val NAVIGATOR = "Navigator"

// 1
val activityServiceLocatorFactory: (ServiceLocator) -> ServiceLocatorFactory<AppCompatActivity> =
    // 2
    { fallbackServiceLocator: ServiceLocator ->
        // 3
        { activity: AppCompatActivity ->
            ActivityServiceLocator(activity).apply {
                applicationServiceLocator = fallbackServiceLocator
            }
        }
    }


// ...
class ActivityServiceLocator(
    val activity: AppCompatActivity
) : ServiceLocator {

    // 1
    var applicationServiceLocator: ServiceLocator? = null

    @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
    override fun <A : Any> lookUp(name: String): A = when (name) {
        NAVIGATOR -> NavigatorImpl(activity)
        // 2
        else -> applicationServiceLocator?.lookUp<A>(name)
            ?: throw IllegalArgumentException("No component lookup for the key: $name")
    } as A
}
