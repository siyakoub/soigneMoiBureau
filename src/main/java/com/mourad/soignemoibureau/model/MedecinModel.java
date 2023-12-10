package com.mourad.soignemoibureau.model;

public class MedecinModel extends UserModel {

    private int medecinId;
    private int matricule;
    private int limitCustomer;
    private String speciality;

    public MedecinModel() {
        super();
    }

    public MedecinModel(int userId, String userName, String userFirstName, String userAddress, int userZipCode, String userCity, String userEmail, String userPassword, String userType, int userActif, int medecinId, int matricule, int limiteCustomer, String speciality) {
        super(userId, userName, userFirstName, userAddress, userZipCode, userCity, userEmail, userPassword, userType, userActif);
        this.medecinId = medecinId;
        this.matricule = matricule;
        this.limitCustomer = limiteCustomer;
        this.speciality = speciality;
    }

    public int getMedecinId() {
        return medecinId;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public int getLimitCustomer() {
        return limitCustomer;
    }

    public void setLimitCustomer(int limitCustomer) {
        this.limitCustomer = limitCustomer;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
