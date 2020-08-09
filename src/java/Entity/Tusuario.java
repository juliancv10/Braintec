/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Julian Camilo
 */
@Entity
@Table(name = "tusuario")
public class Tusuario implements Serializable{
    
    @Id
    @Column(name = "numdocumento")
    private int numdocumento;
    @Column(name ="nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "telefono")
    private long telefono;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "correo")
    private String correo;
    @ManyToOne 
    @JoinColumn(name = "iddocumento")
    private Tdocumento tdocumento;

    public int getNumdocumento() {
        return numdocumento;
    }

    public void setNumdocumento(int numdocumento) {
        this.numdocumento = numdocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Tdocumento getTdocumento() {
        return tdocumento;
    }

    public void setTdocumento(Tdocumento tdocumento) {
        this.tdocumento = tdocumento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.numdocumento;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tusuario other = (Tusuario) obj;
        if (this.numdocumento != other.numdocumento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tusuario{" + "numdocumento=" + numdocumento + '}';
    }

    
}
