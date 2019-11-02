package com.artlite.publicatiosystem.ui.activities;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.artlite.bslibrary.ui.activity.BSActivity;
import com.artlite.bslibrary.ui.activity.BSAudioRecordActivity;
import com.artlite.publicatiosystem.R;

/**
 * New item activity
 */
public class NewItemActivity extends BSActivity {

    /**
     * Method which provide the getting of the layout ID for the current Activity
     *
     * @return layout ID for the current Activity
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_new_item;
    }

    /**
     * Method which provide the action when Activity is created
     *
     * @param bundle
     */
    @Override
    protected void onCreateActivity(@Nullable Bundle bundle) {
        this.setTitle(R.string.text_new_publication);
        this.setOnClickListeners(
                R.id.button_add_text,
                R.id.button_add_image,
                R.id.button_add_audio,
                R.id.button_add_save,
                R.id.button_cancel
        );
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

    /**
     * Overriden method for the OnClickListener
     *
     * @param v current view
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button_add_text:
                this.addTextPressed();
                break;
            case R.id.button_add_image:
                this.addImagePressed();
                break;
            case R.id.button_add_audio:
                this.addSoundPressed();
                break;
            case R.id.button_add_save:
                this.onSavePressed();
                break;
            case R.id.button_cancel:
                this.onCancelPressed();
                break;
            default:
                break;
        }
    }

    /**
     * On cancel pressed
     */
    private void onCancelPressed() {
        this.finish();
    }


    /**
     * On save pressed method
     */
    private void onSavePressed() {
        this.finish();
    }

    /**
     * Add sound pressed
     */
    private void addSoundPressed() {
        BSAudioRecordActivity.start(this);
    }

    /**
     * Add image pressed
     */
    private void addImagePressed() {
        this.startActivityForPickImage();
    }

    /**
     * Add text pressed method
     */
    private void addTextPressed() {

    }


}
