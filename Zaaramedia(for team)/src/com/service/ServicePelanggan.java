package com.service;

import com.model.ModelPelanggan;
import java.util.List;

public interface ServicePelanggan {
    void tambahData (ModelPelanggan model);
    void perbaruiData (ModelPelanggan model);
    void hapusData (ModelPelanggan model);
    
    List<ModelPelanggan> tampilData();
    List<ModelPelanggan> pencarianData(String id);
    
}
