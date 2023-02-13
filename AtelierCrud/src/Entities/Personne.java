package Entities;

public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private String contact;

    public Personne(String nom, String prenom, String contact) {
        this.nom = nom;
        this.prenom = prenom;
        this.contact = contact;
    }

    public Personne(int id, String nom, String prenom, String contact) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.contact = contact;
    }
    @Override
    public String toString(){
        return "Personne: [\"ID: "+id+"\",\"Nom: "+nom+"\",\"Prenom: "+prenom+"\",\"Contact: "+contact+"\"]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
