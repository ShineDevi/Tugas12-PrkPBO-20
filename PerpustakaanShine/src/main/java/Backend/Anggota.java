/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author -LENOVO-
 */
import java.util.ArrayList;
import java.sql.*;
public class Anggota {
    private int idanggota;
    private String nama, alamat, telepon;
    
    public Anggota(){
    }
    
    public Anggota (String nama, String alamat, String telepon){
        this.nama=nama;
        this.alamat=alamat;
        this.telepon=telepon;
    }

    public void setIdanggota(int idanggota) {
        this.idanggota = idanggota;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public int getIdanggota() {
        return idanggota;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTelepon() {
        return telepon;
    }
    
    public Anggota getById(int id){
        Anggota a = new Anggota();
        ResultSet rs = DBHelper.selectQuery("SELECT*FROM anggota "
                +" WHERE idanggota = '"+id+"'");
        try{
            while(rs.next()){
                a=new Anggota();
                a.setIdanggota(rs.getInt("idanggota"));
                a.setNama(rs.getString("nama"));
                a.setAlamat(rs.getString("alamat"));
                a.setTelepon(rs.getString("telepon"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }
    public ArrayList<Anggota> getAll(){
        ArrayList<Anggota> ListAnggota=new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT*FROM anggota");
        try {
            while(rs.next()){
                Anggota a = new Anggota();
                a.setIdanggota(rs.getInt("idanggota"));
                a.setNama(rs.getString("nama"));
                a.setAlamat(rs.getString("alamat"));
                a.setTelepon(rs.getString("telepon"));
                
                ListAnggota.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListAnggota;
    }
    public ArrayList<Anggota> search(String keyword){
        ArrayList<Anggota> ListAnggota=new ArrayList();
        String sql="SELECT*FROM anggota WHERE "
                + " nama LIKE '%" + keyword + "%' "
                + " OR alamat LIKE '%" + keyword + "%'"
                + " OR telepon LIKE '%" + keyword + "%'";
        ResultSet rs=DBHelper.selectQuery(sql);
        try {
            while(rs.next()){
                Anggota a = new Anggota();
                a.setIdanggota(rs.getInt("idanggota"));
                a.setNama(rs.getString("nama"));
                a.setAlamat(rs.getString("alamat"));
                a.setTelepon(rs.getString("telepon"));
                
                ListAnggota.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListAnggota;
    }
    public void save(){
        if (getById(idanggota).getIdanggota()==0) {
            String SQL="INSERT INTO anggota (nama, alamat, telepon) VALUES("
                    +" '"+this.nama+"', "
                    +" '"+this.alamat+"', "
                    +" '"+this.telepon+"' "
                    +" )";
            this.idanggota=DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL="UPDATE anggota SET "
                    +" nama= '"+this.nama+"', "
                    +" nama= '"+this.alamat+"', "
                    +" alamat= '"+this.telepon+"' "
                    +" WHERE idanggota= '"+this.idanggota+"' ";
            DBHelper.executeQuery(SQL);
        }
    }
    public void delete(){
        String SQL="DELETE FROM anggota WHERE idanggota= '"+this.idanggota+"'";
        DBHelper.executeQuery(SQL);
    }
    
}
