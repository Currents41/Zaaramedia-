package com.service;

import com.model.ModelKategori;
import java.util.List;

public interface ServiceKategori {
    void tambahData (ModelKategori model);
    void perbaruiData (ModelKategori model);
    void hapusData (ModelKategori model);
    
    List<ModelKategori> tampilData();
    List<ModelKategori> pencarianData(String id);
    
    boolean validasiNamaKategori (ModelKategori model);
    List <ModelKategori> ambilKategori();
    String ambilKategoriID(int id); 
}
