package com.artlite.apiskd.models;

import com.artlite.apiskd.constants.APIConstants;
import com.artlite.bslibrary.helpers.validation.BSValidationHelper;
import com.artlite.bslibrary.managers.BSRandomManager;

public class UserModel {

    /**
     * {@link String} value of the user id
     */
    private final String id;

    /**
     * {@link String} value of the email
     */
    private String email;

    /**
     * {@link String} value of the password
     */
    private String password;

    /**
     * {@link String} value of the first name
     */
    private String firstName;

    /**
     * {@link String} value of the last name
     */
    private String lastName;

    /**
     * {@link String} value of the middle name
     */
    private String middleName;

    public UserModel() {
        this.id = BSRandomManager.generateString(APIConstants.K_ID_LENGTH);
    }

    /**
     * Get the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    public String getId() {
        return id;
    }

    /**
     * Get the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the {@link Object}
     *
     * @param email instance of the {@link Object}
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the {@link Object}
     *
     * @param password instance of the {@link Object}
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the {@link Object}
     *
     * @param firstName instance of the {@link Object}
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the {@link Object}
     *
     * @param lastName instance of the {@link Object}
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the {@link Object}
     *
     * @return instance of the {@link Object}
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Set the {@link Object}
     *
     * @param middleName instance of the {@link Object}
     */
    public void setMiddleName(String middleName) {
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
        public Builder setEmail(String email) {
            this.model.email = email;
            return this;
        }

        /**
         * Set the {@link Object}
         *
         * @param password instance of the {@link Object}
         */
        public Builder setPassword(String password) {
            this.model.password = password;
            return this;
        }

        /**
         * Set the {@link Object}
         *
         * @param firstName instance of the {@link Object}
         */
        public Builder setFirstName(String firstName) {
            this.model.firstName = firstName;
            return this;
        }

        /**
         * Set the {@link Object}
         *
         * @param lastName instance of the {@link Object}
         */
        public Builder setLastName(String lastName) {
            this.model.lastName = lastName;
            return this;
        }

        /**
         * Set the {@link Object}
         *
         * @param middleName instance of the {@link Object}
         */
        public Builder setMiddleName(String middleName) {
            this.model.middleName = middleName;
            return this;
        }

        /**
         * Build method
         *
         * @return instance of the {@link UserModel}
         */
        public UserModel build() {
            return this.model;
        }
    }
}
