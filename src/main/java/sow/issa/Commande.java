package sow.issa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande {
    private static long idCommande;
    private Client client;
    private List<Produit> produits;

    public Commande() {
        Commande.idCommande++;
        this.client = new Client();
        this.produits = new ArrayList<Produit>();
    }

    public Commande(Client client, List<Produit> produits) {
        Commande.idCommande++;
        this.client = client;
        this.produits = produits;
    }

    public long getIdCommande() {
        return Commande.idCommande;
    }

    public static void setIdCommande() {
        Commande.idCommande++;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public String toString() {
        String allProduct = "";
        for (Produit p : produits) {
            allProduct += p.toString() + "\n";
        }
        return "Commande {\n" +
                client.toString() + "\n" +
                allProduct + "}";
    }
}
