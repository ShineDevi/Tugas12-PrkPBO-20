/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;

/**
 *
 * @author -LENOVO-
 */
import Backend.Kategori;
import Backend.Anggota;
import backend.*;
public class TestBackend {
    public static void main(String[] args)
    {
        System.out.println("===================KATEGORI=========================");
        Kategori kat1 = new Kategori("Novel", "Koleksi buku novel");
        Kategori kat2 = new Kategori("Referensi", "Buku referensi ilmiah");
        Kategori kat3 = new Kategori("Komik", "Komik anak-anak");
        
        // test insert
        kat1.save();
        kat2.save();
        kat3.save();
        
        // test update
        kat2.setKeterangan("Koleksi buku referensi ilmiah");
        kat2.save();
        
        // test delete
        kat3.delete();
        // test select all
        for(Kategori k : new Kategori().getAll())
        {
            System.out.println("Nama: " + k.getNama() + ", Ket: " + k.getKeterangan());
        }
        
        // test search
        for(Kategori k : new Kategori().search("ilmiah"))
        {
            System.out.println("Nama: " + k.getNama() + ", Ket: " + k.getKeterangan());
        }
        System.out.println("");
        System.out.println("===================ANGGOTA=========================");
        Anggota a1=new Anggota("Ryan", "Malang", "082331552132");
        Anggota a2=new Anggota("Melli", "Turen", "082331552133");
        Anggota a3=new Anggota("Alice", "Kasembon", "082331552134");
        
        a1.save();
        a2.save();
        a3.save();
        
        for(Anggota a : new Anggota().getAll())
        {
            System.out.println("Nama: " + a.getNama() + ", Alamat: " + a.getAlamat() + 
                    ", Telepon: "+a.getTelepon());
        }
        
        for(Anggota a : new Anggota().search("Kasembon"))
        {
            System.out.println("Nama: " + a.getNama() + ", Alamat: " + a.getAlamat() +
                    ", Telepon: "+a.getTelepon());
        }
    }
}
