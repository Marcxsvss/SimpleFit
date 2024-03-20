/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplefit;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author marki
 */
@Entity
@Table(name = "dietaalimento")
@NamedQueries({
    @NamedQuery(name = "Dietaalimento.findAll", query = "SELECT d FROM Dietaalimento d"),
    @NamedQuery(name = "Dietaalimento.findByDietaid", query = "SELECT d FROM Dietaalimento d WHERE d.dietaalimentoPK.dietaid = :dietaid"),
    @NamedQuery(name = "Dietaalimento.findByAlimentoid", query = "SELECT d FROM Dietaalimento d WHERE d.dietaalimentoPK.alimentoid = :alimentoid"),
    @NamedQuery(name = "Dietaalimento.findByCantidad", query = "SELECT d FROM Dietaalimento d WHERE d.cantidad = :cantidad")})
public class Dietaalimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DietaalimentoPK dietaalimentoPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "alimentoid", referencedColumnName = "alimentoid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alimentos alimentos;
    @JoinColumn(name = "dietaid", referencedColumnName = "dietaid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dietas dietas;

    public Dietaalimento() {
    }

    public Dietaalimento(DietaalimentoPK dietaalimentoPK) {
        this.dietaalimentoPK = dietaalimentoPK;
    }

    public Dietaalimento(int dietaid, int alimentoid) {
        this.dietaalimentoPK = new DietaalimentoPK(dietaid, alimentoid);
    }

    public DietaalimentoPK getDietaalimentoPK() {
        return dietaalimentoPK;
    }

    public void setDietaalimentoPK(DietaalimentoPK dietaalimentoPK) {
        this.dietaalimentoPK = dietaalimentoPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Alimentos getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(Alimentos alimentos) {
        this.alimentos = alimentos;
    }

    public Dietas getDietas() {
        return dietas;
    }

    public void setDietas(Dietas dietas) {
        this.dietas = dietas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dietaalimentoPK != null ? dietaalimentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dietaalimento)) {
            return false;
        }
        Dietaalimento other = (Dietaalimento) object;
        if ((this.dietaalimentoPK == null && other.dietaalimentoPK != null) || (this.dietaalimentoPK != null && !this.dietaalimentoPK.equals(other.dietaalimentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplefit.Dietaalimento[ dietaalimentoPK=" + dietaalimentoPK + " ]";
    }
    
}
