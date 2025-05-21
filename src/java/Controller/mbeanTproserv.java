/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.TproservFacadeLocal;
import Entity.Tcategoria;
import Entity.Tproserv;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Julian Camilo
 */
@ManagedBean
@SessionScoped
public class mbeanTproserv implements Serializable {

    @EJB
    private TproservFacadeLocal tproservFacade;
    private List<Tproserv> listaTproserv;
    private List<Tproserv> listaServicio;
    private List<Tproserv> listarPS;

    private Tproserv tproserv;
    private Tcategoria tcategoria;
    private String msj;

    private Integer idProducto;
    private Integer cantidad;

    public List<Tproserv> getListarPS() {
        this.listarPS = this.tproservFacade.findAll();
        return listarPS;
    }

    public void setListarPS(List<Tproserv> listarPS) {
        this.listarPS = listarPS;
    }

    public List<Tproserv> getListaServicio() {
        this.listaServicio = this.tproservFacade.listarServ();
        return listaServicio;
    }

    public void setListaServicio(List<Tproserv> listaServicio) {
        this.listaServicio = listaServicio;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<Tproserv> getListaTproserv() {
        this.listaTproserv = this.tproservFacade.listarRep();
        return listaTproserv;
    }

    public void setListaTproserv(List<Tproserv> listaTproserv) {
        this.listaTproserv = listaTproserv;
    }

    public Tproserv getTproserv() {
        return tproserv;
    }

    public void setTproserv(Tproserv tproserv) {
        this.tproserv = tproserv;
    }

    public Tcategoria getTcategoria() {
        return tcategoria;
    }

    public void setTcategoria(Tcategoria tcategoria) {
        this.tcategoria = tcategoria;
    }

    @PostConstruct
    public void init() {
        this.tproserv = new Tproserv();
        this.tcategoria = new Tcategoria();
    }

    public void guardar() {
        try {
            this.tproserv.setTcategoria(tcategoria);
            this.tproserv.setEstado(true);
            tproserv.setCantidad(0);
            this.tproservFacade.create(tproserv);
            this.msj = "Se ha generado el registro correctamente";
            this.tproserv = new Tproserv();
            this.tcategoria = new Tcategoria();

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error, los datos ingresados son incorrectos" + e.getMessage();
        }

        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);

    }

    public void actualizar() {
        try {
            this.tproserv.setTcategoria(tcategoria);
            this.tproservFacade.edit(tproserv);
            this.msj = "Registro Actualizado correctamente";
            this.tproserv = new Tproserv();
            this.tcategoria = new Tcategoria();

        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void eliminar(Tproserv eli) {
        try {
            this.tproservFacade.remove(eli);
            this.msj = "Registro Eliminado Correctamente";
        } catch (Exception e) {
            e.printStackTrace();
            this.msj = "Error" + e.getMessage();
        }
        FacesMessage mensaje = new FacesMessage(this.msj);
        FacesContext.getCurrentInstance().addMessage(null, mensaje);
    }

    public void editardatos(Tproserv ed) {
        this.tcategoria.setIdcategoria(ed.getTcategoria().getIdcategoria());
        this.tproserv = ed;
    }

    public void limpiar() {
        this.tproserv = new Tproserv();
        this.tcategoria = new Tcategoria();
    }

    public void ingresoAlma() {

        if (cantidad > 0) {
            Tproserv producto = tproservFacade.find(idProducto);
            producto.setCantidad(producto.getCantidad() + cantidad);
            tproservFacade.edit(producto);
            

        } else {

            FacesMessage mensaje = new FacesMessage("No se aceptan valores negativos");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
        addInfoMessage("Exito!", "Ingreso guardado satisfactoriamente");
    }

    public static void addInfoMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
    }

    public static void addErrorMessageTitle(String title, String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg));
    }
}
