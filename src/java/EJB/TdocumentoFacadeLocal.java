/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.Tdocumento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface TdocumentoFacadeLocal {

    void create(Tdocumento tdocumento);

    void edit(Tdocumento tdocumento);

    void remove(Tdocumento tdocumento);

    Tdocumento find(Object id);

    List<Tdocumento> findAll();

    List<Tdocumento> findRange(int[] range);

    int count();
    
}
