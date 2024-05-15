/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplefit;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 *
 * @author marki
 */
@Embeddable
public class RutinamaquinaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "rutinaid")
    private int rutinaid;
    @Basic(optional = false)
    @Column(name = "maquinaid")
    private int maquinaid;
    @Basic(optional = false)
    @Column(name = "dia")
    private String dia;

    public RutinamaquinaPK() {
    }

    public RutinamaquinaPK(int rutinaid, int maquinaid, String dia) {
        this.rutinaid = rutinaid;
        this.maquinaid = maquinaid;
        this.dia = dia;
    }

    public int getRutinaid() {
        return rutinaid;
    }

    public void setRutinaid(int rutinaid) {
        this.rutinaid = rutinaid;
    }

    public int getMaquinaid() {
        return maquinaid;
    }

    public void setMaquinaid(int maquinaid) {
        this.maquinaid = maquinaid;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rutinaid;
        hash += (int) maquinaid;
        hash += (dia != null ? dia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RutinamaquinaPK)) {
            return false;
        }
        RutinamaquinaPK other = (RutinamaquinaPK) object;
        if (this.rutinaid != other.rutinaid) {
            return false;
        }
        if (this.maquinaid != other.maquinaid) {
            return false;
        }
        if ((this.dia == null && other.dia != null) || (this.dia != null && !this.dia.equals(other.dia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplefit.RutinamaquinaPK[ rutinaid=" + rutinaid + ", maquinaid=" + maquinaid + ", dia=" + dia + " ]";
    }
    
}
