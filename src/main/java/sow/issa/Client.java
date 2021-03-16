package sow.issa;

import java.util.Date;

public class Client extends Personne{
    private static long idClient = 0;

    public Client(){
        super();
        Client.idClient++;
    }

    public Client(String nom, String prenom, String dateNais, String telephone) {
        super(nom, prenom, dateNais, telephone);
        Client.idClient++;
    }

    public static long getIdClient() {
        return Client.idClient;
    }

    public static void setIdClient(long idClient) {
        Client.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "\tClient " +
                "{\n" +
                    //"\t\tidClient='" + Client.idClient + "'\n"   +
                    super.toString() +
                "\n\t}";

    }
}
