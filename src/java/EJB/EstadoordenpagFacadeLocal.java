/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Estadoordenpag;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface EstadoordenpagFacadeLocal {

    void create(Estadoordenpag estadoordenpag);

    void edit(Estadoordenpag estadoordenpag);

    void remove(Estadoordenpag estadoordenpag);

    Estadoordenpag find(Object id);

    List<Estadoordenpag> findAll();

    List<Estadoordenpag> findRange(int[] range);

    int count();
    
}
