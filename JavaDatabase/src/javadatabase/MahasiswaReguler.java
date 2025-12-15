/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

/**
 *
 * @author ADVAN
 */
public class MahasiswaReguler extends mahasiswa{
    public MahasiswaReguler(String nim, String nama, int jumlahSKS) {
        super(nim, nama, "Reguler", jumlahSKS);
    }
    
    public MahasiswaReguler(int id, String nim, String nama, int jumlahSKS) {
        super(id, nim, nama, "Reguler", jumlahSKS);
    }
    
    @Override
    public double hitungBiayaKuliah() { 
        return (double)jumlahSKS * 150000;
    }
}
