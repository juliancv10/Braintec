/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.EstadoordenpagFacadeLocal;
import Entity.Estadoordenpag;
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
public class mbeanEstadoordenpag implements Serializable{
    
    @EJB
    private EstadoordenpagFacadeLocal estadoordenpagFacade;
    private List<Estadoordenpag> listaEstadoordenpag;
    private Estadoordenpag estadoordenpag;

    public List<Estadoordenpag> getListaEstadoordenpag() {
        this.listaEstadoordenpag = this.estadoordenpagFacade.findAll();
        return listaEstadoordenpag;
    }

    public void setListaEstadoordenpag(List<Estadoordenpag> listaEstadoordenpag) {
        this.listaEstadoordenpag = listaEstadoordenpag;
    }

    public Estadoordenpag getEstadoordenpag() {
        return estadoordenpag;
    }

    public void setEstadoordenpag(Estadoordenpag estadoordenpag) {
        this.estadoordenpag = estadoordenpag;
    }
    
    @PostConstruct
    public void init(){
        this.estadoordenpag = new Estadoordenpag();
}
}
