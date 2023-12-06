/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servis;

import java.util.Date;
import java.util.List;
import model.Memasak;

/**
 *
 * @author fatiq
 */
public interface ServisMasak {
    void tambahData(Memasak mod);
    void hapusData(String id);
    
    List<Memasak> ambilData();
    List<Memasak> getByNO(String no);
    List<Memasak> getByTanggal(Date tanggal);
    List<Memasak> getByPetugas(String nama);
    List<Memasak> getByMenu(String nama);
    Memasak getByNo(String no);
    String getNomer();
}
