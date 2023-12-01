/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import config.koneksi;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import servis.ServisLaporan;
import view.CetakNota;

/**
 *
 * @author fatiq
 */
public class DaoLaporan implements ServisLaporan {

    Connection conn = null;

    public DaoLaporan() {
        conn = koneksi.getConnection();
    }

    @Override
    public JasperPrint cetakNotaPembelian(String no) {
        try {
            String path = "src/report/NotaPembelian.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(path);
            HashMap<String, Object> par = new HashMap<>();
            par.put("no", no);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, par, conn);
            new CetakNota(null,true,print).setVisible(true);
            return print;
        } catch (JRException ex) {
            Logger.getLogger(DaoLaporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public JasperPrint cetakNotaSupply(String no) {
        try {
            String path = "src/report/NotaSupply.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(path);
            HashMap<String, Object> par = new HashMap<>();
            par.put("no", no);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, par, conn);
            new CetakNota(null,true,print).setVisible(true);
            return print;
        } catch (JRException ex) {
            Logger.getLogger(DaoLaporan.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
