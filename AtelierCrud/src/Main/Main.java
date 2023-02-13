package Main;

import Entities.Personne;
import Services.Personne_Service;

public class Main {
    public static void main(String [] args){

        Personne_Service service = new Personne_Service();
        service.clear();
        Personne zaher = new Personne("Zaher","A mri","27871448");
        service.ajouter(zaher);
        zaher.setId(1);
        System.out.println(service.afficher());
        zaher.setPrenom("Amri");
        service.modifier(zaher);
        System.out.println(service.afficher());
        service.ajouter(new Personne("Foulen","Ben Foulen","--"));
//        service.supprimer(new Personne(1,null,null,null)); // uncomment this to delete a person check of the right id.
        System.out.println(service.afficher());
    }
}
