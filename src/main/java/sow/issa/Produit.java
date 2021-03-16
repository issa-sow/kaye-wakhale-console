package sow.issa;

public class Produit {
    private static long idProduit;
    private String nomProduit;
    private double prix;
    private String marque;
    private String modele;

    public Produit() {
        Produit.idProduit++;
        this.nomProduit = null;
        this.prix = 0;
        this.marque = null;
        this.modele = null;
    }

    public Produit(String nomProduit, double prix, String marque, String modele) {
        Produit.idProduit++;
        this.nomProduit = nomProduit;
        this.prix = prix;
        this.marque = marque;
        this.modele = modele;
    }

    public static long getIdProduit() {
        return Produit.idProduit;
    }

    public static void setIdProduit() {
        Produit.idProduit++;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Override
    public String toString() {
        return "\tProduit {\n" +
                //"\t\tidProduit=" + idProduit + "'\n" +
                "\t\tnomProduit='" + nomProduit + "'\n" +
                "\t\tprix=" + prix + "'\n" +
                "\t\tmarque=" + marque + "'\n" +
                "\t\tmodele='" + modele + "'\n" +
                "\t}";
    }
}
