/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TdocumentoFacadeLocal;
import Entity.Tdocumento;
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
public class mbeanTdocumento implements Serializable{
    
    @EJB
    private TdocumentoFacadeLocal tdocumentoFacade;
    private List<Tdocumento> listaTdocumento;
    private Tdocumento tdocumento;

    public List<Tdocumento> getListaTdocumento() {
        this.listaTdocumento = this.tdocumentoFacade.findAll();
        return listaTdocumento;
    }

    public void setListaTdocumento(List<Tdocumento> listaTdocumento) {
        this.listaTdocumento = listaTdocumento;
    }

    public Tdocumento getTdocumento() {
        return tdocumento;
    }

    public void setTdocumento(Tdocumento tdocumento) {
        this.tdocumento = tdocumento;
    }
    
    @PostConstruct
    public void init(){
        this.tdocumento = new Tdocumento();
    }
}
