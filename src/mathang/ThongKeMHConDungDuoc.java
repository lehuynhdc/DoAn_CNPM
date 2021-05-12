/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathang;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class ThongKeMHConDungDuoc extends javax.swing.JFrame {

    /**
     * Creates new form ThongKeMHConDungDuoc
     */
    public ThongKeMHConDungDuoc() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    //constructor con dung duoc trong kho
    public ThongKeMHConDungDuoc(ArrayList<MatHang> mh,ArrayList<Integer> soluong) {
        initComponents();
        this.setLocationRelativeTo(null);
        int index = 0;
        DefaultTableModel model = new DefaultTableModel();
        String a[] = {"       ID", "   Tên mặt hàng", "  Số lượng"};
        model.setColumnIdentifiers(a);
        ArrayList arrRows = new ArrayList();
        for(MatHang temp:mh){
            arrRows.add(temp.getIdMatHang());
            arrRows.add(temp.getTenMatHang());
            arrRows.add(String.valueOf(soluong.get(index)));
            model.addRow(arrRows.toArray());
            index++;
            arrRows.clear();
        }
        this.tb_ConDungDuoc.setModel(model);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_TieuDe = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ConDungDuoc = new javax.swing.JTable();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thống Kê");
        setForeground(new java.awt.Color(153, 0, 0));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1110, 430));
        setPreferredSize(new java.awt.Dimension(1060, 376));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_TieuDe.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_TieuDe.setForeground(new java.awt.Color(153, 0, 0));
        lb_TieuDe.setText("Các sản phẩm còn sử dụng được");
        getContentPane().add(lb_TieuDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 322, 41));

        tb_ConDungDuoc.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        tb_ConDungDuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "                                                    ID", "                                           Tên Mặt Hàng", "                                         Số Lượng"
            }
        ));
        tb_ConDungDuoc.setRowHeight(30);
        jScrollPane1.setViewportView(tb_ConDungDuoc);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 988, 240));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mathang/thongkehu.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -100, 1100, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ThongKeMHConDungDuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeMHConDungDuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeMHConDungDuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeMHConDungDuoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeMHConDungDuoc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_TieuDe;
    private javax.swing.JTable tb_ConDungDuoc;
    // End of variables declaration//GEN-END:variables
}
