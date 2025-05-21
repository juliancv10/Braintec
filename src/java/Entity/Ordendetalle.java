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

/**
 *
 * @author Julian Camilo
 */
@Entity
@Table(name = "ordendetalle")
public class Ordendetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idodetalle")
    private Integer idodetalle;
    @ManyToOne
    @JoinColumn(name = "idordenm")
    private Ordenmaestro ordenmaestro;
    @ManyToOne
    @JoinColumn(name = "idprodserv")
    private Tproserv tproserv;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio_unitario")
    private Double precioUnitario;
    @Column(name = "total")
    private Double total;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    private Date fecha;
    @Column (name = "activo")
    private Boolean activo;

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
   
    public Integer getIdodetalle() {
        return idodetalle;
    }

    public void setIdodetalle(Integer idodetalle) {
        this.idodetalle = idodetalle;
    }

    public Ordenmaestro getOrdenmaestro() {
        return ordenmaestro;
    }

    public void setOrdenmaestro(Ordenmaestro ordenmaestro) {
        this.ordenmaestro = ordenmaestro;
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

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.idodetalle);
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
        final Ordendetalle other = (Ordendetalle) obj;
        if (!Objects.equals(this.idodetalle, other.idodetalle)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ordendetalle{" + "idodetalle=" + idodetalle + '}';
    }

    
}
