package com.artlite.apiskd.dao;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.artlite.apiskd.models.UserModel;

import java.util.List;

/**
 * Users dao
 */
@Dao
public interface APIUsersDao {

    /**
     * Method which provide to add user model to the database
     *
     * @param model instance of the {@link UserModel}
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(UserModel model);

    /**
     * Method which provide the clear of the users table
     */
    @Query("DELETE FROM Users")
    void clear();

    /**
     * Method which provide the getting of the all users
     *
     * @return instance of the {@link List} of the {@link UserModel}
     */
    @Query("SELECT * FROM users ORDER BY email ASC")
    LiveData<List<UserModel>> getAllUsers();

    /**
     * Method which provide the search user by email
     *
     * @param email {@link String} value of the email
     * @return instance of the {@link List}
     */
    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    List<UserModel> getUserByEmail(@NonNull String email);

}
