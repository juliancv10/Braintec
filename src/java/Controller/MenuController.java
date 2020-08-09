/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.MenuUsuariosFacadeLocal;
import Entity.MenuUsuarios;
import Entity.Templeado;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author Julian Camilo
 */
@Named
@SessionScoped
public class MenuController implements Serializable {

    @EJB
    private MenuUsuariosFacadeLocal EJBMenu;
    private List<MenuUsuarios> listaMenu;
    private MenuModel model;

    @PostConstruct
    public void init() {
        this.listarMenus();
        model = new DefaultMenuModel();
        this.establecerPermisos();
    }

    public void listarMenus() {
        try {
            listaMenu = EJBMenu.findAll();
        } catch (Exception e) {
        }

    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public void establecerPermisos() {
        Templeado us = (Templeado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("templeado");
        
        for (MenuUsuarios m : listaMenu) {
            if (m.getTipomenu().equals("S") && m.getIdroles().equals(us.getTroles())) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getMnombre());
                for (MenuUsuarios i : listaMenu) {
                    MenuUsuarios Codigosubmenu = i.getCodigosubmenu();
                    if (Codigosubmenu != null) {
                        if (Codigosubmenu.getMcodigo() == m.getMcodigo()) {
                            DefaultMenuItem item = new DefaultMenuItem(i.getMnombre());
                            item.setUrl(i.getUrl());
                            firstSubmenu.addElement(item);
                        }
                    }
                }
                model.addElement(firstSubmenu);
            } else {
                if (m.getCodigosubmenu() == null && m.getIdroles().equals(us.getTroles())) {
                    DefaultMenuItem item = new DefaultMenuItem(m.getMnombre());
                    item.setUrl(m.getUrl());
                    model.addElement(item);
                }
            }
        }
    }
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
