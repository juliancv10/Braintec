/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Remision;
import Entity.Remisiondetalle;
import Entity.Remisiondetalle_;
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
public class RemisiondetalleFacade extends AbstractFacade<Remisiondetalle> implements RemisiondetalleFacadeLocal {

    @PersistenceContext(unitName = "BraintecProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RemisiondetalleFacade() {
        super(Remisiondetalle.class);
    }
    
    @Override
    public List<Remisiondetalle> listarRem(Remision op) {

        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Remisiondetalle> query = qb.createQuery(Remisiondetalle.class);
        Root<Remisiondetalle> entidad = query.from(Remisiondetalle.class);
        query.where(
                qb.equal(entidad.get(Remisiondetalle_.remision), op),
                qb.equal(entidad.get(Remisiondetalle_.estado), true)
        );
        // query.orderBy(qb.asc(cab.get(Tracabventas_.fecregistro)));
        List<Remisiondetalle> result = em.createQuery(query).getResultList();
        return result;

    }

}
