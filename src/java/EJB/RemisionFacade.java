/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Remision;
import Entity.Remision_;
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
public class RemisionFacade extends AbstractFacade<Remision> implements RemisionFacadeLocal {

    @PersistenceContext(unitName = "BraintecProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RemisionFacade() {
        super(Remision.class);
    }
    
    @Override
    public List<Remision> listarRemAct() {
        
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Remision> query = qb.createQuery(Remision.class);
        Root<Remision> entidad = query.from(Remision.class);
        query.where(
                qb.equal(entidad.get(Remision_.estado), true)
        );
        
        List<Remision> result = em.createQuery(query).getResultList();
        return result;
        
    }
}
