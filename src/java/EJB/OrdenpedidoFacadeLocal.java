/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Ordenpedido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface OrdenpedidoFacadeLocal {

    void create(Ordenpedido ordenpedido);

    void edit(Ordenpedido ordenpedido);

    void remove(Ordenpedido ordenpedido);

    Ordenpedido find(Object id);

    List<Ordenpedido> findAll();

    List<Ordenpedido> findRange(int[] range);

    int count();
    
}
