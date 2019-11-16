package com.artlite.apiskd.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.artlite.apiskd.models.UserModel;
import com.artlite.apiskd.repositories.APIUserRepository;

import java.util.List;

/**
 * User view model class
 */
public final class UserViewModel extends AndroidViewModel {

    /**
     * Instance of the {@link APIUserRepository}
     */
    private final APIUserRepository repository;

    /**
     * Instance of the {@link LiveData}
     */
    private final LiveData<List<UserModel>> users;

    /**
     * Create view model from the {@link Application}
     *
     * @param application instance of the {@link Application}
     */
    public UserViewModel(@NonNull Application application) {
        super(application);
        this.repository = new APIUserRepository(application);
        this.users = this.repository.getAllUsers();
    }

    /**
     * Method which provide the getting of the all users
     *
     * @return instance of the {@link LiveData}
     */
    @NonNull
    public LiveData<List<UserModel>> getAllUsers() {
        return this.users;
    }

    /**
     * Method which provide the insert of the user model
     *
     * @param model instance of the {@link UserModel}
     */
    public void add(@Nullable UserModel model) {
        this.repository.add(model);
    }

    /**
     * Method which provide the clearing of the users table
     */
    public void clear() {
        this.repository.clear();
    }

    /**
     * Method which provide the getting user by email
     *
     * @param email String value of the email
     * @return instance of the {@link List}
     */
    public List<UserModel> getUserByEmail(@NonNull String email) {
        return this.repository.getUserByEmail(email);
    }

}
