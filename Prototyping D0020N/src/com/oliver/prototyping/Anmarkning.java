package com.oliver.prototyping;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Anmarkning {
    private String anmarkningsId;
    private String inspektionsId;
    private String hyresgastId;
    private String beskrivning;
    private Timestamp fixDatum;
    private Inspektion inspektionByInspektionsId;
    private Hyresgast hyresgastByHyresgastId;

    @Id
    @Column(name = "AnmarkningsId", nullable = true, length = 6)
    public String getAnmarkningsId () {
        return anmarkningsId;
    }

    public void setAnmarkningsId (String anmarkningsId) {
        this.anmarkningsId = anmarkningsId;
    }

    @Basic
    @Column(name = "InspektionsId", nullable = false, length = 6)
    public String getInspektionsId () {
        return inspektionsId;
    }

    public void setInspektionsId (String inspektionsId) {
        this.inspektionsId = inspektionsId;
    }

    @Basic
    @Column(name = "HyresgastId", nullable = false, length = 6)
    public String getHyresgastId () {
        return hyresgastId;
    }

    public void setHyresgastId (String hyresgastId) {
        this.hyresgastId = hyresgastId;
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
    @Column(name = "FixDatum", nullable = true)
    public Timestamp getFixDatum () {
        return fixDatum;
    }

    public void setFixDatum (Timestamp fixDatum) {
        this.fixDatum = fixDatum;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anmarkning that = (Anmarkning)o;
        return Objects.equals(anmarkningsId, that.anmarkningsId) && Objects.equals(inspektionsId, that.inspektionsId) && Objects.equals(hyresgastId, that.hyresgastId) && Objects.equals(beskrivning, that.beskrivning) && Objects.equals(fixDatum, that.fixDatum);
    }

    @Override
    public int hashCode () {
        return Objects.hash(anmarkningsId, inspektionsId, hyresgastId, beskrivning, fixDatum);
    }

    @ManyToOne
    @JoinColumn(name = "InspektionsId", referencedColumnName = "InspektionsId", nullable = false)
    public Inspektion getInspektionByInspektionsId () {
        return inspektionByInspektionsId;
    }

    public void setInspektionByInspektionsId (Inspektion inspektionByInspektionsId) {
        this.inspektionByInspektionsId = inspektionByInspektionsId;
    }

    @ManyToOne
    @JoinColumn(name = "HyresgastId", referencedColumnName = "HyresgastId", nullable = false)
    public Hyresgast getHyresgastByHyresgastId () {
        return hyresgastByHyresgastId;
    }

    public void setHyresgastByHyresgastId (Hyresgast hyresgastByHyresgastId) {
        this.hyresgastByHyresgastId = hyresgastByHyresgastId;
    }

    private com.oliver.prototyping.Hyresgast Hyresgast;

    @ManyToOne
    public com.oliver.prototyping.Hyresgast getHyresgast () {
        return Hyresgast;
    }

    public void setHyresgast (com.oliver.prototyping.Hyresgast hyresgast) {
        Hyresgast = hyresgast;
    }
}
