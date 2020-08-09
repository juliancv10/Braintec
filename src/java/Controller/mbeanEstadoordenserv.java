/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.EstadoordenservFacadeLocal;
import Entity.Estadoordenserv;
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
public class mbeanEstadoordenserv implements Serializable{
    
    @EJB
    private EstadoordenservFacadeLocal estadoordenservFacade;
    private List<Estadoordenserv> listaEstadoordenserv;
    private Estadoordenserv estadoordenserv;

    public List<Estadoordenserv> getListaEstadoordenserv() {
        this.listaEstadoordenserv = this.estadoordenservFacade.findAll();
        return listaEstadoordenserv;
    }

    public void setListaEstadoordenserv(List<Estadoordenserv> listaEstadoordenserv) {
        this.listaEstadoordenserv = listaEstadoordenserv;
    }

    public Estadoordenserv getEstadoordenserv() {
        return estadoordenserv;
    }

    public void setEstadoordenserv(Estadoordenserv estadoordenserv) {
        this.estadoordenserv = estadoordenserv;
    }
    
    @PostConstruct
    public void init(){
        this.estadoordenserv = new Estadoordenserv();
    }
}
