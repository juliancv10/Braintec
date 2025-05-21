/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Ordentipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface OrdentipoFacadeLocal {

    void create(Ordentipo ordentipo);

    void edit(Ordentipo ordentipo);

    void remove(Ordentipo ordentipo);

    Ordentipo find(Object id);

    List<Ordentipo> findAll();

    List<Ordentipo> findRange(int[] range);

    int count();
    
}
