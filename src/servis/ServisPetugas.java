/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servis;

import java.util.List;
import model.Pegawai;

/**
 *
 * @author fatiq
 */
public interface ServisPetugas {
    void tambahData(Pegawai mod);
    void ubahData(Pegawai mod);
    void hapusData(String id);
    
    List<Pegawai> ambilData();
    List<Pegawai> getByID(String id);
    List<Pegawai> getByNama(String nama);
    List<Pegawai> getByAlamat(String alamat);
    Pegawai getById(String id);
    Pegawai login(String user, String pass);
    String getNomer();
}
