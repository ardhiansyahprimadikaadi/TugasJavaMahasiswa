/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

/**
 *
 * @author ADVAN
 */
public class MahasiswaInternasional extends mahasiswa {
    public MahasiswaInternasional(String nim, String nama, int jumlahSKS) {
        super(nim, nama, "Internasional", jumlahSKS);
    }
    
    public MahasiswaInternasional(int id, String nim, String nama, int jumlahSKS) {
        super(id, nim, nama, "Internasional", jumlahSKS);
    }
    
    @Override
    public double hitungBiayaKuliah() { 
        return (double)jumlahSKS * 300000 + 5000000;
    }
}
