/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TrolesFacadeLocal;
import Entity.Troles;
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
public class mbeanTroles implements Serializable{
    
    @EJB
    private TrolesFacadeLocal trolesFacade;
    private List<Troles> listaTroles;
    private Troles troles;

    public List<Troles> getListaTroles() {
        this.listaTroles = this.trolesFacade.findAll();
        return listaTroles;
    }

    public void setListaTroles(List<Troles> listaTroles) {
        this.listaTroles = listaTroles;
    }

    public Troles getTroles() {
        return troles;
    }

    public void setTroles(Troles troles) {
        this.troles = troles;
    }
    
    @PostConstruct
    public void init(){
        this.troles = new Troles();
    }
}
