package com.oliver.prototyping;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Hyresavtal {
    private String avtalsId;
    private Date startDatum;
    private Date slutDatum;
    private Integer hyra;
    private String hyresgastId;
    private Hyresgast hyresgastByHyresgastId;

    @Id
    @Column(name = "AvtalsId", nullable = true, length = 6)
    public String getAvtalsId () {
        return avtalsId;
    }

    public void setAvtalsId (String avtalsId) {
        this.avtalsId = avtalsId;
    }

    @Basic
    @Column(name = "StartDatum", nullable = true)
    public Date getStartDatum () {
        return startDatum;
    }

    public void setStartDatum (Date startDatum) {
        this.startDatum = startDatum;
    }

    @Basic
    @Column(name = "SlutDatum", nullable = true)
    public Date getSlutDatum () {
        return slutDatum;
    }

    public void setSlutDatum (Date slutDatum) {
        this.slutDatum = slutDatum;
    }

    @Basic
    @Column(name = "Hyra", nullable = true, precision = 0)
    public Integer getHyra () {
        return hyra;
    }

    public void setHyra (Integer hyra) {
        this.hyra = hyra;
    }

    @Basic
    @Column(name = "HyresgastId", nullable = true, length = 6)
    public String getHyresgastId () {
        return hyresgastId;
    }

    public void setHyresgastId (String hyresgastId) {
        this.hyresgastId = hyresgastId;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hyresavtal that = (Hyresavtal)o;
        return Objects.equals(avtalsId, that.avtalsId) && Objects.equals(startDatum, that.startDatum) && Objects.equals(slutDatum, that.slutDatum) && Objects.equals(hyra, that.hyra) && Objects.equals(hyresgastId, that.hyresgastId);
    }

    @Override
    public int hashCode () {
        return Objects.hash(avtalsId, startDatum, slutDatum, hyra, hyresgastId);
    }

    @ManyToOne
    @JoinColumn(name = "HyresgastId", referencedColumnName = "HyresgastId")
    public Hyresgast getHyresgastByHyresgastId () {
        return hyresgastByHyresgastId;
    }

    public void setHyresgastByHyresgastId (Hyresgast hyresgastByHyresgastId) {
        this.hyresgastByHyresgastId = hyresgastByHyresgastId;
    }
}
