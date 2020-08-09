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
@Table(name = "tprioridad")
public class Tprioridad implements Serializable{
    
    @Id
    @Column(name = "idprioridad")
    private int idprioridad;
    @Column(name = "tipoprioridad")
    private String tipoprioridad;

    public int getIdprioridad() {
        return idprioridad;
    }

    public void setIdprioridad(int idprioridad) {
        this.idprioridad = idprioridad;
    }

    public String getTipoprioridad() {
        return tipoprioridad;
    }

    public void setTipoprioridad(String tipoprioridad) {
        this.tipoprioridad = tipoprioridad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idprioridad;
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
        final Tprioridad other = (Tprioridad) obj;
        if (this.idprioridad != other.idprioridad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tprioridad{" + "idprioridad=" + idprioridad + '}';
    }
}
