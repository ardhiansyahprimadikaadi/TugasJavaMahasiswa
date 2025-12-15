/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

/**
 *
 * @author ADVAN
 */
public class mahasiswa {
    public int id;
    public String nim;
    public String nama;
    public String jenisMahasiswa; 
    public int jumlahSKS;         
    
    public mahasiswa(String nim, String nama, String jenisMahasiswa, int jumlahSKS){
        this.nim = nim;
        this.nama = nama;
        this.jenisMahasiswa = jenisMahasiswa;
        this.jumlahSKS = jumlahSKS;
    }
    
    public mahasiswa(int id, String nim, String nama, String jenisMahasiswa, int jumlahSKS){
        this.id = id;
        this.nim = nim;
        this.nama = nama;
        this.jenisMahasiswa = jenisMahasiswa;
        this.jumlahSKS = jumlahSKS;
    }    
    
    public double hitungBiayaKuliah() {
        return 0; 
    }
    
    public double getBiayaKuliah() {
        return hitungBiayaKuliah();
    }
}
