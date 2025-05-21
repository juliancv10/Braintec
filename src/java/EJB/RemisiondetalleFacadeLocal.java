/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Remision;
import Entity.Remisiondetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface RemisiondetalleFacadeLocal {

    void create(Remisiondetalle remisiondetalle);

    void edit(Remisiondetalle remisiondetalle);

    void remove(Remisiondetalle remisiondetalle);

    Remisiondetalle find(Object id);

    List<Remisiondetalle> findAll();

    List<Remisiondetalle> findRange(int[] range);

    int count();
    
    List<Remisiondetalle> listarRem(Remision op);
    
}
