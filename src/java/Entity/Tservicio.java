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
@Table(name = "tservicio")
public class Tservicio implements Serializable{
    
    @Id
    @Column(name = "idservicio")
    private int idservicio;
    @Column(name = "nombreservicio")
    private String nombreservicio;
    @Column(name = "descservicio")
    private String descservicio;
    @Column(name = "tarifaservicio")
    private Long tarifaservicio;

    public int getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(int idservicio) {
        this.idservicio = idservicio;
    }

    public String getNombreservicio() {
        return nombreservicio;
    }

    public void setNombreservicio(String nombreservicio) {
        this.nombreservicio = nombreservicio;
    }

    public String getDescservicio() {
        return descservicio;
    }

    public void setDescservicio(String descservicio) {
        this.descservicio = descservicio;
    }

    public Long getTarifaservicio() {
        return tarifaservicio;
    }

    public void setTarifaservicio(Long tarifaservicio) {
        this.tarifaservicio = tarifaservicio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idservicio;
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
        final Tservicio other = (Tservicio) obj;
        if (this.idservicio != other.idservicio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tservicio{" + "idservicio=" + idservicio + '}';
    }
}
