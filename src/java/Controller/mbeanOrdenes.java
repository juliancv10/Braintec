/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.OrdendetalleFacadeLocal;
import EJB.OrdenmaestroFacadeLocal;
import EJB.TproservFacadeLocal;
import EJB.TusuarioFacadeLocal;

import Entity.Tusuario;
import Entity.Ordendetalle;
import Entity.Ordenmaestro;
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
public class mbeanOrdenes implements Serializable {

    @EJB
    private OrdenmaestroFacadeLocal facadeOrdenmaestro;

    @EJB
    private OrdendetalleFacadeLocal facadeOrdendetalle;

    private List<Ordenmaestro> listaOrdenM;

    private List<Ordenmaestro> listarTodasOM;

    @EJB
    private TproservFacadeLocal facadeProserv;

    @EJB
    private TusuarioFacadeLocal facadeTusuario;

    private List<Tproserv> proserv;
    private List<Tusuario> usuarios;

    private Tusuario usuario;
    private Ordendetalle detalleActual;
    private List<Ordendetalle> detalleGuardar = new LinkedList<>();
    private String ordenActual;
    private Date fechaOrden;
    private Double totalOrdenm;

    private List<Ordendetalle> detalleOrdenListar = new LinkedList<>();

    public static void addInfoMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
    }

    public static void addErrorMessageTitle(String title, String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, msg));
    }

    public List<Ordenmaestro> getListarTodasOM() {
        this.listarTodasOM = this.facadeOrdenmaestro.findAll();
        return listarTodasOM;
    }

    public void setListarTodasOM(List<Ordenmaestro> listarTodasOM) {
        this.listarTodasOM = listarTodasOM;
    }

    //    private List<Ordenmaestro>
    public List<Ordenmaestro> getListaOrdenM() {
        this.listaOrdenM = this.facadeOrdenmaestro.listarActivos();
        return listaOrdenM;
    }

    public void setListaOrdenM(List<Ordenmaestro> listaOrdenM) {
        this.listaOrdenM = listaOrdenM;
    }

    public String getOrdenActual() {
        return ordenActual;
    }

    public void setOrdenActual(String ordenActual) {
        this.ordenActual = ordenActual;
    }

    public List<Tproserv> getProserv() {
        return proserv;
    }

    public void setProserv(List<Tproserv> proserv) {
        this.proserv = proserv;
    }

    public List<Tusuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Tusuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Tusuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Tusuario usuario) {
        this.usuario = usuario;
    }

    public Ordendetalle getDetalleActual() {
        return detalleActual;
    }

    public void setDetalleActual(Ordendetalle detalleActual) {
        this.detalleActual = detalleActual;
    }

    public List<Ordendetalle> getDetalleGuardar() {
        //   this.detalleGuardar = this.facadeOrdendetalle.findAll();
        return detalleGuardar;
    }

    public void setDetalleGuardar(List<Ordendetalle> detalleGuardar) {
        this.detalleGuardar = detalleGuardar;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Double getTotalOrdenm() {
        return totalOrdenm;
    }

    public void setTotalOrdenm(Double totalOrdenm) {
        this.totalOrdenm = totalOrdenm;
    }

    public List<Ordendetalle> getDetalleOrdenListar() {
        return detalleOrdenListar;
    }

    public void setDetalleOrdenListar(List<Ordendetalle> detalleOrdenListar) {
        this.detalleOrdenListar = detalleOrdenListar;
    }

    public void listardetop(Ordenmaestro op) {
        detalleOrdenListar = facadeOrdendetalle.listarOrdes(op);
    }

    @PostConstruct
    public void init() {
        usuario = new Tusuario();
        detalleActual = new Ordendetalle();

        detalleActual.setCantidad(0);
        proserv = facadeProserv.findAll();
        usuarios = facadeTusuario.findAll();
    }

    public void agregarDetalle() {

        Ordendetalle dg = new Ordendetalle();
        dg = detalleActual;

        if (dg != null && dg.getTproserv().getPrecio() != null && dg.getTproserv() != null && dg.getCantidad() != null
                && dg.getCantidad() > dg.getTproserv().getCantidad() && !dg.getTproserv().getTcategoria().getCategoriarepuesto().equals("Servicios")) {
            addErrorMessageTitle("Error", "No existe inventario para la cantidad seleccionada");
            return;
        }

        dg.setPrecioUnitario(dg.getTproserv().getPrecio());
        dg.setTotal(dg.getTproserv().getPrecio() * dg.getCantidad());

        //TotalMonto
        detalleGuardar.add(dg);
        detalleActual = new Ordendetalle();

    }

    public void guardar() {
        Ordenmaestro orden = new Ordenmaestro();
        orden.setTusuario(usuario);
        orden.setFecha(Calendar.getInstance().getTime());
        orden.setPagado(false);
        facadeOrdenmaestro.create(orden);
        Double monto = 0D;
        for (Ordendetalle d : detalleGuardar) {
            d.setOrdenmaestro(orden);
            d.setTotal(d.getCantidad() * d.getPrecioUnitario());
            d.setFecha(Calendar.getInstance().getTime());
            monto += d.getTotal();
            d.setActivo(true);
            facadeOrdendetalle.create(d);
            Tproserv p = d.getTproserv();
            p.setCantidad(p.getCantidad() - d.getCantidad());
            facadeProserv.edit(p);
        }
        orden.setActivo(true);
        orden.setMonto(monto);
        facadeOrdenmaestro.edit(orden);
        ordenActual = "" + orden.getIdocabecera();
        fechaOrden = orden.getFecha();
        totalOrdenm = orden.getMonto();

        addInfoMessage("Guardado!", "Información guardada satisfactoriamente, se creó la orden: " + orden.getIdocabecera());
    }

    public void limpiarop() {
        detalleGuardar = new LinkedList<>();
        proserv = new LinkedList<>();
        usuario = new Tusuario();
        fechaOrden = new Date();
        totalOrdenm = new Double(0);
        ordenActual = new String("");
    }

    public void eliminarOM(Ordenmaestro m) {

        List<Ordendetalle> detalleEliminar = facadeOrdendetalle.listarOrdes(m);
        for (Ordendetalle d : detalleEliminar) {
            Tproserv p = d.getTproserv();
            if (!p.getTcategoria().getCategoriarepuesto().equals("Servicios")) {
                p.setCantidad(p.getCantidad() + d.getCantidad());
                facadeProserv.edit(p);
            }
            d.setActivo(false);
            facadeOrdendetalle.edit(d);
        }
        m.setActivo(false);
        facadeOrdenmaestro.edit(m);
        listaOrdenM = facadeOrdenmaestro.listarActivos();
        addInfoMessage("Aviso!", "Se ha cancelado la Orden Seleccionada");
    }

    public void eliminarItem(Ordendetalle d) {
        Ordenmaestro o = d.getOrdenmaestro();
        Tproserv p = d.getTproserv();
        if (!p.getTcategoria().getCategoriarepuesto().equals("Servicios")) {
            p.setCantidad(p.getCantidad() + d.getCantidad());
            facadeProserv.edit(p);
        }
        o.setMonto(o.getMonto() - d.getTotal());
        facadeOrdenmaestro.edit(o);
        d.setActivo(false);
        facadeOrdendetalle.edit(d);
        detalleOrdenListar = facadeOrdendetalle.listarOrdes(d.getOrdenmaestro());
        addInfoMessage("Guardado!", "Se ha cancelado el item de la Orden:" + o.getIdocabecera());
    }

}
