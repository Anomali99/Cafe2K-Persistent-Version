/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import dao.DaoLaporan;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author fatiq
 */
public class CetakNota extends javax.swing.JDialog {

    /**
     * Creates new form KartuAnggota
     */
    int xx, xy;
    
    public CetakNota(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public CetakNota(JFrame parent, boolean modal, JasperPrint print) {
        super(parent, modal);
        initComponents();
        pn_conten.removeAll();
        pn_conten.setLayout(new BorderLayout());
        pn_conten.repaint();
        pn_conten.add(new JRViewer(print));
        pn_conten.revalidate();
    }

    public CetakNota(java.awt.Frame parent, boolean modal, JasperPrint print, String email) {
        super(parent, modal);
        initComponents();
        pn_conten.removeAll();
        pn_conten.setLayout(new BorderLayout());
        pn_conten.repaint();
        pn_conten.add(new JRViewer(print));
        pn_conten.revalidate();
        tf_email.setText(email);
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
        jPanelGradientVertikal1 = new custom.JPanelGradientVertikal();
        jLabel1 = new javax.swing.JLabel();
        pn_report = new javax.swing.JPanel();
        pn_conten = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_email = new javax.swing.JTextField();
        btn_kta = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("KTA");
        setIconImage(null);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(79, 42, 24));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanelGradientVertikal1.setCEnd(new java.awt.Color(166, 145, 138));
        jPanelGradientVertikal1.setCStart(new java.awt.Color(79, 42, 24));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CETAK NOTA");

        javax.swing.GroupLayout jPanelGradientVertikal1Layout = new javax.swing.GroupLayout(jPanelGradientVertikal1);
        jPanelGradientVertikal1.setLayout(jPanelGradientVertikal1Layout);
        jPanelGradientVertikal1Layout.setHorizontalGroup(
            jPanelGradientVertikal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
        );
        jPanelGradientVertikal1Layout.setVerticalGroup(
            jPanelGradientVertikal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pn_report.setBackground(new java.awt.Color(255, 255, 255));
        pn_report.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(79, 42, 24)));

        javax.swing.GroupLayout pn_contenLayout = new javax.swing.GroupLayout(pn_conten);
        pn_conten.setLayout(pn_contenLayout);
        pn_contenLayout.setHorizontalGroup(
            pn_contenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pn_contenLayout.setVerticalGroup(
            pn_contenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Kirim ke :");

        btn_kta.setBackground(new java.awt.Color(79, 42, 24));
        btn_kta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_kta.setForeground(new java.awt.Color(79, 42, 24));
        btn_kta.setText("KIRIM");
        btn_kta.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_ktaMouseMoved(evt);
            }
        });
        btn_kta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ktaMouseExited(evt);
            }
        });
        btn_kta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ktaActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(new java.awt.Color(166, 145, 138));
        btn_hapus.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(166, 145, 138));
        btn_hapus.setText("BATAL");
        btn_hapus.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_hapusMouseMoved(evt);
            }
        });
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_hapusMouseExited(evt);
            }
        });
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_reportLayout = new javax.swing.GroupLayout(pn_report);
        pn_report.setLayout(pn_reportLayout);
        pn_reportLayout.setHorizontalGroup(
            pn_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_reportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(tf_email)
                    .addComponent(btn_kta, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_conten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_reportLayout.setVerticalGroup(
            pn_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_reportLayout.createSequentialGroup()
                .addGroup(pn_reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pn_reportLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_kta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 401, Short.MAX_VALUE)
                        .addComponent(btn_hapus))
                    .addGroup(pn_reportLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pn_conten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGradientVertikal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_report, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanelGradientVertikal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ktaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ktaMouseMoved
        btn_kta.setForeground(Color.white);
    }//GEN-LAST:event_btn_ktaMouseMoved

    private void btn_ktaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ktaMouseExited
        btn_kta.setForeground(new Color(79,42,24));
    }//GEN-LAST:event_btn_ktaMouseExited

    private void btn_ktaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ktaActionPerformed
        String email = tf_email.getText().toString();
        jLabel1.requestFocus();
    }//GEN-LAST:event_btn_ktaActionPerformed

    private void btn_hapusMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseMoved
        btn_hapus.setForeground(Color.white);
    }//GEN-LAST:event_btn_hapusMouseMoved

    private void btn_hapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseExited
        btn_hapus.setForeground(new Color(166,145,138));
    }//GEN-LAST:event_btn_hapusMouseExited

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        dispose();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CetakNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CetakNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CetakNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CetakNota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CetakNota dialog = new CetakNota(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_kta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private custom.JPanelGradientVertikal jPanelGradientVertikal1;
    private javax.swing.JPanel pn_conten;
    private javax.swing.JPanel pn_report;
    private javax.swing.JTextField tf_email;
    // End of variables declaration//GEN-END:variables
}
