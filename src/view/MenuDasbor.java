/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import dao.DaoMenu;
import java.util.List;
import javax.swing.JLabel;
import model.Menu;
import servis.ServisMenu;

/**
 *
 * @author fatiq
 */
public class MenuDasbor extends javax.swing.JPanel {

    /**
     * Creates new form MenuPetugas
     */
    private final ServisMenu servis = new DaoMenu();

    public MenuDasbor() {
        initComponents();
        menu1.setText("");
        harga1.setText("");
        menu2.setText("");
        harga2.setText("");
        menu3.setText("");
        harga3.setText("");
        menu4.setText("");
        harga4.setText("");
        menu5.setText("");
        harga5.setText("");
        menu6.setText("");
        harga6.setText("");
        setMn();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelCustom3 = new custom.JPanelCustom();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        menu1 = new javax.swing.JLabel();
        harga1 = new javax.swing.JLabel();
        menu2 = new javax.swing.JLabel();
        harga2 = new javax.swing.JLabel();
        menu3 = new javax.swing.JLabel();
        harga3 = new javax.swing.JLabel();
        menu4 = new javax.swing.JLabel();
        harga4 = new javax.swing.JLabel();
        menu5 = new javax.swing.JLabel();
        harga5 = new javax.swing.JLabel();
        menu6 = new javax.swing.JLabel();
        harga6 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BGCafe2K.png"))); // NOI18N

        jPanelCustom3.setBackground(new java.awt.Color(166, 145, 138));
        jPanelCustom3.setKananAtas(20);
        jPanelCustom3.setKananBawah(20);
        jPanelCustom3.setKiriAtas(20);
        jPanelCustom3.setKiriBawah(20);

        jSeparator1.setBackground(new java.awt.Color(79, 42, 24));
        jSeparator1.setForeground(new java.awt.Color(79, 42, 24));

        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(79, 42, 24));
        jLabel2.setText("Menu Terlaris");

        menu1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        menu1.setForeground(new java.awt.Color(79, 42, 24));
        menu1.setText("Menu Terlaris");

        harga1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        harga1.setForeground(new java.awt.Color(79, 42, 24));
        harga1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        harga1.setText("15000");

        menu2.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        menu2.setForeground(new java.awt.Color(79, 42, 24));
        menu2.setText("Menu Terlaris");

        harga2.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        harga2.setForeground(new java.awt.Color(79, 42, 24));
        harga2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        harga2.setText("15000");

        menu3.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        menu3.setForeground(new java.awt.Color(79, 42, 24));
        menu3.setText("Menu Terlaris");

        harga3.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        harga3.setForeground(new java.awt.Color(79, 42, 24));
        harga3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        harga3.setText("15000");

        menu4.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        menu4.setForeground(new java.awt.Color(79, 42, 24));
        menu4.setText("Menu Terlaris");

        harga4.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        harga4.setForeground(new java.awt.Color(79, 42, 24));
        harga4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        harga4.setText("15000");

        menu5.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        menu5.setForeground(new java.awt.Color(79, 42, 24));
        menu5.setText("Menu Terlaris");

        harga5.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        harga5.setForeground(new java.awt.Color(79, 42, 24));
        harga5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        harga5.setText("15000");

        menu6.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        menu6.setForeground(new java.awt.Color(79, 42, 24));
        menu6.setText("Menu Terlaris");

        harga6.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        harga6.setForeground(new java.awt.Color(79, 42, 24));
        harga6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        harga6.setText("15000");

        javax.swing.GroupLayout jPanelCustom3Layout = new javax.swing.GroupLayout(jPanelCustom3);
        jPanelCustom3.setLayout(jPanelCustom3Layout);
        jPanelCustom3Layout.setHorizontalGroup(
            jPanelCustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCustom3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanelCustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCustom3Layout.createSequentialGroup()
                        .addGroup(jPanelCustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(menu6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanelCustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(harga5, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(harga6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCustom3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 275, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCustom3Layout.createSequentialGroup()
                        .addGroup(jPanelCustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(menu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(menu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(menu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(harga3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(harga2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(harga1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(harga4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(14, 14, 14))
        );
        jPanelCustom3Layout.setVerticalGroup(
            jPanelCustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCustom3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu1)
                    .addComponent(harga1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu2)
                    .addComponent(harga2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu3)
                    .addComponent(harga3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu4)
                    .addComponent(harga4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu5)
                    .addComponent(harga5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCustom3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(menu6)
                    .addComponent(harga6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanelCustom3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanelCustom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, "card3");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel harga1;
    private javax.swing.JLabel harga2;
    private javax.swing.JLabel harga3;
    private javax.swing.JLabel harga4;
    private javax.swing.JLabel harga5;
    private javax.swing.JLabel harga6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private custom.JPanelCustom jPanelCustom3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel menu1;
    private javax.swing.JLabel menu2;
    private javax.swing.JLabel menu3;
    private javax.swing.JLabel menu4;
    private javax.swing.JLabel menu5;
    private javax.swing.JLabel menu6;
    // End of variables declaration//GEN-END:variables

    private void setMn() {
        JLabel[] menu = {menu1,menu2,menu3,menu4,menu5,menu6};
        JLabel[] harga = {harga1,harga2,harga3,harga4,harga5,harga6};
        List<Menu> mn = servis.getTerlaris();
        for(int i = 0; i < mn.size(); i++){
            menu[i].setText(mn.get(i).getNama());
            harga[i].setText(mn.get(i).getRpHarga());
        }
    }
}
