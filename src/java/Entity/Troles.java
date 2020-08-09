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
@Table(name = "troles")
public class Troles implements Serializable{
    
    @Id
    @Column(name = "idroles")
    private int idroles;
    @Column(name = "tiporol")
    private String tiporol;

    public int getIdroles() {
        return idroles;
    }

    public void setIdroles(int idroles) {
        this.idroles = idroles;
    }

    public String getTiporol() {
        return tiporol;
    }

    public void setTiporol(String tiporol) {
        this.tiporol = tiporol;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.idroles;
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
        final Troles other = (Troles) obj;
        if (this.idroles != other.idroles) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Troles{" + "idroles=" + idroles + '}';
    }
    
    
}
