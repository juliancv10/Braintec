/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Julian Camilo
 */
@Entity
@Table(name = "ordenpedido")
public class Ordenpedido implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idopedido;
    @Column(name = "fpedido")
    private Date fpedido;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "numdocumento")
    private Tusuario tusuario;
    @ManyToOne
    @JoinColumn(name = "refrepuesto")
    private Tinventario tinventario;
    @ManyToOne
    @JoinColumn(name = "idestordenped")
    private Estadoordenped estadoordenped;

    public int getIdopedido() {
        return idopedido;
    }

    public void setIdopedido(int idopedido) {
        this.idopedido = idopedido;
    }

    public Date getFpedido() {
        return fpedido;
    }

    public void setFpedido(Date fpedido) {
        this.fpedido = fpedido;
    }

    public Tusuario getTusuario() {
        return tusuario;
    }

    public void setTusuario(Tusuario tusuario) {
        this.tusuario = tusuario;
    }

    public Tinventario getTinventario() {
        return tinventario;
    }

    public void setTinventario(Tinventario tinventario) {
        this.tinventario = tinventario;
    }

    public Estadoordenped getEstadoordenped() {
        return estadoordenped;
    }

    public void setEstadoordenped(Estadoordenped estadoordenped) {
        this.estadoordenped = estadoordenped;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.idopedido;
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
        final Ordenpedido other = (Ordenpedido) obj;
        if (this.idopedido != other.idopedido) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ordenpedido{" + "idopedido=" + idopedido + '}';
    }
}
