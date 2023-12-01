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
public class DetailBahanPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "kode_menu")
    private String kodeMenu;
    @Basic(optional = false)
    @Column(name = "kode_bahan")
    private String kodeBahan;

    public DetailBahanPK() {
    }

    public DetailBahanPK(String kodeMenu, String kodeBahan) {
        this.kodeMenu = kodeMenu;
        this.kodeBahan = kodeBahan;
    }

    public String getKodeMenu() {
        return kodeMenu;
    }

    public void setKodeMenu(String kodeMenu) {
        this.kodeMenu = kodeMenu;
    }

    public String getKodeBahan() {
        return kodeBahan;
    }

    public void setKodeBahan(String kodeBahan) {
        this.kodeBahan = kodeBahan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodeMenu != null ? kodeMenu.hashCode() : 0);
        hash += (kodeBahan != null ? kodeBahan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailBahanPK)) {
            return false;
        }
        DetailBahanPK other = (DetailBahanPK) object;
        if ((this.kodeMenu == null && other.kodeMenu != null) || (this.kodeMenu != null && !this.kodeMenu.equals(other.kodeMenu))) {
            return false;
        }
        if ((this.kodeBahan == null && other.kodeBahan != null) || (this.kodeBahan != null && !this.kodeBahan.equals(other.kodeBahan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DetailBahanPK[ kodeMenu=" + kodeMenu + ", kodeBahan=" + kodeBahan + " ]";
    }
    
}
