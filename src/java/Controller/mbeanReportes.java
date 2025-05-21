/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.OrdenmaestroFacadeLocal;
import Entity.Ordenmaestro;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Julian Camilo
 */
@ManagedBean
@SessionScoped
public class mbeanReportes implements Serializable{

    @EJB
    private OrdenmaestroFacadeLocal ordenmFacade;
    
    private List<Ordenmaestro> listado;
    
    private BarChartModel bar;
    
    public mbeanReportes() {
    }
    
    public void listarOrM(){
        listado=ordenmFacade.listarOM();
        graficar();
    }

    public List<Ordenmaestro> getListado() {
        return listado;
    }

    public void setListado(List<Ordenmaestro> listado) {
        this.listado = listado;
    }

    public BarChartModel getBar() {
        return bar;
    }

    public void setBar(BarChartModel bar) {
        this.bar = bar;
    }
    
    
    
    public void graficar(){
        bar = new BarChartModel();
        
        for(int i=0; i<ordenmFacade.listarOM().size(); i++){
            ChartSeries serie = new BarChartSeries();
        serie.setLabel(ordenmFacade.listarOM().get(i).getObservaciones());
        serie.set(ordenmFacade.listarOM().get(i).getObservaciones(),ordenmFacade.listarOM().get(i).getMonto());
        bar.addSeries(serie);
        }
        bar.setTitle(">>>>>>>>");
        bar.setLegendPosition("ne");
        bar.setAnimate(true);
        
        Axis xAxis = bar.getAxis(AxisType.X);
        xAxis.setLabel("OBS");
        Axis yAxis=bar.getAxis(AxisType.Y);
        yAxis.setLabel("Ordenes");
        yAxis.setMin(10000);
        yAxis.setMax(1000000);
        
    }
}
