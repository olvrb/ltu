package com.oliver.prototyping;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Inspektion {
    private String inspektionsId;
    private String hyresrattId;
    private Date datum;
    private Collection<Anmarkning> anmarkningsByInspektionsId;
    private Hyresratt hyresrattByHyresrattId;

    @Id
    @Column(name = "InspektionsId", nullable = true, length = 6)
    public String getInspektionsId () {
        return inspektionsId;
    }

    public void setInspektionsId (String inspektionsId) {
        this.inspektionsId = inspektionsId;
    }

    @Basic
    @Column(name = "HyresrattId", nullable = false, length = 6)
    public String getHyresrattId () {
        return hyresrattId;
    }

    public void setHyresrattId (String hyresrattId) {
        this.hyresrattId = hyresrattId;
    }

    @Basic
    @Column(name = "Datum", nullable = true)
    public Date getDatum () {
        return datum;
    }

    public void setDatum (Date datum) {
        this.datum = datum;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inspektion that = (Inspektion)o;
        return Objects.equals(inspektionsId, that.inspektionsId) && Objects.equals(hyresrattId, that.hyresrattId) && Objects.equals(datum, that.datum);
    }

    @Override
    public int hashCode () {
        return Objects.hash(inspektionsId, hyresrattId, datum);
    }

    @OneToMany(mappedBy = "inspektionByInspektionsId")
    public Collection<Anmarkning> getAnmarkningsByInspektionsId () {
        return anmarkningsByInspektionsId;
    }

    public void setAnmarkningsByInspektionsId (Collection<Anmarkning> anmarkningsByInspektionsId) {
        this.anmarkningsByInspektionsId = anmarkningsByInspektionsId;
    }

    @ManyToOne
    @JoinColumn(name = "HyresrattId", referencedColumnName = "LagenhetsId", nullable = false)
    public Hyresratt getHyresrattByHyresrattId () {
        return hyresrattByHyresrattId;
    }

    public void setHyresrattByHyresrattId (Hyresratt hyresrattByHyresrattId) {
        this.hyresrattByHyresrattId = hyresrattByHyresrattId;
    }
}
