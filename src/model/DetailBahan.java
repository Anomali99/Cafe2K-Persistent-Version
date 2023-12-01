/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "detail_bahan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailBahan.findAll", query = "SELECT d FROM DetailBahan d"),
    @NamedQuery(name = "DetailBahan.findByKodeMenu", query = "SELECT d FROM DetailBahan d WHERE d.detailBahanPK.kodeMenu = :kodeMenu"),
    @NamedQuery(name = "DetailBahan.findByKodeBahan", query = "SELECT d FROM DetailBahan d WHERE d.detailBahanPK.kodeBahan = :kodeBahan"),
    @NamedQuery(name = "DetailBahan.findByJumlah", query = "SELECT d FROM DetailBahan d WHERE d.jumlah = :jumlah")})
public class DetailBahan implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailBahanPK detailBahanPK;
    @Column(name = "jumlah")
    private Integer jumlah;
    @JoinColumn(name = "kode_bahan", referencedColumnName = "kode_bahan", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bahan bahan;
    @JoinColumn(name = "kode_menu", referencedColumnName = "kode_menu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menu menu;

    public DetailBahan() {
    }

    public DetailBahan(DetailBahanPK detailBahanPK) {
        this.detailBahanPK = detailBahanPK;
    }

    public DetailBahan(String kodeMenu, String kodeBahan) {
        this.detailBahanPK = new DetailBahanPK(kodeMenu, kodeBahan);
    }

    public DetailBahanPK getDetailBahanPK() {
        return detailBahanPK;
    }

    public void setDetailBahanPK(DetailBahanPK detailBahanPK) {
        this.detailBahanPK = detailBahanPK;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Bahan getBahan() {
        return bahan;
    }

    public void setBahan(Bahan bahan) {
        this.bahan = bahan;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailBahanPK != null ? detailBahanPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailBahan)) {
            return false;
        }
        DetailBahan other = (DetailBahan) object;
        if ((this.detailBahanPK == null && other.detailBahanPK != null) || (this.detailBahanPK != null && !this.detailBahanPK.equals(other.detailBahanPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DetailBahan[ detailBahanPK=" + detailBahanPK + " ]";
    }
    
}
