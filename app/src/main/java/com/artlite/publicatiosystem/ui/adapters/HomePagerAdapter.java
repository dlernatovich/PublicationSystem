package com.artlite.publicatiosystem.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.artlite.publicatiosystem.ui.fragments.DraftFragment;
import com.artlite.publicatiosystem.ui.fragments.FavouriteFragment;
import com.artlite.publicatiosystem.ui.fragments.HomeFragment;
import com.artlite.publicatiosystem.ui.fragments.SettingsFragment;

/**
 * Adapter which provide to show the fragments on the home screen
 *
 * @see com.artlite.publicatiosystem.ui.activities.HomeActivity
 */
public final class HomePagerAdapter extends FragmentStatePagerAdapter {

    /**
     * Constructor which provide to create the adapter from the fragment manager
     *
     * @param fm instance of {@link FragmentManager}
     */
    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new DraftFragment();
            case 2:
                return new FavouriteFragment();
            case 3:
                return new SettingsFragment();
            default:
                return null;
        }
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return 4;
    }
}
