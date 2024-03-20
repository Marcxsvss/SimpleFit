/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplefit;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author marki
 */
@Entity
@Table(name = "alimentos")
@NamedQueries({
    @NamedQuery(name = "Alimentos.findAll", query = "SELECT a FROM Alimentos a"),
    @NamedQuery(name = "Alimentos.findByAlimentoid", query = "SELECT a FROM Alimentos a WHERE a.alimentoid = :alimentoid"),
    @NamedQuery(name = "Alimentos.findByNombre", query = "SELECT a FROM Alimentos a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Alimentos.findByCalorias", query = "SELECT a FROM Alimentos a WHERE a.calorias = :calorias"),
    @NamedQuery(name = "Alimentos.findByProteinas", query = "SELECT a FROM Alimentos a WHERE a.proteinas = :proteinas"),
    @NamedQuery(name = "Alimentos.findByGrasas", query = "SELECT a FROM Alimentos a WHERE a.grasas = :grasas"),
    @NamedQuery(name = "Alimentos.findByCarbohidratos", query = "SELECT a FROM Alimentos a WHERE a.carbohidratos = :carbohidratos"),
    @NamedQuery(name = "Alimentos.findByLactosa", query = "SELECT a FROM Alimentos a WHERE a.lactosa = :lactosa"),
    @NamedQuery(name = "Alimentos.findByGluten", query = "SELECT a FROM Alimentos a WHERE a.gluten = :gluten")})
public class Alimentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "alimentoid")
    private Integer alimentoid;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "calorias")
    private Integer calorias;
    @Column(name = "proteinas")
    private Integer proteinas;
    @Column(name = "grasas")
    private Integer grasas;
    @Column(name = "carbohidratos")
    private Integer carbohidratos;
    @Column(name = "lactosa")
    private Boolean lactosa;
    @Column(name = "gluten")
    private Boolean gluten;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alimentos")
    private Collection<Dietaalimento> dietaalimentoCollection;

    public Alimentos() {
    }

    public Alimentos(Integer alimentoid) {
        this.alimentoid = alimentoid;
    }

    public Integer getAlimentoid() {
        return alimentoid;
    }

    public void setAlimentoid(Integer alimentoid) {
        this.alimentoid = alimentoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public Integer getProteinas() {
        return proteinas;
    }

    public void setProteinas(Integer proteinas) {
        this.proteinas = proteinas;
    }

    public Integer getGrasas() {
        return grasas;
    }

    public void setGrasas(Integer grasas) {
        this.grasas = grasas;
    }

    public Integer getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(Integer carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public Boolean getLactosa() {
        return lactosa;
    }

    public void setLactosa(Boolean lactosa) {
        this.lactosa = lactosa;
    }

    public Boolean getGluten() {
        return gluten;
    }

    public void setGluten(Boolean gluten) {
        this.gluten = gluten;
    }

    public Collection<Dietaalimento> getDietaalimentoCollection() {
        return dietaalimentoCollection;
    }

    public void setDietaalimentoCollection(Collection<Dietaalimento> dietaalimentoCollection) {
        this.dietaalimentoCollection = dietaalimentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alimentoid != null ? alimentoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimentos)) {
            return false;
        }
        Alimentos other = (Alimentos) object;
        if ((this.alimentoid == null && other.alimentoid != null) || (this.alimentoid != null && !this.alimentoid.equals(other.alimentoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplefit.Alimentos[ alimentoid=" + alimentoid + " ]";
    }
    
}
