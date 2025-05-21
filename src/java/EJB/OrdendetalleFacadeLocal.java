/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Ordendetalle;
import Entity.Ordenmaestro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface OrdendetalleFacadeLocal {

    void create(Ordendetalle ordendetalle);

    void edit(Ordendetalle ordendetalle);

    void remove(Ordendetalle ordendetalle);

    Ordendetalle find(Object id);

    List<Ordendetalle> findAll();

    List<Ordendetalle> findRange(int[] range);
    
    List<Ordendetalle> listarOrdes(Ordenmaestro op);

    int count();
    
}
