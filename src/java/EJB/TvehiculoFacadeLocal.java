/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tvehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface TvehiculoFacadeLocal {

    void create(Tvehiculo tvehiculo);

    void edit(Tvehiculo tvehiculo);

    void remove(Tvehiculo tvehiculo);

    Tvehiculo find(Object id);

    List<Tvehiculo> findAll();

    List<Tvehiculo> findRange(int[] range);

    int count();
    
}
