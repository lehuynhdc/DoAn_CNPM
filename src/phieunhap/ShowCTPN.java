/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phieunhap;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class ShowCTPN extends javax.swing.JFrame {

    /**
     * Creates new form ShowCTPN
     */
    private QuanLiPhieuNhap qlpn;
    private DefaultTableModel model;
    
    public ShowCTPN() {
        initComponents();
    }

    public ShowCTPN(QuanLiPhieuNhap aThis, boolean rootPaneCheckingEnabled){
        initComponents();
        this.setLocationRelativeTo(null);
        lb_IDPN.setText("Chi tiết của phiếu nhập: " + aThis.getPhieuNhap().getIdPN());
        loadData(aThis);
        qlpn = aThis;
    }
    //load du lieu len form
    public void loadData(QuanLiPhieuNhap aThis){
        ctphieunhap.ConnectionSQL sqlCTPN = new ctphieunhap.ConnectionSQL();
        String idPN = aThis.getPhieuNhap().getIdPN();
        ArrayList<InfoCTPN> list = sqlCTPN.getListCTPN(idPN);
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // xoa bo noi dung cu cua table
        for (InfoCTPN info : list) {
            Object[] data = {info.getIdmathang(),info.getTenmathang(),info.getSoLuong(),info.getGia()};
            model.addRow(data);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lb_IDPN = new javax.swing.JLabel();
        btn_Back = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thông Tin");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "       Mã mặt hàng", "       Tên mặt hàng", "             Số lượng", "                Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 71, 714, 360));

        lb_IDPN.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lb_IDPN.setForeground(new java.awt.Color(255, 255, 0));
        getContentPane().add(lb_IDPN, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 310, 30));

        btn_Back.setBackground(new java.awt.Color(255, 255, 255));
        btn_Back.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathang/back.png"))); // NOI18N
        btn_Back.setText("Trở lại");
        btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phieunhap/background_formQL.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_BackActionPerformed

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
            java.util.logging.Logger.getLogger(ShowCTPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowCTPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowCTPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowCTPN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowCTPN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_Back;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb_IDPN;
    // End of variables declaration//GEN-END:variables
}
