/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TvehiculoFacadeLocal;
import Entity.Tusuario;
import Entity.Tvehiculo;
import java.io.Serializable;
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
public class mbeanTvehiculo implements Serializable{
    
    @EJB
    private TvehiculoFacadeLocal tvehiculoFacade;
    private List<Tvehiculo> listaTvehiculo;
    private Tvehiculo tvehiculo;
    private Tusuario tusuario;
    private String msj;

    public List<Tvehiculo> getListaTvehiculo() {
        this.listaTvehiculo = this.tvehiculoFacade.findAll();
        return listaTvehiculo;
    }

    public void setListaTvehiculo(List<Tvehiculo> listaTvehiculo) {
        this.listaTvehiculo = listaTvehiculo;
    }

    public Tvehiculo getTvehiculo() {
        return tvehiculo;
    }

    public void setTvehiculo(Tvehiculo tvehiculo) {
        this.tvehiculo = tvehiculo;
    }

    public Tusuario getTusuario() {
        return tusuario;
    }

    public void setTusuario(Tusuario tusuario) {
        this.tusuario = tusuario;
    }
    
    @PostConstruct
    public void init(){
        this.tvehiculo = new Tvehiculo();
        this.tusuario = new Tusuario();
    }
    
    public void guardar(){
        try {
            this.tvehiculo.setTusuario(tusuario);
            this.tvehiculoFacade.create(tvehiculo);
            this.msj ="Registro creado correctamente";
            this.tusuario = new Tusuario();
            this.tvehiculo = new Tvehiculo();
            
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void actualizar(){
        try {
            this.tvehiculo.setTusuario(tusuario);
            this.tvehiculoFacade.edit(tvehiculo);
            this.msj ="Registro Actualizado correctamente";
            this.tusuario = new Tusuario();
            this.tvehiculo = new Tvehiculo();
            
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void eliminar(Tvehiculo eli){
        try {
           this.tvehiculoFacade.remove(eli);
           this.msj = "Registro Eliminado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void editardatos(Tvehiculo ed){
        this.tusuario.setNumdocumento(ed.getTusuario().getNumdocumento());
        this.tvehiculo = ed;
    }
    
    public void limpiar(){
        this.tusuario = new Tusuario();
        this.tvehiculo = new Tvehiculo();
    }
}
