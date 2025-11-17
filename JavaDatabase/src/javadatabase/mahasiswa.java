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
    
    public mahasiswa(String nim, String nama){
        this.nim = nim;
        this.nama = nama;
    }
    public mahasiswa(int id, String nim, String nama){
        this.id = id;
        this.nama = nama;
        this.nim = nim;
    }    
}
