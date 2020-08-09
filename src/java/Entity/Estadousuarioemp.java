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
import javax.persistence.Table;

/**
 *
 * @author Julian Camilo
 */
@Entity
@Table(name = "estadousuarioemp")
public class Estadousuarioemp implements Serializable{
    
    @Id
    @Column(name = "idestadou")
    private int idestadou;
    @Column(name = " estadousuario")
    private String estadousuario;

    public int getIdestadou() {
        return idestadou;
    }

    public void setIdestadou(int idestadou) {
        this.idestadou = idestadou;
    }

    public String getEstadousuario() {
        return estadousuario;
    }

    public void setEstadousuario(String estadousuario) {
        this.estadousuario = estadousuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idestadou;
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
        final Estadousuarioemp other = (Estadousuarioemp) obj;
        if (this.idestadou != other.idestadou) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estadousuarioemp{" + "idestadou=" + idestadou + '}';
    }
}
