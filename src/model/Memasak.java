/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
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
@Table(name = "memasak")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Memasak.getAll", query = "SELECT m FROM Memasak m ORDER BY m.memasakPK.noMasak"),
    @NamedQuery(name = "Memasak.getByNo", query = "SELECT m FROM Memasak m WHERE m.memasakPK.noMasak = :noMasak"),
    @NamedQuery(name = "Memasak.getByPegawai", query = "SELECT m FROM Memasak m WHERE LOWER(m.pegawai.nama) LIKE LOWER(:nama) ORDER BY m.memasakPK.noMasak"),
    @NamedQuery(name = "Memasak.getByTanggal", query = "SELECT m FROM Memasak m WHERE m.tanggal = :tanggal ORDER BY m.memasakPK.noMasak"),
    @NamedQuery(name = "Memasak.getByKeterangan", query = "SELECT m FROM Memasak m WHERE LOWER(m.keterangan) LIKE LOWER(:keterangan) ORDER BY m.memasakPK.noMasak"),
    @NamedQuery(name = "Memasak.getByNO", query = "SELECT m FROM Memasak m WHERE LOWER(m.memasakPK.noMasak) LIKE LOWER(:noMasak) ORDER BY m.memasakPK.noMasak"),
    @NamedQuery(name = "Memasak.getByMenu", query = "SELECT m FROM Memasak m WHERE m.memasakPK.noMasak IN (SELECT dm.detailMasakPK.noMasak FROM DetailMasak dm WHERE LOWER(dm.menu.nama) LIKE LOWER(:menu)) ORDER BY m.memasakPK.noMasak"),
    @NamedQuery(name = "Memasak.getNomer", query = "SELECT SUBSTRING(m.memasakPK.noMasak, LENGTH(m.memasakPK.noMasak) - 2) AS nomor FROM Memasak m WHERE m.memasakPK.noMasak LIKE 'C%' ORDER BY m.memasakPK.noMasak DESC")})
public class Memasak implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MemasakPK memasakPK;
    @Column(name = "tanggal")
    @Temporal(TemporalType.DATE)
    private Date tanggal;
    @Column(name = "keterangan")
    private String keterangan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memasak")
    private Collection<DetailMasak> detailMasakCollection;
    @JoinColumn(name = "id_pegawai", referencedColumnName = "id_pegawai", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pegawai pegawai;

    public Memasak() {
    }

    public Memasak(MemasakPK memasakPK) {
        this.memasakPK = memasakPK;
    }

    public Memasak(String idPegawai, String noMasak) {
        this.memasakPK = new MemasakPK(idPegawai, noMasak);
    }

    public MemasakPK getMemasakPK() {
        return memasakPK;
    }

    public void setMemasakPK(MemasakPK memasakPK) {
        this.memasakPK = memasakPK;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @XmlTransient
    public Collection<DetailMasak> getDetailMasakCollection() {
        return detailMasakCollection;
    }

    public void setDetailMasakCollection(Collection<DetailMasak> detailMasakCollection) {
        this.detailMasakCollection = detailMasakCollection;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memasakPK != null ? memasakPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Memasak)) {
            return false;
        }
        Memasak other = (Memasak) object;
        if ((this.memasakPK == null && other.memasakPK != null) || (this.memasakPK != null && !this.memasakPK.equals(other.memasakPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Memasak[ memasakPK=" + memasakPK + " ]";
    }
    
    public String getAllMenu(){
        String b = null;
        for(DetailMasak db : detailMasakCollection){
            if(b==null)
                b = db.getMenu().getNama() + " " + db.getJumlah().toString() + "x";
            else
                b = b + ", " + db.getMenu().getNama() + " " + db.getJumlah().toString() + "x";
        }
        return b;
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
}
