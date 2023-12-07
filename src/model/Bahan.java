/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.Rupiah;
import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "bahan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bahan.getAll", query = "SELECT b FROM Bahan b ORDER BY b.kodeBahan"),
    @NamedQuery(name = "Bahan.getByKode", query = "SELECT b FROM Bahan b WHERE b.kodeBahan = :kodeBahan"),
    @NamedQuery(name = "Bahan.getByKODE", query = "SELECT b FROM Bahan b WHERE LOWER(b.kodeBahan) LIKE LOWER(:kodeBahan) ORDER BY b.kodeBahan"),
    @NamedQuery(name = "Bahan.getByNama", query = "SELECT b FROM Bahan b WHERE LOWER(b.nama) LIKE LOWER(:nama) ORDER BY b.kodeBahan"),
    @NamedQuery(name = "Bahan.getByHarga", query = "SELECT b FROM Bahan b WHERE b.harga = :harga ORDER BY b.kodeBahan"),
    @NamedQuery(name = "Bahan.getByStok", query = "SELECT b FROM Bahan b WHERE b.stok = :stok ORDER BY b.kodeBahan"),
    @NamedQuery(name = "Bahan.getNomer", query = "SELECT SUBSTRING(b.kodeBahan, LENGTH(b.kodeBahan) - 2) AS nomor FROM Bahan b WHERE b.kodeBahan LIKE 'BN%' ORDER BY b.kodeBahan DESC")})
public class Bahan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kode_bahan")
    private String kodeBahan;
    @Column(name = "nama")
    private String nama;
    @Column(name = "harga")
    private BigInteger harga;
    @Column(name = "stok")
    private Integer stok;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bahan")
    private Collection<DetailSupply> detailSupplyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bahan")
    private Collection<DetailBahan> detailBahanCollection;

    public Bahan() {
    }

    public Bahan(String kodeBahan) {
        this.kodeBahan = kodeBahan;
    }

    public String getKodeBahan() {
        return kodeBahan;
    }

    public void setKodeBahan(String kodeBahan) {
        this.kodeBahan = kodeBahan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public BigInteger getHarga() {
        return harga;
    }

    public void setHarga(BigInteger harga) {
        this.harga = harga;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    @XmlTransient
    public Collection<DetailSupply> getDetailSupplyCollection() {
        return detailSupplyCollection;
    }

    public void setDetailSupplyCollection(Collection<DetailSupply> detailSupplyCollection) {
        this.detailSupplyCollection = detailSupplyCollection;
    }

    @XmlTransient
    public Collection<DetailBahan> getDetailBahanCollection() {
        return detailBahanCollection;
    }

    public void setDetailBahanCollection(Collection<DetailBahan> detailBahanCollection) {
        this.detailBahanCollection = detailBahanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodeBahan != null ? kodeBahan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bahan)) {
            return false;
        }
        Bahan other = (Bahan) object;
        if ((this.kodeBahan == null && other.kodeBahan != null) || (this.kodeBahan != null && !this.kodeBahan.equals(other.kodeBahan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bahan[ kodeBahan=" + kodeBahan + " ]";
    }

    public String getRpHarga() {
        return Rupiah.getRp(harga);
    }
    
}
