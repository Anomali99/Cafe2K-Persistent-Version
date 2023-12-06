/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servis;

import java.util.Date;
import java.util.List;
import model.Supply;

/**
 *
 * @author fatiq
 */
public interface ServisSupply {
    void tambahData(Supply mod);
    void hapusData(String id);
    
    List<Supply> ambilData();
    List<Supply> getByNO(String no);
    List<Supply> getByTanggal(Date tanggal);
    List<Supply> getByPetugas(String nama);
    List<Supply> getBySupplier(String nama);
    Supply getByNo(String no);
    String getNomer();
}
