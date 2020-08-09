/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Estadoordenped;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface EstadoordenpedFacadeLocal {

    void create(Estadoordenped estadoordenped);

    void edit(Estadoordenped estadoordenped);

    void remove(Estadoordenped estadoordenped);

    Estadoordenped find(Object id);

    List<Estadoordenped> findAll();

    List<Estadoordenped> findRange(int[] range);

    int count();
    
}
