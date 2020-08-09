/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tprioridad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface TprioridadFacadeLocal {

    void create(Tprioridad tprioridad);

    void edit(Tprioridad tprioridad);

    void remove(Tprioridad tprioridad);

    Tprioridad find(Object id);

    List<Tprioridad> findAll();

    List<Tprioridad> findRange(int[] range);

    int count();
    
}
