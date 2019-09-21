package com.artlite.publicatiosystem.mvp.login;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;

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

    }

}
