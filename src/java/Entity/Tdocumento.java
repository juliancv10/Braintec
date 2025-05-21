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
import javax.persistence.Table;


/**
 *
 * @author Julian Camilo
 */
@Entity
@Table(name = "tdocumento")
public class Tdocumento implements Serializable{
    
    @Id
    @Column(name = "iddocumento") 
    private int iddocumento;
    @Column(name = "tipodocumento")
    private String tipodocumento;

    public int getIddocumento() {
        return iddocumento;
    }

    public void setIddocumento(int iddocumento) {
        this.iddocumento = iddocumento;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    @Override
    public String toString() {
        return "Tdocumento{" + "iddocumento=" + iddocumento + '}';
    }

}
