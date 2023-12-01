/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servis;

import java.util.List;
import model.Pembelian;

/**
 *
 * @author fatiq
 */
public interface ServisPembelian {
    void tambahData(Pembelian mod);
    void hapusData(String id);
    
    List<Pembelian> ambilData();
    List<Pembelian> getByNO(String no);
    List<Pembelian> getByTanggal(String tanggal);
    List<Pembelian> getByPetugas(String nama);
    List<Pembelian> getByPelanggan(String nama);
    Pembelian getByNo(String no);
    String getNomer();
}
