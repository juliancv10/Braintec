/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Ordendetalle;
import Entity.Ordendetalle_;
import Entity.Ordenmaestro;
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
public class OrdendetalleFacade extends AbstractFacade<Ordendetalle> implements OrdendetalleFacadeLocal {

    @PersistenceContext(unitName = "BraintecProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdendetalleFacade() {
        super(Ordendetalle.class);
    }

    @Override
    public List<Ordendetalle> listarOrdes(Ordenmaestro op) {

        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Ordendetalle> query = qb.createQuery(Ordendetalle.class);
        Root<Ordendetalle> entidad = query.from(Ordendetalle.class);
        query.where(
                qb.equal(entidad.get(Ordendetalle_.ordenmaestro), op),
                qb.equal(entidad.get(Ordendetalle_.activo), true)
        );
        // query.orderBy(qb.asc(cab.get(Tracabventas_.fecregistro)));
        List<Ordendetalle> result = em.createQuery(query).getResultList();
        return result;

    }

}
