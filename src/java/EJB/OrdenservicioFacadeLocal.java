/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Ordenservicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface OrdenservicioFacadeLocal {

    void create(Ordenservicio ordenservicio);

    void edit(Ordenservicio ordenservicio);

    void remove(Ordenservicio ordenservicio);

    Ordenservicio find(Object id);

    List<Ordenservicio> findAll();

    List<Ordenservicio> findRange(int[] range);

    int count();
    
}
