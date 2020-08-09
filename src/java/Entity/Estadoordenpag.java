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
@Table(name = "estadoordenpag")
public class Estadoordenpag implements Serializable{
    
    @Id
    @Column(name = "idestordenpag")
    private int idestordenpag;
    @Column(name = "estadoordenpag")
    private String estadoordenpag;

    public int getIdestordenpag() {
        return idestordenpag;
    }

    public void setIdestordenpag(int idestordenpag) {
        this.idestordenpag = idestordenpag;
    }

    public String getEstadoordenpag() {
        return estadoordenpag;
    }

    public void setEstadoordenpag(String estadoordenpag) {
        this.estadoordenpag = estadoordenpag;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idestordenpag;
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
        final Estadoordenpag other = (Estadoordenpag) obj;
        if (this.idestordenpag != other.idestordenpag) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estadoordenpag{" + "idestordenpag=" + idestordenpag + '}';
    }
    
}
