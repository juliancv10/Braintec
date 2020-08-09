/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tcategoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface TcategoriaFacadeLocal {

    void create(Tcategoria tcategoria);

    void edit(Tcategoria tcategoria);

    void remove(Tcategoria tcategoria);

    Tcategoria find(Object id);

    List<Tcategoria> findAll();

    List<Tcategoria> findRange(int[] range);

    int count();
    
}
