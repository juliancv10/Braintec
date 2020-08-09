/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tinventario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface TinventarioFacadeLocal {

    void create(Tinventario tinventario);

    void edit(Tinventario tinventario);

    void remove(Tinventario tinventario);

    Tinventario find(Object id);

    List<Tinventario> findAll();

    List<Tinventario> findRange(int[] range);

    int count();
    
}
