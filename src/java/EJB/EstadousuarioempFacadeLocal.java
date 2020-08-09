/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Estadousuarioemp;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface EstadousuarioempFacadeLocal {

    void create(Estadousuarioemp estadousuarioemp);

    void edit(Estadousuarioemp estadousuarioemp);

    void remove(Estadousuarioemp estadousuarioemp);

    Estadousuarioemp find(Object id);

    List<Estadousuarioemp> findAll();

    List<Estadousuarioemp> findRange(int[] range);

    int count();
    
}
