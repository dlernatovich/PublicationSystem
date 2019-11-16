package com.artlite.apiskd.repositories;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.artlite.apiskd.dao.APIUsersDao;
import com.artlite.apiskd.databases.APIDatabase;
import com.artlite.apiskd.models.UserModel;

import java.util.List;

/**
 * Class which provide the repository for the {@link UserModel}
 */
public final class APIUserRepository {

    /**
     * Instance of the {@link APIUsersDao}
     */
    private final APIUsersDao dao;

    /**
     * Instance of the {@link LiveData}
     */
    private final LiveData<List<UserModel>> data;

    /**
     * Default constructor
     */
    public APIUserRepository(@NonNull Context context) {
        APIDatabase database = APIDatabase.getInstance(context);
        this.dao = database.usersDao();
        this.data = this.dao.getAllUsers();
    }

    /**
     * Get all users live data
     *
     * @return instance of the {@link LiveData}
     */
    @NonNull
    public LiveData<List<UserModel>> getAllUsers() {
        return data;
    }

    /**
     * Method which provide the add of the {@link UserModel}
     *
     * @param model instance of the {@link UserModel}
     */
    public void add(@Nullable final UserModel model) {
        APIDatabase.executor.execute(new Runnable() {
            @Override
            public void run() {
                dao.add(model);
            }
        });
    }

    /**
     * Method which provide the clear functionality
     */
    public void clear() {
        APIDatabase.executor.execute(new Runnable() {
            @Override
            public void run() {
                dao.clear();
            }
        });
    }

    /**
     * Method which provide the getting user by email
     *
     * @param email String value of the email
     * @return instance of the {@link List}
     */
    public List<UserModel> getUserByEmail(@NonNull String email) {
        return this.dao.getUserByEmail(email);
    }

}
