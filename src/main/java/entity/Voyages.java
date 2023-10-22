package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Voyages {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;


    @Basic
    @Column(name = "datedepart")
    private Date datedepart;
    @Basic
    @Column(name = "datedarriver")
    private Date datedarriver;
    @Basic
    @Column(name = "heuredepart")
    private Time heuredepart;
    @Basic
    @Column(name = "heuredarriver")
    private Time heuredarriver;
    @Basic
    @Column(name = "place")
    private Integer place;
    @Basic
    @Column(name = "villearriver")
    private String villearriver;
    @Basic
    @Column(name = "villedepart")
    private String villedepart;

    @Basic
    @Column(name = "prix")
    private float prix;

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Admins admins;

    public Voyages() {

    }

    public Admins getAdmins() {
        return admins;
    }

    public void setAdmins(Admins admins) {
        this.admins = admins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(Date datedepart) {
        this.datedepart = datedepart;
    }

    public Date getDatedarriver() {
        return datedarriver;
    }

    public void setDatedarriver(Date datedarriver) {
        this.datedarriver = datedarriver;
    }

    public Time getHeuredepart() {
        return heuredepart;
    }

    public void setHeuredepart(Time heuredepart) {
        this.heuredepart = heuredepart;
    }

    public Time getHeuredarriver() {
        return heuredarriver;
    }

    public void setHeuredarriver(Time heuredarriver) {
        this.heuredarriver = heuredarriver;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getVillearriver() {
        return villearriver;
    }

    public void setVillearriver(String villearriver) {
        this.villearriver = villearriver;
    }

    public String getVilledepart() {
        return villedepart;
    }

    public void setVilledepart(String villedepart) {
        this.villedepart = villedepart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voyages voyages = (Voyages) o;

        if (id != voyages.id) return false;
        if (datedepart != null ? !datedepart.equals(voyages.datedepart) : voyages.datedepart != null) return false;
        if (datedarriver != null ? !datedarriver.equals(voyages.datedarriver) : voyages.datedarriver != null)
            return false;
        if (heuredepart != null ? !heuredepart.equals(voyages.heuredepart) : voyages.heuredepart != null) return false;
        if (heuredarriver != null ? !heuredarriver.equals(voyages.heuredarriver) : voyages.heuredarriver != null)
            return false;
        if (place != null ? !place.equals(voyages.place) : voyages.place != null) return false;
        if (villearriver != null ? !villearriver.equals(voyages.villearriver) : voyages.villearriver != null)
            return false;
        if (villedepart != null ? !villedepart.equals(voyages.villedepart) : voyages.villedepart != null) return false;
//        if (idAdmin != null ? !idAdmin.equals(voyages.idAdmin) : voyages.idAdmin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datedepart != null ? datedepart.hashCode() : 0);
        result = 31 * result + (datedarriver != null ? datedarriver.hashCode() : 0);
        result = 31 * result + (heuredepart != null ? heuredepart.hashCode() : 0);
        result = 31 * result + (heuredarriver != null ? heuredarriver.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (villearriver != null ? villearriver.hashCode() : 0);
        result = 31 * result + (villedepart != null ? villedepart.hashCode() : 0);
//        result = 31 * result + (idAdmin != null ? idAdmin.hashCode() : 0);
        return result;
    }
}
