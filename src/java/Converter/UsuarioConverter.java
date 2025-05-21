/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;


import EJB.TdocumentoFacadeLocal;
import Entity.Tdocumento;
import Entity.Tusuario;

/**
 *
 * @author Julian Camilo
 */
public final class UsuarioConverter {

    private UsuarioConverter() {

    }

    public static Tusuario toTusuario(TdocumentoFacadeLocal f, String datosUsuarios) {
        System.err.println(">>>>>>>>>>" + datosUsuarios);
        String[] datos = datosUsuarios.split(";");
        if (datos.length < 7 || datos[0] == null || datos[0].isEmpty()) {
            return null;
        }
        Tusuario tusuario = new Tusuario();
        tusuario.setNumdocumento(Integer.parseInt(datos[0]));
        tusuario.setNombre(datos[1]);
        tusuario.setApellido(datos[2]);
        tusuario.setTelefono(Long.parseLong(datos[3]));
        tusuario.setDireccion(datos[4]);
        tusuario.setCorreo(datos[5]);
        Tdocumento t = f.buscar(datos[6]);
        if (t == null) {
            return null;
        }
        tusuario.setTdocumento(t);

        return tusuario;
    }

}
