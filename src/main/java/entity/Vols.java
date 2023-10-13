package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

@Entity
public class Vols {
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "code")
    private int code;
    @OneToMany(mappedBy = "volsByVolId")
    private Collection<Escapls> escaplsByCode;

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vols vols = (Vols) o;

        if (place != vols.place) return false;
        if (code != vols.code) return false;
        if (datedepart != null ? !datedepart.equals(vols.datedepart) : vols.datedepart != null) return false;
        if (datedarriver != null ? !datedarriver.equals(vols.datedarriver) : vols.datedarriver != null) return false;
        if (heuredepart != null ? !heuredepart.equals(vols.heuredepart) : vols.heuredepart != null) return false;
        if (heuredarriver != null ? !heuredarriver.equals(vols.heuredarriver) : vols.heuredarriver != null)
            return false;
        if (villearriver != null ? !villearriver.equals(vols.villearriver) : vols.villearriver != null) return false;
        if (villedepart != null ? !villedepart.equals(vols.villedepart) : vols.villedepart != null) return false;

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
        result = 31 * result + code;
        return result;
    }

    public Collection<Escapls> getEscaplsByCode() {
        return escaplsByCode;
    }

    public void setEscaplsByCode(Collection<Escapls> escaplsByCode) {
        this.escaplsByCode = escaplsByCode;
    }
}
