/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Remision;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface RemisionFacadeLocal {

    void create(Remision remision);

    void edit(Remision remision);

    void remove(Remision remision);

    Remision find(Object id);

    List<Remision> findAll();

    List<Remision> findRange(int[] range);

    int count();
    
    List<Remision> listarRemAct();
    
}
