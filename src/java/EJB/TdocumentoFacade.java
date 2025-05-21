/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tdocumento;
import Entity.Tdocumento_;

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
public class TdocumentoFacade extends AbstractFacade<Tdocumento> implements TdocumentoFacadeLocal {

    @PersistenceContext(unitName = "BraintecProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TdocumentoFacade() {
        super(Tdocumento.class);
    }

    @Override
    public Tdocumento buscar(String nombre) {

        CriteriaBuilder qb = em.getCriteriaBuilder();
        CriteriaQuery<Tdocumento> query = qb.createQuery(Tdocumento.class);
        Root<Tdocumento> entidad = query.from(Tdocumento.class);
        query.where(
                qb.equal(entidad.get(Tdocumento_.tipodocumento), nombre)
        );
        // query.orderBy(qb.asc(cab.get(Tracabventas_.fecregistro)));
        List<Tdocumento> result = em.createQuery(query).getResultList();
        return result.isEmpty() ? null : result.get(0);

    }

}
