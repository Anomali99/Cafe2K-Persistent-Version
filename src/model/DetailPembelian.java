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
@Table(name = "detail_pembelian")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailPembelian.findAll", query = "SELECT d FROM DetailPembelian d"),
    @NamedQuery(name = "DetailPembelian.findByKodeMenu", query = "SELECT d FROM DetailPembelian d WHERE d.detailPembelianPK.kodeMenu = :kodeMenu"),
    @NamedQuery(name = "DetailPembelian.findByIdPegawai", query = "SELECT d FROM DetailPembelian d WHERE d.detailPembelianPK.idPegawai = :idPegawai"),
    @NamedQuery(name = "DetailPembelian.findByIdPelanggan", query = "SELECT d FROM DetailPembelian d WHERE d.detailPembelianPK.idPelanggan = :idPelanggan"),
    @NamedQuery(name = "DetailPembelian.findByNoPembelian", query = "SELECT d FROM DetailPembelian d WHERE d.detailPembelianPK.noPembelian = :noPembelian"),
    @NamedQuery(name = "DetailPembelian.findByJumlah", query = "SELECT d FROM DetailPembelian d WHERE d.jumlah = :jumlah"),
    @NamedQuery(name = "DetailPembelian.findBySubtotal", query = "SELECT d FROM DetailPembelian d WHERE d.subtotal = :subtotal"),
    @NamedQuery(name = "DetailPembelian.findByKeterangan", query = "SELECT d FROM DetailPembelian d WHERE d.keterangan = :keterangan")})
public class DetailPembelian implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailPembelianPK detailPembelianPK;
    @Column(name = "jumlah")
    private Integer jumlah;
    @Column(name = "subtotal")
    private BigInteger subtotal;
    @Column(name = "keterangan")
    private String keterangan;
    @JoinColumn(name = "kode_menu", referencedColumnName = "kode_menu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menu menu;
    @JoinColumns({
        @JoinColumn(name = "id_pegawai", referencedColumnName = "id_pegawai", insertable = false, updatable = false),
        @JoinColumn(name = "id_pelanggan", referencedColumnName = "id_pelanggan", insertable = false, updatable = false),
        @JoinColumn(name = "no_pembelian", referencedColumnName = "no_pembelian", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Pembelian pembelian;

    public DetailPembelian() {
    }

    public DetailPembelian(DetailPembelianPK detailPembelianPK) {
        this.detailPembelianPK = detailPembelianPK;
    }

    public DetailPembelian(String kodeMenu, String idPegawai, String idPelanggan, String noPembelian) {
        this.detailPembelianPK = new DetailPembelianPK(kodeMenu, idPegawai, idPelanggan, noPembelian);
    }

    public DetailPembelianPK getDetailPembelianPK() {
        return detailPembelianPK;
    }

    public void setDetailPembelianPK(DetailPembelianPK detailPembelianPK) {
        this.detailPembelianPK = detailPembelianPK;
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Pembelian getPembelian() {
        return pembelian;
    }

    public void setPembelian(Pembelian pembelian) {
        this.pembelian = pembelian;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailPembelianPK != null ? detailPembelianPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailPembelian)) {
            return false;
        }
        DetailPembelian other = (DetailPembelian) object;
        if ((this.detailPembelianPK == null && other.detailPembelianPK != null) || (this.detailPembelianPK != null && !this.detailPembelianPK.equals(other.detailPembelianPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DetailPembelian[ detailPembelianPK=" + detailPembelianPK + " ]";
    }

    public String getRpSubtotal() {
        return Rupiah.getRp(subtotal);
    }
    
}
