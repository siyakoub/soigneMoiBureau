package com.mourad.soignemoibureau.model;
import com.google.gson.annotations.SerializedName;

public class SejourModel {
    @SerializedName("sejour_id")
    private int sejourId;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("medecin_id")
    private int medecinId;
    @SerializedName("dateDebut")
    private String dateDebut; // format datetime
    @SerializedName("dateFin")
    private String dateFin; // format datetime, peut être null
    @SerializedName("motif")
    private String motif;
    @SerializedName("speciality")
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
