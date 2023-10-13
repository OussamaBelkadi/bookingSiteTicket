package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Escapls {
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
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "vol_id")
    private Integer volId;
    @ManyToOne
    @JoinColumn(name = "vol_id", referencedColumnName = "code")
    private Vols volsByVolId;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getVolId() {
        return volId;
    }

    public void setVolId(Integer volId) {
        this.volId = volId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Escapls escapls = (Escapls) o;

        if (place != escapls.place) return false;
        if (id != escapls.id) return false;
        if (datedepart != null ? !datedepart.equals(escapls.datedepart) : escapls.datedepart != null) return false;
        if (datedarriver != null ? !datedarriver.equals(escapls.datedarriver) : escapls.datedarriver != null)
            return false;
        if (heuredepart != null ? !heuredepart.equals(escapls.heuredepart) : escapls.heuredepart != null) return false;
        if (heuredarriver != null ? !heuredarriver.equals(escapls.heuredarriver) : escapls.heuredarriver != null)
            return false;
        if (villearriver != null ? !villearriver.equals(escapls.villearriver) : escapls.villearriver != null)
            return false;
        if (villedepart != null ? !villedepart.equals(escapls.villedepart) : escapls.villedepart != null) return false;
        if (volId != null ? !volId.equals(escapls.volId) : escapls.volId != null) return false;

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
        result = 31 * result + id;
        result = 31 * result + (volId != null ? volId.hashCode() : 0);
        return result;
    }

    public Vols getVolsByVolId() {
        return volsByVolId;
    }

    public void setVolsByVolId(Vols volsByVolId) {
        this.volsByVolId = volsByVolId;
    }
}
