package com.artlite.apiskd.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.artlite.apiskd.constants.APIConstants;
import com.artlite.bslibrary.helpers.validation.BSValidationHelper;
import com.artlite.bslibrary.managers.BSRandomManager;

@Entity(tableName = "users")
public class UserModel {

    /**
     * {@link String} value of the user id
     */
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "identifier")
    private String identifier;

    /**
     * {@link String} value of the email
     */
    @NonNull
    @ColumnInfo(name = "email")
    private String email;

    /**
     * {@link String} value of the password
     */
    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    /**
     * {@link String} value of the first name
     */
    @Nullable
    @ColumnInfo(name = "first_name")
    private String firstName;

    /**
     * {@link String} value of the last name
     */
    @Nullable
    @ColumnInfo(name = "last_name")
    private String lastName;

    /**
     * {@link String} value of the middle name
     */
    @Nullable
    @ColumnInfo(name = "middle_name")
    private String middleName;

    /**
     * Default constructor
     */
    public UserModel() {
        this.setIdentifier(BSRandomManager.generateString(APIConstants.K_ID_LENGTH));
    }

    /**
     * Method which provide the id setting
     *
     * @param id instance of the {@link String}
     */
    public void setIdentifier(@NonNull String id) {
        this.identifier = id;
    }

    /**
     * Get the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    @NonNull
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Get the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    @NonNull
    public String getEmail() {
        return email;
    }

    /**
     * Set the {@link Object}
     *
     * @param email instance of the {@link Object}
     */
    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    /**
     * Get the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    @NonNull
    public String getPassword() {
        return password;
    }

    /**
     * Set the {@link Object}
     *
     * @param password instance of the {@link Object}
     */
    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    /**
     * Get the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    @Nullable
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the {@link Object}
     *
     * @param firstName instance of the {@link Object}
     */
    public void setFirstName(@Nullable String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    @Nullable
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the {@link Object}
     *
     * @param lastName instance of the {@link Object}
     */
    public void setLastName(@Nullable String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    @Nullable
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Set the {@link Object}
     *
     * @param middleName instance of the {@link Object}
     */
    public void setMiddleName(@Nullable String middleName) {
        this.middleName = middleName;
    }

    /**
     * Validation method
     *
     * @return if it correct model
     */
    public boolean validate() {
        if (this.email == null || this.email.isEmpty()) return false;
        if (!BSValidationHelper.validateEmail(this.email)) return false;
        if (this.password == null || this.password.isEmpty()) return false;
        return true;
    }

    /**
     * Builder for the {@link UserModel}
     */
    public static class Builder {

        /**
         * Instance of the {@link UserModel}
         */
        private final UserModel model;

        /**
         * Default constructor
         */
        public Builder() {
            this.model = new UserModel();
        }

        /**
         * Set the {@link Object}
         *
         * @param email instance of the {@link Object}
         */
        public Builder setEmail(@NonNull String email) {
            this.model.email = email;
            return this;
        }

        /**
         * Set the {@link Object}
         *
         * @param password instance of the {@link Object}
         */
        public Builder setPassword(@NonNull String password) {
            this.model.password = password;
            return this;
        }

        /**
         * Set the {@link Object}
         *
         * @param firstName instance of the {@link Object}
         */
        public Builder setFirstName(@Nullable String firstName) {
            this.model.firstName = firstName;
            return this;
        }

        /**
         * Set the {@link Object}
         *
         * @param lastName instance of the {@link Object}
         */
        public Builder setLastName(@Nullable String lastName) {
            this.model.lastName = lastName;
            return this;
        }

        /**
         * Set the {@link Object}
         *
         * @param middleName instance of the {@link Object}
         */
        public Builder setMiddleName(@Nullable String middleName) {
            this.model.middleName = middleName;
            return this;
        }

        /**
         * Build method
         *
         * @return instance of the {@link UserModel}
         */
        @NonNull
        public UserModel build() {
            return this.model;
        }
    }
}
