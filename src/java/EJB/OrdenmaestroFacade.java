/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Ordenmaestro;
import Entity.Ordenmaestro_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Julian Camilo
 */
@Stateless
public class OrdenmaestroFacade extends AbstractFacade<Ordenmaestro> implements OrdenmaestroFacadeLocal {

    @PersistenceContext(unitName = "BraintecProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenmaestroFacade() {
        super(Ordenmaestro.class);
    }
    
    @Override
    public List<Ordenmaestro> listarActivos() {
        
        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Ordenmaestro> query = qb.createQuery(Ordenmaestro.class);
        Root<Ordenmaestro> entidad = query.from(Ordenmaestro.class);
        query.where(
                qb.equal(entidad.get(Ordenmaestro_.activo), true)
        );
        
        List<Ordenmaestro> result = em.createQuery(query).getResultList();
        return result;
        
    }
    
    public List<Ordenmaestro> listarOM() {
        Query q = em.createNativeQuery("SELECT idocabecera, tipo, numdocumento, monto, fecha, activo FROM dbbraintecpro.ordenmaestro;", Ordenmaestro.class);
        List<Ordenmaestro> lst= q.getResultList();
        return lst;
    }

    
}
