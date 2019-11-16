package com.artlite.publicatiosystem.mvp.login;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.artlite.apiskd.models.UserModel;
import com.artlite.apiskd.viewmodels.UserViewModel;

import java.util.List;

/**
 * Login contract
 */
public final class LoginContract {

    /**
     * Events enum
     */
    public enum Events {
        SUCCESS, ERROR, NULL_EMAIL, WRONG_EMAIL, NULL_PASSWORD
    }

    /**
     * Presenter interface
     */
    public interface Presenter {

        /**
         * Method which provide to do the auth logic
         *
         * @param email    value
         * @param password value
         */
        void loginPresenterAuth(@Nullable String email,
                                @Nullable String password);

        /**
         * Method which provide the validation of the input data
         *
         * @param email    value
         * @param password value
         * @return validation result
         */
        boolean loginPresenterValidate(@Nullable String email,
                                       @Nullable String password);

        /**
         * Method which provide the getting of the available users
         *
         * @return instance of the {@link List}
         */
        @NonNull
        List<UserModel> getAvailableUsers(@Nullable String email);

        /**
         * Method which provide the save of the {@link UserModel} to database
         *
         * @param model instance of the {@link UserModel}
         */
        void save(@NonNull UserModel model);

    }

    /**
     * View interface
     */
    public interface View {

        /**
         * Method which provide the logic when the presenter return result
         *
         * @param event   instance of the {@link android.app.usage.UsageEvents.Event}
         * @param message instance of the {@link String}
         */
        @MainThread
        void loginViewOnResult(Events event,
                               @Nullable String message);

        /**
         * Method which provide the getting of the view model
         *
         * @return instance of the {@link UserViewModel}
         */
        @NonNull
        UserViewModel getViewModel();

    }

}
