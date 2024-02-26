/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpasimplefit;

import jakarta.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author alumno
 */
@Entity
@Table(name = "dietas")
@NamedQueries({
    @NamedQuery(name = "Dietas.findAll", query = "SELECT d FROM Dietas d"),
    @NamedQuery(name = "Dietas.findByDietaid", query = "SELECT d FROM Dietas d WHERE d.dietaid = :dietaid"),
    @NamedQuery(name = "Dietas.findByNombre", query = "SELECT d FROM Dietas d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Dietas.findByObjetivo", query = "SELECT d FROM Dietas d WHERE d.objetivo = :objetivo"),
    @NamedQuery(name = "Dietas.findByCalorias", query = "SELECT d FROM Dietas d WHERE d.calorias = :calorias"),
    @NamedQuery(name = "Dietas.findByDuracion", query = "SELECT d FROM Dietas d WHERE d.duracion = :duracion")})
public class Dietas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dietaid")
    private Integer dietaid;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "objetivo")
    private String objetivo;
    @Column(name = "calorias")
    private Integer calorias;
    @Column(name = "duracion")
    private Integer duracion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dietas")
    @JsonbTransient
    private Collection<Dietaalimento> dietaalimentoCollection;
    @JoinColumn(name = "userid", referencedColumnName = "dni")
    @ManyToOne
    private Users userid;

    public Dietas() {
    }

    public Dietas(Integer dietaid) {
        this.dietaid = dietaid;
    }

    public Integer getDietaid() {
        return dietaid;
    }

    public void setDietaid(Integer dietaid) {
        this.dietaid = dietaid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Collection<Dietaalimento> getDietaalimentoCollection() {
        return dietaalimentoCollection;
    }

    public void setDietaalimentoCollection(Collection<Dietaalimento> dietaalimentoCollection) {
        this.dietaalimentoCollection = dietaalimentoCollection;
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
        hash += (dietaid != null ? dietaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dietas)) {
            return false;
        }
        Dietas other = (Dietas) object;
        if ((this.dietaid == null && other.dietaid != null) || (this.dietaid != null && !this.dietaid.equals(other.dietaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpasimplefit.Dietas[ dietaid=" + dietaid + " ]";
    }
    
}
