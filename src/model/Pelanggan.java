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
@Table(name = "pelanggan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pelanggan.getAll", query = "SELECT p FROM Pelanggan p ORDER BY p.idPelanggan"),
    @NamedQuery(name = "Pelanggan.getById", query = "SELECT p FROM Pelanggan p WHERE p.idPelanggan = :idPelanggan"),
    @NamedQuery(name = "Pelanggan.getByID", query = "SELECT p FROM Pelanggan p WHERE LOWER(p.idPelanggan) LIKE LOWER(:idPelanggan) ORDER BY p.idPelanggan"),
    @NamedQuery(name = "Pelanggan.getByNama", query = "SELECT p FROM Pelanggan p WHERE LOWER(p.nama) LIKE LOWER(:nama) ORDER BY p.idPelanggan"),
    @NamedQuery(name = "Pelanggan.getByAlamat", query = "SELECT p FROM Pelanggan p WHERE LOWER(p.alamat) LIKE LOWER(:alamat) ORDER BY p.idPelanggan"),
    @NamedQuery(name = "Pelanggan.getByTelephone", query = "SELECT p FROM Pelanggan p WHERE LOWER(p.telephone) LIKE LOWER(:telephone) ORDER BY p.idPelanggan"),
    @NamedQuery(name = "Pelanggan.getNomer", query = "SELECT SUBSTRING(p.idPelanggan, LENGTH(p.idPelanggan) - 2) AS nomor FROM Pelanggan p WHERE p.idPelanggan LIKE 'P%' ORDER BY p.idPelanggan DESC")})
public class Pelanggan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pelanggan")
    private String idPelanggan;
    @Column(name = "nama")
    private String nama;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pelanggan")
    private Collection<Pembelian> pembelianCollection;

    public Pelanggan() {
    }

    public Pelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
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
    public Collection<Pembelian> getPembelianCollection() {
        return pembelianCollection;
    }

    public void setPembelianCollection(Collection<Pembelian> pembelianCollection) {
        this.pembelianCollection = pembelianCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPelanggan != null ? idPelanggan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pelanggan)) {
            return false;
        }
        Pelanggan other = (Pelanggan) object;
        if ((this.idPelanggan == null && other.idPelanggan != null) || (this.idPelanggan != null && !this.idPelanggan.equals(other.idPelanggan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pelanggan[ idPelanggan=" + idPelanggan + " ]";
    }
    
}
