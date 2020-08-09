/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tvehiculo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Julian Camilo
 */
@Stateless
public class TvehiculoFacade extends AbstractFacade<Tvehiculo> implements TvehiculoFacadeLocal {

    @PersistenceContext(unitName = "BraintecProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TvehiculoFacade() {
        super(Tvehiculo.class);
    }
    
}
