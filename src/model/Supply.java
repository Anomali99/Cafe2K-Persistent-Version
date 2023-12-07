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
@Table(name = "supply")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supply.getAll", query = "SELECT s FROM Supply s ORDER BY s.supplyPK.noSupply"),
    @NamedQuery(name = "Supply.getByNo", query = "SELECT s FROM Supply s WHERE s.supplyPK.noSupply = :noSupply"),
    @NamedQuery(name = "Supply.getBySupplier", query = "SELECT s FROM Supply s WHERE LOWER(s.supplier.nama) LIKE LOWER(:nama) ORDER BY s.supplyPK.noSupply"),
    @NamedQuery(name = "Supply.getByPegawai", query = "SELECT s FROM Supply s WHERE LOWER(s.pegawai.nama) LIKE LOWER(:nama) ORDER BY s.supplyPK.noSupply"),
    @NamedQuery(name = "Supply.getByNO", query = "SELECT s FROM Supply s WHERE LOWER(s.supplyPK.noSupply) LIKE LOWER(:noSupply) ORDER BY s.supplyPK.noSupply"),
    @NamedQuery(name = "Supply.getByTanggal", query = "SELECT s FROM Supply s WHERE s.tanggal = :tanggal ORDER BY s.supplyPK.noSupply"),
    @NamedQuery(name = "Supply.getByTotal", query = "SELECT s FROM Supply s WHERE s.total = :total ORDER BY s.supplyPK.noSupply"),
    @NamedQuery(name = "Supply.getNomer", query = "SELECT SUBSTRING(s.supplyPK.noSupply, LENGTH(s.supplyPK.noSupply) - 2) AS nomor FROM Supply s WHERE s.supplyPK.noSupply LIKE 'R%' ORDER BY s.supplyPK.noSupply DESC")})
public class Supply implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SupplyPK supplyPK;
    @Column(name = "tanggal") 
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Column(name = "total")
    private BigInteger total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supply")
    private Collection<DetailSupply> detailSupplyCollection;
    @JoinColumn(name = "id_pegawai", referencedColumnName = "id_pegawai", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pegawai pegawai;
    @JoinColumn(name = "id_supplier", referencedColumnName = "id_supplier", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Supplier supplier;

    public Supply() {
    }

    public Supply(SupplyPK supplyPK) {
        this.supplyPK = supplyPK;
    }

    public Supply(String idSupplier, String idPegawai, String noSupply) {
        this.supplyPK = new SupplyPK(idSupplier, idPegawai, noSupply);
    }

    public SupplyPK getSupplyPK() {
        return supplyPK;
    }

    public void setSupplyPK(SupplyPK supplyPK) {
        this.supplyPK = supplyPK;
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

    @XmlTransient
    public Collection<DetailSupply> getDetailSupplyCollection() {
        return detailSupplyCollection;
    }

    public void setDetailSupplyCollection(Collection<DetailSupply> detailSupplyCollection) {
        this.detailSupplyCollection = detailSupplyCollection;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplyPK != null ? supplyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supply)) {
            return false;
        }
        Supply other = (Supply) object;
        if ((this.supplyPK == null && other.supplyPK != null) || (this.supplyPK != null && !this.supplyPK.equals(other.supplyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Supply[ supplyPK=" + supplyPK + " ]";
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
    
    public String getRpTotal(){
        return Rupiah.getRp(total);
    }
    
}
