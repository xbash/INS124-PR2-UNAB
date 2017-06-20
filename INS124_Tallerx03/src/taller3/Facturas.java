/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author rgonzalez
 */
@Entity
@Table(name = "Facturas", catalog = "PrograII", schema = "")
@NamedQueries({
    @NamedQuery(name = "Facturas.findAll", query = "SELECT f FROM Facturas f")
    , @NamedQuery(name = "Facturas.findByFolio", query = "SELECT f FROM Facturas f WHERE f.folio = :folio")
    , @NamedQuery(name = "Facturas.findByRut", query = "SELECT f FROM Facturas f WHERE f.rut = :rut")
    , @NamedQuery(name = "Facturas.findByNombre", query = "SELECT f FROM Facturas f WHERE f.nombre = :nombre")
    , @NamedQuery(name = "Facturas.findByGlosa", query = "SELECT f FROM Facturas f WHERE f.glosa = :glosa")
    , @NamedQuery(name = "Facturas.findByNeto", query = "SELECT f FROM Facturas f WHERE f.neto = :neto")
    , @NamedQuery(name = "Facturas.findByIva", query = "SELECT f FROM Facturas f WHERE f.iva = :iva")
    , @NamedQuery(name = "Facturas.findByTotal", query = "SELECT f FROM Facturas f WHERE f.total = :total")
    , @NamedQuery(name = "Facturas.findByEstadopago", query = "SELECT f FROM Facturas f WHERE f.estadopago = :estadopago")})
public class Facturas implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "folio")
    private String folio;
    @Column(name = "rut")
    private String rut;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "glosa")
    private String glosa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "neto")
    private Float neto;
    @Column(name = "iva")
    private Float iva;
    @Column(name = "total")
    private Float total;
    @Column(name = "estadopago")
    private Character estadopago;

    public Facturas() {
    }

    public Facturas(String folio) {
        this.folio = folio;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        String oldFolio = this.folio;
        this.folio = folio;
        changeSupport.firePropertyChange("folio", oldFolio, folio);
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        String oldRut = this.rut;
        this.rut = rut;
        changeSupport.firePropertyChange("rut", oldRut, rut);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        String oldGlosa = this.glosa;
        this.glosa = glosa;
        changeSupport.firePropertyChange("glosa", oldGlosa, glosa);
    }

    public Float getNeto() {
        return neto;
    }

    public void setNeto(Float neto) {
        Float oldNeto = this.neto;
        this.neto = neto;
        changeSupport.firePropertyChange("neto", oldNeto, neto);
    }

    public Float getIva() {
        return iva;
    }

    public void setIva(Float iva) {
        Float oldIva = this.iva;
        this.iva = iva;
        changeSupport.firePropertyChange("iva", oldIva, iva);
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        Float oldTotal = this.total;
        this.total = total;
        changeSupport.firePropertyChange("total", oldTotal, total);
    }

    public Character getEstadopago() {
        return estadopago;
    }

    public void setEstadopago(Character estadopago) {
        Character oldEstadopago = this.estadopago;
        this.estadopago = estadopago;
        changeSupport.firePropertyChange("estadopago", oldEstadopago, estadopago);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (folio != null ? folio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facturas)) {
            return false;
        }
        Facturas other = (Facturas) object;
        if ((this.folio == null && other.folio != null) || (this.folio != null && !this.folio.equals(other.folio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "taller3.Facturas[ folio=" + folio + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
