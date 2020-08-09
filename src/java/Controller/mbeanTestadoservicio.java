/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TestadoservicioFacadeLocal;
import Entity.Testadoservicio;
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
public class mbeanTestadoservicio implements Serializable{
    
    @EJB
    private TestadoservicioFacadeLocal testadoservicioFacade;
    private List<Testadoservicio> listaTestadoservicio;
    private Testadoservicio testadoservicio;

    public List<Testadoservicio> getListaTestadoservicio() {
        this.listaTestadoservicio = this.testadoservicioFacade.findAll();
        return listaTestadoservicio;
    }

    public void setListaTestadoservicio(List<Testadoservicio> listaTestadoservicio) {
        this.listaTestadoservicio = listaTestadoservicio;
    }

    public Testadoservicio getTestadoservicio() {
        return testadoservicio;
    }

    public void setTestadoservicio(Testadoservicio testadoservicio) {
        this.testadoservicio = testadoservicio;
    }
    
    @PostConstruct
    public void init(){
        this.testadoservicio = new Testadoservicio();
    }
}
