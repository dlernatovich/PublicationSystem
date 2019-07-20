package com.artlite.publicatiosystem.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.artlite.bslibrary.ui.activity.BSActivity;
import com.artlite.publicatiosystem.R;

/**
 * Activity which provide the show of the home screen
 */
public class HomeActivity extends BSActivity {

    /**
     * Method which provide the getting of the layout ID for the current Activity
     *
     * @return layout ID for the current Activity
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    /**
     * Method which provide the action when Activity is created
     *
     * @param bundle
     */
    @Override
    protected void onCreateActivity(@Nullable Bundle bundle) {
        this.setTitle(R.string.text_home);
    }

    /**
     * Method which provide the action when Activity is created (post creation)
     * Use it if you create any callback inside the activity like
     * <b>final |CallbackType| callback = new |CallbackType|</b>
     *
     * @param bundle
     */
    @Override
    protected void onActivityPostCreation(@Nullable Bundle bundle) {

    }
}
