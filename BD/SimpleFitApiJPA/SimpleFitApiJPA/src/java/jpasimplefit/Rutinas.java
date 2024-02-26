package jpasimplefit;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "rutinas")
@NamedQueries({
    @NamedQuery(name = "Rutinas.findAll", query = "SELECT r FROM Rutinas r"),
    @NamedQuery(name = "Rutinas.findByRutinaid", query = "SELECT r FROM Rutinas r WHERE r.rutinaid = :rutinaid"),
    @NamedQuery(name = "Rutinas.findByNombre", query = "SELECT r FROM Rutinas r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Rutinas.findByFrecuencia", query = "SELECT r FROM Rutinas r WHERE r.frecuencia = :frecuencia")})
public class Rutinas implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rutinaid")
    private Integer rutinaid;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "frecuencia")
    private Integer frecuencia;
    @JoinTable(name = "rutinamaquina", joinColumns = {
        @JoinColumn(name = "rutinaid", referencedColumnName = "rutinaid")}, inverseJoinColumns = {
        @JoinColumn(name = "maquinaid", referencedColumnName = "maquinaid")})
    @ManyToMany
    private Collection<Maquinas> maquinasCollection;
    @JoinColumn(name = "userid", referencedColumnName = "dni")
    @ManyToOne
    private Users userid;

    public Rutinas() {
    }

    public Rutinas(Integer rutinaid) {
        this.rutinaid = rutinaid;
    }

    public Integer getRutinaid() {
        return rutinaid;
    }

    public void setRutinaid(Integer rutinaid) {
        this.rutinaid = rutinaid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Collection<Maquinas> getMaquinasCollection() {
        return maquinasCollection;
    }

    public void setMaquinasCollection(Collection<Maquinas> maquinasCollection) {
        this.maquinasCollection = maquinasCollection;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutinaid != null ? rutinaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutinas)) {
            return false;
        }
        Rutinas other = (Rutinas) object;
        if ((this.rutinaid == null && other.rutinaid != null) || (this.rutinaid != null && !this.rutinaid.equals(other.rutinaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpasimplefit.Rutinas[ rutinaid=" + rutinaid + " ]";
    }
    
}
