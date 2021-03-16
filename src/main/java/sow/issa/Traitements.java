package sow.issa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Traitements {
    List<Fournisseur> allFournisseur = new ArrayList<>();
    List<Client> allClient  = new ArrayList<>();
    Stock stock = Stock.getInsatance();
    Scanner sc = new Scanner(System.in);
    /**
     * Partie concernant l'administrateur
     * c'est cette fonction qui gére l'ajout d'un fournisseur ou d'un client
     */
    public void insertPersonne(){
        System.out.println("*******[AJOUT D'UN FOURNISSEUR OU D'UN CLIENT]*******");
        char response = ' ', choix = ' ';
        do {
            do {
                System.out.println("Voulez-vous ajoiuter :");
                System.out.println("\t F: un fournisseur");
                System.out.println("\t C: un client");
                choix = sc.nextLine().charAt(0);
            } while(choix != 'F' && choix != 'C');

            if(choix == 'F') {
                System.out.println("****************[ FOURNISSEUR ]***************");
                Fournisseur fournisseur = insertFournisseur();
                allFournisseur.add(fournisseur);
            } else {
                System.out.println("****************[ CLIENT ]***************");
                Client client = insertClient();
                allClient.add(client);
            }

            do {
                System.out.println("Souhaitez-vous continuer à ajouter un fournisseur/client (O/N) ?");
                response = sc.nextLine().charAt(0);
            } while (response != 'O' && response != 'N');

        }while (response == 'O');
    }

    /**
     * les methodes insertFournisseur et insertClient nous évite d'avoir à taper dupliquer les mêmes bout
     * de codes à chaque fois qu'on souhaite inserer un fournisseur ou un client
     */
    public Fournisseur insertFournisseur() {
        Fournisseur f = new Fournisseur();
        System.out.print("Saisissez le nom du fournissuer : ");
        f.setNom(sc.nextLine());
        System.out.print("Saisissez le prenom nom du fournissuer : ");
        f.setPrenom(sc.nextLine());
        System.out.print("Saisissez la date de naissance nom du fournissuer : ");
        f.setDateNais(sc.nextLine());
        System.out.print("Saisissez le numéro de téléphone nom du fournissuer : ");
        f.setTelephone(sc.nextLine());

        return f;
    }

    public Client insertClient() {
        Client c = new Client();
        System.out.print("Saisissez le nom du client: ");
        c.setNom(sc.nextLine());
        System.out.print("Saisissez le prenom du client: ");
        c.setPrenom(sc.nextLine());
        System.out.print("Saisissez la date de naissance du client: ");
        c.setDateNais(sc.nextLine());
        System.out.print("Saisissez le numéro de téléphone du client: ");
        c.setTelephone(sc.nextLine());

        return  c;
    }

    /**
     * La methode listFournisseur liste tous les fournisseurs ajouter
     */
    public void listFournisseur(){
        System.out.println("***********[ LA LISTE DE TOUS LES FOURNISSEURS ]**************");
        System.out.println("[");
        for(Fournisseur f : allFournisseur){
            System.out.println(f.toString());
        }
        System.out.println("]");
    }

    /**
     * La methode listClient liste tous les client ajouter
     */
    public void listClient(){
        System.out.println("***********[ LA LISTE DE TOUS LES CLIENTS ]**************");
        System.out.println("[");
        for(Client c : allClient){
            System.out.println(c.toString());
        }
        System.out.println("]");
    }

    /**
     * La memthode addProduct permet d'ajouter un/des produit(s)
     * les produit sont ajouter au stock(la classe Stock implemente le pattern SINGLETON)
     * L'objectif est d'assurer qu'un seul stock sera créer et d'y ajouter les nouveaux produits
     */
    public void addProduct(){
        System.out.println("*******************[ AJOUT DE PRODUIT ]*********************");
        char response = ' ';
        do {
            Produit p = new Produit();
            System.out.print("Donnez le nom : ");
            p.setNomProduit(sc.nextLine());
            System.out.print("Donnez le prix fixe : ");
            p.setPrix(sc.nextDouble());
            sc.nextLine();
            System.out.print("Donnez la marque : ");
            p.setMarque(sc.nextLine());
            System.out.print("Donnez le modéle : ");
            p.setModele(sc.nextLine());

            stock.getAllProduct().add(p);

            do {
                System.out.println("Voulez-vous continuer à ajouter des produits (O/N) ?");
                response = sc.nextLine().charAt(0);
            } while (response != 'O' && response != 'N');

        } while (response == 'O');
    }

    public void listProduct() {
        System.out.println("[");
        for(Produit p : stock.getAllProduct()) {
            System.out.println(p.toString());
        }
        System.out.println("]");
    }

    /**
     * La methode passerCommande permet à un client de passer une commande
     */

    public void passerCommade() {
        System.out.println("******************[ COMMANDER UN/DES PRODUIT ]***********************");
        System.out.println("\t BIENVENUE CHER CLIENT! VOICI LA LISTE DE TOUT NOS PRODUIT DISPONIBLE");
        listProduct();
        char response = ' ', addProduct = ' ';
        boolean bool = true;
        do {
            do {
                System.out.println("Souhaitez-vous passer une commande (O/N) ?");
                response = sc.nextLine().charAt(0);
            } while (response  != 'O' && response != 'N');

            if (response == 'O') {
                Commande com = new Commande();
                com.setClient(insertClient());

                do {
                    System.out.print("Veuillez choisir un produit existant : ");
                    String choixProduit = sc.nextLine();
                    int i=0;
                    while (i<stock.getAllProduct().size() && !(stock.getAllProduct().get(i).getNomProduit()).equals(choixProduit)) {
                        i++;
                    }

                    if (i == stock.getAllProduct().size()) {
                        System.out.println("Désolé mais ce produit n'est pas disponible !");
                        bool = false;
                    } else {
                        com.getProduits().add(stock.getAllProduct().get(i));
                        System.out.println("Voulez-vous ajouter un autre produit (O/N) ?");
                        addProduct = sc.nextLine().charAt(0);
                        if (addProduct == 'O') bool = true;
                        else bool = false;
                    }
                } while (bool == true);
                /**
                 * Il ne reste plus qu'a afficher la commande s'il y'en un
                 */
                if(com.getProduits().size() > 0)  showCommande(com);
            }
        } while ( response == 'O');
    }

    public void showCommande(Commande c) {
        System.out.println("***************[ INFORMATION DÈTAILLER DE LA COMMANDE ]*******************");
        System.out.println(c.toString());
    }
}
