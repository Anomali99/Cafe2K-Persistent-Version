/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servis;

import java.util.List;
import model.Supplier;

/**
 *
 * @author fatiq
 */
public interface ServisSupplier {
    void tambahData(Supplier mod);
    void ubahData(Supplier mod);
    void hapusData(String id);
    
    List<Supplier> ambilData();
    List<Supplier> getByID(String id);
    List<Supplier> getByNama(String nama);
    List<Supplier> getByAlamat(String alamat);
    Supplier getById(String id);
    String getNomer();
}
