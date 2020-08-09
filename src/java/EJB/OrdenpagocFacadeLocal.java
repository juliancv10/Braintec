/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Ordenpagoc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface OrdenpagocFacadeLocal {

    void create(Ordenpagoc ordenpagoc);

    void edit(Ordenpagoc ordenpagoc);

    void remove(Ordenpagoc ordenpagoc);

    Ordenpagoc find(Object id);

    List<Ordenpagoc> findAll();

    List<Ordenpagoc> findRange(int[] range);

    int count();
    
}
