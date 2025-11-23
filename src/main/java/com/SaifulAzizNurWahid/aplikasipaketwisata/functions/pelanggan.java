/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaifulAzizNurWahid.aplikasipaketwisata.functions;

import java.util.ArrayList;
import java.util.List;

public class pelanggan {

    private int id;
    private String nama;
    private String kontak;
    private String alamat;
    private List<pesanan> daftarPesanan = new ArrayList<>();

    public pelanggan(int id, String nama, String kontak, String alamat) {
        this.id = id;
        this.nama = nama;
        this.kontak = kontak;
        this.alamat = alamat;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public List<pesanan> getDaftarPesanan() {
        return daftarPesanan;
    }

    public String getKontak() {
        return kontak;
    }

    public void tambahPesanan(pesanan p) {
        daftarPesanan.add(p);
    }

    public boolean hapusPesananByKode(int kode) {
        pesanan target = null;
        for (pesanan psn : daftarPesanan) {
            if (psn.getKodePesanan() == kode) {
                target = psn;
                break;
            }
        }
        if (target != null) {
            daftarPesanan.remove(target);
            return true;
        }
        return false;
    }

    public void tampilInfo() {
        System.out.printf("ID:%d | %s | %s | %s%n", id, nama, kontak, alamat);
    }

    public void tampilPesanan() {
    if (daftarPesanan.isEmpty()) {
        System.out.println("  Belum ada pesanan.");
        return;
    }
    System.out.println("Daftar Pesanan Pelanggan ID"+id);
    for (pesanan p : daftarPesanan) {
        p.tampilRingkasan();
    }
}

    public double totalPembayaran() {
        double total = 0;
        for (pesanan p : daftarPesanan) {
            total += p.getTotalHarga();
        }
        return total;
    }

    public void handlePaketDihapus(int paketId) {
        for (pesanan p : daftarPesanan) {
            if (p.getPaket() != null && p.getPaket().getId() == paketId) {
                p.setPaket(null);
                p.setStatus("Tidak Tersedia");
            }
        }
    }
}
