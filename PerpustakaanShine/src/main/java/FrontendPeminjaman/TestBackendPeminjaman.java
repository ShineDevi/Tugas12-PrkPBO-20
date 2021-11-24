/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FrontendPeminjaman;

/**
 *
 * @author -LENOVO-
 */
import Backend.*;
public class TestBackendPeminjaman
{
    public static void main(String[] args)
    {
        Anggota ryan = new Anggota().getById(10);
        Anggota melli = new Anggota().getById(11);
        Anggota alice = new Anggota().getById(12);
        Buku timun = new Buku().getById(35);
        Buku aljabar = new Buku().getById(36);
        Peminjaman p1 = new Peminjaman(ryan, timun,"20210811","20210813");
        Peminjaman p2 = new Peminjaman(melli, timun,"20210811","20210816");
        Peminjaman p3 = new Peminjaman(alice, aljabar,"20210811","20210812");
        // test insert
        p1.save();
        p2.save();
        // test update
        p2.setTanggalkembali("20210815");
        p2.save();
        // test delete
        p3.delete();
        // test select all
        for(Peminjaman p : new Peminjaman().getAll())
        {
            System.out.println("Anggota: " + p.getAnggota().getNama() + ", Buku: " 
                    + p.getBuku().getJudul() + ", Tanggal pinjam: " + p.getTanggalpinjam()
                    + ", Tanggal kembali: " + p.getTanggalkembali());
        }
        // test search
        for(Peminjaman p : new Peminjaman().search("20210811"))
        {
            System.out.println("Anggota: " + p.getAnggota().getNama() + ", Buku: " 
                    + p.getBuku().getJudul() + ", Tanggal pinjam: " + p.getTanggalpinjam()
                    + ", Tanggal kembali: " + p.getTanggalkembali());
        }
    }
}
