/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fatiq
 */
@Entity
@Table(name = "supplier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplier.getAll", query = "SELECT s FROM Supplier s ORDER BY s.idSupplier"),
    @NamedQuery(name = "Supplier.getById", query = "SELECT s FROM Supplier s WHERE s.idSupplier = :idSupplier"),
    @NamedQuery(name = "Supplier.getByID", query = "SELECT s FROM Supplier s WHERE LOWER(s.idSupplier) LIKE LOWER(:idSupplier) ORDER BY s.idSupplier"),
    @NamedQuery(name = "Supplier.getByNama", query = "SELECT s FROM Supplier s WHERE LOWER(s.nama) LIKE LOWER(:nama) ORDER BY s.idSupplier"),
    @NamedQuery(name = "Supplier.getByAlamat", query = "SELECT s FROM Supplier s WHERE LOWER(s.alamat) LIKE LOWER(:alamat) ORDER BY s.idSupplier"),
    @NamedQuery(name = "Supplier.getByTelephone", query = "SELECT s FROM Supplier s WHERE LOWER(s.telephone) LIKE LOWER(:telephone) ORDER BY s.idSupplier"),
    @NamedQuery(name = "Supplier.getNomer", query = "SELECT SUBSTRING(s.idSupplier, LENGTH(s.idSupplier) - 2) AS nomor FROM Supplier s WHERE s.idSupplier LIKE 'S%' ORDER BY s.idSupplier DESC")})
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_supplier")
    private String idSupplier;
    @Column(name = "nama")
    private String nama;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Collection<Supply> supplyCollection;

    public Supplier() {
    }

    public Supplier(String idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(String idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @XmlTransient
    public Collection<Supply> getSupplyCollection() {
        return supplyCollection;
    }

    public void setSupplyCollection(Collection<Supply> supplyCollection) {
        this.supplyCollection = supplyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSupplier != null ? idSupplier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.idSupplier == null && other.idSupplier != null) || (this.idSupplier != null && !this.idSupplier.equals(other.idSupplier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Supplier[ idSupplier=" + idSupplier + " ]";
    }
    
}
