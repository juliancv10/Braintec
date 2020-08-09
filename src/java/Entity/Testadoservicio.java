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
@Table(name = "testadoservicio")
public class Testadoservicio implements Serializable{
    
    @Id
    @Column(name = "idestadoserv")
    private int idestadoserv;
    @Column(name = "tipoestado")
    private String tipoestado;

    public int getIdestadoserv() {
        return idestadoserv;
    }

    public void setIdestadoserv(int idestadoserv) {
        this.idestadoserv = idestadoserv;
    }

    public String getTipoestado() {
        return tipoestado;
    }

    public void setTipoestado(String tipoestado) {
        this.tipoestado = tipoestado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idestadoserv;
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
        final Testadoservicio other = (Testadoservicio) obj;
        if (this.idestadoserv != other.idestadoserv) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Testadoservicio{" + "idestadoserv=" + idestadoserv + '}';
    }
    
    
}
