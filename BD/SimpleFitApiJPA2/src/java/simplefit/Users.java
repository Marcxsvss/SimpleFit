/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simplefit;

import jakarta.json.bind.annotation.JsonbTransient;
import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
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
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByDni", query = "SELECT u FROM Users u WHERE u.dni = :dni"),
    @NamedQuery(name = "Users.findByNombre", query = "SELECT u FROM Users u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findBySexo", query = "SELECT u FROM Users u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "Users.findByEdad", query = "SELECT u FROM Users u WHERE u.edad = :edad"),
    @NamedQuery(name = "Users.findByAltura", query = "SELECT u FROM Users u WHERE u.altura = :altura"),
    @NamedQuery(name = "Users.findByAlergias", query = "SELECT u FROM Users u WHERE u.alergias = :alergias")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "dni")
    private Integer dni;
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "altura")
    private Integer altura;
    @Column(name = "alergias")
    private String alergias;
    @OneToMany(mappedBy = "userid")
    @JsonbTransient
    private Collection<Rutinas> rutinasCollection;
    @OneToMany(mappedBy = "userid")
    @JsonbTransient
    private Collection<Dietas> dietasCollection;

    public Users() {
    }

    public Users(Integer dni) {
        this.dni = dni;
    }

    public Users(Integer dni, String email) {
        this.dni = dni;
        this.email = email;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public Collection<Rutinas> getRutinasCollection() {
        return rutinasCollection;
    }

    public void setRutinasCollection(Collection<Rutinas> rutinasCollection) {
        this.rutinasCollection = rutinasCollection;
    }

    public Collection<Dietas> getDietasCollection() {
        return dietasCollection;
    }

    public void setDietasCollection(Collection<Dietas> dietasCollection) {
        this.dietasCollection = dietasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "simplefit.Users[ dni=" + dni + " ]";
    }
    
}
