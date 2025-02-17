package com.service;

import com.model.ModelKaryawan;
import java.util.List;

public interface ServiceKaryawan {
    void tambahData (ModelKaryawan model);
    void perbaruiData (ModelKaryawan model);
    void hapusData (ModelKaryawan model);
    
    List<ModelKaryawan> tampilData();
    List<ModelKaryawan> pencarianData(String id);
    
    String generateSHA256(String password);

    ModelKaryawan prosesLogin(ModelKaryawan model);
    boolean prosesSignUp(ModelKaryawan model);
    
    boolean validasiPasswordLama(String namaKaryawan, String passwordLama);
    boolean pergantianPassword(String namaKaryawan, String passwordLama, String passwordBaru);
}
