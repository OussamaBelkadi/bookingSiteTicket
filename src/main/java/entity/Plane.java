package entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Plane {
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
    private int place;
    @Basic
    @Column(name = "villearriver")
    private String villearriver;
    @Basic
    @Column(name = "villedepart")
    private String villedepart;

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

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
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

        Plane plane = (Plane) o;

        if (place != plane.place) return false;
        if (datedepart != null ? !datedepart.equals(plane.datedepart) : plane.datedepart != null) return false;
        if (datedarriver != null ? !datedarriver.equals(plane.datedarriver) : plane.datedarriver != null) return false;
        if (heuredepart != null ? !heuredepart.equals(plane.heuredepart) : plane.heuredepart != null) return false;
        if (heuredarriver != null ? !heuredarriver.equals(plane.heuredarriver) : plane.heuredarriver != null)
            return false;
        if (villearriver != null ? !villearriver.equals(plane.villearriver) : plane.villearriver != null) return false;
        if (villedepart != null ? !villedepart.equals(plane.villedepart) : plane.villedepart != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = datedepart != null ? datedepart.hashCode() : 0;
        result = 31 * result + (datedarriver != null ? datedarriver.hashCode() : 0);
        result = 31 * result + (heuredepart != null ? heuredepart.hashCode() : 0);
        result = 31 * result + (heuredarriver != null ? heuredarriver.hashCode() : 0);
        result = 31 * result + place;
        result = 31 * result + (villearriver != null ? villearriver.hashCode() : 0);
        result = 31 * result + (villedepart != null ? villedepart.hashCode() : 0);
        return result;
    }
}
