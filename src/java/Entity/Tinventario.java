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
@Table(name = "tinventario")
public class Tinventario implements Serializable{
    
    @Id
    @Column(name = "refrepuesto")
    private int refrepuesto;
    @Column(name = "nombrerepuesto")
    private String nombrerepuesto;
    @Column(name = "marcarepuesto")
    private String marcarepuesto;
    @Column(name = "cantidadexistente")
    private int cantidadexistente;
    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Tcategoria tcategoria;
    @ManyToOne
    @JoinColumn(name = "idproveedor")
    private Tproveedor tproveedor;

    public int getRefrepuesto() {
        return refrepuesto;
    }

    public void setRefrepuesto(int refrepuesto) {
        this.refrepuesto = refrepuesto;
    }

    public String getNombrerepuesto() {
        return nombrerepuesto;
    }

    public void setNombrerepuesto(String nombrerepuesto) {
        this.nombrerepuesto = nombrerepuesto;
    }

    public String getMarcarepuesto() {
        return marcarepuesto;
    }

    public void setMarcarepuesto(String marcarepuesto) {
        this.marcarepuesto = marcarepuesto;
    }

    public int getCantidadexistente() {
        return cantidadexistente;
    }

    public void setCantidadexistente(int cantidadexistente) {
        this.cantidadexistente = cantidadexistente;
    }

    public Tcategoria getTcategoria() {
        return tcategoria;
    }

    public void setTcategoria(Tcategoria tcategoria) {
        this.tcategoria = tcategoria;
    }

    public Tproveedor getTproveedor() {
        return tproveedor;
    }

    public void setTproveedor(Tproveedor tproveedor) {
        this.tproveedor = tproveedor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.refrepuesto;
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
        final Tinventario other = (Tinventario) obj;
        if (this.refrepuesto != other.refrepuesto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tinventario{" + "refrepuesto=" + refrepuesto + '}';
    }
}
