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

public class Peminjaman {
    private int idpeminjaman;
    private Anggota anggota = new Anggota();
    private Buku buku = new Buku();
    private String tanggalpinjam;
    private String tanggalkembali;

    public void setIdpeminjaman(int idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public void setTanggalpinjam(String tanggalpinjam) {
        this.tanggalpinjam = tanggalpinjam;
    }

    public void setTanggalkembali(String tanggalkembali) {
        this.tanggalkembali = tanggalkembali;
    }

    public int getIdpeminjaman() {
        return idpeminjaman;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public String getTanggalpinjam() {
        return tanggalpinjam;
    }

    public String getTanggalkembali() {
        return tanggalkembali;
    }
    
    
    public Peminjaman() {

    }
    public Peminjaman(Anggota anggota, Buku buku, String tanggalpinjam, String tanggalkembali) {
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalpinjam = tanggalpinjam;
        this.tanggalkembali = tanggalkembali;
    }
    public Peminjaman getById(int id) {
        Peminjaman p = new Peminjaman();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                                            + " p.idpeminjaman AS idpeminjaman, "
                                            + " a.idanggota AS idanggota, "
                                            + " b.idbuku AS idbuku, "
                                            + " p.tanggalpinjam AS tanggalpinjam, "
                                            + " p.tanggalkembali AS tanggalkembali "
                                            + " FROM peminjaman p "
                                            + " LEFT JOIN anggota a ON a.idanggota = p.idanggota"
                                            + " LEFT JOIN buku b ON b.idbuku = p.idbuku"
                                            + " WHERE p.idpeminjaman = '" + id + "'");
        try {
            while(rs.next()){
                p = new Peminjaman();
                p.setIdpeminjaman(rs.getInt("idpeminjaman"));
                p.getAnggota().setIdanggota(rs.getInt("idanggota"));
                p.getBuku().setIdbuku(rs.getInt("idbuku"));
                p.getBuku().getKategori().setIdkategori(rs.getInt("idkategori"));
                p.getAnggota().setNama(rs.getString("nama"));
                p.getAnggota().setAlamat(rs.getString("alamat"));
                p.getAnggota().setTelepon(rs.getString("telepon"));
                p.getBuku().setJudul(rs.getString("judul"));
                p.getBuku().setPenerbit(rs.getString("penerbit"));
                p.getBuku().setPenulis(rs.getString("penulis"));
                p.setTanggalpinjam(rs.getString("tanggalpinjam"));
                p.setTanggalkembali(rs.getString("tanggalkembali"));
            }
    }
    catch (Exception e) {
        e.printStackTrace();
    }
        return p;
    }

    public ArrayList<Peminjaman> getAll() {
    ArrayList<Peminjaman> ListPeminjaman = new ArrayList();

    ResultSet rs = DBHelper.selectQuery("SELECT "
                                            + " p.idpeminjaman AS idpeminjaman, "
                                            + " a.idanggota AS idanggota, "
                                            + " b.idbuku AS idbuku, "
                                            + " p.tanggalpinjam AS tanggalpinjam, "
                                            + " p.tanggalkembali AS tanggalkembali "
                                            + " FROM peminjaman p "
                                            + " LEFT JOIN anggota a ON a.idanggota = p.idanggota"
                                            + " LEFT JOIN buku b ON b.idbuku = p.idbuku");
    try {
        while(rs.next()){
            Peminjaman p = new Peminjaman();
            p.setIdpeminjaman(rs.getInt("idpeminjaman"));
            p.getAnggota().setIdanggota(rs.getInt("idanggota"));
            p.getBuku().setIdbuku(rs.getInt("idbuku"));
            p.getBuku().getKategori().setIdkategori(rs.getInt("idkategori"));
            p.getAnggota().setNama(rs.getString("nama"));
            p.getAnggota().setAlamat(rs.getString("alamat"));
            p.getAnggota().setTelepon(rs.getString("telepon"));
            p.getBuku().setJudul(rs.getString("judul"));
            p.getBuku().setPenerbit(rs.getString("penerbit"));
            p.getBuku().setPenulis(rs.getString("penulis"));
            p.setTanggalpinjam(rs.getString("tanggalpinjam"));
            p.setTanggalkembali(rs.getString("tanggalkembali"));

            ListPeminjaman.add(p);
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }
        return ListPeminjaman;
    }

    public ArrayList<Peminjaman> search(String keyword) {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                                            + " p.idpeminjaman AS idpeminjaman, "
                                            + " a.idanggota AS idanggota, "
                                            + " b.idbuku AS idbuku, "
                                            + " p.tanggalpinjam AS tanggalpinjam, "
                                            + " p.tanggalkembali AS tanggalkembali "
                                            + " FROM peminjaman p "
                                            + " LEFT JOIN anggota a ON a.idanggota = p.idanggota"
                                            + " LEFT JOIN buku b ON b.idbuku = p.idbuku"
                                            + " WHERE a.idanggota = " + keyword + " "
                                            + " OR b.idbuku = " + keyword + " "
                                            + " OR p.tanggalpinjam = '" + keyword + "' "
                                            + " OR p.tanggalkembali = '" + keyword + "' ");
        try {
            while(rs.next()){
                Peminjaman p = new Peminjaman();
                p.setIdpeminjaman(rs.getInt("idpeminjaman"));
                p.getAnggota().setIdanggota(rs.getInt("idanggota"));
                p.getBuku().setIdbuku(rs.getInt("idbuku"));
                p.getBuku().getKategori().setIdkategori(rs.getInt("idkategori"));
                p.getAnggota().setNama(rs.getString("nama"));
                p.getAnggota().setAlamat(rs.getString("alamat"));
                p.getAnggota().setTelepon(rs.getString("telepon"));
                p.getBuku().setJudul(rs.getString("judul"));
                p.getBuku().setPenerbit(rs.getString("penerbit"));
                p.getBuku().setPenulis(rs.getString("penulis"));
                p.setTanggalpinjam(rs.getString("tanggalpinjam"));
                p.setTanggalkembali(rs.getString("tanggalkembali"));

            ListPeminjaman.add(p);
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }
        return ListPeminjaman;
    }

     public void save() {
        if(getById(idpeminjaman).getIdpeminjaman() == 0) {
        String SQL = "INSERT INTO peminjaman (idanggota, idbuku, tanggalpinjam, tanggalkembali) VALUES("
                        + " '" + this.getAnggota().getIdanggota() + "', "
                        + " '" + this.getBuku().getIdbuku() + "', "
                        + " '" + this.tanggalpinjam + "', "
                        + " '" + this.tanggalkembali + "' "
                        + " )";
        this.idpeminjaman= DBHelper.insertQueryGetId(SQL);
    }
    else {
        String SQL = "UPDATE peminjaman SET "
                        + " idanggota = '" + this.getAnggota().getIdanggota() + "', "
                        + " idbuku = '" + this.getBuku().getIdbuku() + "', "
                        + " tanggalpinjam = '" + this.tanggalpinjam + "', "
                        + " tanggalkembali = '" + this.tanggalkembali + "' "
                        + " WHERE idpeminjaman = '" + this.idpeminjaman + "'";
        DBHelper.executeQuery(SQL);
        }
    }
    public void delete() {
        String SQL = "DELETE FROM peminjaman WHERE idpeminjaman = '" + this.idpeminjaman + "'";
        DBHelper.executeQuery(SQL);
    }
}
