package tn.esprit.spring.gestioncandidats;

public class JobDTO {
    private  int ID;
    private String Service;
    private boolean Etat;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getService() {
        return Service;
    }

    public void setService(String service) {
        Service = service;
    }

    public boolean isEtat() {
        return Etat;
    }

    public void setEtat(boolean etat) {
        Etat = etat;
    }
}