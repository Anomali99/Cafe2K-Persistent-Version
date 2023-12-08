    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.Rupiah;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fatiq
 */
@Entity
@Table(name = "pembelian")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pembelian.getAll", query = "SELECT p FROM Pembelian p ORDER BY p.pembelianPK.noPembelian"),
    @NamedQuery(name = "Pembelian.getByNo", query = "SELECT p FROM Pembelian p WHERE p.pembelianPK.noPembelian = :noPembelian "),
    @NamedQuery(name = "Pembelian.getByPegawai", query = "SELECT p FROM Pembelian p WHERE LOWER(p.pegawai.nama) LIKE LOWER(:nama) ORDER BY p.pembelianPK.noPembelian"),
    @NamedQuery(name = "Pembelian.getByPelanggan", query = "SELECT p FROM Pembelian p WHERE LOWER(p.pelanggan.nama) LIKE LOWER(:nama) ORDER BY p.pembelianPK.noPembelian"),
    @NamedQuery(name = "Pembelian.getByNO", query = "SELECT p FROM Pembelian p WHERE LOWER(p.pembelianPK.noPembelian) LIKE LOWER(:noPembelian) ORDER BY p.pembelianPK.noPembelian"),
    @NamedQuery(name = "Pembelian.getByTanggal", query = "SELECT p FROM Pembelian p WHERE p.tanggal = :tanggal ORDER BY p.pembelianPK.noPembelian"),
    @NamedQuery(name = "Pembelian.getByTotal", query = "SELECT p FROM Pembelian p WHERE p.total = :total ORDER BY p.pembelianPK.noPembelian"),
    @NamedQuery(name = "Pembelian.getPerBulan", query = "SELECT p FROM Pembelian p WHERE p.tanggal BETWEEN :tglAwal AND :tglAkhir ORDER BY p.pembelianPK.noPembelian"),
    @NamedQuery(name = "Pembelian.getByStatus", query = "SELECT p FROM Pembelian p WHERE LOWER(p.status) LIKE LOWER(:status) ORDER BY p.pembelianPK.noPembelian"),
    @NamedQuery(name = "Pembelian.getNomer", query = "SELECT SUBSTRING(p.pembelianPK.noPembelian, LENGTH(p.pembelianPK.noPembelian) - 2) AS nomor FROM Pembelian p WHERE p.pembelianPK.noPembelian LIKE 'T%' ORDER BY p.pembelianPK.noPembelian DESC")})
public class Pembelian implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PembelianPK pembelianPK;
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Column(name = "total")
    private BigInteger total;
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pembelian")
    private Collection<DetailPembelian> detailPembelianCollection;
    @JoinColumn(name = "id_pegawai", referencedColumnName = "id_pegawai", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pegawai pegawai;
    @JoinColumn(name = "id_pelanggan", referencedColumnName = "id_pelanggan", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pelanggan pelanggan;

    public Pembelian() {
    }

    public Pembelian(PembelianPK pembelianPK) {
        this.pembelianPK = pembelianPK;
    }

    public Pembelian(String idPegawai, String idPelanggan, String noPembelian) {
        this.pembelianPK = new PembelianPK(idPegawai, idPelanggan, noPembelian);
    }

    public PembelianPK getPembelianPK() {
        return pembelianPK;
    }

    public void setPembelianPK(PembelianPK pembelianPK) {
        this.pembelianPK = pembelianPK;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<DetailPembelian> getDetailPembelianCollection() {
        return detailPembelianCollection;
    }

    public void setDetailPembelianCollection(Collection<DetailPembelian> detailPembelianCollection) {
        this.detailPembelianCollection = detailPembelianCollection;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pembelianPK != null ? pembelianPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pembelian)) {
            return false;
        }
        Pembelian other = (Pembelian) object;
        if ((this.pembelianPK == null && other.pembelianPK != null) || (this.pembelianPK != null && !this.pembelianPK.equals(other.pembelianPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pembelian[ pembelianPK=" + pembelianPK + " ]";
    }
    
    public String getTgl(){
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String tgl = "";
        try {
            Date date = inputDateFormat.parse(tanggal.toString());
            tgl = outputDateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return tgl;
    }
    
    public void setTgl(String tgl){
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            tanggal = inputDateFormat.parse(tgl);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getRpTotal() {
        return Rupiah.getRp(total);
    }
    
}
