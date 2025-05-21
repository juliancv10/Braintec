/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.OrdenmaestroFacadeLocal;
import EJB.RemisionFacadeLocal;
import EJB.RemisiondetalleFacadeLocal;
import EJB.TproservFacadeLocal;
import Entity.Ordenmaestro;
import Entity.Remision;
import Entity.Remisiondetalle;
import Entity.Tproserv;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
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
public class mbeanRemision implements Serializable {

    @EJB
    private RemisionFacadeLocal facadeRemision;

    @EJB
    private RemisiondetalleFacadeLocal facadeDetalleremision;

    @EJB
    private TproservFacadeLocal facadeProserv;

    @EJB
    private OrdenmaestroFacadeLocal facadeOrdenmaestro;

    private List<Remision> listaRemision;
    private List<Tproserv> listproserv;
    private List<Ordenmaestro> listaOrdMa;
    private Ordenmaestro omaestro;
    private Remisiondetalle detalleActRem;
    private List<Remisiondetalle> detalleGuardarRem = new LinkedList<>();
    private String remisionActual;
    private Date fechaRemision;
    private List<Remisiondetalle> detalleRemListar = new LinkedList<>();

    public List<Remision> getListaRemision() {
        this.listaRemision = this.facadeRemision.listarRemAct();
        return listaRemision;
    }

    public void setListaRemision(List<Remision> listaRemision) {
        this.listaRemision = listaRemision;
    }

    public List<Tproserv> getListproserv() {
        return listproserv;
    }

    public void setListproserv(List<Tproserv> listproserv) {
        this.listproserv = listproserv;
    }

    public List<Ordenmaestro> getListaOrdMa() {
        return listaOrdMa;
    }

    public void setListaOrdMa(List<Ordenmaestro> listaOrdMa) {
        this.listaOrdMa = listaOrdMa;
    }

    public Ordenmaestro getOmaestro() {
        return omaestro;
    }

    public void setOmaestro(Ordenmaestro omaestro) {
        this.omaestro = omaestro;
    }

    public Remisiondetalle getDetalleActRem() {
        return detalleActRem;
    }

    public void setDetalleActRem(Remisiondetalle detalleActRem) {
        this.detalleActRem = detalleActRem;
    }

    public List<Remisiondetalle> getDetalleGuardarRem() {
        return detalleGuardarRem;
    }

    public void setDetalleGuardarRem(List<Remisiondetalle> detalleGuardarRem) {
        this.detalleGuardarRem = detalleGuardarRem;
    }

    public String getRemisionActual() {
        return remisionActual;
    }

    public void setRemisionActual(String remisionActual) {
        this.remisionActual = remisionActual;
    }

    public Date getFechaRemision() {
        return fechaRemision;
    }

    public void setFechaRemision(Date fechaRemision) {
        this.fechaRemision = fechaRemision;
    }

    public List<Remisiondetalle> getDetalleRemListar() {
        return detalleRemListar;
    }

    public void setDetalleRemListar(List<Remisiondetalle> detalleRemListar) {
        this.detalleRemListar = detalleRemListar;
    }
    
    public void listardetremop(Remision op){
        detalleRemListar = facadeDetalleremision.listarRem(op);
    }
    

    @PostConstruct
    public void init() {
        detalleActRem = new Remisiondetalle();
        detalleActRem.setCantidad(0);
        listproserv = facadeProserv.listarRep();
        listaOrdMa = facadeOrdenmaestro.listarActivos();
    }

    public void agregarItems() {
        Remisiondetalle dr = new Remisiondetalle();
        dr = detalleActRem;

        if (dr != null && dr.getTproserv().getPrecio() != null && dr.getTproserv() != null && dr.getCantidad() != null
                && dr.getCantidad() > dr.getTproserv().getCantidad() && !dr.getTproserv().getTcategoria().getCategoriarepuesto().equals("Servicios")) {
            addErrorMessageTitle("Error", "No existe inventario para la cantidad seleccionada");
            return;
        }

        detalleGuardarRem.add(dr);
        detalleActRem = new Remisiondetalle();
    }

    public void guardarRem() {
        Remision rem = new Remision();
        rem.setOrdenmaestro(omaestro);
        rem.setFecharem(Calendar.getInstance().getTime());
        facadeRemision.create(rem);
        for (Remisiondetalle g : detalleGuardarRem) {
            g.setRemision(rem);
            g.setFechadet(Calendar.getInstance().getTime());
            g.setEstado(true);
            facadeDetalleremision.create(g);
        }
        rem.setEstado(true);
        facadeRemision.edit(rem);
        remisionActual = " " + rem.getIdremision();
        fechaRemision = rem.getFecharem();
        addInfoMessage("Guardado!", "Información guardada satisfactoriamente, numero de Remisión: " + rem.getIdremision());
    }

    public void limpiarop() {
        detalleGuardarRem = new LinkedList<>();
        listproserv = new LinkedList<>();
        omaestro = new Ordenmaestro();
        remisionActual = new String("");
        fechaRemision = new Date();
    }


    public void eliminarRem(Remision m) {
        List<Remisiondetalle> detremEliminar = facadeDetalleremision.listarRem(m);
        for (Remisiondetalle d : detremEliminar) {
            d.setEstado(false);
            facadeDetalleremision.edit(d);
        }
        m.setEstado(false);
        facadeRemision.edit(m);
        listaRemision = facadeRemision.listarRemAct();
        addInfoMessage("Aviso!", "Se ha cancelado la Remision Seleccionada");
    }

    public void eliminarItemRem(Remisiondetalle m){
        Remision r = m.getRemision();
        facadeRemision.edit(r);
        r.setEstado(false);
        facadeDetalleremision.edit(m);
        detalleRemListar = facadeDetalleremision.listarRem(m.getRemision());
        addInfoMessage("Guardado!", "Se ha cancelado el item de la Orden:" + r.getIdremision());
    }
    
    
    //MENSAJES
    public static void addInfoMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
    }

    public static void addErrorMessageTitle(String title, String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg));
    }
}
