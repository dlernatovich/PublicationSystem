package com.artlite.publicatiosystem.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.artlite.bslibrary.annotations.FindViewBy;
import com.artlite.bslibrary.ui.activity.BSActivity;
import com.artlite.bslibrary.ui.custom.BSViewPagerNonScroll;
import com.artlite.publicatiosystem.R;
import com.artlite.publicatiosystem.ui.adapters.HomePagerAdapter;
import com.artlite.publicatiosystem.ui.views.BottomBarView;

/**
 * Activity which provide the show of the home screen
 */
public class HomeActivity extends BSActivity implements BottomBarView.BottomBarViewDelegate {

    /**
     * Instance of the {@link BSViewPagerNonScroll}
     */
    @FindViewBy(id = R.id.view_pager)
    private BSViewPagerNonScroll viewPager;

    /**
     * Instance of the {@link BottomBarView}
     */
    @FindViewBy(id = R.id.view_bottom_bar)
    private BottomBarView bottomBar;

    /**
     * Instance of the {@link HomePagerAdapter}
     */
    private HomePagerAdapter adapter;

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
        this.adapter = new HomePagerAdapter(this.getSupportFragmentManager());
        this.viewPager.setAdapter(this.adapter);
        this.bottomBar.setDelegate(this);
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

    // ------ BottomBarViewDelegate

    /**
     * Method which provide the functionality when the item in the
     * bottom bar was clicked
     *
     * @param view  instance of the {@link BottomBarView}
     * @param index value
     */
    @Override
    public void bottomBarClicked(@NonNull BottomBarView view, int index) {
        this.viewPager.setCurrentItem(index);
    }
}
