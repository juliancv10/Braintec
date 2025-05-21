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
@Table (name = "ordenservicio")
public class OrdenServicio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcaso")
    private Integer idcaso;
    @Column(name = "fechaserv")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaserv;
    @Column(name = "fechafin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafin;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "prioridad")
    private String prioridad;
    @ManyToOne
    @JoinColumn(name = "vehiculo")
    private Tvehiculo tvehiculo;
    @ManyToOne
    @JoinColumn(name = "idservicio")
    private Tproserv tproserv;

    public Integer getIdcaso() {
        return idcaso;
    }

    public void setIdcaso(Integer idcaso) {
        this.idcaso = idcaso;
    }

    public Date getFechaserv() {
        return fechaserv;
    }

    public void setFechaserv(Date fechaserv) {
        this.fechaserv = fechaserv;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
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

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Tvehiculo getTvehiculo() {
        return tvehiculo;
    }

    public void setTvehiculo(Tvehiculo tvehiculo) {
        this.tvehiculo = tvehiculo;
    }

    public Tproserv getTproserv() {
        return tproserv;
    }

    public void setTproserv(Tproserv tproserv) {
        this.tproserv = tproserv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.idcaso);
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
        final OrdenServicio other = (OrdenServicio) obj;
        if (!Objects.equals(this.idcaso, other.idcaso)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrdenServicio{" + "idcaso=" + idcaso + '}';
    }
    
}
