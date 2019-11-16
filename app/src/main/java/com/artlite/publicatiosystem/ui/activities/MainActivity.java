package com.artlite.publicatiosystem.ui.activities;

import android.app.usage.UsageEvents;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.artlite.apiskd.viewmodels.UserViewModel;
import com.artlite.bslibrary.annotations.FindViewBy;
import com.artlite.bslibrary.ui.activity.BSActivity;
import com.artlite.bslibrary.ui.fonted.BSEditText;
import com.artlite.publicatiosystem.R;
import com.artlite.publicatiosystem.mvp.login.DefaultLoginPresenter;
import com.artlite.publicatiosystem.mvp.login.LoginContract;
import com.artlite.publicatiosystem.repositories.user.UserRepository;

/**
 * Activity which provide the login for us
 */
public class MainActivity extends BSActivity implements LoginContract.View {

    /**
     * Users view model
     */
    private UserViewModel userViewModel;

    /**
     * Instance of {@link BSEditText}
     */
    @FindViewBy(id = R.id.edit_login)
    private BSEditText loginEditText;

    /**
     * Instance of {@link BSEditText}
     */
    @FindViewBy(id = R.id.edit_password)
    private BSEditText passwordEditText;

    /**
     * Instance of the {@link DefaultLoginPresenter}
     */
    private DefaultLoginPresenter presenter;

    /**
     * Method which provide the getting of the layout ID for the current Activity
     *
     * @return layout ID for the current Activity
     */
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * Method which provide the action when Activity is created
     *
     * @param bundle
     */
    @Override
    protected void onCreateActivity(@Nullable Bundle bundle) {
        this.setTitle(R.string.text_login);
//        if (UserRepository.getInstance().isAuthentificated()) {
//            this.startHomeActivity();
//            return;
//        }
        this.userViewModel = ViewModelProviders.of(this)
                .get(UserViewModel.class);
        this.presenter = new DefaultLoginPresenter(this);
        this.setOnClickListeners(R.id.button_register,
                R.id.button_forgot_password,
                R.id.button_login);
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
     * Method which provide the starting of the home activity
     *
     * @see HomeActivity
     */
    protected void startHomeActivity() {
        this.startActivity(HomeActivity.class, true);
    }

    /**
     * Overriden method for the OnClickListener
     *
     * @param v current view
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_login) {
            this.presenter.loginPresenterAuth(this.loginEditText.getStringValue(),
                    this.passwordEditText.getStringValue());
        } else if (id == R.id.button_register) {
            // TODO: 20.07.2019
        } else if (id == R.id.button_forgot_password) {
            // TODO: 20.07.2019
        }
    }

    /**
     * Method which provide the logic when the presenter return result
     *
     * @param event   instance of the {@link UsageEvents.Event}
     * @param message instance of the {@link String}
     */
    @Override
    public void loginViewOnResult(LoginContract.Events event, @Nullable String message) {
        switch (event) {
            case SUCCESS:
                this.startHomeActivity();
                break;
            case ERROR:
                break;
            case NULL_EMAIL:
                this.loginEditText.setError(getString(R.string.text_required_field));
                break;
            case WRONG_EMAIL:
                this.loginEditText.setError(getString(R.string.text_invalid_email));
                break;
            case NULL_PASSWORD:
                this.passwordEditText.setError(getString(R.string.text_required_field));
                break;
        }
    }

    /**
     * Method which provide the getting of the view model
     *
     * @return instance of the {@link UserViewModel}
     */
    @NonNull
    public UserViewModel getViewModel() {
        return this.userViewModel;
    }

}
