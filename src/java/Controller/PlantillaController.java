/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Templeado;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Julian Camilo
 */
@Named
@ViewScoped
public class PlantillaController implements Serializable{
    
    public void verificarSesion(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Templeado us = (Templeado) context.getExternalContext().getSessionMap().get("templeado");
            if (us ==null){
                context.getExternalContext().redirect("./../permisos.xhtml");
            }
        
        }catch (Exception e) { 
            
        }
    }
}
