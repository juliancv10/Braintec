/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tproveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface TproveedorFacadeLocal {

    void create(Tproveedor tproveedor);

    void edit(Tproveedor tproveedor);

    void remove(Tproveedor tproveedor);

    Tproveedor find(Object id);

    List<Tproveedor> findAll();

    List<Tproveedor> findRange(int[] range);

    int count();
    
}
