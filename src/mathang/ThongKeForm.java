/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathang;

/**
 *
 * @author DELL
 */
public class ThongKeForm extends javax.swing.JFrame {

    /**
     * Creates new form ThongKeForm
     */
    public ThongKeForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_ShowTrongNgay = new javax.swing.JButton();
        lb_ConDungDuocTrongNgay = new javax.swing.JLabel();
        lb_Hu = new javax.swing.JLabel();
        lb_ConDungDuoc = new javax.swing.JLabel();
        btn_ShowHu = new javax.swing.JButton();
        btn_ShowConDungDuoc = new javax.swing.JButton();
        lb_ThongKe = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thống Kê");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_ShowTrongNgay.setBackground(new java.awt.Color(102, 153, 255));
        btn_ShowTrongNgay.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_ShowTrongNgay.setForeground(new java.awt.Color(255, 255, 255));
        btn_ShowTrongNgay.setText("Show");
        btn_ShowTrongNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ShowTrongNgayActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ShowTrongNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 175, -1, -1));

        lb_ConDungDuocTrongNgay.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_ConDungDuocTrongNgay.setForeground(new java.awt.Color(255, 255, 255));
        lb_ConDungDuocTrongNgay.setText("Thống kê mặt hàng còn dùng được trong ngày:");
        getContentPane().add(lb_ConDungDuocTrongNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 179, -1, -1));

        lb_Hu.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_Hu.setForeground(new java.awt.Color(255, 255, 255));
        lb_Hu.setText("Thống kê mặt hàng hư hoặc hết hạn:");
        getContentPane().add(lb_Hu, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 233, -1, -1));

        lb_ConDungDuoc.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_ConDungDuoc.setForeground(new java.awt.Color(255, 255, 255));
        lb_ConDungDuoc.setText("Thống kê mặt hàng còn dùng được:");
        getContentPane().add(lb_ConDungDuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 119, -1, -1));

        btn_ShowHu.setBackground(new java.awt.Color(102, 153, 255));
        btn_ShowHu.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_ShowHu.setForeground(new java.awt.Color(255, 255, 255));
        btn_ShowHu.setText("Show");
        btn_ShowHu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ShowHuActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ShowHu, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 229, -1, -1));

        btn_ShowConDungDuoc.setBackground(new java.awt.Color(102, 153, 255));
        btn_ShowConDungDuoc.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_ShowConDungDuoc.setForeground(new java.awt.Color(255, 255, 255));
        btn_ShowConDungDuoc.setText("Show");
        btn_ShowConDungDuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ShowConDungDuocActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ShowConDungDuoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 116, -1, -1));

        lb_ThongKe.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_ThongKe.setForeground(new java.awt.Color(255, 255, 255));
        lb_ThongKe.setText("Thông Kê");
        getContentPane().add(lb_ThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 13, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathang/thongke.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 630, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ShowConDungDuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ShowConDungDuocActionPerformed
        // TODO add your handling code here:
        MatHang mh = new MatHang();
        mh.thongKeMHConDungDuoc();
    }//GEN-LAST:event_btn_ShowConDungDuocActionPerformed

    private void btn_ShowTrongNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ShowTrongNgayActionPerformed
        // TODO add your handling code here:
        MatHang mh = new MatHang();
        long millis=System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String strDate = mh.dateToString(date);
        mh.thongKeMHConDungDuocTrongNgay(strDate);
    }//GEN-LAST:event_btn_ShowTrongNgayActionPerformed

    private void btn_ShowHuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ShowHuActionPerformed
        // TODO add your handling code here:
        MatHang mh = new MatHang();
        mh.thongKeMHBiHu();
    }//GEN-LAST:event_btn_ShowHuActionPerformed

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
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ShowConDungDuoc;
    private javax.swing.JButton btn_ShowHu;
    private javax.swing.JButton btn_ShowTrongNgay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lb_ConDungDuoc;
    private javax.swing.JLabel lb_ConDungDuocTrongNgay;
    private javax.swing.JLabel lb_Hu;
    private javax.swing.JLabel lb_ThongKe;
    // End of variables declaration//GEN-END:variables
}
