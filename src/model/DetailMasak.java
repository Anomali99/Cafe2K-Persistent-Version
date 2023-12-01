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
@Table(name = "detail_masak")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailMasak.findAll", query = "SELECT d FROM DetailMasak d"),
    @NamedQuery(name = "DetailMasak.findByIdPegawai", query = "SELECT d FROM DetailMasak d WHERE d.detailMasakPK.idPegawai = :idPegawai"),
    @NamedQuery(name = "DetailMasak.findByNoMasak", query = "SELECT d FROM DetailMasak d WHERE d.detailMasakPK.noMasak = :noMasak"),
    @NamedQuery(name = "DetailMasak.findByKodeMenu", query = "SELECT d FROM DetailMasak d WHERE d.detailMasakPK.kodeMenu = :kodeMenu"),
    @NamedQuery(name = "DetailMasak.findByJumlah", query = "SELECT d FROM DetailMasak d WHERE d.jumlah = :jumlah")})
public class DetailMasak implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailMasakPK detailMasakPK;
    @Column(name = "jumlah")
    private Integer jumlah;
    @JoinColumns({
        @JoinColumn(name = "id_pegawai", referencedColumnName = "id_pegawai", insertable = false, updatable = false),
        @JoinColumn(name = "no_masak", referencedColumnName = "no_masak", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Memasak memasak;
    @JoinColumn(name = "kode_menu", referencedColumnName = "kode_menu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Menu menu;

    public DetailMasak() {
    }

    public DetailMasak(DetailMasakPK detailMasakPK) {
        this.detailMasakPK = detailMasakPK;
    }

    public DetailMasak(String idPegawai, String noMasak, String kodeMenu) {
        this.detailMasakPK = new DetailMasakPK(idPegawai, noMasak, kodeMenu);
    }

    public DetailMasakPK getDetailMasakPK() {
        return detailMasakPK;
    }

    public void setDetailMasakPK(DetailMasakPK detailMasakPK) {
        this.detailMasakPK = detailMasakPK;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Memasak getMemasak() {
        return memasak;
    }

    public void setMemasak(Memasak memasak) {
        this.memasak = memasak;
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
        hash += (detailMasakPK != null ? detailMasakPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailMasak)) {
            return false;
        }
        DetailMasak other = (DetailMasak) object;
        if ((this.detailMasakPK == null && other.detailMasakPK != null) || (this.detailMasakPK != null && !this.detailMasakPK.equals(other.detailMasakPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.DetailMasak[ detailMasakPK=" + detailMasakPK + " ]";
    }
    
}
