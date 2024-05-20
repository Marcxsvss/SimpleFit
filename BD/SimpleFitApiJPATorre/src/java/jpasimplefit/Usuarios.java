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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password"),
    @NamedQuery(name = "Usuarios.findByDni", query = "SELECT u FROM Usuarios u WHERE u.dni = :dni"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByAltura", query = "SELECT u FROM Usuarios u WHERE u.altura = :altura"),
    @NamedQuery(name = "Usuarios.findByPeso", query = "SELECT u FROM Usuarios u WHERE u.peso = :peso"),
    @NamedQuery(name = "Usuarios.findByEdad", query = "SELECT u FROM Usuarios u WHERE u.edad = :edad"),
    @NamedQuery(name = "Usuarios.findBySexo", query = "SELECT u FROM Usuarios u WHERE u.sexo = :sexo"),
    @NamedQuery(name = "Usuarios.findBySomatotipo", query = "SELECT u FROM Usuarios u WHERE u.somatotipo = :somatotipo"),
    @NamedQuery(name = "Usuarios.findByRutinastate", query = "SELECT u FROM Usuarios u WHERE u.rutinastate = :rutinastate"),
    @NamedQuery(name = "Usuarios.findByAcceso", query = "SELECT u FROM Usuarios u WHERE u.acceso = :acceso")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "dni")
    private String dni;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "altura")
    private String altura;
    @Column(name = "peso")
    private String peso;
    @Column(name = "edad")
    private String edad;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "somatotipo")
    private String somatotipo;
    @Column(name = "rutinastate")
    private Integer rutinastate;
    @Column(name = "acceso")
    private Integer acceso;
    @JoinTable(name = "usuariorutina", joinColumns = {
        @JoinColumn(name = "userid", referencedColumnName = "email")}, inverseJoinColumns = {
        @JoinColumn(name = "rutinaid", referencedColumnName = "rutinaid")})
    @ManyToMany
    @JsonbTransient
    private Collection<Rutinas> rutinasCollection;

    public Usuarios() {
    }

    public Usuarios(String email) {
        this.email = email;
    }

    public Usuarios(String email, String dni) {
        this.email = email;
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSomatotipo() {
        return somatotipo;
    }

    public void setSomatotipo(String somatotipo) {
        this.somatotipo = somatotipo;
    }

    public Integer getRutinastate() {
        return rutinastate;
    }

    public void setRutinastate(Integer rutinastate) {
        this.rutinastate = rutinastate;
    }

    public Integer getAcceso() {
        return acceso;
    }

    public void setAcceso(Integer acceso) {
        this.acceso = acceso;
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
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpasimplefit.Usuarios[ email=" + email + " ]";
    }
    
}
