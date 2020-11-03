package com.oliver.prototyping;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Hyresratt {
    private String lagenhetsId;
    private String gatuNamn;
    private String gatuNummer;
    private Integer postNummer;
    private String beskrivning;
    private Integer antalRum;
    private Collection<Hyresgast> hyresgastsByLagenhetsId;
    private Collection<Inspektion> inspektionsByLagenhetsId;

    @Id
    @Column(name = "LagenhetsId", nullable = true, length = 6)
    public String getLagenhetsId () {
        return lagenhetsId;
    }

    public void setLagenhetsId (String lagenhetsId) {
        this.lagenhetsId = lagenhetsId;
    }

    @Basic
    @Column(name = "GatuNamn", nullable = true, length = 50)
    public String getGatuNamn () {
        return gatuNamn;
    }

    public void setGatuNamn (String gatuNamn) {
        this.gatuNamn = gatuNamn;
    }

    @Basic
    @Column(name = "GatuNummer", nullable = true, length = 10)
    public String getGatuNummer () {
        return gatuNummer;
    }

    public void setGatuNummer (String gatuNummer) {
        this.gatuNummer = gatuNummer;
    }

    @Basic
    @Column(name = "PostNummer", nullable = true)
    public Integer getPostNummer () {
        return postNummer;
    }

    public void setPostNummer (Integer postNummer) {
        this.postNummer = postNummer;
    }

    @Basic
    @Column(name = "Beskrivning", nullable = true, length = 1024)
    public String getBeskrivning () {
        return beskrivning;
    }

    public void setBeskrivning (String beskrivning) {
        this.beskrivning = beskrivning;
    }

    @Basic
    @Column(name = "AntalRum", nullable = true)
    public Integer getAntalRum () {
        return antalRum;
    }

    public void setAntalRum (Integer antalRum) {
        this.antalRum = antalRum;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hyresratt hyresratt = (Hyresratt)o;
        return Objects.equals(lagenhetsId, hyresratt.lagenhetsId) && Objects.equals(gatuNamn, hyresratt.gatuNamn) && Objects.equals(gatuNummer, hyresratt.gatuNummer) && Objects.equals(postNummer, hyresratt.postNummer) && Objects.equals(beskrivning, hyresratt.beskrivning) && Objects.equals(antalRum, hyresratt.antalRum);
    }

    @Override
    public int hashCode () {
        return Objects.hash(lagenhetsId, gatuNamn, gatuNummer, postNummer, beskrivning, antalRum);
    }

    @OneToMany(mappedBy = "hyresrattByHyresrattId")
    public Collection<Hyresgast> getHyresgastsByLagenhetsId () {
        return hyresgastsByLagenhetsId;
    }

    public void setHyresgastsByLagenhetsId (Collection<Hyresgast> hyresgastsByLagenhetsId) {
        this.hyresgastsByLagenhetsId = hyresgastsByLagenhetsId;
    }

    @OneToMany(mappedBy = "hyresrattByHyresrattId")
    public Collection<Inspektion> getInspektionsByLagenhetsId () {
        return inspektionsByLagenhetsId;
    }

    public void setInspektionsByLagenhetsId (Collection<Inspektion> inspektionsByLagenhetsId) {
        this.inspektionsByLagenhetsId = inspektionsByLagenhetsId;
    }
}
