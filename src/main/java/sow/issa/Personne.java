package sow.issa;

import java.util.Date;

public abstract class Personne {
    protected String nom;
    protected String prenom;
    protected String dateNais;
    protected String telephone;
    
    public Personne() {
        this.nom = null;
        this.prenom = null;
        this.dateNais = null;
        this.telephone = null;
    }

    public Personne(String nom, String prenom, String dateNais, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNais = dateNais;
        this.telephone = telephone;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNais() {
        return dateNais;
    }

    public void setDateNais(String dateNais) {
        this.dateNais = dateNais;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "\t\tnom='" + nom + "'\n" +
                "\t\tprenom='" + prenom + "'\n"  +
                "\t\tdateNais=" + dateNais + "'\n" +
                "\t\telephone='" + telephone + "'" ;
    }
}
