/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tcategoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Julian Camilo
 */
@Stateless
public class TcategoriaFacade extends AbstractFacade<Tcategoria> implements TcategoriaFacadeLocal {

    @PersistenceContext(unitName = "BraintecProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TcategoriaFacade() {
        super(Tcategoria.class);
    }
    
}
