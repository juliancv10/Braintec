/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.MenuUsuarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Julian Camilo
 */
@Stateless
public class MenuUsuariosFacade extends AbstractFacade<MenuUsuarios> implements MenuUsuariosFacadeLocal {

    @PersistenceContext(unitName = "BraintecProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuUsuariosFacade() {
        super(MenuUsuarios.class);
    }
    
}
