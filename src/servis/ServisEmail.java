/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servis;

import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author fatiq
 */
public interface ServisEmail {
    void kririm(String email, String subyek, JasperPrint print);
    String krirmKode(String email);
}
