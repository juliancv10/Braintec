/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Julian Camilo
 */
@Entity
@Table(name = "tvehiculo")
public class Tvehiculo implements Serializable{
    
    @Id
    @Column(name = "placavehiculo")
    private String placavehiculo;
    @Column(name = "marcavehiculo")
    private String marcavehiculo;
    @Column(name = "modelovehiculo")
    private String modelovehiculo;
    @Column(name = "cilindrajevehiculo")
    private String cilindrajevehiculo;
    @Column(name = "kilometrajevehiculo")
    private String kilometrajevehiculo;
    @Column(name = "trasmisionvehiculo")
    private String trasmisionvehiculo;
    @Column(name = "aniovehiculo")
    private int aniovehiculo;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "numdocumento")
    private Tusuario tusuario;

    public String getPlacavehiculo() {
        return placavehiculo;
    }

    public void setPlacavehiculo(String placavehiculo) {
        this.placavehiculo = placavehiculo;
    }

    public String getMarcavehiculo() {
        return marcavehiculo;
    }

    public void setMarcavehiculo(String marcavehiculo) {
        this.marcavehiculo = marcavehiculo;
    }

    public String getModelovehiculo() {
        return modelovehiculo;
    }

    public void setModelovehiculo(String modelovehiculo) {
        this.modelovehiculo = modelovehiculo;
    }

    public String getCilindrajevehiculo() {
        return cilindrajevehiculo;
    }

    public void setCilindrajevehiculo(String cilindrajevehiculo) {
        this.cilindrajevehiculo = cilindrajevehiculo;
    }

    public String getKilometrajevehiculo() {
        return kilometrajevehiculo;
    }

    public void setKilometrajevehiculo(String kilometrajevehiculo) {
        this.kilometrajevehiculo = kilometrajevehiculo;
    }

    public String getTrasmisionvehiculo() {
        return trasmisionvehiculo;
    }

    public void setTrasmisionvehiculo(String trasmisionvehiculo) {
        this.trasmisionvehiculo = trasmisionvehiculo;
    }

    public int getAniovehiculo() {
        return aniovehiculo;
    }

    public void setAniovehiculo(int aniovehiculo) {
        this.aniovehiculo = aniovehiculo;
    }

    public Tusuario getTusuario() {
        return tusuario;
    }

    public void setTusuario(Tusuario tusuario) {
        this.tusuario = tusuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.placavehiculo);
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
        final Tvehiculo other = (Tvehiculo) obj;
        if (!Objects.equals(this.placavehiculo, other.placavehiculo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tvehiculo{" + "placavehiculo=" + placavehiculo + '}';
    }
}
