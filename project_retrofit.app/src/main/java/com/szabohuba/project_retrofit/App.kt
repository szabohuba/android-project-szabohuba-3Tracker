package com.szabohuba.project_retrofit

import android.app.Application
import com.szabohuba.project_retrofit.manager.SharedPreferencesManager

/**
 * Base class of Android app, containing components like Activities and Services.
 * Application or its sub classes are instantiated before all the activities or any other application
 * objects have been created in Android app.
 *
 */
class App : Application() {

    companion object {
        lateinit var sharedPreferences: SharedPreferencesManager
    }

    override fun onCreate() {
        super.onCreate()
        sharedPreferences = SharedPreferencesManager(applicationContext)
    }
}