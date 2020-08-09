/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Estadoordenserv;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface EstadoordenservFacadeLocal {

    void create(Estadoordenserv estadoordenserv);

    void edit(Estadoordenserv estadoordenserv);

    void remove(Estadoordenserv estadoordenserv);

    Estadoordenserv find(Object id);

    List<Estadoordenserv> findAll();

    List<Estadoordenserv> findRange(int[] range);

    int count();
    
}
