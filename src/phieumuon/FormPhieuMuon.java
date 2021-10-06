/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * van con 1 bug chua fix o cho tim kiem mat hang sau do them vao phieu
 * se gay ra mat ca table tim kiem và khong the tiep tuc thuc hien 
*/
package phieumuon;

import ctphieumuon.CTPhieuMuon;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import mathang.MatHang;

/**
 *
 * @author DELL
 */
public class FormPhieuMuon extends javax.swing.JFrame {

    /**
     * Creates new form FormPhieuNhap
     */
    private DefaultTableModel model;
    private ArrayList<MatHang> dsMatHang;
    private ArrayList<MatHang> dsMatHangDaThem = new ArrayList<>();
    private MatHang matHang;
    private ArrayList<Integer> dsSoLuong = new ArrayList<>();
    private Integer index;
    private QuanLiPhieuMuon qlpm;

    public MatHang getMatHang() {
        return matHang;
    }
    
    public FormPhieuMuon() {
        initComponents();
        this.setLocationRelativeTo(null);
        java.sql.Date date = getTime();
        mathang.MatHang mh = new MatHang();
        String b,c;
        String strDate = mh.dateToString(date);
        b = strDate.split("-")[0];
        c = strDate.split("-")[2];
        String temp = "Ngày: " + c + "-" +strDate.split("-")[1] + "-" +b;
        loadData(strDate);
        lb_NgayLapPhieu.setText(temp);
        text_idPM.setText(autoIDPM());
        text_idPM.setEditable(false);
        btn_XoaMHDaNhap.setVisible(false);
        comb_idMH_tenMH.setVisible(false);
        text_TimKiem.setVisible(false);
    }
    
    FormPhieuMuon(QuanLiPhieuMuon aThis, boolean rootPaneCheckingEnabled){
        initComponents();
        this.setLocationRelativeTo(null);
        java.sql.Date date = getTime();
        mathang.MatHang mh = new MatHang();
        String b,c;
        String strDate = mh.dateToString(date);
        b = strDate.split("-")[0];
        c = strDate.split("-")[2];
        String temp = "Ngày: " + c + "-" +strDate.split("-")[1] + "-" +b;
        loadData(strDate);
        lb_NgayLapPhieu.setText(temp);
        text_idPM.setText(autoIDPM());
        text_idNV.setText(aThis.getIdNV());
        text_idNV.setEditable(false);
        text_idPM.setEditable(false);
        btn_XoaMHDaNhap.setVisible(false);
        comb_idMH_tenMH.setVisible(false);
        text_TimKiem.setVisible(false);
        qlpm = aThis;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_idPM = new javax.swing.JLabel();
        text_idPM = new javax.swing.JTextField();
        lb_idNV = new javax.swing.JLabel();
        text_idNV = new javax.swing.JTextField();
        lb_PhieuMuon = new javax.swing.JLabel();
        lb_NgayLapPhieu = new javax.swing.JLabel();
        comb_idMH_tenMH = new javax.swing.JComboBox<>();
        text_TimKiem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_TimKiem = new javax.swing.JTable();
        btn_Them = new javax.swing.JButton();
        btn_Huy = new javax.swing.JButton();
        btn_XuatPhieu = new javax.swing.JButton();
        lb_SoLuong = new javax.swing.JLabel();
        text_SL = new javax.swing.JTextField();
        btn_XoaMHDaNhap = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản Lí PHiếu Mượn");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_idPM.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_idPM.setText("Mã phiếu mượn:");
        getContentPane().add(lb_idPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 204, -1, -1));

        text_idPM.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        getContentPane().add(text_idPM, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 201, 206, -1));

        lb_idNV.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_idNV.setText("Mã nhân viên:");
        getContentPane().add(lb_idNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 256, -1, -1));

        text_idNV.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        getContentPane().add(text_idNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 253, 206, -1));

        lb_PhieuMuon.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lb_PhieuMuon.setText("Phiếu Mượn");
        getContentPane().add(lb_PhieuMuon, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 94, -1, -1));

        lb_NgayLapPhieu.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        getContentPane().add(lb_NgayLapPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 149, 242, 34));

        comb_idMH_tenMH.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        comb_idMH_tenMH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã mặt hàng", "Tên mặt hàng" }));
        getContentPane().add(comb_idMH_tenMH, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 305, -1, 37));

        text_TimKiem.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        text_TimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_TimKiemKeyReleased(evt);
            }
        });
        getContentPane().add(text_TimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 305, 206, -1));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "       Mã mặt hàng", "       Tên mặt hàng", "             Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 710, 272));

        table_TimKiem.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        table_TimKiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "       Mã mặt hàng", "       Tên mặt hàng", "            NSX", "             HSD", "             Số lượng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_TimKiem.setRowHeight(30);
        table_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_TimKiemMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_TimKiem);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 349, 710, 122));

        btn_Them.setBackground(new java.awt.Color(255, 255, 255));
        btn_Them.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_Them.setText("Thêm");
        btn_Them.setFocusTraversalPolicyProvider(true);
        btn_Them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThemMouseClicked(evt);
            }
        });
        getContentPane().add(btn_Them, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 478, 129, 40));

        btn_Huy.setBackground(new java.awt.Color(255, 255, 255));
        btn_Huy.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_Huy.setText("Hủy");
        btn_Huy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_HuyMouseClicked(evt);
            }
        });
        getContentPane().add(btn_Huy, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 815, 141, -1));

        btn_XuatPhieu.setBackground(new java.awt.Color(255, 255, 255));
        btn_XuatPhieu.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_XuatPhieu.setText("Xuất Phiếu");
        btn_XuatPhieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XuatPhieuMouseClicked(evt);
            }
        });
        getContentPane().add(btn_XuatPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(551, 815, -1, -1));

        lb_SoLuong.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_SoLuong.setText("Số lượng: ");
        getContentPane().add(lb_SoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 481, -1, -1));

        text_SL.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        text_SL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_SLKeyReleased(evt);
            }
        });
        getContentPane().add(text_SL, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 478, 131, -1));

        btn_XoaMHDaNhap.setBackground(new java.awt.Color(255, 255, 255));
        btn_XoaMHDaNhap.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_XoaMHDaNhap.setText("Xóa");
        btn_XoaMHDaNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaMHDaNhapMouseClicked(evt);
            }
        });
        getContentPane().add(btn_XoaMHDaNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 815, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phieumuon/FormSua.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 870));
        background.getAccessibleContext().setAccessibleName("background");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_TimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_TimKiemKeyReleased
        // TODO add your handling code here:
        int columnIndex = 0;
        String value = (String) comb_idMH_tenMH.getSelectedItem();
        switch (value) {
            case "Mã mặt hàng":
            columnIndex = 0;
            break;
            case "Tên mặt hàng":
            columnIndex = 1;
            break;
        }
        timKiem(columnIndex);
    }//GEN-LAST:event_text_TimKiemKeyReleased

    private void table_TimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_TimKiemMouseClicked
        // TODO add your handling code here:
        matHang = getDataARow();
    }//GEN-LAST:event_table_TimKiemMouseClicked

    private void btn_ThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ThemMouseClicked
        // TODO add your handling code here:
        int i = 0;
        if(this.getMatHang() == null){
            JOptionPane.showMessageDialog(rootPane, "Phải chọn 1 mặt hàng để thêm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        else{
            if(text_SL.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Phải nhập đủ số lượng !", "Lỗi", JOptionPane.ERROR_MESSAGE);                
                return;
            }
            MatHang mh = this.getMatHang();
            //if khac -1 thi da ton tai mh trong danh sach
            if(this.isExist(dsMatHangDaThem, mh) != -1){
                this.updateMHDaTonTai();
                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0); // xoa bo noi dung cu cua table
                for (MatHang mh1 : dsMatHangDaThem) {
                    Object[] data = {mh1.getIdMatHang(),mh1.getTenMatHang(),dsSoLuong.get(i)};
                    model.addRow(data);
                    i++;
                }
                this.matHang = null;
                text_SL.setText("");
            }
            else{
                dsMatHangDaThem.add(mh);
                dsSoLuong.add(Integer.parseInt(text_SL.getText()));
                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0); // xoa bo noi dung cu cua table
                for (MatHang mh1 : dsMatHangDaThem) {
                    Object[] data = {mh1.getIdMatHang(),mh1.getTenMatHang(),dsSoLuong.get(i)};
                    model.addRow(data);
                    i++;
                }
                this.matHang = null;
            }
        }
        String b,c;
        String strDate = lb_NgayLapPhieu.getText().split(" ")[1];
        b = strDate.split("-")[0];
        c = strDate.split("-")[2];
        String temp = c + "-" +strDate.split("-")[1] + "-" +b;
        loadDataAfter(temp);
    }//GEN-LAST:event_btn_ThemMouseClicked

    private void btn_HuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HuyMouseClicked
        // TODO add your handling code here
        dispose();
    }//GEN-LAST:event_btn_HuyMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        matHang = getDataARowDaThem();
        btn_XoaMHDaNhap.setVisible(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btn_XoaMHDaNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XoaMHDaNhapMouseClicked
        // TODO add your handling code here:
        int i = 0,j = 0;
        for(MatHang mh:dsMatHangDaThem){
            if(mh.getIdMatHang().equals(matHang.getIdMatHang())){
                dsMatHangDaThem.remove(i);
                break;
            }
            i++;
        }
        dsSoLuong.remove(i);
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // xoa bo noi dung cu cua table
        for (MatHang mh1 : dsMatHangDaThem) {
            Object[] data = {mh1.getIdMatHang(),mh1.getTenMatHang(),dsSoLuong.get(j)};
            model.addRow(data);
            j++;
        }
        this.matHang = null;
        String b,c;
        String strDate = lb_NgayLapPhieu.getText().split(" ")[1];
        b = strDate.split("-")[0];
        c = strDate.split("-")[2];
        String temp = c + "-" +strDate.split("-")[1] + "-" +b;
        btn_XoaMHDaNhap.setVisible(false);
        loadDataAfter(temp);
    }//GEN-LAST:event_btn_XoaMHDaNhapMouseClicked

    private void btn_XuatPhieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XuatPhieuMouseClicked
        // TODO add your handling code here:
        if(dsMatHangDaThem.size() == 0){
            JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra không thể xuất phiếu. Vui lòng thực hiện lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);        
            dispose();
            return;
        }
        try{
            //insert phieu muon vao db
            java.sql.Date date = getTime();
            PhieuMuon pm = new PhieuMuon(text_idPM.getText(), date, text_idNV.getText());
            ConnectionSQL sql = new ConnectionSQL();
            sql.insertSQL(pm);
            
            //insert ctphieu muon vao db
            int i = 0;
            CTPhieuMuon ctpm = new CTPhieuMuon();
            ctphieumuon.ConnectionSQL sqlCT = new ctphieumuon.ConnectionSQL();
            ctpm.setIdPM(text_idPM.getText());
            for(MatHang mh:dsMatHangDaThem){
                ctpm.setIdMH(mh.getIdMatHang());
                ctpm.setSoLuong(dsSoLuong.get(i));
                sqlCT.insertSQL(ctpm);
                i++;
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra không thể xuất phiếu. Vui lòng thực hiện lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);        
            dispose();
        }
        qlpm.loadData();
        JOptionPane.showMessageDialog(rootPane, "Xuất phiếu thành công!", "Message", JOptionPane.INFORMATION_MESSAGE);                
        dispose();
    }//GEN-LAST:event_btn_XuatPhieuMouseClicked

    private void text_SLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_SLKeyReleased
        // TODO add your handling code here:
        MatHang mh = new MatHang();
        String text = text_SL.getText();
        char a = text.charAt(text.length() - 1);
        if(!KTinput(Character.toString(a)) || text_SL.getText().equals("0") || text_SL.getText().equals(" ")){
            text_SL.setText("");
            JOptionPane.showMessageDialog(rootPane, "Bạn chỉ được nhập số lớn hơn 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        String ngayLap = this.convertStrToStr(lb_NgayLapPhieu.getText().split(" ")[1]);
        if(!(mh.ktChoMuonTB(this.getMatHang().getIdMatHang(), ngayLap,Integer.parseInt(text_SL.getText())))){
            text_SL.setText("");
            JOptionPane.showMessageDialog(rootPane, "Số lượng đã vượt quá giới hạn!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_text_SLKeyReleased

    //tim kiem theo ma hoac ten
    private void timKiem(int columnIndex) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table_TimKiem.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(String.format("(?i)%s", text_TimKiem.getText()), columnIndex));
    }
    
    //load du lieu len table
    public void loadData(String strDate){
        mathang.ConnectionSQL sql = new mathang.ConnectionSQL();
        ArrayList<MatHang> dsMHDelete = new ArrayList<>();
        mathang.ConnectionSQL sqlMH = new mathang.ConnectionSQL();
        ArrayList<Integer> list = sqlMH.getListSLConDungDuoc(strDate);
        int i = 0;
        dsMatHang =  sql.getListMH("select * from mathang");        
        model = (DefaultTableModel) table_TimKiem.getModel();
        model.setRowCount(0); // xoa bo noi dung cu cua table
        for(MatHang mh : dsMatHang){
            if(!(mh.ktChoMuonTB(mh.getIdMatHang(), strDate))){
                dsMHDelete.add(mh);
            }
            i++;
        }
        for(MatHang mh :dsMHDelete){
            dsMatHang.remove(mh);
        }
        i = 0;
        for (MatHang mh : dsMatHang) {
            Object[] data = {mh.getIdMatHang(),mh.getTenMatHang(),mh.getNSX(),mh.getHSD(),list.get(i)};
            model.addRow(data);
            i++;
        }
    }
    
    //load du lieu sau khi da them len table
    public void loadDataAfter(String strDate){
        mathang.ConnectionSQL sql = new mathang.ConnectionSQL();
        ArrayList<MatHang> dsMHDelete = new ArrayList<>();
        ArrayList<Integer> list = sql.getListSLConDungDuocAfter(strDate,dsMatHangDaThem,dsSoLuong);
        int i = 0,j = 0;
        dsMatHang =  sql.getListMH("select * from mathang");        
        model = (DefaultTableModel) table_TimKiem.getModel();
        model.setRowCount(0); // xoa bo noi dung cu cua table
        //xoa cac mat hang ko con the muon duoc trong ngay
        for(MatHang mh : dsMatHang){
            if(!(mh.ktChoMuonTB(mh.getIdMatHang(), strDate))){
                dsMHDelete.add(mh);
            }
            i++;
        }
        for(MatHang mh :dsMHDelete){
            dsMatHang.remove(mh);
        }
        
        //update lai list(list so luong mat hang con cho muon chua tru so vua them vao phieu)
        i = 0;
        for(MatHang mh : dsMatHang){
            for(MatHang mh1 : dsMatHangDaThem){
                if(mh.getIdMatHang().equals(mh1.getIdMatHang())){
                    int soluong = list.get(i) - dsSoLuong.get(j);
                    list.set(i, soluong);
                    break;
                }
                j++;
            }
            j = 0;
            i++;
        }
        
        i = 0;
        for (MatHang mh : dsMatHang) {
            if(list.get(i) != 0){
                Object[] data = {mh.getIdMatHang(),mh.getTenMatHang(),mh.getNSX(),mh.getHSD(),list.get(i)};
                model.addRow(data);
            }            
            i++;
        }
        text_SL.setText("");
    }
    
    //lay du lieu tu 1 hang cua table tim kiem
    public MatHang getDataARow(){
        int i = table_TimKiem.getSelectedRow();
        MatHang mh = new MatHang();
        mh.setIdMatHang((String) table_TimKiem.getValueAt(i,0));
        mh.setTenMatHang((String) table_TimKiem.getValueAt(i,1));
        mh.setNSX((Date) table_TimKiem.getValueAt(i,2));
        mh.setHSD((Date) table_TimKiem.getValueAt(i,3));
        return mh;
    } 
    
    //lay du lieu tu 1 hang cua table da them
    public MatHang getDataARowDaThem(){
        int i = jTable1.getSelectedRow();
        MatHang mh = new MatHang();
        mh.setIdMatHang((String) jTable1.getValueAt(i,0));
        mh.setTenMatHang((String) jTable1.getValueAt(i,1));
//        mh.setNSX((Date) table_TimKiem.getValueAt(i,2));
//        mh.setHSD((Date) table_TimKiem.getValueAt(i,3));
        return mh;
    } 
    
    //auto create IDPM
    public String autoIDPM(){
        ConnectionSQL sql = new ConnectionSQL();
        String lastIDPM = sql.getLastIDPM();
        String newIDPM = "PM";
        if(lastIDPM == null){
            newIDPM += '1'; 
            return newIDPM;
        }
        int temp = Integer.parseInt(lastIDPM.split("M")[1]);
        newIDPM += String.valueOf(temp+1);
        return newIDPM;
    } 
    
    //kiem tra ko phai ky tu dac biet va  khong phai la so
    public static boolean KTinput(String str){
        if(str.isEmpty()) return true;
        String regex = "\\w+";
        String digit = "\\d";
        String[] ls = str.split(" ");
        for (String s:ls){
            if(!s.matches(regex) || !s.matches(digit)) 
                return false;//false la da nhap KT dac biet or chu
        }
        return true;
    }
    
    //kiem tra ma hang da ton tai chua(true là da ton tai)
    public int isExist(ArrayList<MatHang> ds,MatHang matHang){
        index = -1;
        for(MatHang mh:ds){
            if(mh.getIdMatHang().equals(matHang.getIdMatHang())){
                index++;
                return index;
            }
            index++;
        }
        index = -1;
        return index;
    }
    
    //cap nhat lai soluong va gia cua MH da ton tai trong ds
    public void updateMHDaTonTai(){
        dsSoLuong.set(index, Integer.parseInt(text_SL.getText()));
    }
    
    //lay ngay gio hien tai
    public java.sql.Date getTime(){
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);   
        return date;
    }
    
    //convert string dd-mm-yyyy to yyyy-mm-dd
    public String convertStrToStr(String strDD){
        String day,temp,year;
        day = strDD.split("-")[0];
        year = strDD.split("-")[2];
        String strYYYY = year + "-" +strDD.split("-")[1] + "-" + day;
        return strYYYY;
    }
    
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
            java.util.logging.Logger.getLogger(FormPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPhieuMuon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btn_Huy;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_XoaMHDaNhap;
    private javax.swing.JButton btn_XuatPhieu;
    private javax.swing.JComboBox<String> comb_idMH_tenMH;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb_NgayLapPhieu;
    private javax.swing.JLabel lb_PhieuMuon;
    private javax.swing.JLabel lb_SoLuong;
    private javax.swing.JLabel lb_idNV;
    private javax.swing.JLabel lb_idPM;
    private javax.swing.JTable table_TimKiem;
    private javax.swing.JTextField text_SL;
    private javax.swing.JTextField text_TimKiem;
    private javax.swing.JTextField text_idNV;
    private javax.swing.JTextField text_idPM;
    // End of variables declaration//GEN-END:variables
}
