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
    public int tahunmasuk;
    
    public mahasiswa(String nim, String nama, int tahunmasuk){
        this.nim = nim;
        this.nama = nama;
        this.tahunmasuk = tahunmasuk;
    }
    public mahasiswa(int id, String nim, String nama, int tahunmasuk){
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.tahunmasuk = tahunmasuk;
    }    
}
