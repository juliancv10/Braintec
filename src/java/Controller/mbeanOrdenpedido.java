/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.OrdenpedidoFacadeLocal;
import Entity.Estadoordenped;
import Entity.Ordenpedido;
import Entity.Tinventario;
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
public class mbeanOrdenpedido implements Serializable{
    
    @EJB
    private OrdenpedidoFacadeLocal ordenpedidoFacade;
    private List<Ordenpedido> listaOrdenpedido;
    private Ordenpedido ordenpedido;
    private Tusuario tusuario;
    private Tinventario tinventario;
    private Estadoordenped estadoordenped;

    public List<Ordenpedido> getListaOrdenpedido() {
        this.listaOrdenpedido = this.ordenpedidoFacade.findAll();
        return listaOrdenpedido;
    }

    public void setListaOrdenpedido(List<Ordenpedido> listaOrdenpedido) {
        this.listaOrdenpedido = listaOrdenpedido;
    }

    public Ordenpedido getOrdenpedido() {
        return ordenpedido;
    }

    public void setOrdenpedido(Ordenpedido ordenpedido) {
        this.ordenpedido = ordenpedido;
    }

    public Tusuario getTusuario() {
        return tusuario;
    }

    public void setTusuario(Tusuario tusuario) {
        this.tusuario = tusuario;
    }

    public Tinventario getTinventario() {
        return tinventario;
    }

    public void setTinventario(Tinventario tinventario) {
        this.tinventario = tinventario;
    }

    public Estadoordenped getEstadoordenped() {
        return estadoordenped;
    }

    public void setEstadoordenped(Estadoordenped estadoordenped) {
        this.estadoordenped = estadoordenped;
    }
    
    @PostConstruct
    public void init (){
        this.ordenpedido = new Ordenpedido();
        this.tusuario = new Tusuario();
        this.tinventario = new Tinventario();
        this.estadoordenped = new Estadoordenped();
    }
}
