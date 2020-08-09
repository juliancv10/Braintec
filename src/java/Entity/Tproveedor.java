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
@Table(name = "tproveedor")
public class Tproveedor implements Serializable{
    
    @Id
    @Column(name = "idproveedor")
    private int idproveedor;
    @Column(name = "rsocialproveedor")
    private String rsocialproveedor;
    @Column(name = "percontactoproveedor")
    private String percontactoproveedor;
    @Column(name = "telefonoproveedor")
    private int telefonoproveedor;
    @Column(name = "correoproveedor")
    private String correoproveedor;

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getRsocialproveedor() {
        return rsocialproveedor;
    }

    public void setRsocialproveedor(String rsocialproveedor) {
        this.rsocialproveedor = rsocialproveedor;
    }

    public String getPercontactoproveedor() {
        return percontactoproveedor;
    }

    public void setPercontactoproveedor(String percontactoproveedor) {
        this.percontactoproveedor = percontactoproveedor;
    }

    public int getTelefonoproveedor() {
        return telefonoproveedor;
    }

    public void setTelefonoproveedor(int telefonoproveedor) {
        this.telefonoproveedor = telefonoproveedor;
    }

    public String getCorreoproveedor() {
        return correoproveedor;
    }

    public void setCorreoproveedor(String correoproveedor) {
        this.correoproveedor = correoproveedor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.idproveedor;
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
        final Tproveedor other = (Tproveedor) obj;
        if (this.idproveedor != other.idproveedor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tproveedor{" + "idproveedor=" + idproveedor + '}';
    }
}
