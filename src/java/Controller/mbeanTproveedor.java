/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TproveedorFacadeLocal;
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
public class mbeanTproveedor implements Serializable{
    
    @EJB
    private TproveedorFacadeLocal tproveedorFacade;
    private List<Tproveedor> listaTproveedor;
    private Tproveedor tproveedor;

    public List<Tproveedor> getListaTproveedor() {
        this.listaTproveedor = this.tproveedorFacade.findAll();
        return listaTproveedor;
    }

    public void setListaTproveedor(List<Tproveedor> listaTproveedor) {
        this.listaTproveedor = listaTproveedor;
    }

    public Tproveedor getTproveedor() {
        return tproveedor;
    }

    public void setTproveedor(Tproveedor tproveedor) {
        this.tproveedor = tproveedor;
    }
    
    @PostConstruct
    public void init(){
        this.tproveedor = new Tproveedor();
       
    }
}
