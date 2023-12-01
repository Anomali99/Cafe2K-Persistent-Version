/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servis;

import java.util.List;
import model.Pelanggan;

/**
 *
 * @author fatiq
 */
public interface ServisPelanggan {
    void tambahData(Pelanggan mod);
    void ubahData(Pelanggan mod);
    void hapusData(String id);
    
    List<Pelanggan> ambilData();
    List<Pelanggan> getByID(String id);
    List<Pelanggan> getByNama(String nama);
    List<Pelanggan> getByAlamat(String alamat);
    Pelanggan getById(String id);
    String getNomer();
}
