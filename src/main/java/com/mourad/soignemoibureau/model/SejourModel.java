package com.mourad.soignemoibureau.model;

public class SejourModel {
    private int sejourId;
    private int userId;
    private int medecinId;
    private String dateDebut; // format datetime
    private String dateFin; // format datetime, peut être null
    private String motif;
    private String speciality; // Chirurgie, Consultation, Urgence, Autopsie, Autre

    public SejourModel() {

    }

    public SejourModel(int sejourId, int userId, int medecinId, String dateDebut, String dateFin, String motif, String speciality) {
        this.sejourId = sejourId;
        this.userId = userId;
        this.medecinId = medecinId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.motif = motif;
        this.speciality = speciality;
    }

    public int getSejourId() {
        return sejourId;
    }

    public int getUserId() {
        return userId;
    }

    public int getMedecinId() {
        return medecinId;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
