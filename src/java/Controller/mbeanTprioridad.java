/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TprioridadFacadeLocal;
import Entity.Tprioridad;
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
public class mbeanTprioridad implements Serializable{
    
    @EJB
    private TprioridadFacadeLocal tprioridadFacade;
    private List<Tprioridad> listaTprioridad;
    private Tprioridad tprioridad;

    public List<Tprioridad> getListaTprioridad() {
        this.listaTprioridad = this.tprioridadFacade.findAll();
        return listaTprioridad;
    }

    public void setListaTprioridad(List<Tprioridad> listaTprioridad) {
        this.listaTprioridad = listaTprioridad;
    }

    public Tprioridad getTprioridad() {
        return tprioridad;
    }

    public void setTprioridad(Tprioridad tprioridad) {
        this.tprioridad = tprioridad;
    }
    
    @PostConstruct
    public void init(){
        this.tprioridad = new Tprioridad();
    }
}
