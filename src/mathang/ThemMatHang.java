/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ThemMatHang extends javax.swing.JFrame {

    /**
     * Creates new form ThemMatHang
     */
    private int choThem=0;
    private QuanLiMatHang qlmh;
    public ThemMatHang() {
        initComponents();        
    }

    ThemMatHang(QuanLiMatHang aThis, boolean rootPaneCheckingEnabled) {
        initComponents();  
        this.setLocationRelativeTo(null);
        this.text_idMH.setText(this.autoIDMH());
        this.text_idMH.setEditable(false);        
        qlmh = aThis;
    }

    //auto create IDMH
    public String autoIDMH(){
        ConnectionSQL sql = new ConnectionSQL();
        String lastIDMH = sql.getLastIDMH();
        String newIDMH = "MH";
        int temp = Integer.parseInt(lastIDMH.split("H")[1]);
        newIDMH += String.valueOf(temp+1);
        return newIDMH;
    }  
    
    //kiem tra cac du lieu dau vao
    public boolean checkInput(){
        if(this.text_tenMH.getText().equals("") || 
                this.text_ngaySX.getText().equals("")||
                this.text_thangSX.getText().equals("")||
                this.text_namSX.getText().equals("")||
                this.text_ngaySD.getText().equals("")||
                this.text_thangSD.getText().equals("")||
                this.text_namSD.getText().equals("")){
           JOptionPane.showMessageDialog(rootPane, "Thiếu thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
           return false;
        }
        else if(!ktNgayThang(this.text_ngaySX.getText(), this.text_thangSX.getText(), this.text_namSX.getText())){
            this.text_ngaySX.setText("");
            this.text_thangSX.setText("");
            this.text_namSX.setText("");
            return false;
        }
        else if(!ktNgayThang(this.text_ngaySD.getText(), this.text_thangSD.getText(), this.text_namSD.getText())){
            this.text_ngaySD.setText("");
            this.text_thangSD.setText("");
            this.text_namSD.setText("");
            return false;
        }
        Date dateSX = null,dateSD = null;
        dateSX = this.textToDate(this.text_ngaySX.getText(), this.text_thangSX.getText(), this.text_namSX.getText());
        dateSD = this.textToDate(this.text_ngaySD.getText(), this.text_thangSD.getText(), this.text_namSD.getText());        
        if(dateSX.compareTo(dateSD) >= 0){
            JOptionPane.showMessageDialog(rootPane, "NGÀY SẢN XUẤT PHẢI NHỎ HƠN HẠN SỬ DỤNG", "WARNING", 
                      JOptionPane.WARNING_MESSAGE);
            return false;
        }
        choThem = 1; 
        return true;
    }
    
    //convert text from form to date "yyyy-mm-dd"
    public Date textToDate(String day,String month,String year){
        String d,m = null;
        Date dateReturn = null;
        if(day.length() == 1){
            d = "0"+day;
            if(month.length() == 1){
                m = "0"+month;
            }
            else{
                m = month;
            }
        }
        else{
            d = day;
            if(month.length() == 1){
                m = "0"+month;
            }
            else{
                m = month;
            }
        }
        String dateFormat = year + "-" + m + "-"+ d;
        try {
            dateReturn = new SimpleDateFormat("yyyy-MM-dd").parse(dateFormat);
        } catch (ParseException ex) {
            Logger.getLogger(ThemMatHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dateReturn;
    }
    //ham kt ngay thang nhap vao
    public boolean ktNgayThang(String text_Ngay,String text_Thang,String text_Nam){
        int d,m,y;
        if(text_Ngay.equals("") || text_Thang.equals("") || text_Nam.equals("")){
            JOptionPane.showMessageDialog(rootPane, "BẠN CHƯA NHẬP NGÀY, THÁNG, NĂM", "WARNING", 
                      JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try{
            d = Integer.parseInt(text_Ngay);
            m = Integer.parseInt(text_Thang);
            y = Integer.parseInt(text_Nam);
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(rootPane, "CHỈ ĐƯỢC NHẬP SỐ VÀO CÁC Ô NGÀY,THÁNG, NĂM", "WARNING", 
                      JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(y>=2001){       
            if(m<1||12<m){
                JOptionPane.showMessageDialog(rootPane, "BẠN ĐÃ NHẬP SAI THÁNG\nTHÁNG PHẢI LỚN HƠN HOẶC BẰNG 1 VÀ NHỎ HƠN HOẶC BẰNG 12!!!", "WARNING", 
                                JOptionPane.WARNING_MESSAGE);
                return false;
            }
            else{
                switch(m){
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                    {
                        if(d <= 0 || d > 31){
                            JOptionPane.showMessageDialog(rootPane, "BẠN ĐÃ NHẬP SAI NGÀY\nNGÀY PHẢI LỚN HƠN HOẶC BẰNG 0 VÀ NHỎ HƠN HOẶC BẰNG 31!!!", "WARNING", 
                                JOptionPane.WARNING_MESSAGE);
                            return false;
                        }
                        break;
                    }
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                    {
                        if(d <= 0 || d > 30){
                            JOptionPane.showMessageDialog(rootPane, "BẠN ĐÃ NHẬP SAI NGÀY\nNGÀY PHẢI LỚN HƠN HOẶC BẰNG 0 VÀ NHỎ HƠN HOẶC BẰNG 30!!!", "WARNING", 
                                JOptionPane.WARNING_MESSAGE);
                            return false;
                        }
                        break;
                    }
                    case 2:
                    {
                        if(ktNamNhuan(y)){
                            if(d <= 0 || d > 29){
                                JOptionPane.showMessageDialog(rootPane, "BẠN ĐÃ NHẬP SAI NGÀY\nNGÀY PHẢI LỚN HƠN HOẶC BẰNG 0 VÀ NHỎ HƠN HOẶC BẰNG 29!!!", "WARNING", 
                                    JOptionPane.WARNING_MESSAGE);
                                return false;
                            }
                        }
                        else{
                            if(d <= 0 || d > 28){
                                JOptionPane.showMessageDialog(rootPane, "BẠN ĐÃ NHẬP SAI NGÀY\nNGÀY PHẢI LỚN HƠN HOẶC BẰNG 0 VÀ NHỎ HƠN HOẶC BẰNG 28!!!", "WARNING", 
                                    JOptionPane.WARNING_MESSAGE);
                                return false;
                            }
                        }                        
                        break;
                    }
                }             
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "BẠN ĐÃ NHẬP SAI NĂM\nNĂM PHẢI LỚN HƠN HOẶC BẰNG 2001!!!", "WARNING", 
                                JOptionPane.WARNING_MESSAGE);
                                return false;
        }
        return true;        
    }
    
    //ham kt nam nhuan
    public boolean ktNamNhuan(int year){
        return (((year % 4 == 0) && (year % 100 != 0)) || 
            (year % 400 == 0)); 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_idMH = new javax.swing.JLabel();
        text_idMH = new javax.swing.JTextField();
        lb_tenMH = new javax.swing.JLabel();
        text_tenMH = new javax.swing.JTextField();
        lb_NSX = new javax.swing.JLabel();
        text_ngaySX = new javax.swing.JTextField();
        text_thangSX = new javax.swing.JTextField();
        text_namSX = new javax.swing.JTextField();
        lb_ngay = new javax.swing.JLabel();
        lb_thang = new javax.swing.JLabel();
        lb_nam = new javax.swing.JLabel();
        text_ngaySD = new javax.swing.JTextField();
        text_thangSD = new javax.swing.JTextField();
        text_namSD = new javax.swing.JTextField();
        lb_ngay1 = new javax.swing.JLabel();
        lb_thang1 = new javax.swing.JLabel();
        lb_nam1 = new javax.swing.JLabel();
        lb_HSD = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_huy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm mặt hàng");

        lb_idMH.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_idMH.setText("Mã mặt hàng:");

        text_idMH.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        lb_tenMH.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_tenMH.setText("Tên mặt hàng:");

        text_tenMH.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        lb_NSX.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_NSX.setText("Ngày sản xuất:");

        text_ngaySX.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        text_thangSX.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        text_namSX.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        lb_ngay.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lb_ngay.setText("Ngày:");

        lb_thang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lb_thang.setText("Tháng:");

        lb_nam.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lb_nam.setText("Năm:");

        text_ngaySD.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        text_thangSD.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        text_namSD.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        lb_ngay1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lb_ngay1.setText("Ngày:");

        lb_thang1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lb_thang1.setText("Tháng:");

        lb_nam1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lb_nam1.setText("Năm:");

        lb_HSD.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_HSD.setText("Hạn sử dụng:");

        btn_them.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_huy.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_huy.setText("Hủy");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_tenMH)
                            .addComponent(lb_idMH))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_tenMH, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(text_idMH)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_NSX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_ngay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_ngaySX, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_thangSX, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_nam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_namSX, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_HSD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_ngay1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_ngaySD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_them)
                                .addGap(18, 18, 18)
                                .addComponent(btn_huy))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lb_thang1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(text_thangSD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_nam1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(text_namSD, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {text_ngaySX, text_thangSX});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_idMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_idMH))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_tenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_tenMH))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_NSX)
                        .addComponent(lb_ngay))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(text_thangSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(text_ngaySX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_thang))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(text_namSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_nam)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_HSD)
                        .addComponent(lb_ngay1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(text_thangSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(text_ngaySD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_thang1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(text_namSD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_nam1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_huy)
                    .addComponent(btn_them))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {text_namSX, text_ngaySX, text_thangSX});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //thuc hien khi bam nut huy
    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_huyActionPerformed

    //thuc hien khi bam nut them
    @SuppressWarnings("empty-statement")
    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:        
       checkInput();
       if(choThem == 1){
           ConnectionSQL sql = new ConnectionSQL();
           Date NSX = this.textToDate(this.text_ngaySX.getText(), this.text_thangSX.getText(), this.text_namSX.getText());
           Date HSD = this.textToDate(this.text_ngaySD.getText(), this.text_thangSD.getText(), this.text_namSD.getText());
           MatHang mh = new MatHang(this.text_idMH.getText(), this.text_tenMH.getText(), NSX, HSD);
           sql.insertSQL(mh);
           qlmh.loadData();
           JOptionPane.showMessageDialog(rootPane, "BẠN ĐÃ THÊM THÀNH CÔNG!!!", "INFORMATION", 
                                JOptionPane.INFORMATION_MESSAGE);
           this.dispose();
       } 
    }//GEN-LAST:event_btn_themActionPerformed

    /**
     * @param args the command line arguments
     */
    public  void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ThemMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemMatHang().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_them;
    private javax.swing.JLabel lb_HSD;
    private javax.swing.JLabel lb_NSX;
    private javax.swing.JLabel lb_idMH;
    private javax.swing.JLabel lb_nam;
    private javax.swing.JLabel lb_nam1;
    private javax.swing.JLabel lb_ngay;
    private javax.swing.JLabel lb_ngay1;
    private javax.swing.JLabel lb_tenMH;
    private javax.swing.JLabel lb_thang;
    private javax.swing.JLabel lb_thang1;
    private javax.swing.JTextField text_idMH;
    private javax.swing.JTextField text_namSD;
    private javax.swing.JTextField text_namSX;
    private javax.swing.JTextField text_ngaySD;
    private javax.swing.JTextField text_ngaySX;
    private javax.swing.JTextField text_tenMH;
    private javax.swing.JTextField text_thangSD;
    private javax.swing.JTextField text_thangSX;
    // End of variables declaration//GEN-END:variables
}
