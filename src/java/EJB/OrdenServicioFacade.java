/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.OrdenServicio;
import Entity.OrdenServicio_;
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
public class OrdenServicioFacade extends AbstractFacade<OrdenServicio> implements OrdenServicioFacadeLocal {

    @PersistenceContext(unitName = "BraintecProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenServicioFacade() {
        super(OrdenServicio.class);
    }
    
    @Override
    public List<OrdenServicio> listarOrdServ() {

        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<OrdenServicio> query = qb.createQuery(OrdenServicio.class);
        Root<OrdenServicio> entidad = query.from(OrdenServicio.class);
        query.where(
                qb.equal(entidad.get(OrdenServicio_.estado), true)
        );
        // query.orderBy(qb.asc(cab.get(Tracabventas_.fecregistro)));
        List<OrdenServicio> result = em.createQuery(query).getResultList();
        return result;

    }
    
        @Override
    public List<OrdenServicio> listarCerrado() {

        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<OrdenServicio> query = qb.createQuery(OrdenServicio.class);
        Root<OrdenServicio> entidad = query.from(OrdenServicio.class);
        query.where(
                qb.equal(entidad.get(OrdenServicio_.estado), false)
        );
        // query.orderBy(qb.asc(cab.get(Tracabventas_.fecregistro)));
        List<OrdenServicio> result = em.createQuery(query).getResultList();
        return result;

    }

    
}
