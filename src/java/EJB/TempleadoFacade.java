/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Templeado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Julian Camilo
 */
@Stateless
public class TempleadoFacade extends AbstractFacade<Templeado> implements TempleadoFacadeLocal {

    @PersistenceContext(unitName = "BraintecProPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TempleadoFacade() {
        super(Templeado.class);
    }
    
    @Override
    public Templeado iniciarSesion(Templeado us){
        Templeado templeado = null;
        String consulta;
        try{
            consulta = "FROM Templeado u WHERE u.usuarioempleado = ?1 and u.contrasenaempleado = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, us.getUsuarioempleado());
            query.setParameter(2, us.getContrasenaempleado());
            List<Templeado> lista = query.getResultList();
            if (!lista.isEmpty()){
                templeado = lista.get(0);
            }
        }catch(Exception e){
            throw e;
            
        }
        return templeado;
    }  
}
