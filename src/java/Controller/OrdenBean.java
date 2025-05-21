/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Ordendetalle;
import Entity.Ordenmaestro;
import Entity.Tproserv;
import Entity.Tusuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Julian Camilo
 */

@ManagedBean
@ViewScoped
public class OrdenBean implements Serializable{
    
    private Ordenmaestro ordenmaestro = new Ordenmaestro();

    private Tusuario tusuario = new Tusuario();
    
    private Tproserv tproserv = new Tproserv();
    
    private Integer cantidad;
    
    private List<Ordendetalle> listadetalle = new ArrayList();

    public Ordenmaestro getOrdenmaestro() {
        return ordenmaestro;
    }

    public void setOrdenmaestro(Ordenmaestro ordenmaestro) {
        this.ordenmaestro = ordenmaestro;
    }

    public Tusuario getTusuario() {
        return tusuario;
    }

    public void setTusuario(Tusuario tusuario) {
        this.tusuario = tusuario;
    }

    public Tproserv getTproserv() {
        return tproserv;
    }

    public void setTproserv(Tproserv tproserv) {
        this.tproserv = tproserv;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<Ordendetalle> getListadetalle() {
        return listadetalle;
    }

    public void setListadetalle(List<Ordendetalle> listadetalle) {
        this.listadetalle = listadetalle;
    }

    
    
    public void agregar(){
        Ordendetalle detalle = new Ordendetalle();
        detalle.setCantidad(cantidad);
        detalle.setTproserv(tproserv);
        this.listadetalle.add(detalle);
    }
    
    public void registrar(){
        try {
            
        } catch (Exception e) {
        }
      
}
}
