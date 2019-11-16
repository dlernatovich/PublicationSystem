package com.artlite.publicatiosystem.repositories.user;

import androidx.annotation.Nullable;

import com.artlite.apiskd.models.UserModel;
import com.artlite.bslibrary.managers.BSCryptSharedPreferenceManager;

/**
 * Class which provide to management the user
 */
public class UserRepository {

    /**
     * Constants enum
     */
    private enum Constants {
        KEY_AUTH("UserRepository.AuthKey"),
        KEY_EMAIL("UserRepository.UserEmail"),
        KEY_PASSWORD("UserRepository.UserPassword");

        private final String value;

        /**
         * Default constructor
         *
         * @param value instance of the {@link String}
         */
        Constants(String value) {
            this.value = value;
        }
    }

    /**
     * Instance of the {@link UserRepository}
     */
    private static UserRepository instance;

    /**
     * Get {@link UserRepository} instance
     *
     * @return instance of the {@link UserRepository}
     */
    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    /**
     * Check if the user is authentificated
     *
     * @return if it authentificated
     */
    public boolean isAuthentificated() {
        String userId = BSCryptSharedPreferenceManager.getString(Constants.KEY_AUTH.value);
        return !userId.isEmpty();
    }

    /**
     * Save user for the authentification
     *
     * @param model instance of the {@link UserModel}
     * @return if it saved
     */
    public boolean saveAuthentification(@Nullable UserModel model) {
        if (model == null) return false;
        if (!model.validate()) return false;
        BSCryptSharedPreferenceManager.save(model.getIdentifier(), Constants.KEY_AUTH.value);
        BSCryptSharedPreferenceManager.save(model.getEmail(), Constants.KEY_EMAIL.value);
        BSCryptSharedPreferenceManager.save(model.getPassword(), Constants.KEY_PASSWORD.value);
        return true;
    }
}
