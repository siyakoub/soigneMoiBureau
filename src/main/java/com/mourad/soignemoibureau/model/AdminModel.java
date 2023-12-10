package com.mourad.soignemoibureau.model;

public class AdminModel extends UserModel{

    private int adminId;
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
