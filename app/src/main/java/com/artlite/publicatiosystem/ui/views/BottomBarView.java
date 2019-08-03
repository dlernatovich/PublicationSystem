package com.artlite.publicatiosystem.ui.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

import com.artlite.bslibrary.ui.view.BSView;
import com.artlite.publicatiosystem.R;

/**
 * View which provide the bottom bar for the navigation between fragments
 */
public class BottomBarView extends BSView {

    /**
     * Delegate for the {@link BottomBarView}
     */
    public interface BottomBarViewDelegate {

        /**
         * Method which provide the functionality when the item in the
         * bottom bar was clicked
         *
         * @param view  instance of the {@link BottomBarView}
         * @param index value
         */
        void bottomBarClicked(@NonNull BottomBarView view, int index);

    }

    /**
     * Instance of the {@link BottomBarViewDelegate}
     */
    private BottomBarViewDelegate delegate;

    /**
     * Constructor which provide the create {@link BSView} from
     *
     * @param context instance of {@link Context}
     */
    public BottomBarView(Context context) {
        super(context);
    }

    /**
     * Constructor which provide the create {@link BSView} from
     *
     * @param context instance of {@link Context}
     * @param attrs   instance of {@link AttributeSet}
     */
    public BottomBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Constructor which provide the create {@link BSView} from
     *
     * @param context      instance of {@link Context}
     * @param attrs        instance of {@link AttributeSet}
     * @param defStyleAttr attribute style
     */
    public BottomBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Method which provide the getting of the layout ID
     *
     * @return layout ID
     */
    @Override
    protected int getLayoutId() {
        return R.layout.view_bottom_bar;
    }

    /**
     * Method which provide interface linking
     */
    @Override
    protected void onLinkInterface() {

    }

    /**
     * Method which provide the creating of the {@link View}
     */
    @Override
    protected void onCreateView() {
        this.setOnClickListeners(R.id.item_1, R.id.item_2, R.id.item_3, R.id.item_4);

    }

    /**
     * Method which provide the setting of the delegate
     *
     * @param delegate instance of the {@link BottomBarViewDelegate}
     */
    public void setDelegate(BottomBarViewDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Method which provide the on click functional
     *
     * @param view instance of {@link View}
     */
    @Override
    public void onClick(View view) {
        int id = view.getId();
        int index = 0;
        if (id == R.id.item_1) {
            index = 0;
        } else if (id == R.id.item_2) {
            index = 1;
        } else if (id == R.id.item_3) {
            index = 2;
        } else if (id == R.id.item_4) {
            index = 3;
        }
        if (this.delegate != null) {
            this.delegate.bottomBarClicked(this, index);
        }
    }
}
