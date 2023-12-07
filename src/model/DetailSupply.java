/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.Rupiah;
import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fatiq
 */
@Entity
@Table(name = "detail_supply")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailSupply.findAll", query = "SELECT d FROM DetailSupply d"),
    @NamedQuery(name = "DetailSupply.findByKodeBahan", query = "SELECT d FROM DetailSupply d WHERE d.detailSupplyPK.kodeBahan = :kodeBahan"),
    @NamedQuery(name = "DetailSupply.findByIdSupplier", query = "SELECT d FROM DetailSupply d WHERE d.detailSupplyPK.idSupplier = :idSupplier"),
    @NamedQuery(name = "DetailSupply.findByIdPegawai", query = "SELECT d FROM DetailSupply d WHERE d.detailSupplyPK.idPegawai = :idPegawai"),
    @NamedQuery(name = "DetailSupply.findByNoSupply", query = "SELECT d FROM DetailSupply d WHERE d.detailSupplyPK.noSupply = :noSupply"),
    @NamedQuery(name = "DetailSupply.findByJumlah", query = "SELECT d FROM DetailSupply d WHERE d.jumlah = :jumlah"),
    @NamedQuery(name = "DetailSupply.findBySubtotal", query = "SELECT d FROM DetailSupply d WHERE d.subtotal = :subtotal"),
    @NamedQuery(name = "DetailSupply.findByKeterangan", query = "SELECT d FROM DetailSupply d WHERE d.keterangan = :keterangan")})
public class DetailSupply implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailSupplyPK detailSupplyPK;
    @Column(name = "jumlah")
    private Integer jumlah;
    @Column(name = "subtotal")
    private BigInteger subtotal;
    @Column(name = "keterangan")
    private String keterangan;
    @JoinColumn(name = "kode_bahan", referencedColumnName = "kode_bahan", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bahan bahan;
    @JoinColumns({
        @JoinColumn(name = "id_supplier", referencedColumnName = "id_supplier", insertable = false, updatable = false),
        @JoinColumn(name = "id_pegawai", referencedColumnName = "id_pegawai", insertable = false, updatable = false),
        @JoinColumn(name = "no_supply", referencedColumnName = "no_supply", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Supply supply;

    public DetailSupply() {
    }

    public DetailSupply(DetailSupplyPK detailSupplyPK) {
        this.detailSupplyPK = detailSupplyPK;
    }

    public DetailSupply(String kodeBahan, String idSupplier, String idPegawai, String noSupply) {
        this.detailSupplyPK = new DetailSupplyPK(kodeBahan, idSupplier, idPegawai, noSupply);
    }

    public DetailSupplyPK getDetailSupplyPK() {
        return detailSupplyPK;
    }

    public void setDetailSupplyPK(DetailSupplyPK detailSupplyPK) {
        this.detailSupplyPK = detailSupplyPK;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public BigInteger getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigInteger subtotal) {
        this.subtotal = subtotal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Bahan getBahan() {
        return bahan;
    }

    public void setBahan(Bahan bahan) {
        this.bahan = bahan;
    }

    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailSupplyPK != null ? detailSupplyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailSupply)) {
            return false;
        }
        DetailSupply other = (DetailSupply) object;
        if ((this.detailSupplyPK == null && other.detailSupplyPK != null) || (this.detailSupplyPK != null && !this.detailSupplyPK.equals(other.detailSupplyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DetailSupply[ detailSupplyPK=" + detailSupplyPK + " ]";
    }

    public String getRpSubtotal() {
        return Rupiah.getRp(subtotal);
    }
    
}
