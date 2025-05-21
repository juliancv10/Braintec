/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.OrdenServicioFacadeLocal;
import Entity.OrdenServicio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Julian Camilo
 */

@ManagedBean
@SessionScoped
public class graficoTaller implements Serializable{
    
    @EJB
    private OrdenServicioFacadeLocal ordenservFacade;
    
    private List<OrdenServicio> listadoOrdServ;
    
    private PieChartModel pieModel;
    
    private int cantidadOrd;

    public List<OrdenServicio> getListadoOrdServ() {
        this.listadoOrdServ = this.ordenservFacade.listarOrdServ();
        return listadoOrdServ;
    }

    public void setListadoOrdServ(List<OrdenServicio> listadoOrdServ) {
        this.listadoOrdServ = listadoOrdServ;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
    
    public void graficar (List<OrdenServicio> listadoOrdServ){
        pieModel = new PieChartModel();
        
        for(OrdenServicio ord : listadoOrdServ){
            //pieModel.set(ord.getPrioridad()), ord.getIdcaso());
        }
    }
}
