/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpasimplefit;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author marki
 */
@Entity
@Table(name = "consejos")
@NamedQueries({
    @NamedQuery(name = "Consejos.findAll", query = "SELECT c FROM Consejos c"),
    @NamedQuery(name = "Consejos.findByConsejoid", query = "SELECT c FROM Consejos c WHERE c.consejoid = :consejoid"),
    @NamedQuery(name = "Consejos.findByConsejo", query = "SELECT c FROM Consejos c WHERE c.consejo = :consejo")})
public class Consejos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "consejoid")
    private Integer consejoid;
    @Column(name = "consejo")
    private String consejo;

    public Consejos() {
    }

    public Consejos(Integer consejoid) {
        this.consejoid = consejoid;
    }

    public Integer getConsejoid() {
        return consejoid;
    }

    public void setConsejoid(Integer consejoid) {
        this.consejoid = consejoid;
    }

    public String getConsejo() {
        return consejo;
    }

    public void setConsejo(String consejo) {
        this.consejo = consejo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consejoid != null ? consejoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consejos)) {
            return false;
        }
        Consejos other = (Consejos) object;
        if ((this.consejoid == null && other.consejoid != null) || (this.consejoid != null && !this.consejoid.equals(other.consejoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplefitjpa.Consejos[ consejoid=" + consejoid + " ]";
    }
    
}
