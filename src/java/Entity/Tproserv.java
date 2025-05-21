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
@Table(name = "tproserv")

public class Tproserv implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idps")
    private Integer idps;
    @Column(name = "codigo")
    private String codigo;    
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio")
    private Double precio;
    @Column(name = "estado")
    private Boolean estado;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Tcategoria tcategoria;

    public Integer getIdps() {
        return idps;
    }

    public void setIdps(Integer idps) {
        this.idps = idps;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Tcategoria getTcategoria() {
        return tcategoria;
    }

    public void setTcategoria(Tcategoria tcategoria) {
        this.tcategoria = tcategoria;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.idps);
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
        final Tproserv other = (Tproserv) obj;
        if (!Objects.equals(this.idps, other.idps)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tproserv{" + "idps=" + idps + '}';
    }

    
}
