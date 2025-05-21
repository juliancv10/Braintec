/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tcategoria;
import Entity.Tproserv;
import Entity.Tproserv_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Julian Camilo
 */
@Stateless
public class TproservFacade extends AbstractFacade<Tproserv> implements TproservFacadeLocal {

    @PersistenceContext(unitName = "BraintecProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TproservFacade() {
        super(Tproserv.class);
    }
    
    @Override
    public List<Tproserv> listarRep() {

        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Tproserv> query = qb.createQuery(Tproserv.class);
        Root<Tproserv> entidad = query.from(Tproserv.class);
        query.where(
                qb.equal(entidad.get(Tproserv_.tcategoria), new Tcategoria(2)),
                qb.equal(entidad.get(Tproserv_.estado), true)
        );
        // query.orderBy(qb.asc(cab.get(Tracabventas_.fecregistro)));
        List<Tproserv> result = em.createQuery(query).getResultList();
        return result;

    }

    @Override
    public List<Tproserv> listarServ() {

        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Tproserv> query = qb.createQuery(Tproserv.class);
        Root<Tproserv> entidad = query.from(Tproserv.class);
        query.where(
                qb.equal(entidad.get(Tproserv_.tcategoria), new Tcategoria(1)),
                qb.equal(entidad.get(Tproserv_.estado), true)
        );
        // query.orderBy(qb.asc(cab.get(Tracabventas_.fecregistro)));
        List<Tproserv> result = em.createQuery(query).getResultList();
        return result;

    }

}
