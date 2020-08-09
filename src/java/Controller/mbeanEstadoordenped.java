/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.EstadoordenpedFacadeLocal;
import Entity.Estadoordenped;
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
public class mbeanEstadoordenped implements Serializable{
    
    @EJB
    private EstadoordenpedFacadeLocal estadoordenpedFacade;
    private List<Estadoordenped> listaEstadoordenped;
    private Estadoordenped estadoordenped;

    public List<Estadoordenped> getListaEstadoordenped() {
        this.listaEstadoordenped = this.estadoordenpedFacade.findAll();
        return listaEstadoordenped;
    }

    public void setListaEstadoordenped(List<Estadoordenped> listaEstadoordenped) {
        this.listaEstadoordenped = listaEstadoordenped;
    }

    public Estadoordenped getEstadoordenped() {
        return estadoordenped;
    }

    public void setEstadoordenped(Estadoordenped estadoordenped) {
        this.estadoordenped = estadoordenped;
    }
    
    @PostConstruct
    public void init(){
        this.estadoordenped = new Estadoordenped();
    }
}
