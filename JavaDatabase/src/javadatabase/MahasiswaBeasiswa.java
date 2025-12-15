/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

/**
 *
 * @author ADVAN
 */
public class MahasiswaBeasiswa extends mahasiswa {
    public MahasiswaBeasiswa(String nim, String nama, int jumlahSKS) {
        super(nim, nama, "Beasiswa", jumlahSKS);
    }
    
    public MahasiswaBeasiswa(int id, String nim, String nama, int jumlahSKS) {
        super(id, nim, nama, "Beasiswa", jumlahSKS);
    }
    
    @Override
    public double hitungBiayaKuliah() { 
        return (double)jumlahSKS * 150000 * 0.50;
    }
}
