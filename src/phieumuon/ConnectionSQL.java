/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phieumuon;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ConnectionSQL {
    public ConnectionSQL(){}

    //them 1 phieu nhap vao database
    public boolean insertSQL(PhieuMuon pm){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=sa";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            String insert = "INSERT INTO phieumuon(idpm,ngaymuon,idnv)" 
                                + "VALUES(?,?,?)";
            try{
                PreparedStatement ps = conn.prepareStatement(insert);
                ps.setString(1, pm.getIdPM());
                ps.setDate(2, new Date(pm.getNgayMuon().getTime()));
                ps.setString(3, pm.getIdNV());
                return ps.executeUpdate() > 0;
            }
            catch(SQLException ex){
                System.err.println("Cannot connect insert, " + ex);
            }
        }
        catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
        
        return false;
    }
    
    //thuc hien cau lenh update
    public void updateSQL(String update){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=sa";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(update);
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
    }
    
    //thuc hien cau lenh delete database
    public void deleteSQL(String id){
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=sa";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            String delete = "delete from phieumuon where idpm = '"+id+"'";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(delete);
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
    }
    
    //thuc hien lay danh sach phieu nhap
    public ArrayList<PhieuMuon> getListPM(){
        ArrayList<PhieuMuon> list = new ArrayList<>();
         try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=sa";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            String select = "select * from phieumuon";
            ResultSet rs = stmt.executeQuery(select);
            while(rs.next()){
                PhieuMuon pm = new PhieuMuon();
                pm.setIdPM(rs.getString("idpm"));
                pm.setNgayMuon(rs.getDate("ngaymuon"));
                pm.setIdNV(rs.getString("idnv"));
                list.add(pm);
            }   
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return list;
    }
    
    //show thong tin 1 phieu muon    
    public void showPM(PhieuMuon pm){
        System.out.println(pm.getIdPM());
        System.out.println(pm.getNgayMuon());
        System.out.println(pm.getIdNV());
    }
    
    //show thong tin danh sach phieu
    public void showListPM(ArrayList<PhieuMuon> list){
        for(PhieuMuon pm:list){
            this.showPM(pm);
        }
    }
    
    //lay ma Phieu nhap cuoi cung trong database
    public String getLastIDPM(){
        String lastID = null;
         try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_DCMPTCT;user=sa;password=sa";
            java.sql.Connection conn = DriverManager.getConnection(dbURL);
            Statement stmt = conn.createStatement();
            String select = "select idpm from phieumuon";
            ResultSet rs = stmt.executeQuery(select);
            while(rs.next()){
                lastID = rs.getString("idpm");
            }   
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
          }
        return lastID;
    }
    
    public static void main(String[] args){
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date ngayMuon = sd.parse("2001-2-2");
            PhieuMuon pm = new PhieuMuon("PM4",ngayMuon , "NV4");
            ArrayList<PhieuMuon> list = new ArrayList<>();
            ConnectionSQL sql = new ConnectionSQL();
//            sql.insertSQL(pm);
//            sql.updateSQL("update phieumuon set idnv = 'NV3' where idpm = 'PM2'");
            list = sql.getListPM();
            sql.showListPM(list);
        } catch (ParseException ex) {
            Logger.getLogger(phieunhap.ConnectionSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
