/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpasimplefit;

import jakarta.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "maquinas")
@NamedQueries({
    @NamedQuery(name = "Maquinas.findAll", query = "SELECT m FROM Maquinas m"),
    @NamedQuery(name = "Maquinas.findByMaquinaid", query = "SELECT m FROM Maquinas m WHERE m.maquinaid = :maquinaid"),
    @NamedQuery(name = "Maquinas.findByNombre", query = "SELECT m FROM Maquinas m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Maquinas.findByMusculo", query = "SELECT m FROM Maquinas m WHERE m.musculo = :musculo")})
public class Maquinas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "maquinaid")
    private Integer maquinaid;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "musculo")
    private String musculo;
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @ManyToMany(mappedBy = "maquinasCollection")
    @JsonbTransient
    private Collection<Rutinas> rutinasCollection;

    public Maquinas() {
    }

    public Maquinas(Integer maquinaid) {
        this.maquinaid = maquinaid;
    }

    public Integer getMaquinaid() {
        return maquinaid;
    }

    public void setMaquinaid(Integer maquinaid) {
        this.maquinaid = maquinaid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMusculo() {
        return musculo;
    }

    public void setMusculo(String musculo) {
        this.musculo = musculo;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Collection<Rutinas> getRutinasCollection() {
        return rutinasCollection;
    }

    public void setRutinasCollection(Collection<Rutinas> rutinasCollection) {
        this.rutinasCollection = rutinasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maquinaid != null ? maquinaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maquinas)) {
            return false;
        }
        Maquinas other = (Maquinas) object;
        if ((this.maquinaid == null && other.maquinaid != null) || (this.maquinaid != null && !this.maquinaid.equals(other.maquinaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpasimplefit.Maquinas[ maquinaid=" + maquinaid + " ]";
    }
    
}
