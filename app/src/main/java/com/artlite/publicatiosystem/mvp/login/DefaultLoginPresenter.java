package com.artlite.publicatiosystem.mvp.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.artlite.apiskd.models.UserModel;
import com.artlite.bslibrary.helpers.validation.BSValidationHelper;
import com.artlite.publicatiosystem.repositories.user.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Default login contract presenter
 */
public class DefaultLoginPresenter implements LoginContract.Presenter {

    /**
     * Instance of the {@link LoginContract.View}
     */
    private final LoginContract.View view;

    /**
     * Default constructor
     *
     * @param view instance of the {@link LoginContract.View}
     */
    public DefaultLoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    /**
     * Method which provide to do the auth logic
     *
     * @param email    value
     * @param password value
     */
    @Override
    public void loginPresenterAuth(@Nullable String email,
                                   @Nullable String password) {
        if (this.loginPresenterValidate(email, password)) {
            List<UserModel> available = this.getAvailableUsers(email);
            UserModel model = null;
            if (available.size() > 0) {
                model = available.get(0);
            } else {
                model = new UserModel.Builder()
                        .setEmail(email)
                        .setPassword(password)
                        .build();
                this.save(model);
            }
            if (!model.getPassword().equals(password)) {
                this.view.loginViewOnResult(LoginContract.Events.ERROR,
                        "Password is invalid");
            } else if (UserRepository.getInstance().saveAuthentification(model)) {
                this.view.loginViewOnResult(LoginContract.Events.SUCCESS, null);
            } else {
                this.view.loginViewOnResult(LoginContract.Events.ERROR,
                        "Cant't save the user authentification");
            }
        }
    }

    /**
     * Method which provide the validation of the input data
     *
     * @param email    value
     * @param password value
     * @return validation result
     */
    @Override
    public boolean loginPresenterValidate(@Nullable String email,
                                          @Nullable String password) {
        if (email == null || email.isEmpty()) {
            this.view.loginViewOnResult(LoginContract.Events.NULL_EMAIL, null);
            return false;
        }
        if (!BSValidationHelper.validateEmail(email)) {
            this.view.loginViewOnResult(LoginContract.Events.WRONG_EMAIL, null);
            return false;
        }
        if (password == null || password.isEmpty()) {
            this.view.loginViewOnResult(LoginContract.Events.NULL_PASSWORD, null);
            return false;
        }
        return true;
    }

    /**
     * Method which provide the getting of the available users
     *
     * @param email
     * @return instance of the {@link List}
     */
    @NonNull
    @Override
    public List<UserModel> getAvailableUsers(@Nullable String email) {
        if (email == null) {
            return new ArrayList<>();
        }
        return this.view.getViewModel().getUserByEmail(email);
    }

    /**
     * Method which provide the save of the {@link UserModel} to database
     *
     * @param model instance of the {@link UserModel}
     */
    @Override
    public void save(@NonNull UserModel model) {
        this.view.getViewModel().add(model);
    }

}
