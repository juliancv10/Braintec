/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TempleadoFacadeLocal;
import Entity.Estadousuarioemp;
import Entity.Templeado;
import Entity.Troles;
import Entity.Tusuario;
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
@ManagedBean(name = "mbeanTempleado")
@SessionScoped
public class mbeanTempleado implements Serializable {

    @EJB
    private TempleadoFacadeLocal templeadoFacade;
    private List<Templeado> listaTempleado;
    private Templeado templeado;
    private Tusuario tusuario;
    private Troles troles;
    private Estadousuarioemp estadousuarioemp;
    private String msj;

    public mbeanTempleado() {
        templeado = new Templeado();
        tusuario = new Tusuario();
    }

    public List<Templeado> getListaTempleado() {
        this.listaTempleado = this.templeadoFacade.findAll();
        return listaTempleado;
    }

    public void setListaTempleado(List<Templeado> listaTempleado) {
        this.listaTempleado = listaTempleado;
    }

    public Templeado getTempleado() {
        return templeado;
    }

    public void setTempleado(Templeado templeado) {
        this.templeado = templeado;
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

    @PostConstruct
    public void init() {
        this.templeado = new Templeado();
        this.tusuario = new Tusuario();
        this.troles = new Troles();
        this.estadousuarioemp = new Estadousuarioemp();
    }

    public String iniciarSesion() {
        Templeado us;
        String redireccion = null;
        try {
            us = templeadoFacade.iniciarSesion(templeado);
            if (us != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("templeado", us);
                redireccion = "/protegido/principal?faces-redirect=true";

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credencial incorrecta"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        }
        return redireccion;
    }

    public void guardar() {
        try {
            this.templeado.setTusuario(tusuario);
            this.templeado.setTroles(troles);
            this.templeado.setEstadousuarioemp(estadousuarioemp);
            templeado.setFcreacion(Calendar.getInstance().getTime());
            this.templeadoFacade.create(templeado);
            this.msj = "Registro creado correctamente";
            this.templeado = new Templeado();
            this.tusuario = new Tusuario();
            this.troles = new Troles();
            this.estadousuarioemp = new Estadousuarioemp();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void actualizar() {
        try {
            this.templeado.setTusuario(tusuario);
            this.templeado.setTroles(troles);
            this.templeado.setEstadousuarioemp(estadousuarioemp);
            this.templeadoFacade.edit(templeado);
            this.msj = "Registro Actualizado correctamente";
            this.templeado = new Templeado();
            this.tusuario = new Tusuario();
            this.troles = new Troles();
            this.estadousuarioemp = new Estadousuarioemp();
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Templeado eli) {
        try {
            this.templeadoFacade.remove(eli);
            this.msj = "Registro Eliminado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editardatos(Templeado ed) {
        this.tusuario.setNumdocumento(ed.getTusuario().getNumdocumento());
        this.troles.setIdroles(ed.getTroles().getIdroles());
        this.estadousuarioemp.setIdestadou(ed.getEstadousuarioemp().getIdestadou());
        this.templeado = ed;
    }

    public void limpiar() {
        this.templeado = new Templeado();
        this.tusuario = new Tusuario();
        this.troles = new Troles();
        this.estadousuarioemp = new Estadousuarioemp();
    }
}
