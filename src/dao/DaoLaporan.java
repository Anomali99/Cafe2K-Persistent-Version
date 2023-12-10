/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JPanel;
import model.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import servis.ServisLaporan;
import view.CetakNota;

/**
 *
 * @author fatiq
 */
public class DaoLaporan implements ServisLaporan {

    @Override
    public JasperPrint cetakNotaPembelian(Pembelian mod) {
        try {
            String path = "src/report/NotaPembelian.jrxml";
            List<DetailPembelian> result = new ArrayList();
            result.addAll(mod.getDetailPembelianCollection());
            HashMap<String, Object> par = new HashMap<>();
            par.put("no", mod.getPembelianPK().getNoPembelian());
            par.put("tgl", mod.getTanggal());
            par.put("total", mod.getRpTotal());
            par.put("idP", mod.getPegawai().getIdPegawai());
            par.put("namaP", mod.getPegawai().getNama());
            par.put("idS", mod.getPelanggan().getIdPelanggan());
            par.put("namaS", mod.getPelanggan().getNama());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(result);
            JasperReport jasperReport = JasperCompileManager.compileReport(path);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, par, dataSource);
            new CetakNota(null, true, print,"","Nota Pembelian").setVisible(true);
            return print;
        } catch (JRException ex) {
            Logger.getLogger(DaoLaporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public JasperPrint cetakNotaSupply(Supply mod) {
        try {
            String path = "src/report/NotaSupply.jrxml";
            List<DetailSupply> result = new ArrayList();
            result.addAll(mod.getDetailSupplyCollection());
            HashMap<String, Object> par = new HashMap<>();
            par.put("no", mod.getSupplyPK().getNoSupply());
            par.put("tgl", mod.getTanggal());
            par.put("total", mod.getRpTotal());
            par.put("idP", mod.getPegawai().getIdPegawai());
            par.put("namaP", mod.getPegawai().getNama());
            par.put("idS", mod.getSupplier().getIdSupplier());
            par.put("namaS", mod.getSupplier().getNama());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(result);
            JasperReport jasperReport = JasperCompileManager.compileReport(path);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, par, dataSource);
            new CetakNota(null, true, print,"","Nota Supply").setVisible(true);
            return print;
        } catch (JRException ex) {
            Logger.getLogger(DaoLaporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public JasperPrint cetakKTA(Pegawai mod) {
        try {
            String path = "src/report/Kartu.jrxml";
            List<Pegawai> result = new ArrayList();
            result.add(mod);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(result);
            JasperReport jasperReport = JasperCompileManager.compileReport(path);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, null, dataSource);
            new CetakNota(null, true, print, mod.getEmail(),"Kartu Tanda Petugas").setVisible(true);
            return print;
        } catch (JRException ex) {
            Logger.getLogger(DaoLaporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public JasperPrint cetakPembelianPerBulan(JPanel pn, int bulan, int tahun) {
        try {
            String path = "src/report/PembelianPerBulan.jrxml";
            SimpleDateFormat tgl = new SimpleDateFormat("dd-MM-yyyy");
            String ak = getTgl(bulan, tahun);
            EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
            em.getTransaction().begin();
            TypedQuery<Pembelian> query = em.createNamedQuery("Pembelian.getPerBulan", Pembelian.class);
            query.setParameter("tglAwal", tgl.parse("01-"+String.format( "%02d",(bulan+1))+"-"+String.valueOf(tahun)));
            query.setParameter("tglAkhir", tgl.parse(ak+"-"+String.format( "%02d",(bulan+1))+"-"+String.valueOf(tahun)));
            List<Pembelian> result = query.getResultList();
            em.getTransaction().commit();
            em.close();
            long total = 0;
            for (Pembelian p : result) {
                long l = Long.parseLong(p.getTotal().toString());
                total = total + l;
            }
            HashMap<String, Object> par = new HashMap<>();
            par.put("bulan", getBulan(bulan));
            par.put("tahun", String.valueOf(tahun));
            par.put("total", Rupiah.getRp(total));
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(result);
            JasperReport jasperReport = JasperCompileManager.compileReport(path);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, par, dataSource);
            pn.removeAll();
            pn.setLayout(new BorderLayout());
            pn.repaint();
            pn.add(new JRViewer(print));
            pn.revalidate();
            return print;
        } catch (JRException ex) {
            Logger.getLogger(DaoLaporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(DaoLaporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public JasperPrint cetakSupplyPerBulan(JPanel pn, int bulan, int tahun) {
        try {
            String path = "src/report/SupplyPerBulan.jrxml";
            SimpleDateFormat tgl = new SimpleDateFormat("dd-MM-yyyy");
            String ak = getTgl(bulan, tahun);
            EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
            em.getTransaction().begin();
            TypedQuery<Supply> query = em.createNamedQuery("Supply.getPerBulan", Supply.class);
            query.setParameter("tglAwal", tgl.parse("01-"+String.format( "%02d",(bulan+1))+"-"+String.valueOf(tahun)));
            query.setParameter("tglAkhir", tgl.parse(ak+"-"+String.format( "%02d",(bulan+1))+"-"+String.valueOf(tahun)));
            List<Supply> result = query.getResultList();
            em.getTransaction().commit();
            em.close();
            long total = 0;
            for (Supply p : result) {
                long l = Long.parseLong(p.getTotal().toString());
                total = total + l;
            }
            HashMap<String, Object> par = new HashMap<>();
            par.put("bulan", getBulan(bulan));
            par.put("tahun", String.valueOf(tahun));
            par.put("total", Rupiah.getRp(total));
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(result);
            JasperReport jasperReport = JasperCompileManager.compileReport(path);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, par, dataSource);
            pn.removeAll();
            pn.setLayout(new BorderLayout());
            pn.repaint();
            pn.add(new JRViewer(print));
            pn.revalidate();
            return print;
        } catch (JRException ex) {
            Logger.getLogger(DaoLaporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(DaoLaporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public JasperPrint cetakMasakPerBulan(JPanel pn, int bulan, int tahun) {
        try {
            String path = "src/report/MasakPerBulan.jrxml";
            SimpleDateFormat tgl = new SimpleDateFormat("dd-MM-yyyy");
            String ak = getTgl(bulan, tahun);
            EntityManager em = Persistence.createEntityManagerFactory("NewCafe2KPU").createEntityManager();
            em.getTransaction().begin();
            TypedQuery<Memasak> query = em.createNamedQuery("Memasak.getPerBulan", Memasak.class);
            query.setParameter("tglAwal", tgl.parse("01-"+String.format( "%02d",(bulan+1))+"-"+String.valueOf(tahun)));
            query.setParameter("tglAkhir", tgl.parse(ak+"-"+String.format( "%02d",(bulan+1))+"-"+String.valueOf(tahun)));
            List<Memasak> result = query.getResultList();
            em.getTransaction().commit();
            em.close();
            HashMap<String, Object> par = new HashMap<>();
            par.put("bulan", getBulan(bulan));
            par.put("tahun", String.valueOf(tahun));
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(result);
            JasperReport jasperReport = JasperCompileManager.compileReport(path);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, par, dataSource);
            pn.removeAll();
            pn.setLayout(new BorderLayout());
            pn.repaint();
            pn.add(new JRViewer(print));
            pn.revalidate();
            return print;
        } catch (JRException ex) {
            Logger.getLogger(DaoLaporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(DaoLaporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private String getBulan(int i) {
        String s = "";
        switch (i) {
            case 0:
                s = "Januari";
                break;
            case 1:
                s = "Februari";
                break;
            case 2:
                s = "Maret";
                break;
            case 3:
                s = "April";
                break;
            case 4:
                s = "Mei";
                break;
            case 5:
                s = "Juni";
                break;
            case 6:
                s = "Juli";
                break;
            case 7:
                s = "Agustus";
                break;
            case 8:
                s = "September";
                break;
            case 9:
                s = "Oktober";
                break;
            case 10:
                s = "November";
                break;
            case 11:
                s = "Desember";
                break;
        }
        return s;
    }
    
    private String getTgl(int bulan, int tahun){
        String ak = "";
            switch(bulan+1){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    ak = "31";
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    ak = "30";
                    break;
                case 2:
                    if((tahun%4==0&&tahun%100!=0)||tahun%400==0){
                        ak = "29";
                    } else {
                        ak = "28";
                    }
                    break;
            }
            return ak;
    }

}
