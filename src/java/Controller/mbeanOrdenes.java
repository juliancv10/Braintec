/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.OrdenservicioFacadeLocal;
import Entity.Estadoordenserv;
import Entity.Ordenservicio;
import Entity.Tprioridad;
import Entity.Tservicio;
import Entity.Tusuario;
import Entity.Tvehiculo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Julian Camilo
 */
@ManagedBean
@SessionScoped
public class mbeanOrdenservicio implements Serializable{
    
    @EJB
    private OrdenservicioFacadeLocal ordenservicioFacade;
    private List<Ordenservicio> listaOrdenservicio;
    private Ordenservicio ordenservicio;
    private Tusuario tusuario;
    private Tvehiculo tvehiculo;
    private Tservicio tservicio;
    private Estadoordenserv estadoordenserv;
    private Tprioridad tprioridad;

    public List<Ordenservicio> getListaOrdenservicio() {
        this.listaOrdenservicio = this.ordenservicioFacade.findAll();
        return listaOrdenservicio;
    }

    public void setListaOrdenservicio(List<Ordenservicio> listaOrdenservicio) {
        this.listaOrdenservicio = listaOrdenservicio;
    }

    public Ordenservicio getOrdenservicio() {
        return ordenservicio;
    }

    public void setOrdenservicio(Ordenservicio ordenservicio) {
        this.ordenservicio = ordenservicio;
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
    
    @PostConstruct
    public void init(){
        this.ordenservicio = new Ordenservicio();
        this.tusuario = new Tusuario();
        this.tvehiculo = new Tvehiculo();
        this.tservicio = new Tservicio();
        this.estadoordenserv = new Estadoordenserv();
        this.tprioridad = new Tprioridad();
    }
}
