/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADVAN
 */
public class JavaDatabaseOop {
    private static final String URL = "jdbc:postgresql://localhost:5432/DatabasePBO";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin123";
    
    public static void main(String[] args) {    
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi Berhasil");
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(JavaDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver PostgreSQL tidak ditemukan!");
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public static void insert(mahasiswa m) throws SQLException {
        String sql = "INSERT INTO mahasiswa(nim, nama) VALUES(?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, m.nim);
            ps.setString(2, m.nama);  
            ps.executeUpdate();
            System.out.println("Data berhasil ditambahkan.");
        } catch (SQLException e) {
            System.out.println("Error insert: " + e.getMessage());
            throw e; 
        }
    }
    public static List<mahasiswa> getAllmahasiswa() {
        List<mahasiswa> list = new ArrayList<>();
        String sql = "SELECT id, nim, nama FROM mahasiswa ORDER BY id"; 
        
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                mahasiswa m = new mahasiswa(
                    rs.getInt("id"),         
                    rs.getString("nim"),     
                    rs.getString("nama")  
                );
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Error read: " + e.getMessage());
        }
        return list;  
    }
    public static void edit(mahasiswa m) throws SQLException {
        String sql = "UPDATE mahasiswa SET nama = ?,nim = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.nama);
            stmt.setString(2, m.nim); 
            stmt.setInt(3, m.id);
            stmt.executeUpdate();
            System.out.println("Data berhasil diperbarui.");
        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
            throw e;
        }
    }
    public static void hapus(int id) throws SQLException {
        String sql = "DELETE FROM mahasiswa WHERE id = ?"; 
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Data berhasil dihapus.");
        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
            throw e;
        }
    }
}
