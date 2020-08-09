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
@Table(name = "estadoordenped")
public class Estadoordenped implements Serializable{
    
    @Id
    @Column(name = "idestordenped")
    private int idestordenped;
    @Column(name = "estadoordenped")
    private String estadoordenped;

    public int getIdestordenped() {
        return idestordenped;
    }

    public void setIdestordenped(int idestordenped) {
        this.idestordenped = idestordenped;
    }

    public String getEstadoordenped() {
        return estadoordenped;
    }

    public void setEstadoordenped(String estadoordenped) {
        this.estadoordenped = estadoordenped;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idestordenped;
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
        final Estadoordenped other = (Estadoordenped) obj;
        if (this.idestordenped != other.idestordenped) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estadoordenped{" + "idestordenped=" + idestordenped + '}';
    }
    
    
}
