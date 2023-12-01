/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
    @NamedQuery(name = "Memasak.findAll", query = "SELECT m FROM Memasak m"),
    @NamedQuery(name = "Memasak.findByIdPegawai", query = "SELECT m FROM Memasak m WHERE m.memasakPK.idPegawai = :idPegawai"),
    @NamedQuery(name = "Memasak.findByTanggal", query = "SELECT m FROM Memasak m WHERE m.tanggal = :tanggal"),
    @NamedQuery(name = "Memasak.findByKeterangan", query = "SELECT m FROM Memasak m WHERE m.keterangan = :keterangan"),
    @NamedQuery(name = "Memasak.findByNoMasak", query = "SELECT m FROM Memasak m WHERE m.memasakPK.noMasak = :noMasak")})
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
}
