package com.artlite.publicatiosystem.core;

import android.app.Application;

import com.artlite.apiskd.databases.APIDatabase;
import com.artlite.bslibrary.core.BSInstance;

/**
 * Class which provide the application sigleton for us
 */
public final class CurrentApplication extends Application {

    /**
     * Instance of the {@link CurrentApplication}
     */
    private static CurrentApplication instance;

    /**
     * Method which provide the getting of the instance
     *
     * @return instance of the {@link CurrentApplication}
     */
    public static CurrentApplication getInstance() {
        return instance;
    }

    /**
     * Method which provide the action when the application start
     */
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        BSInstance.init(this);
    }

}
