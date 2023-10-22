package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Admins {
    @Basic
    @Column(name = "nom")
    private String nom;
    @Basic
    @Column(name = "prenom")
    private String prenom;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;
//    @OneToMany(mappedBy = "id_admin")
//    private List<Voyages> voyages;
//    @OneToMany(mappedBy = "admins")
//    private List<Voyages> voyages;
//    public List<Voyages> getVoyages() {
//        return voyages;
//    }
//
//    public void setVoyages(List<Voyages> voyages) {
//        this.voyages = voyages;
//    }



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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admins admins = (Admins) o;

        if (id != admins.id) return false;
        if (nom != null ? !nom.equals(admins.nom) : admins.nom != null) return false;
        if (prenom != null ? !prenom.equals(admins.prenom) : admins.prenom != null) return false;
        if (email != null ? !email.equals(admins.email) : admins.email != null) return false;
        if (password != null ? !password.equals(admins.password) : admins.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
    public Admins(){}
}
