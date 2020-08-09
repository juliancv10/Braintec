/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TservicioFacadeLocal;
import Entity.Tservicio;
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
public class mbeanTservicio implements Serializable{
    
    @EJB
    private TservicioFacadeLocal tservicioFacade;
    private List<Tservicio> listaTservicio;
    private Tservicio tservicio;

    public List<Tservicio> getListaTservicio() {
        this.listaTservicio = this.tservicioFacade.findAll();
        return listaTservicio;
    }

    public void setListaTservicio(List<Tservicio> listaTservicio) {
        this.listaTservicio = listaTservicio;
    }

    public Tservicio getTservicio() {
        return tservicio;
    }

    public void setTservicio(Tservicio tservicio) {
        this.tservicio = tservicio;
    }
    
    @PostConstruct
    public void init(){
        this.tservicio = new Tservicio();
    }
}
