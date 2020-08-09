/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Estadoordenpag;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Julian Camilo
 */
@Stateless
public class EstadoordenpagFacade extends AbstractFacade<Estadoordenpag> implements EstadoordenpagFacadeLocal {

    @PersistenceContext(unitName = "BraintecProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoordenpagFacade() {
        super(Estadoordenpag.class);
    }
    
}
