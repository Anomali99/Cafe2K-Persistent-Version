/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servis;

import java.util.List;
import model.Bahan;

/**
 *
 * @author fatiq
 */
public interface ServisBahan {
    void tambahData(Bahan mod);
    void ubahData(Bahan mod);
    void hapusData(String kode);
    
    List<Bahan> ambilData();
    List<Bahan> getByKODE(String kode);
    List<Bahan> getByNama(String nama);
    Bahan getByKode(String kode);
    String getNomer();
}
