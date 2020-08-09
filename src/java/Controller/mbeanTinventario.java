/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TinventarioFacadeLocal;
import Entity.Tcategoria;
import Entity.Tinventario;
import Entity.Tproveedor;
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
public class mbeanTinventario implements Serializable{
    
    @EJB
    private TinventarioFacadeLocal tinventarioFacade;
    private List<Tinventario> listaTinventario;
    private Tinventario tinventario;
    private Tcategoria tcategoria;
    private Tproveedor tproveedor;

    public List<Tinventario> getListaTinventario() {
        this.listaTinventario = this.tinventarioFacade.findAll();
        return listaTinventario;
    }

    public void setListaTinventario(List<Tinventario> listaTinventario) {
        this.listaTinventario = listaTinventario;
    }

    public Tinventario getTinventario() {
        return tinventario;
    }

    public void setTinventario(Tinventario tinventario) {
        this.tinventario = tinventario;
    }

    public Tcategoria getTcategoria() {
        return tcategoria;
    }

    public void setTcategoria(Tcategoria tcategoria) {
        this.tcategoria = tcategoria;
    }

    public Tproveedor getTproveedor() {
        return tproveedor;
    }

    public void setTproveedor(Tproveedor tproveedor) {
        this.tproveedor = tproveedor;
    }
    
    @PostConstruct
    public void init(){
        this.tinventario = new Tinventario();
        this.tcategoria = new Tcategoria();
        this.tproveedor = new Tproveedor();
    }
}
