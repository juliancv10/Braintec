/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.EstadousuarioempFacadeLocal;
import Entity.Estadousuarioemp;
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
public class mbeanEstadousuarioemp implements Serializable{
    @EJB
    private EstadousuarioempFacadeLocal estadousuarioempFacade;
    private List<Estadousuarioemp> listaestadousuarioemp;
    private Estadousuarioemp estadousuarioemp;

    public List<Estadousuarioemp> getListaestadousuarioemp() {
        this.listaestadousuarioemp = this.estadousuarioempFacade.findAll();
        return listaestadousuarioemp;
    }

    public void setListaestadousuarioemp(List<Estadousuarioemp> listaestadousuarioemp) {
        this.listaestadousuarioemp = listaestadousuarioemp;
    }

    public Estadousuarioemp getEstadousuarioemp() {
        return estadousuarioemp;
    }

    public void setEstadousuarioemp(Estadousuarioemp estadousuarioemp) {
        this.estadousuarioemp = estadousuarioemp;
    }
    
     @PostConstruct
    public void init(){
        this.estadousuarioemp = new Estadousuarioemp();
    }
    
}
