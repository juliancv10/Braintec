/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "templeado")
public class Templeado implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "idempleado")
    private int idempleado;
    @Column(name = "cargoempleado")
    private String cargoempleado;
    @Column(name = "usuarioempleado")
    private String usuarioempleado;
    @Column(name = "contrasenaempleado")
    private String contrasenaempleado;
    @Temporal(TemporalType.DATE)
    @Column(name = "fcreacion")
    private Date fcreacion;
    @ManyToOne
    @JoinColumn(name = "numdocumento")
    private Tusuario tusuario;
    @ManyToOne
    @JoinColumn(name = "idroles")
    private Troles troles;
    @ManyToOne
    @JoinColumn(name = "idestadou")
    private Estadousuarioemp estadousuarioemp;

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public String getCargoempleado() {
        return cargoempleado;
    }

    public void setCargoempleado(String cargoempleado) {
        this.cargoempleado = cargoempleado;
    }

    public String getUsuarioempleado() {
        return usuarioempleado;
    }

    public void setUsuarioempleado(String usuarioempleado) {
        this.usuarioempleado = usuarioempleado;
    }

    public String getContrasenaempleado() {
        return contrasenaempleado;
    }

    public void setContrasenaempleado(String contrasenaempleado) {
        this.contrasenaempleado = contrasenaempleado;
    }

    public Date getFcreacion() {
        return fcreacion;
    }

    public void setFcreacion(Date fcreacion) {
        this.fcreacion = fcreacion;
    }

    public Tusuario getTusuario() {
        return tusuario;
    }

    public void setTusuario(Tusuario tusuario) {
        this.tusuario = tusuario;
    }

    public Troles getTroles() {
        return troles;
    }

    public void setTroles(Troles troles) {
        this.troles = troles;
    }

    public Estadousuarioemp getEstadousuarioemp() {
        return estadousuarioemp;
    }

    public void setEstadousuarioemp(Estadousuarioemp estadousuarioemp) {
        this.estadousuarioemp = estadousuarioemp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idempleado;
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
        final Templeado other = (Templeado) obj;
        if (this.idempleado != other.idempleado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Templeado{" + "idempleado=" + idempleado + '}';
    }
    
}
