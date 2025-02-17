package com.dao;

import com.config.Koneks;
import com.model.ModelKaryawan;
import com.service.ServiceKaryawan;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class KaryawanDAO implements ServiceKaryawan{

    private final Connection conn;
    
    public KaryawanDAO(){
        conn = Koneks.getConnection();
    }

    @Override
    public void tambahData(ModelKaryawan model) {
        PreparedStatement st = null;
        try {
            String sql = "INSERT INTO karyawan (nama_karyawan, email, password, telepon)VALUES (?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaKaryawan());
            st.setString(2, model.getEmailKaryawan());
            st.setString(3, generateSHA256(model.getPasswordKaryawan()));
            st.setString(4, model.getTeleponKaryawan());

            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void perbaruiData(ModelKaryawan model) {
        PreparedStatement st = null;
        try {
            String sql = "UPDATE karyawan SET nama_karyawan=?, email=?, telepon=? WHERE id_karyawan=?";
            
            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaKaryawan());
            st.setString(2, model.getEmailKaryawan());
            st.setString(3, model.getTeleponKaryawan());
            st.setInt(4, model.getIdKaryawan());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }

    @Override
    public void hapusData(ModelKaryawan model) {
        PreparedStatement st = null;
        String sql = "DELETE FROM karyawan WHERE id_karyawan=?";
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, model.getIdKaryawan());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelKaryawan> tampilData() {
        PreparedStatement st = null;
        ResultSet rs= null;
        List list = new ArrayList();
        String sql = "SELECT * FROM karyawan";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                ModelKaryawan karyawan = new ModelKaryawan();
                karyawan.setIdKaryawan(rs.getInt("id_karyawan"));
                karyawan.setNamaKaryawan(rs.getString("nama_karyawan"));
                karyawan.setEmailKaryawan(rs.getString("email"));
                karyawan.setTeleponKaryawan(rs.getString("telepon"));

                list.add(karyawan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ModelKaryawan> pencarianData(String id) {
        PreparedStatement st = null;
        ResultSet rs= null;
        List list = new ArrayList();
        String sql = "SELECT * FROM karyawan WHERE id_karyawan LIKE '%"+id+"%' "
                + "OR nama_karyawan LIKE '%"+id+"%' "
                + "OR email LIKE '%"+id+"%' "
                +"OR telepon LIKE '%"+id+"%' ";        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                ModelKaryawan karyawan = new ModelKaryawan();
                karyawan.setIdKaryawan(rs.getInt("id_karyawan"));
                karyawan.setNamaKaryawan(rs.getString("nama_karyawan"));
                karyawan.setEmailKaryawan(rs.getString("email"));
                karyawan.setTeleponKaryawan(rs.getString("telepon"));

                list.add(karyawan);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String generateSHA256(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodehash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder(2*encodehash.length);
            
            for(byte b: encodehash){
                String hex = Integer.toHexString(0xff & b);
                if(hex.length()==1){
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;    
    }

    @Override
    public ModelKaryawan prosesLogin(ModelKaryawan model) {
        PreparedStatement st = null;
        ResultSet rs = null;
        ModelKaryawan modelKar = null;
        String sql = "SELECT * FROM karyawan WHERE nama_karyawan = ? AND password=?";
        
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaKaryawan());
            st.setString(2, generateSHA256(model.getPasswordKaryawan()));
            rs = st.executeQuery();
            
            if(rs.next()){
                modelKar = new ModelKaryawan();
                modelKar.setIdKaryawan(rs.getInt("id_karyawan"));
                modelKar.setNamaKaryawan(rs.getString("nama_karyawan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(st!=null){
                try {
                    st.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return modelKar;
    }

    @Override
    public boolean prosesSignUp(ModelKaryawan model) {
        PreparedStatement st = null;
        String sql = "INSERT INTO karyawan (nama_karyawan, email, password, telepon) " +
                     "VALUES (?, ?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE " +
                     "nama_karyawan = VALUES(nama_karyawan), " +
                     "email = VALUES(email), " +
                     "password = VALUES(password), " +
                     "telepon = VALUES(telepon)";

        try {
            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaKaryawan());
            st.setString(2, model.getEmailKaryawan());
            st.setString(3, generateSHA256(model.getPasswordKaryawan())); 
            st.setString(4, model.getTeleponKaryawan());

            int rowsAffected = st.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean validasiPasswordLama(String namaKaryawan, String passwordLama) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String enkripsiPasswordLama = generateSHA256(passwordLama);
        String sql = "SELECT * FROM karyawan WHERE nama_karyawan = ? AND password = ?";
        
        try {
            st = conn.prepareStatement(sql);
            st.setString(1,namaKaryawan);
            st.setString(2, enkripsiPasswordLama);
            rs = st.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean pergantianPassword(String namaKaryawan, String passwordLama, String passwordBaru) {
        PreparedStatement st = null;
        PreparedStatement stUpdate = null;
        ResultSet rs = null;
        String enkripsiPasswordLama = generateSHA256(passwordLama);
        String enkripsipasswordBaru = generateSHA256(passwordBaru);
        String sql = "SELECT * FROM karyawan WHERE nama_karyawan = ? AND password = ?";
        
        try {
            st = conn.prepareStatement(sql);
            st.setString(1,namaKaryawan);
            st.setString(2, enkripsiPasswordLama);
            rs = st.executeQuery();
            
            if(rs.next()){
                String sqlUpdate = "UPDATE karyawan SET password = ? WHERE nama_karyawan = ?";
                stUpdate = conn.prepareStatement(sqlUpdate);
                stUpdate.setString(1,enkripsipasswordBaru);
                stUpdate.setString(2, namaKaryawan);
                int result = stUpdate.executeUpdate();
                return result > 0;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


