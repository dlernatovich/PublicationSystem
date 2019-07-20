package com.artlite.publicatiosystem.core;

import android.app.Application;

import com.artlite.bslibrary.core.BSInstance;

/**
 * Class which provide the application sigleton for us
 */
public final class CurrentApplication extends Application {

    /**
     * Method which provide the action when the application start
     */
    @Override
    public void onCreate() {
        super.onCreate();
        BSInstance.init(this);
    }
}
