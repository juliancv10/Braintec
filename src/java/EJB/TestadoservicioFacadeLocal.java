/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Testadoservicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface TestadoservicioFacadeLocal {

    void create(Testadoservicio testadoservicio);

    void edit(Testadoservicio testadoservicio);

    void remove(Testadoservicio testadoservicio);

    Testadoservicio find(Object id);

    List<Testadoservicio> findAll();

    List<Testadoservicio> findRange(int[] range);

    int count();
    
}
