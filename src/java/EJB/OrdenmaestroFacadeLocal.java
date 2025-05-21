/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Ordenmaestro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface OrdenmaestroFacadeLocal {

    void create(Ordenmaestro ordenmaestro);

    void edit(Ordenmaestro ordenmaestro);

    void remove(Ordenmaestro ordenmaestro);

    Ordenmaestro find(Object id);

    List<Ordenmaestro> findAll();

    List<Ordenmaestro> findRange(int[] range);
    
    List<Ordenmaestro> listarActivos();
    
    List<Ordenmaestro> listarOM();

    int count();
    
}
