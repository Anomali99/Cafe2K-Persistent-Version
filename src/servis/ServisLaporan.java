/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servis;

import javax.swing.JPanel;
import model.*;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author fatiq
 */
public interface ServisLaporan {
    JasperPrint cetakNotaPembelian(Pembelian mod);
    JasperPrint cetakNotaSupply(Supply mod);
    JasperPrint cetakKTA(Pegawai mod);
    JasperPrint cetakPembelianPerBulan(JPanel pn,int bulan, int tahun);
}
