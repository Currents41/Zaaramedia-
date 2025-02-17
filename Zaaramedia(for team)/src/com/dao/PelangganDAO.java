package com.dao;

import com.config.Koneks;
import com.model.ModelPelanggan;
import com.service.ServicePelanggan;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class PelangganDAO implements ServicePelanggan{

    private final Connection conn;
    
    public PelangganDAO(){
        conn = Koneks.getConnection();
    }

    @Override
    public void tambahData(ModelPelanggan model) {
        PreparedStatement st = null;
        try {
            String sql = "INSERT INTO pelanggan (nama_pelanggan, telepon, alamat)VALUES (?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaPelanggan());
            st.setString(2, model.getTeleponPelanggan());
            st.setString(3, model.getAlamatPelanggan());

            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void perbaruiData(ModelPelanggan model) {
        PreparedStatement st = null;
        try {
            String sql = "UPDATE pelanggan SET nama_pelanggan=?, telepon=?, alamat=? WHERE id_pelanggan=?";
            
            st = conn.prepareStatement(sql);
            st.setString(1, model.getNamaPelanggan());
            st.setString(2, model.getTeleponPelanggan());
            st.setString(3, model.getAlamatPelanggan());
            st.setInt(4, model.getIdPelanggan());

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }

    @Override
    public void hapusData(ModelPelanggan model) {
        PreparedStatement st = null;
        String sql = "DELETE FROM pelanggan WHERE id_pelanggan=?";
        try {
            st = conn.prepareStatement(sql);
            st.setInt(1, model.getIdPelanggan());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ModelPelanggan> tampilData() {
        PreparedStatement st = null;
        ResultSet rs= null;
        List list = new ArrayList();
        String sql = "SELECT * FROM pelanggan";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                ModelPelanggan pelanggan = new ModelPelanggan();
                pelanggan.setIdPelanggan(rs.getInt("id_pelanggan"));
                pelanggan.setNamaPelanggan(rs.getString("nama_pelanggan"));
                pelanggan.setTeleponPelanggan(rs.getString("telepon"));
                pelanggan.setAlamatPelanggan(rs.getString("alamat"));

                list.add(pelanggan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<ModelPelanggan> pencarianData(String id) {
        PreparedStatement st = null;
        ResultSet rs= null;
        List list = new ArrayList();
        String sql = "SELECT * FROM pelanggan WHERE id_pelanggan LIKE '%"+id+"%' "
                + "OR nama_pelanggan LIKE '%"+id+"%' "
                + "OR telepon LIKE '%"+id+"%' "
                +"OR alamat LIKE '%"+id+"%' ";
        
        try {
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                ModelPelanggan pelanggan = new ModelPelanggan();
                pelanggan.setIdPelanggan(rs.getInt("id_pelanggan"));
                pelanggan.setNamaPelanggan (rs.getString("nama_pelanggan"));
                pelanggan.setTeleponPelanggan(rs.getString("telepon"));
                pelanggan.setAlamatPelanggan(rs.getString("alamat"));
                
                list.add(pelanggan);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
} 
