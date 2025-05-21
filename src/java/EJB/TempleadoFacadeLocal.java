/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Templeado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface TempleadoFacadeLocal {

    void create(Templeado templeado);

    void edit(Templeado templeado);

    void remove(Templeado templeado);

    Templeado find(Object id);

    List<Templeado> findAll();

    List<Templeado> findRange(int[] range);

    int count();
    
    Templeado iniciarSesion(Templeado us);

}
