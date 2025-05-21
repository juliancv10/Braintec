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
@Table (name = "remision")
public class Remision implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idremision")
    private Integer idremision;
    
    @ManyToOne
    @JoinColumn(name = "numordenp")
    private Ordenmaestro ordenmaestro;
    
    @Column(name = "fecharem")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharem;
    
    @Column(name = "observaciones")
    private String observaciones;
    
    @Column (name = "estado")
    private Boolean estado;

    public Integer getIdremision() {
        return idremision;
    }

    public Ordenmaestro getOrdenmaestro() {
        return ordenmaestro;
    }

    public void setOrdenmaestro(Ordenmaestro ordenmaestro) {
        this.ordenmaestro = ordenmaestro;
    }

    public Date getFecharem() {
        return fecharem;
    }

    public void setFecharem(Date fecharem) {
        this.fecharem = fecharem;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idremision);
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
        final Remision other = (Remision) obj;
        if (!Objects.equals(this.idremision, other.idremision)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Remision{" + "idremision=" + idremision + '}';
    }

    
    
}
