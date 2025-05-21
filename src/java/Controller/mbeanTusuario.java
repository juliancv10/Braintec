/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TusuarioFacadeLocal;
import Entity.Tdocumento;
import Entity.Tusuario;
import java.io.Serializable;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Julian Camilo
 */
@ManagedBean
@SessionScoped
public class mbeanTusuario implements Serializable{
    
    @EJB
    private TusuarioFacadeLocal tusuarioFacade;
    private List<Tusuario> listaTusuario;
    private Tusuario tusuario;
    private Tdocumento tdocumento;
    private String msj;


    public List<Tusuario> getListaTusuario() {
        this.listaTusuario = this.tusuarioFacade.findAll();
        return listaTusuario;
    }

    public void setListaTusuario(List<Tusuario> listaTusuario) {
        this.listaTusuario = listaTusuario;
    }

    public Tusuario getTusuario() {
        return tusuario;
    }

    public void setTusuario(Tusuario tusuario) {
        this.tusuario = tusuario;
    }

    public Tdocumento getTdocumento() {
        return tdocumento;
    }

    public void setTdocumento(Tdocumento tdocumento) {
        this.tdocumento = tdocumento;
    }
    
    @PostConstruct
    public void init(){
        this.tusuario = new Tusuario();
        this.tdocumento = new Tdocumento();
    }
    
    public void guardar(){
        try {
            this.tusuario.setTdocumento(tdocumento);
            this.tusuarioFacade.create(tusuario);
            this.msj ="Registro creado correctamente";
            this.tdocumento = new Tdocumento();
            this.tusuario = new Tusuario();


        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void actualizar(){
        try {
            this.tusuario.setTdocumento(tdocumento);
            this.tusuarioFacade.edit(tusuario);
            this.msj ="Registro Actualizado correctamente";
            this.tdocumento = new Tdocumento();
            this.tusuario = new Tusuario();
            
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    
    public void eliminar(Tusuario eli){
        try {
           this.tusuarioFacade.remove(eli);
           this.msj = "Registro Eliminado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj ="Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }
    public void editardatos(Tusuario ed){
        this.tdocumento.setIddocumento(ed.getTdocumento().getIddocumento());
        this.tusuario = ed;
    }
    
    public void limpiar(){
        this.tdocumento = new Tdocumento();
        this.tusuario = new Tusuario();
    }

    public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
        if (!(arg2 instanceof Integer)) {
            throw new ValidatorException(new FacesMessage("Debe ser un entero"));
        }

        int valor = (Integer) arg2;

        if ((valor < 1000000) || (valor > 199999999)) {
            throw new ValidatorException(new FacesMessage(
                    "Debe ingresar un documento mayor a 1000000"));
        }
    }
}
