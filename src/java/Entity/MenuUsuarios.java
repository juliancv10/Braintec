/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Julian Camilo
 */
@Entity
@Table (name = "menuusuario")
public class MenuUsuarios implements Serializable{
    
    @Id
    @Column(name = "mcodigo")
    private int mcodigo;
    @Column (name = "mnombre")
    private String mnombre;
    @Column (name = "url")
    private String url;
    @Column (name = "tipomenu")
    private String tipomenu;
    @ManyToOne
    @JoinColumn(name = "idroles")
    private Troles idroles;
    @ManyToOne
    @JoinColumn(name = "codigosubmenu")
    private MenuUsuarios codigosubmenu;

    public int getMcodigo() {
        return mcodigo;
    }

    public void setMcodigo(int mcodigo) {
        this.mcodigo = mcodigo;
    }

    public String getMnombre() {
        return mnombre;
    }

    public void setMnombre(String mnombre) {
        this.mnombre = mnombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }   
    
    public String getTipomenu() {
        return tipomenu;
    }

    public void setTipomenu(String tipomenu) {
        this.tipomenu = tipomenu;
    }

    public Troles getIdroles() {
        return idroles;
    }

    public void setIdroles(Troles idroles) {
        this.idroles = idroles;
    }

    public MenuUsuarios getCodigosubmenu() {
        return codigosubmenu;
    }

    public void setCodigosubmenu(MenuUsuarios codigosubmenu) {
        this.codigosubmenu = codigosubmenu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.mcodigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuUsuarios other = (MenuUsuarios) obj;
        if (this.mcodigo != other.mcodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MenuUsuarios{" + "mcodigo=" + mcodigo + '}';
    }

}
