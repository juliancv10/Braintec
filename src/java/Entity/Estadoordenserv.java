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
@Table(name = "estadoordenserv")
public class Estadoordenserv implements Serializable{
    
    @Id
    @Column(name = "idestordenserv")
    private int idestordenserv;
    @Column(name = "estadoordenserv")
    private String estadoordenserv;

    public int getIdestordenserv() {
        return idestordenserv;
    }

    public void setIdestordenserv(int idestordenserv) {
        this.idestordenserv = idestordenserv;
    }

    public String getEstadoordenserv() {
        return estadoordenserv;
    }

    public void setEstadoordenserv(String estadoordenserv) {
        this.estadoordenserv = estadoordenserv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idestordenserv;
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
        final Estadoordenserv other = (Estadoordenserv) obj;
        if (this.idestordenserv != other.idestordenserv) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estadoordenserv{" + "idestordenserv=" + idestordenserv + '}';
    }
    
    
}
