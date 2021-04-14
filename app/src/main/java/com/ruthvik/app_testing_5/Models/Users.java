package com.ruthvik.app_testing_5.Models;

public class Users {
    String userProfilePhoto, userName, userEmail, userPassword, userId, userLastMessage;

    public Users(String userProfilePhoto, String userName, String userEmail, String userPassword, String userId, String userLastMessage) {
        this.userProfilePhoto = userProfilePhoto;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userId = userId;
        this.userLastMessage = userLastMessage;
    }

    public Users() {}

    // signup class
    public Users(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserProfilePhoto() {
        return userProfilePhoto;
    }

    public void setUserProfilePhoto(String userProfilePhoto) {
        this.userProfilePhoto = userProfilePhoto;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserLastMessage() {
        return userLastMessage;
    }

    public void setUserLastMessage(String userLastMessage) {
        this.userLastMessage = userLastMessage;
    }
}
