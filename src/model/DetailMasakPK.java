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
public class DetailMasakPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_pegawai")
    private String idPegawai;
    @Basic(optional = false)
    @Column(name = "no_masak")
    private String noMasak;
    @Basic(optional = false)
    @Column(name = "kode_menu")
    private String kodeMenu;

    public DetailMasakPK() {
    }

    public DetailMasakPK(String idPegawai, String noMasak, String kodeMenu) {
        this.idPegawai = idPegawai;
        this.noMasak = noMasak;
        this.kodeMenu = kodeMenu;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getNoMasak() {
        return noMasak;
    }

    public void setNoMasak(String noMasak) {
        this.noMasak = noMasak;
    }

    public String getKodeMenu() {
        return kodeMenu;
    }

    public void setKodeMenu(String kodeMenu) {
        this.kodeMenu = kodeMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPegawai != null ? idPegawai.hashCode() : 0);
        hash += (noMasak != null ? noMasak.hashCode() : 0);
        hash += (kodeMenu != null ? kodeMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailMasakPK)) {
            return false;
        }
        DetailMasakPK other = (DetailMasakPK) object;
        if ((this.idPegawai == null && other.idPegawai != null) || (this.idPegawai != null && !this.idPegawai.equals(other.idPegawai))) {
            return false;
        }
        if ((this.noMasak == null && other.noMasak != null) || (this.noMasak != null && !this.noMasak.equals(other.noMasak))) {
            return false;
        }
        if ((this.kodeMenu == null && other.kodeMenu != null) || (this.kodeMenu != null && !this.kodeMenu.equals(other.kodeMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DetailMasakPK[ idPegawai=" + idPegawai + ", noMasak=" + noMasak + ", kodeMenu=" + kodeMenu + " ]";
    }
    
}
