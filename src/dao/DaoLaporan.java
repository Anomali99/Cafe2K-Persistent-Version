/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
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
            par.put("no",mod.getPembelianPK().getNoPembelian());
            par.put("tgl",mod.getTanggal());
            par.put("total",mod.getRpTotal());
            par.put("idP",mod.getPegawai().getIdPegawai());
            par.put("namaP",mod.getPegawai().getNama());
            par.put("idS",mod.getPelanggan().getIdPelanggan());
            par.put("namaS",mod.getPelanggan().getNama());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(result);
            JasperReport jasperReport = JasperCompileManager.compileReport(path);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, par, dataSource);
            new CetakNota(null, true, print).setVisible(true);
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
            par.put("no",mod.getSupplyPK().getNoSupply());
            par.put("tgl",mod.getTanggal());
            par.put("total",mod.getRpTotal());
            par.put("idP",mod.getPegawai().getIdPegawai());
            par.put("namaP",mod.getPegawai().getNama());
            par.put("idS",mod.getSupplier().getIdSupplier());
            par.put("namaS",mod.getSupplier().getNama());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(result);
            JasperReport jasperReport = JasperCompileManager.compileReport(path);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, par, dataSource);
            new CetakNota(null, true, print).setVisible(true);
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
            new CetakNota(null, true, print,mod.getEmail()).setVisible(true);
            return print;
        } catch (JRException ex) {
            Logger.getLogger(DaoLaporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
