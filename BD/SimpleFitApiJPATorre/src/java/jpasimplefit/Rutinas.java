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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "rutinas")
@NamedQueries({
    @NamedQuery(name = "Rutinas.findAll", query = "SELECT r FROM Rutinas r"),
    @NamedQuery(name = "Rutinas.findByRutinaid", query = "SELECT r FROM Rutinas r WHERE r.rutinaid = :rutinaid"),
    @NamedQuery(name = "Rutinas.findByTitulo", query = "SELECT r FROM Rutinas r WHERE r.titulo = :titulo"),
    @NamedQuery(name = "Rutinas.findByDescripcion", query = "SELECT r FROM Rutinas r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Rutinas.findByFrecuencia", query = "SELECT r FROM Rutinas r WHERE r.frecuencia = :frecuencia"),
    @NamedQuery(name = "Rutinas.findByDiasdescanso", query = "SELECT r FROM Rutinas r WHERE r.diasdescanso = :diasdescanso"),
    @NamedQuery(name = "Rutinas.findByDificultad", query = "SELECT r FROM Rutinas r WHERE r.dificultad = :dificultad")})
public class Rutinas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "rutinaid")
    private Integer rutinaid;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "frecuencia")
    private Integer frecuencia;
    @Column(name = "diasdescanso")
    private Integer diasdescanso;
    @Column(name = "dificultad")
    private String dificultad;
    @ManyToMany(mappedBy = "rutinasCollection")
    @JsonbTransient
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutinas")
    @JsonbTransient
    private Collection<Rutinamaquina> rutinamaquinaCollection;

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Integer frecuencia) {
        this.frecuencia = frecuencia;
    }

    public Integer getDiasdescanso() {
        return diasdescanso;
    }

    public void setDiasdescanso(Integer diasdescanso) {
        this.diasdescanso = diasdescanso;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    public Collection<Rutinamaquina> getRutinamaquinaCollection() {
        return rutinamaquinaCollection;
    }

    public void setRutinamaquinaCollection(Collection<Rutinamaquina> rutinamaquinaCollection) {
        this.rutinamaquinaCollection = rutinamaquinaCollection;
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
