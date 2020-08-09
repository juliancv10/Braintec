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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Julian Camilo
 */
@Entity
@Table(name = "ordenpagoc")
public class Ordenpagoc implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idordenpag;
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaorden")
    private Date fechaorden;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "numdocumento")
    private Tusuario tusuario;
    @ManyToOne
    @JoinColumn(name = "idopedido")
    private Ordenpedido ordenpedido;
    @ManyToOne
    @JoinColumn(name = "idcasoservicio")
    private Ordenservicio ordenservicio;
    @ManyToOne
    @JoinColumn(name = "idestordenpag")
    private Estadoordenpag estadoordenpag;

    public int getIdordenpag() {
        return idordenpag;
    }

    public void setIdordenpag(int idordenpag) {
        this.idordenpag = idordenpag;
    }

    public Date getFechaorden() {
        return fechaorden;
    }

    public void setFechaorden(Date fechaorden) {
        this.fechaorden = fechaorden;
    }

    public Tusuario getTusuario() {
        return tusuario;
    }

    public void setTusuario(Tusuario tusuario) {
        this.tusuario = tusuario;
    }

    public Ordenpedido getOrdenpedido() {
        return ordenpedido;
    }

    public void setOrdenpedido(Ordenpedido ordenpedido) {
        this.ordenpedido = ordenpedido;
    }

    public Ordenservicio getOrdenservicio() {
        return ordenservicio;
    }

    public void setOrdenservicio(Ordenservicio ordenservicio) {
        this.ordenservicio = ordenservicio;
    }

    public Estadoordenpag getEstadoordenpag() {
        return estadoordenpag;
    }

    public void setEstadoordenpag(Estadoordenpag estadoordenpag) {
        this.estadoordenpag = estadoordenpag;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.idordenpag;
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
        final Ordenpagoc other = (Ordenpagoc) obj;
        if (this.idordenpag != other.idordenpag) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ordenpagoc{" + "idordenpag=" + idordenpag + '}';
    }
    
    
}
