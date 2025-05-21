/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
@Table (name = "remisiondetalle")
public class Remisiondetalle implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetrem")
    private Integer iddetrem;
    
    @ManyToOne
    @JoinColumn(name = "idrem")
    private Remision remision;
    
    @ManyToOne
    @JoinColumn(name = "idproducto")
    private Tproserv tproserv;
    
    @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "fechadet")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadet;
    
    @Column (name = "estado")
    private Boolean estado;

    public Integer getIddetrem() {
        return iddetrem;
    }

    public void setIddetrem(Integer iddetrem) {
        this.iddetrem = iddetrem;
    }

    public Remision getRemision() {
        return remision;
    }

    public void setRemision(Remision remision) {
        this.remision = remision;
    }

    public Tproserv getTproserv() {
        return tproserv;
    }

    public void setTproserv(Tproserv tproserv) {
        this.tproserv = tproserv;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechadet() {
        return fechadet;
    }

    public void setFechadet(Date fechadet) {
        this.fechadet = fechadet;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.iddetrem);
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
        final Remisiondetalle other = (Remisiondetalle) obj;
        if (!Objects.equals(this.iddetrem, other.iddetrem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Remisiondetalle{" + "iddetrem=" + iddetrem + '}';
    }
    
    
}
