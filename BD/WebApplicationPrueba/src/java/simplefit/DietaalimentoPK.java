/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplefit;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author marki
 */
@Embeddable
public class DietaalimentoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "dietaid")
    private int dietaid;
    @Basic(optional = false)
    @Column(name = "alimentoid")
    private int alimentoid;

    public DietaalimentoPK() {
    }

    public DietaalimentoPK(int dietaid, int alimentoid) {
        this.dietaid = dietaid;
        this.alimentoid = alimentoid;
    }

    public int getDietaid() {
        return dietaid;
    }

    public void setDietaid(int dietaid) {
        this.dietaid = dietaid;
    }

    public int getAlimentoid() {
        return alimentoid;
    }

    public void setAlimentoid(int alimentoid) {
        this.alimentoid = alimentoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) dietaid;
        hash += (int) alimentoid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DietaalimentoPK)) {
            return false;
        }
        DietaalimentoPK other = (DietaalimentoPK) object;
        if (this.dietaid != other.dietaid) {
            return false;
        }
        if (this.alimentoid != other.alimentoid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplefit.DietaalimentoPK[ dietaid=" + dietaid + ", alimentoid=" + alimentoid + " ]";
    }
    
}
