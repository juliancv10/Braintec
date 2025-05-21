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
@Table(name = "tcategoria")
public class Tcategoria implements Serializable{

    @Id
    @Column(name = "idcategoria")
    private int idcategoria;
    @Column(name = "categoriarepuesto")
    private String categoriarepuesto;

    public Tcategoria() {

    }


    public Tcategoria(Integer id) {
        this.idcategoria = id;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getCategoriarepuesto() {
        return categoriarepuesto;
    }

    public void setCategoriarepuesto(String categoriarepuesto) {
        this.categoriarepuesto = categoriarepuesto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idcategoria;
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
        final Tcategoria other = (Tcategoria) obj;
        if (this.idcategoria != other.idcategoria) {
            return false;
        }
        return true;
    }
}
