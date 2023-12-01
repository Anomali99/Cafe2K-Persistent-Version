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
public class SupplyPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_supplier")
    private String idSupplier;
    @Basic(optional = false)
    @Column(name = "id_pegawai")
    private String idPegawai;
    @Basic(optional = false)
    @Column(name = "no_supply")
    private String noSupply;

    public SupplyPK() {
    }

    public SupplyPK(String idSupplier, String idPegawai, String noSupply) {
        this.idSupplier = idSupplier;
        this.idPegawai = idPegawai;
        this.noSupply = noSupply;
    }

    public String getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(String idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getNoSupply() {
        return noSupply;
    }

    public void setNoSupply(String noSupply) {
        this.noSupply = noSupply;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSupplier != null ? idSupplier.hashCode() : 0);
        hash += (idPegawai != null ? idPegawai.hashCode() : 0);
        hash += (noSupply != null ? noSupply.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplyPK)) {
            return false;
        }
        SupplyPK other = (SupplyPK) object;
        if ((this.idSupplier == null && other.idSupplier != null) || (this.idSupplier != null && !this.idSupplier.equals(other.idSupplier))) {
            return false;
        }
        if ((this.idPegawai == null && other.idPegawai != null) || (this.idPegawai != null && !this.idPegawai.equals(other.idPegawai))) {
            return false;
        }
        if ((this.noSupply == null && other.noSupply != null) || (this.noSupply != null && !this.noSupply.equals(other.noSupply))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SupplyPK[ idSupplier=" + idSupplier + ", idPegawai=" + idPegawai + ", noSupply=" + noSupply + " ]";
    }
    
}
