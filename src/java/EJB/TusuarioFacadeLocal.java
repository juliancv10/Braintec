/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tusuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface TusuarioFacadeLocal {

    void create(Tusuario tusuario);

    void edit(Tusuario tusuario);

    void remove(Tusuario tusuario);

    Tusuario find(Object id);

    List<Tusuario> findAll();

    List<Tusuario> findRange(int[] range);

    int count();
    
}
