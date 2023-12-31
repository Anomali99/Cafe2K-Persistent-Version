/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.Rupiah;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.getAll", query = "SELECT m FROM Menu m ORDER BY m.kodeMenu"),
    @NamedQuery(name = "Menu.getByKode", query = "SELECT m FROM Menu m WHERE m.kodeMenu = :kodeMenu ORDER BY m.kodeMenu"),
    @NamedQuery(name = "Menu.getByKODE", query = "SELECT m FROM Menu m WHERE LOWER(m.kodeMenu) LIKE LOWER(:kodeMenu) ORDER BY m.kodeMenu"),
    @NamedQuery(name = "Menu.getByNama", query = "SELECT m FROM Menu m WHERE LOWER(m.nama) LIKE LOWER(:nama) ORDER BY m.kodeMenu"),
    @NamedQuery(name = "Menu.getByHarga", query = "SELECT m FROM Menu m WHERE m.harga = :harga ORDER BY m.kodeMenu"),
    @NamedQuery(name = "Menu.getByStok", query = "SELECT m FROM Menu m WHERE m.stok = :stok ORDER BY m.kodeMenu"),
    @NamedQuery(name = "Menu.getTerlaris", query = "SELECT m FROM Menu m WHERE m.kodeMenu IN (SELECT d.detailPembelianPK.kodeMenu FROM DetailPembelian d)"),
    @NamedQuery(name = "Menu.getByBahan", query = "SELECT m FROM Menu m WHERE m.kodeMenu IN (SELECT d.detailBahanPK.kodeMenu FROM DetailBahan d WHERE LOWER(d.bahan.nama) LIKE LOWER(:bahan)) ORDER BY m.kodeMenu"),
    @NamedQuery(name = "Menu.getNomer", query = "SELECT SUBSTRING(m.kodeMenu, LENGTH(m.kodeMenu) - 2) AS nomor FROM Menu m WHERE m.kodeMenu LIKE 'MN%' ORDER BY m.kodeMenu DESC")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kode_menu")
    private String kodeMenu;
    @Column(name = "nama")
    private String nama;
    @Column(name = "harga")
    private BigInteger harga;
    @Column(name = "stok")
    private Integer stok;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private Collection<DetailMasak> detailMasakCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private Collection<DetailPembelian> detailPembelianCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private Collection<DetailBahan> detailBahanCollection;

    public Menu() {
    }

    public Menu(String kodeMenu) {
        this.kodeMenu = kodeMenu;
    }

    public String getKodeMenu() {
        return kodeMenu;
    }

    public void setKodeMenu(String kodeMenu) {
        this.kodeMenu = kodeMenu;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public BigInteger getHarga() {
        return harga;
    }

    public void setHarga(BigInteger harga) {
        this.harga = harga;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    @XmlTransient
    public Collection<DetailMasak> getDetailMasakCollection() {
        return detailMasakCollection;
    }

    public void setDetailMasakCollection(Collection<DetailMasak> detailMasakCollection) {
        this.detailMasakCollection = detailMasakCollection;
    }

    @XmlTransient
    public Collection<DetailPembelian> getDetailPembelianCollection() {
        return detailPembelianCollection;
    }

    public void setDetailPembelianCollection(Collection<DetailPembelian> detailPembelianCollection) {
        this.detailPembelianCollection = detailPembelianCollection;
    }

    @XmlTransient
    public Collection<DetailBahan> getDetailBahanCollection() {
        return detailBahanCollection;
    }

    public void setDetailBahanCollection(Collection<DetailBahan> detailBahanCollection) {
        this.detailBahanCollection = detailBahanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodeMenu != null ? kodeMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.kodeMenu == null && other.kodeMenu != null) || (this.kodeMenu != null && !this.kodeMenu.equals(other.kodeMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Menu[ kodeMenu=" + kodeMenu + " ]";
    }

    public String getAllBahan() {
        String b = "";
        for (DetailBahan db : detailBahanCollection) {
            if (b.equals("")) {
                b = db.getBahan().getNama() + " " + db.getJumlah().toString() + "x";
            } else {
                b = b + ", " + db.getBahan().getNama() + " " + db.getJumlah().toString() + "x";
            }
        }
        return b;
    }

    public String getAllBahan(int i) {
        String b = "";
        for (DetailBahan db : detailBahanCollection) {
            int j = db.getJumlah() * i;
            if (b.equals("")) {
                b = db.getBahan().getNama() + " " + j + "x";
            } else {
                b = b + ", " + db.getBahan().getNama() + " " + j + "x";
            }
        }
        return b;
    }

    public String getRpHarga() {
        return Rupiah.getRp(harga);
    }

    public boolean isBahanCukup(int i) {
        boolean b = true;
        for (DetailBahan db : detailBahanCollection) {
            if (db.getJumlah() * i > db.getBahan().getStok()) {
                b = false;
            }
        }
        return b;
    }

    public int getTerjual() {
        int i = 0;
        try {
            for (DetailPembelian db : detailPembelianCollection) {
                i = i + db.getJumlah();
            }
        } catch (NullPointerException e) {
        }
        return i;
    }
}
