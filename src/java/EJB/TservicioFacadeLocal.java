/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tservicio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface TservicioFacadeLocal {

    void create(Tservicio tservicio);

    void edit(Tservicio tservicio);

    void remove(Tservicio tservicio);

    Tservicio find(Object id);

    List<Tservicio> findAll();

    List<Tservicio> findRange(int[] range);

    int count();
    
}
