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
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Julian Camilo
 */
@Named
@ViewScoped
public class rserviciocontroller implements Serializable{
    
    @EJB
    private OrdenservicioFacadeLocal OservicioEJB;
    private Ordenservicio ordenservicio;
    private Tusuario tusuario;
    private Tvehiculo tvehiculo;
    private Tservicio tservicio;
    private Estadoordenserv estadoordenserv;
    private Tprioridad tprioridad;
    
    @PostConstruct
    public void init(){
        ordenservicio = new Ordenservicio();
        tusuario = new Tusuario();
        tvehiculo = new Tvehiculo();
        tservicio = new Tservicio();
        estadoordenserv = new Estadoordenserv();
        tprioridad = new Tprioridad();
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
    public void guardar(){//Metodos
        try {
            this.ordenservicio.setTusuario(tusuario);
            OservicioEJB.create(ordenservicio);
            this.ordenservicio.setTvehiculo(tvehiculo);
            this.ordenservicio.setTservicio(tservicio);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso", "Se Registro Correctamente"));
            
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Aviso", "Error"));
        }
    }
}
