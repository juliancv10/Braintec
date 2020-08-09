/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Troles;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface TrolesFacadeLocal {

    void create(Troles troles);

    void edit(Troles troles);

    void remove(Troles troles);

    Troles find(Object id);

    List<Troles> findAll();

    List<Troles> findRange(int[] range);

    int count();
    
}
