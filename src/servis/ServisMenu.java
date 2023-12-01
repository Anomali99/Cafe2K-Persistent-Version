/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servis;

import java.util.List;
import model.Menu;

/**
 *
 * @author fatiq
 */
public interface ServisMenu {
    void tambahData(Menu mod);
    void ubahData(Menu mod);
    void hapusData(String id);
    
    List<Menu> ambilData(); 
    List<Menu> getTerlaris();
    List<Menu> getByKODE(String kode);
    List<Menu> getByNama(String nama);
    List<Menu> getByBahan(String bahan);
    Menu getByKode(String kode);
    String getNomer();
}
