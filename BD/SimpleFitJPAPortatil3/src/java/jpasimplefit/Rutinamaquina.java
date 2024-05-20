/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpasimplefit;

import jakarta.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
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
@Table(name = "rutinamaquina")
@NamedQueries({
    @NamedQuery(name = "Rutinamaquina.findAll", query = "SELECT r FROM Rutinamaquina r"),
    @NamedQuery(name = "Rutinamaquina.findByRutinaidAndDia", query = "SELECT rm.rutinamaquinaPK.maquinaid FROM Rutinamaquina rm WHERE rm.rutinamaquinaPK.rutinaid = :rutinaid AND rm.rutinamaquinaPK.dia = :dia"),
    @NamedQuery(name = "Rutinamaquina.findToDelete", query = "SELECT rm.rutinamaquinaPK FROM Rutinamaquina rm WHERE rm.rutinamaquinaPK.rutinaid = :rutinaid"), //Igual hay que borrar esto
    @NamedQuery(name = "Rutinamaquina.findByRutinaid", query = "SELECT r FROM Rutinamaquina r WHERE r.rutinamaquinaPK.rutinaid = :rutinaid"),
    @NamedQuery(name = "Rutinamaquina.findByMaquinaid", query = "SELECT r FROM Rutinamaquina r WHERE r.rutinamaquinaPK.maquinaid = :maquinaid"),
    @NamedQuery(name = "Rutinamaquina.findByDia", query = "SELECT r FROM Rutinamaquina r WHERE r.rutinamaquinaPK.dia = :dia")})
public class Rutinamaquina implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RutinamaquinaPK rutinamaquinaPK;
    @JoinColumn(name = "maquinaid", referencedColumnName = "maquinaid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonbTransient
    private Maquinas maquinas;
    @JoinColumn(name = "rutinaid", referencedColumnName = "rutinaid", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    @JsonbTransient
    private Rutinas rutinas;

    public Rutinamaquina() {
    }

    public Rutinamaquina(RutinamaquinaPK rutinamaquinaPK) {
        this.rutinamaquinaPK = rutinamaquinaPK;
    }

    public Rutinamaquina(int rutinaid, int maquinaid, String dia) {
        this.rutinamaquinaPK = new RutinamaquinaPK(rutinaid, maquinaid, dia);
    }

    public RutinamaquinaPK getRutinamaquinaPK() {
        return rutinamaquinaPK;
    }

    public void setRutinamaquinaPK(RutinamaquinaPK rutinamaquinaPK) {
        this.rutinamaquinaPK = rutinamaquinaPK;
    }

    public Maquinas getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(Maquinas maquinas) {
        this.maquinas = maquinas;
    }

    public Rutinas getRutinas() {
        return rutinas;
    }

    public void setRutinas(Rutinas rutinas) {
        this.rutinas = rutinas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutinamaquinaPK != null ? rutinamaquinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutinamaquina)) {
            return false;
        }
        Rutinamaquina other = (Rutinamaquina) object;
        if ((this.rutinamaquinaPK == null && other.rutinamaquinaPK != null) || (this.rutinamaquinaPK != null && !this.rutinamaquinaPK.equals(other.rutinamaquinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplefitjpa.Rutinamaquina[ rutinamaquinaPK=" + rutinamaquinaPK + " ]";
    }
    
}
