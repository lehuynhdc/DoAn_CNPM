/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * van con 1 bug chua fix o cho tim kiem mat hang sau do them vao phieu
 * se gay ra mat ca table tim kiem và khong the tiep tuc thuc hien 
*/
package phieunhap;

import ctphieunhap.CTPhieuNhap;
import java.math.BigDecimal;
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
public class FormPhieuNhap extends javax.swing.JFrame {

    /**
     * Creates new form FormPhieuNhap
     */
    private DefaultTableModel model;
    private QuanLiPhieuNhap qlpn;
    private ArrayList<MatHang> dsMatHang;
    private ArrayList<MatHang> dsMatHangDaThem = new ArrayList<>();
    private MatHang matHang;
    private ArrayList<Integer> dsSoLuong = new ArrayList<>();;
    private ArrayList<Integer> dsGia= new ArrayList<>();;
    private Integer index;

    public MatHang getMatHang() {
        return matHang;
    }
    
    public FormPhieuNhap() {
        initComponents();
    }
    
    FormPhieuNhap(QuanLiPhieuNhap aThis, boolean rootPaneCheckingEnabled){
        initComponents();
        this.setLocationRelativeTo(null);
        loadData();
        text_idPN.setText(autoIDPN());
        text_idPN.setEditable(false);
        btn_XoaMHDaNhap.setVisible(false);
        comb_idMH_tenMH.setVisible(false);
        text_TimKiem.setVisible(false);
        qlpn = aThis;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_idPN = new javax.swing.JLabel();
        text_idPN = new javax.swing.JTextField();
        lb_idNV = new javax.swing.JLabel();
        text_idNV = new javax.swing.JTextField();
        lb_idNCC = new javax.swing.JLabel();
        lb_PhieuNhap = new javax.swing.JLabel();
        lb_NgayLapPhieu = new javax.swing.JLabel();
        comb_NCC = new javax.swing.JComboBox<>();
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
        lb_Gia = new javax.swing.JLabel();
        text_SL = new javax.swing.JTextField();
        text_Gia = new javax.swing.JTextField();
        btn_XoaMHDaNhap = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lb_idPN.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_idPN.setText("Mã phiếu nhập:");

        text_idPN.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        lb_idNV.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_idNV.setText("Mã nhân viên:");

        text_idNV.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        lb_idNCC.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_idNCC.setText("Mã nhà cung cấp:");

        lb_PhieuNhap.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        lb_PhieuNhap.setText("Phiếu Nhập");

        lb_NgayLapPhieu.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        comb_NCC.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        comb_NCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NCC1-Ngà", "NCC2-Đức" }));

        comb_idMH_tenMH.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        comb_idMH_tenMH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã mặt hàng", "Tên mặt hàng" }));

        text_TimKiem.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        text_TimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_TimKiemKeyReleased(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "       Mã mặt hàng", "       Tên mặt hàng", "             Số lượng", "                Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false
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

        table_TimKiem.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        table_TimKiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "       Mã mặt hàng", "       Tên mặt hàng", "            NSX", "             HSD"
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
        table_TimKiem.setRowHeight(30);
        table_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_TimKiemMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_TimKiem);

        btn_Them.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_Them.setText("Thêm");
        btn_Them.setFocusTraversalPolicyProvider(true);
        btn_Them.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ThemMouseClicked(evt);
            }
        });

        btn_Huy.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_Huy.setText("Hủy");
        btn_Huy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_HuyMouseClicked(evt);
            }
        });

        btn_XuatPhieu.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_XuatPhieu.setText("Xuất Phiếu");
        btn_XuatPhieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XuatPhieuMouseClicked(evt);
            }
        });

        lb_SoLuong.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_SoLuong.setText("Số lượng: ");

        lb_Gia.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lb_Gia.setText("Giá:");

        text_SL.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        text_SL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_SLKeyReleased(evt);
            }
        });

        text_Gia.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        text_Gia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_GiaKeyReleased(evt);
            }
        });

        btn_XoaMHDaNhap.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        btn_XoaMHDaNhap.setText("Xóa");
        btn_XoaMHDaNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_XoaMHDaNhapMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_NgayLapPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
            .addComponent(jScrollPane3)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(lb_PhieuNhap))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_idPN)
                                    .addComponent(lb_idNV)
                                    .addComponent(lb_idNCC)
                                    .addComponent(comb_idMH_tenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text_idPN, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(text_idNV, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(comb_NCC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(text_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 80, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lb_SoLuong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_SL, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(lb_Gia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_XoaMHDaNhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Huy)
                        .addGap(18, 18, 18)
                        .addComponent(btn_XuatPhieu)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comb_NCC, text_TimKiem, text_idNV, text_idPN});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_Huy, btn_XuatPhieu});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(lb_PhieuNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lb_NgayLapPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_idPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_idPN))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_idNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_idNV))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_idNCC)
                    .addComponent(comb_NCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comb_idMH_tenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_TimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_SoLuong)
                    .addComponent(text_SL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_Gia)
                    .addComponent(text_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Huy)
                    .addComponent(btn_XuatPhieu)
                    .addComponent(btn_XoaMHDaNhap))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Them, comb_NCC, text_Gia, text_TimKiem, text_idNV, text_idPN});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Huy, btn_XoaMHDaNhap, btn_XuatPhieu});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lb_Gia, lb_SoLuong});

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
            if(text_Gia.getText().equals("") || text_SL.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Phải nhập đủ số lượng và giá!", "Lỗi", JOptionPane.ERROR_MESSAGE);                
                return;
            }
            MatHang mh = this.getMatHang();
            //if khac -1 thi da ton tai mh trong danh sach
            if(this.isExist(dsMatHangDaThem, mh) != -1){
                this.updateMHDaTonTai();
                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0); // xoa bo noi dung cu cua table
                for (MatHang mh1 : dsMatHangDaThem) {
                    Object[] data = {mh1.getIdMatHang(),mh1.getTenMatHang(),dsSoLuong.get(i),dsGia.get(i)};
                    model.addRow(data);
                    i++;
                }
                this.matHang = null;
                text_Gia.setText("");
                text_SL.setText("");
            }
            else{
                dsMatHangDaThem.add(mh);
                dsSoLuong.add(Integer.parseInt(text_SL.getText()));
                dsGia.add(Integer.parseInt(text_Gia.getText()));
                model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0); // xoa bo noi dung cu cua table
                for (MatHang mh1 : dsMatHangDaThem) {
                    Object[] data = {mh1.getIdMatHang(),mh1.getTenMatHang(),dsSoLuong.get(i),dsGia.get(i)};
                    model.addRow(data);
                    i++;
                }
                this.matHang = null;
                text_Gia.setText("");
                text_SL.setText("");
            }
        }
    }//GEN-LAST:event_btn_ThemMouseClicked

    private void btn_HuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_HuyMouseClicked
        // TODO add your handling code here
        dispose();
    }//GEN-LAST:event_btn_HuyMouseClicked

    private void text_SLKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_SLKeyReleased
        // TODO add your handling code here:
        String text = text_SL.getText();
        char a = text.charAt(text.length() - 1);
        if(!KTinput(Character.toString(a))){
            text_SL.setText("");
            JOptionPane.showMessageDialog(rootPane, "Bạn chỉ được nhập số!", "Lỗi", JOptionPane.ERROR_MESSAGE);  
        }
    }//GEN-LAST:event_text_SLKeyReleased

    private void text_GiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_GiaKeyReleased
        // TODO add your handling code here:
        String text = text_Gia.getText();
        char a = text.charAt(text.length() - 1);
        if(!KTinput(Character.toString(a))){
            text_Gia.setText("");
            JOptionPane.showMessageDialog(rootPane, "Bạn chỉ được nhập số!", "Lỗi", JOptionPane.ERROR_MESSAGE);  
        }
    }//GEN-LAST:event_text_GiaKeyReleased

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
        dsGia.remove(i);
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // xoa bo noi dung cu cua table
        for (MatHang mh1 : dsMatHangDaThem) {
            Object[] data = {mh1.getIdMatHang(),mh1.getTenMatHang(),dsSoLuong.get(j),dsGia.get(j)};
            model.addRow(data);
            j++;
        }
        this.matHang = null;
    }//GEN-LAST:event_btn_XoaMHDaNhapMouseClicked

    private void btn_XuatPhieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_XuatPhieuMouseClicked
        // TODO add your handling code here:
        try{
            //insert phieu nhap vao db
            java.sql.Date date = getTime();
            String idNCC = (String) comb_NCC.getSelectedItem();
            idNCC = idNCC.split("-")[0];
            PhieuNhap pn = new PhieuNhap(text_idPN.getText(), date, text_idNV.getText(),idNCC);
            ConnectionSQL sql = new ConnectionSQL();
            sql.insertSQL(pn);
            
            //insert ctphieu nhap vao db
            int i = 0;
            CTPhieuNhap ctpn = new CTPhieuNhap();
            ctphieunhap.ConnectionSQL sqlCT = new ctphieunhap.ConnectionSQL();
            ctpn.setIdPN(text_idPN.getText());
            for(MatHang mh:dsMatHangDaThem){
                ctpn.setIdMH(mh.getIdMatHang());
                ctpn.setSoLuong(dsSoLuong.get(i));
                ctpn.setGia(BigDecimal.valueOf(dsGia.get(i)));
                sqlCT.insertSQL(ctpn);
                i++;
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Có lỗi xảy ra không thể xuất phiếu. Vui lòng thực hiện lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);        
            dispose();
        }
        qlpn.loadData();
        JOptionPane.showMessageDialog(rootPane, "Xuất phiếu thành công!", "Message", JOptionPane.INFORMATION_MESSAGE);                
        dispose();
    }//GEN-LAST:event_btn_XuatPhieuMouseClicked

    //tim kiem theo ma hoac ten
    private void timKiem(int columnIndex) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table_TimKiem.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(String.format("(?i)%s", text_TimKiem.getText()), columnIndex));
    }
    
    //load du lieu len table
    public void loadData(){
        mathang.ConnectionSQL sql = new mathang.ConnectionSQL();
        dsMatHang =  sql.getListMH("select * from mathang");        
        model = (DefaultTableModel) table_TimKiem.getModel();
        model.setRowCount(0); // xoa bo noi dung cu cua table
        for (MatHang mh : dsMatHang) {
            Object[] data = {mh.getIdMatHang(),mh.getTenMatHang(),mh.getNSX(),mh.getHSD()};
            model.addRow(data);
        }
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
    
    //auto create IDPN
    public String autoIDPN(){
        ConnectionSQL sql = new ConnectionSQL();
        String lastIDPN = sql.getLastIDPN();
        String newIDPN = "PN";
        int temp = Integer.parseInt(lastIDPN.split("N")[1]);
        newIDPN += String.valueOf(temp+1);
        return newIDPN;
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
        dsGia.set(index, Integer.parseInt(text_Gia.getText()));
    }
    
    //lay ngay gio hien tai
    public java.sql.Date getTime(){
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);   
//        System.out.println(date); 
        return date;
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
            java.util.logging.Logger.getLogger(FormPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPhieuNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Huy;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_XoaMHDaNhap;
    private javax.swing.JButton btn_XuatPhieu;
    private javax.swing.JComboBox<String> comb_NCC;
    private javax.swing.JComboBox<String> comb_idMH_tenMH;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb_Gia;
    private javax.swing.JLabel lb_NgayLapPhieu;
    private javax.swing.JLabel lb_PhieuNhap;
    private javax.swing.JLabel lb_SoLuong;
    private javax.swing.JLabel lb_idNCC;
    private javax.swing.JLabel lb_idNV;
    private javax.swing.JLabel lb_idPN;
    private javax.swing.JTable table_TimKiem;
    private javax.swing.JTextField text_Gia;
    private javax.swing.JTextField text_SL;
    private javax.swing.JTextField text_TimKiem;
    private javax.swing.JTextField text_idNV;
    private javax.swing.JTextField text_idPN;
    // End of variables declaration//GEN-END:variables
}
