/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javadatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADVAN
 */
public class JavaDatabase {
    private static final String URL = "jdbc:postgresql://localhost:5432/LatihanPBO";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin123";
    
    public static void main(String[] args) {     
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Berhasil");
            mahasiswa m = new mahasiswa ("12345","Ardi",2024);
            
            String sqls = "INSERT INTO mahasiswa (nim,nama,tahunmasuk) VALUES('"+m.nim+"','"+m.nama+"',"+m.tahunmasuk+")";
            System.out.println(sqls);
            Statement s = con.createStatement();
            s.executeUpdate(sqls);
            
            String sql = "INSERT INTO mahasiswa(nim, nama, tahunmasuk) VALUES(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, m.nim);
            ps.setString(2, m.nama);
            ps.setInt(3, m.tahunmasuk); 
            ps.executeUpdate();
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(JavaDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static List<mahasiswa>getAllmahasiswa() {
        List<mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM mahasiswa";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                mahasiswa m = new mahasiswa(
                    rs.getString("nim"),
                    rs.getString("name"),
                    rs.getInt("tahunmasuk")
                );
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Error read: " + e.getMessage());
        }
        return list;  
    } 
    
     public static void update(mahasiswa m) {
        String sql = "UPDATE mahasiswa SET name = ?, tahunmasuk = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.nama);
            stmt.setInt(3, m.id);
            stmt.executeUpdate();
            System.out.println("Data berhasil diperbarui.");
        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
        }
    }
     
    public static void delete(int id) {
        String sql = "DELETE FROM items WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Data berhasil dihapus.");
        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
        }
    }
}
