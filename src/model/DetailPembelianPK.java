/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author fatiq
 */
@Embeddable
public class DetailPembelianPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "kode_menu")
    private String kodeMenu;
    @Basic(optional = false)
    @Column(name = "id_pegawai")
    private String idPegawai;
    @Basic(optional = false)
    @Column(name = "id_pelanggan")
    private String idPelanggan;
    @Basic(optional = false)
    @Column(name = "no_pembelian")
    private String noPembelian;

    public DetailPembelianPK() {
    }

    public DetailPembelianPK(String kodeMenu, String idPegawai, String idPelanggan, String noPembelian) {
        this.kodeMenu = kodeMenu;
        this.idPegawai = idPegawai;
        this.idPelanggan = idPelanggan;
        this.noPembelian = noPembelian;
    }

    public String getKodeMenu() {
        return kodeMenu;
    }

    public void setKodeMenu(String kodeMenu) {
        this.kodeMenu = kodeMenu;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(String idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNoPembelian() {
        return noPembelian;
    }

    public void setNoPembelian(String noPembelian) {
        this.noPembelian = noPembelian;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodeMenu != null ? kodeMenu.hashCode() : 0);
        hash += (idPegawai != null ? idPegawai.hashCode() : 0);
        hash += (idPelanggan != null ? idPelanggan.hashCode() : 0);
        hash += (noPembelian != null ? noPembelian.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailPembelianPK)) {
            return false;
        }
        DetailPembelianPK other = (DetailPembelianPK) object;
        if ((this.kodeMenu == null && other.kodeMenu != null) || (this.kodeMenu != null && !this.kodeMenu.equals(other.kodeMenu))) {
            return false;
        }
        if ((this.idPegawai == null && other.idPegawai != null) || (this.idPegawai != null && !this.idPegawai.equals(other.idPegawai))) {
            return false;
        }
        if ((this.idPelanggan == null && other.idPelanggan != null) || (this.idPelanggan != null && !this.idPelanggan.equals(other.idPelanggan))) {
            return false;
        }
        if ((this.noPembelian == null && other.noPembelian != null) || (this.noPembelian != null && !this.noPembelian.equals(other.noPembelian))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DetailPembelianPK[ kodeMenu=" + kodeMenu + ", idPegawai=" + idPegawai + ", idPelanggan=" + idPelanggan + ", noPembelian=" + noPembelian + " ]";
    }
    
}
