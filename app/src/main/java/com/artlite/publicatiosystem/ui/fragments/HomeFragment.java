package com.artlite.publicatiosystem.ui.fragments;

import android.view.View;

import com.artlite.bslibrary.ui.fragment.BSFragment;
import com.artlite.publicatiosystem.R;
import com.artlite.publicatiosystem.ui.activities.NewItemActivity;

public class HomeFragment extends BSFragment {

    /**
     * Method which provide the getting of the current layout ID
     *
     * @return current layout ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    /**
     * Method which provide the action when fragment is created
     *
     * @param containerView current view
     */
    @Override
    protected void onCreateFragment(View containerView) {
        this.setOnClickListeners(R.id.button_add);
    }

    /**
     * Method which provide the action when fragment is created
     *
     * @param containerView current view
     */
    @Override
    protected void onFragmentPostCreation(View containerView) {

    }

    /**
     * Method which provide the action for the OnClickListener event
     *
     * @param v current view
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_add) {
            this.startActivity(NewItemActivity.class);
        }
    }
}
