/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Converter.UsuarioConverter;
import EJB.TdocumentoFacadeLocal;
import EJB.TusuarioFacadeLocal;

import Entity.Tusuario;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Julian Camilo
 */
@ManagedBean
@SessionScoped
public class MbeanCargaDatos implements Serializable {

    @EJB
    private TusuarioFacadeLocal facadeTusuario;

    @EJB
    private TdocumentoFacadeLocal tdocumentoFacade;

    private Part cargarDatos;

    Tusuario tusuario = new Tusuario();

    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Part getCargarDatos() {
        return cargarDatos;
    }

    public void setCargarDatos(Part cargarDatos) {
        this.cargarDatos = cargarDatos;
    }

    public MbeanCargaDatos() {
    }

   

    public void cargarArchivos(FileUploadEvent event) throws IOException {
        try {           
                InputStream input = event.getFile().getInputstream();
                BufferedReader br = new BufferedReader(new InputStreamReader(input));
                String line;
                int creados = 0;
                int descartados = 0;
                while ((line = br.readLine()) != null) {
                    if(line!=null && !line.isEmpty()){
                    Tusuario t = UsuarioConverter.toTusuario(tdocumentoFacade, line);
                    if (t != null) {
                        facadeTusuario.create(t);
                        creados++;
                    } else {
                        descartados++;
                    }
                    }
                }

                FacesMessage fcFacesMessage = new FacesMessage("Información", "Se crearon " + creados + " se descartaron " + descartados);
                FacesContext.getCurrentInstance().addMessage(null, fcFacesMessage);

             
        } catch (Exception e) {
            e.printStackTrace();
        }

//UploadedFile file = event.getFile();
        //ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    }

}
