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
public class MemasakPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_pegawai")
    private String idPegawai;
    @Basic(optional = false)
    @Column(name = "no_masak")
    private String noMasak;

    public MemasakPK() {
    }

    public MemasakPK(String idPegawai, String noMasak) {
        this.idPegawai = idPegawai;
        this.noMasak = noMasak;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPegawai != null ? idPegawai.hashCode() : 0);
        hash += (noMasak != null ? noMasak.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemasakPK)) {
            return false;
        }
        MemasakPK other = (MemasakPK) object;
        if ((this.idPegawai == null && other.idPegawai != null) || (this.idPegawai != null && !this.idPegawai.equals(other.idPegawai))) {
            return false;
        }
        if ((this.noMasak == null && other.noMasak != null) || (this.noMasak != null && !this.noMasak.equals(other.noMasak))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MemasakPK[ idPegawai=" + idPegawai + ", noMasak=" + noMasak + " ]";
    }
    
}
