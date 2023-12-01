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
import javax.persistence.Lob;
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
@Table(name = "pegawai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pegawai.getAll", query = "SELECT p FROM Pegawai p ORDER BY p.idPegawai"),
    @NamedQuery(name = "Pegawai.getById", query = "SELECT p FROM Pegawai p WHERE p.idPegawai = :idPegawai"),
    @NamedQuery(name = "Pegawai.getByID", query = "SELECT p FROM Pegawai p WHERE LOWER(p.idPegawai) LIKE LOWER(:idPegawai) ORDER BY p.idPegawai"),
    @NamedQuery(name = "Pegawai.getByNama", query = "SELECT p FROM Pegawai p WHERE LOWER(p.nama) LIKE LOWER(:nama) ORDER BY p.idPegawai"),
    @NamedQuery(name = "Pegawai.getByAlamat", query = "SELECT p FROM Pegawai p WHERE LOWER(p.alamat) LIKE LOWER(:alamat) ORDER BY p.idPegawai"),
    @NamedQuery(name = "Pegawai.getByTelephone", query = "SELECT p FROM Pegawai p WHERE LOWER(p.telephone) LIKE LOWER(:telephone) ORDER BY p.idPegawai"),
    @NamedQuery(name = "Pegawai.getByEmail", query = "SELECT p FROM Pegawai p WHERE LOWER(p.email) LIKE LOWER(:email) ORDER BY p.idPegawai"),
    @NamedQuery(name = "Pegawai.getByLevel", query = "SELECT p FROM Pegawai p WHERE LOWER(p.level) LIKE LOWER(:level) ORDER BY p.idPegawai"),
    @NamedQuery(name = "Pegawai.getNomer", query = "SELECT SUBSTRING(p.idPegawai, LENGTH(p.idPegawai) - 2) AS nomor FROM Pegawai p WHERE p.idPegawai LIKE 'PT%' ORDER BY p.idPegawai DESC"),
    @NamedQuery(name = "Pegawai.login", query = "SELECT p FROM Pegawai p WHERE p.username = :username AND p.password = :password")})
public class Pegawai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pegawai")
    private String idPegawai;
    @Column(name = "nama")
    private String nama;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "email")
    private String email;
    @Column(name = "level")
    private String level;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pegawai")
    private Collection<Supply> supplyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pegawai")
    private Collection<Pembelian> pembelianCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pegawai")
    private Collection<Memasak> memasakCollection;

    public Pegawai() {
    }

    public Pegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Collection<Supply> getSupplyCollection() {
        return supplyCollection;
    }

    public void setSupplyCollection(Collection<Supply> supplyCollection) {
        this.supplyCollection = supplyCollection;
    }

    @XmlTransient
    public Collection<Pembelian> getPembelianCollection() {
        return pembelianCollection;
    }

    public void setPembelianCollection(Collection<Pembelian> pembelianCollection) {
        this.pembelianCollection = pembelianCollection;
    }

    @XmlTransient
    public Collection<Memasak> getMemasakCollection() {
        return memasakCollection;
    }

    public void setMemasakCollection(Collection<Memasak> memasakCollection) {
        this.memasakCollection = memasakCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPegawai != null ? idPegawai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pegawai)) {
            return false;
        }
        Pegawai other = (Pegawai) object;
        if ((this.idPegawai == null && other.idPegawai != null) || (this.idPegawai != null && !this.idPegawai.equals(other.idPegawai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pegawai[ idPegawai=" + idPegawai + " ]";
    }
    
}
