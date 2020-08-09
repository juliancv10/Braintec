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
@Table (name = "ordenservicio")
public class Ordenservicio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcasoservicio;
    @Column(name = "resumenservicio")
    private String resumenservicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "finiservicio")
    private Date finiservicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "ffinservicio")
    private Date ffinservicio;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "numdocumento")
    private Tusuario tusuario;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "placavehiculo")
    private Tvehiculo tvehiculo;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idservicio")
    private Tservicio tservicio;
    @ManyToOne
    @JoinColumn(name = "idestordenserv")
    private Estadoordenserv estadoordenserv;
    @ManyToOne
    @JoinColumn(name = "idprioridad")
    private Tprioridad tprioridad;

    public int getIdcasoservicio() {
        return idcasoservicio;
    }

    public void setIdcasoservicio(int idcasoservicio) {
        this.idcasoservicio = idcasoservicio;
    }

    public String getResumenservicio() {
        return resumenservicio;
    }

    public void setResumenservicio(String resumenservicio) {
        this.resumenservicio = resumenservicio;
    }

    public Date getFiniservicio() {
        return finiservicio;
    }

    public void setFiniservicio(Date finiservicio) {
        this.finiservicio = finiservicio;
    }

    public Date getFfinservicio() {
        return ffinservicio;
    }

    public void setFfinservicio(Date ffinservicio) {
        this.ffinservicio = ffinservicio;
    }

    public Tusuario getTusuario() {
        return tusuario;
    }

    public void setTusuario(Tusuario tusuario) {
        this.tusuario = tusuario;
    }

    public Tvehiculo getTvehiculo() {
        return tvehiculo;
    }

    public void setTvehiculo(Tvehiculo tvehiculo) {
        this.tvehiculo = tvehiculo;
    }

    public Tservicio getTservicio() {
        return tservicio;
    }

    public void setTservicio(Tservicio tservicio) {
        this.tservicio = tservicio;
    }

    public Estadoordenserv getEstadoordenserv() {
        return estadoordenserv;
    }

    public void setEstadoordenserv(Estadoordenserv estadoordenserv) {
        this.estadoordenserv = estadoordenserv;
    }

    public Tprioridad getTprioridad() {
        return tprioridad;
    }

    public void setTprioridad(Tprioridad tprioridad) {
        this.tprioridad = tprioridad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idcasoservicio;
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
        final Ordenservicio other = (Ordenservicio) obj;
        if (this.idcasoservicio != other.idcasoservicio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ordenservicio{" + "idcasoservicio=" + idcasoservicio + '}';
    }

    
}
