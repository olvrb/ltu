package com.oliver.prototyping;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Hyresgast {
    private String hyresgastId;
    private String personnummer;
    private String eNamn;
    private String fNamn;
    private String hyresrattId;
    private Collection<Anmarkning> anmarkningsByHyresgastId;
    private Collection<Hyresavtal> hyresavtalsByHyresgastId;
    private Hyresratt hyresrattByHyresrattId;

    @Id
    @Column(name = "HyresgastId", nullable = true, length = 6)
    public String getHyresgastId () {
        return hyresgastId;
    }

    public void setHyresgastId (String hyresgastId) {
        this.hyresgastId = hyresgastId;
    }

    @Basic
    @Column(name = "Personnummer", nullable = true, length = 12)
    public String getPersonnummer () {
        return personnummer;
    }

    public void setPersonnummer (String personnummer) {
        this.personnummer = personnummer;
    }

    @Basic
    @Column(name = "ENamn", nullable = true, length = 50)
    public String geteNamn () {
        return eNamn;
    }

    public void seteNamn (String eNamn) {
        this.eNamn = eNamn;
    }

    @Basic
    @Column(name = "FNamn", nullable = true, length = 50)
    public String getfNamn () {
        return fNamn;
    }

    public void setfNamn (String fNamn) {
        this.fNamn = fNamn;
    }

    @Basic
    @Column(name = "HyresrattId", nullable = true, length = 6)
    public String getHyresrattId () {
        return hyresrattId;
    }

    public void setHyresrattId (String hyresrattId) {
        this.hyresrattId = hyresrattId;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hyresgast hyresgast = (Hyresgast)o;
        return Objects.equals(hyresgastId, hyresgast.hyresgastId) && Objects.equals(personnummer, hyresgast.personnummer) && Objects.equals(eNamn, hyresgast.eNamn) && Objects.equals(fNamn, hyresgast.fNamn) && Objects.equals(hyresrattId, hyresgast.hyresrattId);
    }

    @Override
    public int hashCode () {
        return Objects.hash(hyresgastId, personnummer, eNamn, fNamn, hyresrattId);
    }

    @OneToMany(mappedBy = "hyresgastByHyresgastId")
    public Collection<Anmarkning> getAnmarkningsByHyresgastId () {
        return anmarkningsByHyresgastId;
    }

    public void setAnmarkningsByHyresgastId (Collection<Anmarkning> anmarkningsByHyresgastId) {
        this.anmarkningsByHyresgastId = anmarkningsByHyresgastId;
    }

    @OneToMany(mappedBy = "hyresgastByHyresgastId")
    public Collection<Hyresavtal> getHyresavtalsByHyresgastId () {
        return hyresavtalsByHyresgastId;
    }

    public void setHyresavtalsByHyresgastId (Collection<Hyresavtal> hyresavtalsByHyresgastId) {
        this.hyresavtalsByHyresgastId = hyresavtalsByHyresgastId;
    }

    @ManyToOne
    @JoinColumn(name = "HyresrattId", referencedColumnName = "LagenhetsId")
    public Hyresratt getHyresrattByHyresrattId () {
        return hyresrattByHyresrattId;
    }

    public void setHyresrattByHyresrattId (Hyresratt hyresrattByHyresrattId) {
        this.hyresrattByHyresrattId = hyresrattByHyresrattId;
    }
}
