package com.cho.githubsearch

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho

/**
 * Created by chonamdoo on 2017. 9. 17..
 */

class FlickrApp : Application(){
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        AppContext.init(base)
    }
}