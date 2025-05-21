/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tproserv;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface TproservFacadeLocal {

    void create(Tproserv tproserv);

    void edit(Tproserv tproserv);

    void remove(Tproserv tproserv);

    Tproserv find(Object id);

    List<Tproserv> findAll();

    List<Tproserv> findRange(int[] range);

    int count();
    
    List<Tproserv> listarRep();
    
    List<Tproserv> listarServ();

    
}
