/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.OrdenServicioFacadeLocal;
import Entity.OrdenServicio;
import Entity.Tproserv;
import Entity.Tvehiculo;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Julian Camilo
 */
@ManagedBean
@SessionScoped
public class MbeanOrdenserv implements Serializable {

    @EJB
    private OrdenServicioFacadeLocal ordenservicioFacade;
    private List<OrdenServicio> listaOrdenServicio;
    private List<OrdenServicio> listaCerrados;
    private OrdenServicio ordenservicio;
    private Tproserv tproserv;
    private Tvehiculo tvehiculo;
    private String msj;

    public List<OrdenServicio> getListaCerrados() {
        this.listaCerrados = this.ordenservicioFacade.listarCerrado();
        return listaCerrados;
    }

    public void setListaCerrados(List<OrdenServicio> listaCerrados) {
        this.listaCerrados = listaCerrados;
    }
   
    public List<OrdenServicio> getListaOrdenServicio() {
        this.listaOrdenServicio = this.ordenservicioFacade.listarOrdServ();
        return listaOrdenServicio;
    }

    public void setListaOrdenServicio(List<OrdenServicio> listaOrdenServicio) {
        this.listaOrdenServicio = listaOrdenServicio;
    }

    public OrdenServicio getOrdenservicio() {
        return ordenservicio;
    }

    public void setOrdenservicio(OrdenServicio ordenservicio) {
        this.ordenservicio = ordenservicio;
    }

    public Tproserv getTproserv() {
        return tproserv;
    }

    public void setTproserv(Tproserv tproserv) {
        this.tproserv = tproserv;
    }

    public Tvehiculo getTvehiculo() {
        return tvehiculo;
    }

    public void setTvehiculo(Tvehiculo tvehiculo) {
        this.tvehiculo = tvehiculo;
    }

    @PostConstruct
    public void init() {
        this.ordenservicio = new OrdenServicio();
        this.tproserv = new Tproserv();
        this.tvehiculo = new Tvehiculo();
    }

    public void guardar() {
        try {
            this.ordenservicio.setTvehiculo(tvehiculo);
            this.ordenservicio.setTproserv(tproserv);
            ordenservicio.setEstado(true);
            ordenservicio.setFechaserv(Calendar.getInstance().getTime());
            this.ordenservicioFacade.create(ordenservicio);
            this.msj = "Registro Actualizado correctamente";
            this.tvehiculo = new Tvehiculo();
            this.tproserv = new Tproserv();
            this.ordenservicio = new OrdenServicio();

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void actualizar() {
        try {
            this.ordenservicio.setTvehiculo(tvehiculo);
            this.ordenservicio.setTproserv(tproserv);
            this.ordenservicioFacade.edit(ordenservicio);
            this.msj = "Registro Actualizado correctamente";
            this.tvehiculo = new Tvehiculo();
            this.tproserv = new Tproserv();
            this.ordenservicio = new OrdenServicio();

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(OrdenServicio eli) {
        try {
            this.ordenservicioFacade.remove(eli);
            this.msj = "Registro Eliminado Correctamente";

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editardatos(OrdenServicio ed) {
        this.tvehiculo.setPlacavehiculo(ed.getTvehiculo().getPlacavehiculo());
        this.tproserv.setIdps(ed.getTproserv().getIdps());
        this.ordenservicio = ed;
    }

    public void limpiar() {
        this.ordenservicio = new OrdenServicio();
        this.tproserv = new Tproserv();
        this.tvehiculo = new Tvehiculo();
    }

    public void cierrecaso() {
        try {
            this.ordenservicio.setTvehiculo(tvehiculo);
            this.ordenservicio.setTproserv(tproserv);
            ordenservicio.setEstado(false);
            ordenservicio.setFechafin(Calendar.getInstance().getTime());
            this.ordenservicioFacade.edit(ordenservicio);
            this.msj = ("Se ha realizado el cierre del caso: " + ordenservicio.getIdcaso());
            this.tvehiculo = new Tvehiculo();
            this.tproserv = new Tproserv();
            this.ordenservicio = new OrdenServicio();
                       
        } catch (Exception e) {
            
            e.printStackTrace();
            this.msj = "Error no se han ingresaron comentarios del cierre" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
}
