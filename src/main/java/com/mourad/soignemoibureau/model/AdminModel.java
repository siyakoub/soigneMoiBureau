package com.mourad.soignemoibureau.model;

import com.google.gson.annotations.SerializedName;


public class AdminModel extends UserModel{
    @SerializedName("admin_id")
    private int adminId;
    @SerializedName("adminRole")
    private String adminRole;

    public AdminModel() {
        super();
    }

    public AdminModel(int userId, String userName, String userFirstName, String userAddress, int userZipCode, String userCity, String userEmail, String userPassword, String userType, int userActif, int adminId,  String administratorRole) {
        super(userId, userName, userFirstName, userAddress, userZipCode, userCity, userEmail, userPassword, userType, userActif);
        this.adminId = adminId;
        this.adminRole = administratorRole;
    }

    public int getAdminId() {
        return adminId;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }
}
