/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entity.MenuUsuarios;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Julian Camilo
 */
@Local
public interface MenuUsuariosFacadeLocal {

    void create(MenuUsuarios menuUsuarios);

    void edit(MenuUsuarios menuUsuarios);

    void remove(MenuUsuarios menuUsuarios);

    MenuUsuarios find(Object id);

    List<MenuUsuarios> findAll();

    List<MenuUsuarios> findRange(int[] range);

    int count();
    
}
