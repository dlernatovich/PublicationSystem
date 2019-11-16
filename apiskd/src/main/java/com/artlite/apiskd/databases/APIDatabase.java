package com.artlite.apiskd.databases;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.artlite.apiskd.dao.APIUsersDao;
import com.artlite.apiskd.models.UserModel;
import com.artlite.bslibrary.annotations.Warning;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class which provide the room database for the API SDK
 */
@Database(entities = {UserModel.class}, version = 1, exportSchema = false)
public abstract class APIDatabase extends RoomDatabase {

    /**
     * Getting instance of the {@link APIUsersDao}
     *
     * @return instance of the {@link APIUsersDao}
     */
    public abstract APIUsersDao usersDao();

    /**
     * Instance of the {@link APIDatabase}
     */
    private static volatile APIDatabase instance;

    /**
     * Amount of the threads number
     */
    private static final int K_THREADS_NUMBER = 4;

    /**
     * Instance of the {@link ExecutorService}
     */
    public static final ExecutorService executor =
            Executors.newFixedThreadPool(K_THREADS_NUMBER);

    /**
     * Get of the database
     *
     * @return instance of the {@link APIDatabase}
     */
    @NonNull
    public static APIDatabase getInstance(@NonNull final Context context) {
        if (instance == null) {
            synchronized (APIDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            APIDatabase.class,
                            "api_database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }

}
