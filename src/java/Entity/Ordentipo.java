/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Julian Camilo
 */

@Entity
@Table(name = "ordentipo")
public class Ordentipo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "idtipo")
    private Integer idtipo;
    @Column(name = "ordtipo")
    private String ordtipo;

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public String getOrdtipo() {
        return ordtipo;
    }

    public void setOrdtipo(String ordtipo) {
        this.ordtipo = ordtipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idtipo);
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
        final Ordentipo other = (Ordentipo) obj;
        if (!Objects.equals(this.idtipo, other.idtipo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ordentipo{" + "idtipo=" + idtipo + '}';
    }
          
}
