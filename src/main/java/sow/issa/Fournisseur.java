package sow.issa;

public class Fournisseur extends Personne{
    private static long idFournisseur = 0;

    public Fournisseur(){
        super();
        Fournisseur.idFournisseur++;
    }

    public Fournisseur(String nom, String prenom, String dateNais, String telephone) {
        super(nom, prenom, dateNais, telephone);
        Fournisseur.idFournisseur++;
    }

    public static long getIdFournisseur() {
        return Fournisseur.idFournisseur;
    }

    public static void setIdFournisseur() {
        Fournisseur.idFournisseur++;
    }

    @Override
    public String toString() {
         return "\tFournisseur " +
                "{\n" +
                    //"\t\tidFournisseur='" + Fournisseur.idFournisseur + "'\n"  +
                    super.toString() +
                "\n\t}";
    }
}
