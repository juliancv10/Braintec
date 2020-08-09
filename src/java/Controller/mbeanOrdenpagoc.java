/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.OrdenpagocFacadeLocal;
import Entity.Estadoordenpag;
import Entity.Ordenpagoc;
import Entity.Ordenpedido;
import Entity.Ordenservicio;
import Entity.Tusuario;
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
public class mbeanOrdenpagoc implements Serializable{
    @EJB
    private OrdenpagocFacadeLocal ordenpagocFacade;
    private List<Ordenpagoc> listaOrdenpagoc;
    private Ordenpagoc ordenpagoc;
    private Tusuario tusuario;
    private Ordenpedido ordenpedido;
    private Ordenservicio ordenservicio;
    private Estadoordenpag estadoordenpag;

    public List<Ordenpagoc> getListaOrdenpagoc() {
        this.listaOrdenpagoc = this.ordenpagocFacade.findAll();
        return listaOrdenpagoc;
    }

    public void setListaOrdenpagoc(List<Ordenpagoc> listaOrdenpagoc) {
        this.listaOrdenpagoc = listaOrdenpagoc;
    }

    public Ordenpagoc getOrdenpagoc() {
        return ordenpagoc;
    }

    public void setOrdenpagoc(Ordenpagoc ordenpagoc) {
        this.ordenpagoc = ordenpagoc;
    }

    public Tusuario getTusuario() {
        return tusuario;
    }

    public void setTusuario(Tusuario tusuario) {
        this.tusuario = tusuario;
    }

    public Ordenpedido getOrdenpedido() {
        return ordenpedido;
    }

    public void setOrdenpedido(Ordenpedido ordenpedido) {
        this.ordenpedido = ordenpedido;
    }

    public Ordenservicio getOrdenservicio() {
        return ordenservicio;
    }

    public void setOrdenservicio(Ordenservicio ordenservicio) {
        this.ordenservicio = ordenservicio;
    }

    public Estadoordenpag getEstadoordenpag() {
        return estadoordenpag;
    }

    public void setEstadoordenpag(Estadoordenpag estadoordenpag) {
        this.estadoordenpag = estadoordenpag;
    }
    
    @PostConstruct
    public void init (){
        this.ordenpagoc = new Ordenpagoc();
        this.tusuario = new Tusuario();
        this.ordenpedido = new Ordenpedido();
        this.ordenservicio = new Ordenservicio();
        this.estadoordenpag = new Estadoordenpag();
    }
}
