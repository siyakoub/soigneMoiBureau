package com.mourad.soignemoibureau.model;

public class UserModel {
    private int userId;
    private String userName;
    private String userFirstName;
    private String userAddress;
    private int userZipCode;
    private String userCity;
    private String userEmail;
    private String userPassword;
    private String userType; // Médecin, Client, Administrateur
    private int userActif;

    public UserModel() {

    }

    public UserModel(int userId, String userName, String userFirstName, String userAddress, int userZipCode, String userCity, String userEmail, String userPassword, String userType, int userActif) {
        this.userId = userId;
        this.userName = userName;
        this.userFirstName = userFirstName;
        this.userAddress = userAddress;
        this.userZipCode = userZipCode;
        this.userCity = userCity;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userType = userType;
        this.userActif = userActif;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getUserZipCode() {
        return userZipCode;
    }

    public void setUserZipCode(int userZipCode) {
        this.userZipCode = userZipCode;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getUserActif() {
        return userActif;
    }

    public void setUserActif(int userActif) {
        this.userActif = userActif;
    }
}
