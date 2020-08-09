/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import EJB.MenuUsuariosFacadeLocal;
import Entity.MenuUsuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
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
public class mbeanMenuUsuario implements Serializable {

    @EJB
    private MenuUsuariosFacadeLocal menuusuariosFacade;
    private List<MenuUsuarios> listaMenuUsuarios;
    private MenuModel model;

    @PostConstruct
    public void init() {
        this.listarMenus();
        model = new DefaultMenuModel();
        this.establecerpermisos();
    }

    public void listarMenus() {
        try {
            listaMenuUsuarios = menuusuariosFacade.findAll();
        } catch (Exception e) {
        }
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }

    public void establecerpermisos() {
        for (MenuUsuarios m : listaMenuUsuarios) {
            if (m.getTipomenu().equals("S")) {
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getMnombre());
                for (MenuUsuarios i : listaMenuUsuarios) {
                    MenuUsuarios codigosubmenu = i.getCodigosubmenu();
                    if (codigosubmenu != null) {
                        if (codigosubmenu.getMcodigo() == m.getMcodigo()) {
                            DefaultMenuItem item = new DefaultMenuItem(i.getMnombre());
                            firstSubmenu.addElement(item);
                        }
                    }
                }
                model.addElement(firstSubmenu);
            } else {
                if (m.getCodigosubmenu() == null) {
                    DefaultMenuItem item = new DefaultMenuItem(m.getMnombre());
                    model.addElement(item);
                }
            }

        }
    }
}
