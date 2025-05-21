/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.OrdenServicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface OrdenServicioFacadeLocal {

    void create(OrdenServicio ordenServicio);

    void edit(OrdenServicio ordenServicio);

    void remove(OrdenServicio ordenServicio);

    OrdenServicio find(Object id);

    List<OrdenServicio> findAll();

    List<OrdenServicio> findRange(int[] range);
    
    List<OrdenServicio> listarOrdServ() ;
    
    List<OrdenServicio> listarCerrado() ;

    int count();
    
}
