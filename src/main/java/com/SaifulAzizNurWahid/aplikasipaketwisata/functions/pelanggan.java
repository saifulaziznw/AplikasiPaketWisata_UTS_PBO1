/*
 * Kelas pelanggan merepresentasikan data pelanggan dalam aplikasi paket wisata.
 * Setiap pelanggan dapat memiliki beberapa pesanan.
 */
package com.SaifulAzizNurWahid.aplikasipaketwisata.functions;

import java.util.ArrayList;
import java.util.List;

// Kelas pelanggan yang menyimpan informasi dasar pelanggan dan daftar pesanannya
public class pelanggan {

    // Atribut dasar pelanggan
    private int id;
    private String nama;
    private String kontak;
    private String alamat;

    // List untuk menampung semua pesanan pelanggan
    private List<pesanan> daftarPesanan = new ArrayList<>();

    // Constructor untuk mengisi data pelanggan
    public pelanggan(int id, String nama, String kontak, String alamat) {
        this.id = id;
        this.nama = nama;
        this.kontak = kontak;
        this.alamat = alamat;
    }

    // Getter untuk mengambil ID pelanggan
    public int getId() {
        return id;
    }

    // Getter untuk mengambil nama pelanggan
    public String getNama() {
        return nama;
    }

    // Getter untuk mengambil list pesanan pelanggan
    public List<pesanan> getDaftarPesanan() {
        return daftarPesanan;
    }

    // Getter untuk kontak pelanggan
    public String getKontak() {
        return kontak;
    }

    // Menambahkan pesanan baru ke daftar pesanan pelanggan
    public void tambahPesanan(pesanan p) {
        daftarPesanan.add(p);
    }

    // Menghapus pesanan berdasarkan kode pesanan
    public boolean hapusPesananByKode(int kode) {
        pesanan target = null;

        // Mencari pesanan yang cocok
        for (pesanan psn : daftarPesanan) {
            if (psn.getKodePesanan() == kode) {
                target = psn;
                break;
            }
        }

        // Jika ditemukan, hapus pesanan dan return true
        if (target != null) {
            daftarPesanan.remove(target);
            return true;
        }

        // Jika tidak ditemukan, return false
        return false;
    }

    // Menampilkan informasi dasar pelanggan
    public void tampilInfo() {
        System.out.printf("ID:%d | %s | %s | %s%n", id, nama, kontak, alamat);
    }

    // Menampilkan seluruh pesanan pelanggan
    public void tampilPesanan() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("  Belum ada pesanan.");
            return;
        }

        System.out.println("Daftar Pesanan Pelanggan ID " + id);

        // Menampilkan ringkasan setiap pesanan
        for (pesanan p : daftarPesanan) {
            p.tampilRingkasan();
        }
    }

    // Menghitung total pembayaran dari seluruh pesanan
    public double totalPembayaran() {
        double total = 0;

        for (pesanan p : daftarPesanan) {
            total += p.getTotalHarga();
        }

        return total;
    }

    // Menangani kasus ketika sebuah paket wisata dihapus dari sistem
    // Jika pesanan pelanggan menggunakan paket tersebut, paket diset null dan status pesanan diubah
    public void handlePaketDihapus(int paketId) {
        for (pesanan p : daftarPesanan) {
            if (p.getPaket() != null && p.getPaket().getId() == paketId) {
                p.setPaket(null);
                p.setStatus("Tidak Tersedia"); // Menandai bahwa paket sudah dihapus
            }
        }
    }
}
