/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TcategoriaFacadeLocal;
import Entity.Tcategoria;
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
public class mbeanTcategoria implements Serializable{
    
    @EJB
    private TcategoriaFacadeLocal tcategoriaFacade;
    private List<Tcategoria> listaTcategoria;
    private Tcategoria tcategoria;

    public List<Tcategoria> getListaTcategoria() {
        this.listaTcategoria = this.tcategoriaFacade.findAll();
        return listaTcategoria;
    }

    public void setListaTcategoria(List<Tcategoria> listaTcategoria) {
        this.listaTcategoria = listaTcategoria;
    }

    public Tcategoria getTcategoria() {
        return tcategoria;
    }

    public void setTcategoria(Tcategoria tcategoria) {
        this.tcategoria = tcategoria;
    }
    
    @PostConstruct
    public void init(){
        this.tcategoria = new Tcategoria();
    }
}
