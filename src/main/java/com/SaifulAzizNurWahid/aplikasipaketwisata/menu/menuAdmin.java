package com.SaifulAzizNurWahid.aplikasipaketwisata.menu;

import java.util.List;
import java.util.ArrayList;
import com.SaifulAzizNurWahid.aplikasipaketwisata.helper.*;
import com.SaifulAzizNurWahid.aplikasipaketwisata.functions.*;

public class menuAdmin {

    private static List<paketWisata> daftarPaket = new ArrayList<>();
    private static List<pelanggan> daftarPelanggan = new ArrayList<>();
    private static int paketId = 1;
    private static int pelangganId = 1;
    private static int pesananId = 1;

    public void mainMenu() {
        int pilih;

        do {
            System.out.println("\n===== Menu Admin =====");
            System.out.println("1. Lihat Daftar Paket Wisata");
            System.out.println("2. Tambah Paket Wisata");
            System.out.println("3. Hapus Paket Wisata");
            System.out.println("4. Cari Paket Wisata");
            System.out.println("5. Buat Pesanan untuk Pelanggan");
            System.out.println("6. Lihat Pelanggan & Pesanan");
            System.out.println("6. Cari Pelanggan");
            System.out.println("0. Logout");

            pilih = InputHelper.readInt("Masukkan angka 0-7: ");

            switch (pilih) {
                case 1:
                    tampilDataPaket();
//                    break;
                case 2:
                    tambahPaket();
                    break;
                case 3:
                    hapusPaket();
                    break;
                case 4:
                    cariPaket();
                    break;
                case 5:
                    pesanPaket();
                    break;
                case 6:
                    lihatPlgPsn();
                    break;
                case 7:
                    cariPlg();
                    break;
                case 0: {
                    System.out.println("Logout...");
                    return;
                }
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilih != 0);
    }

    public void tampilDataPaket() {
        System.out.println("\n============================================= Daftar Paket Wisata ===================================================");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        if (daftarPaket.isEmpty()) {
            System.out.println("Daftar Paket Wisata Kosong");
            InputHelper.pause();
            return;
        }
        System.out.printf("ID:%-10s | %-15s | Rp %-10.2f | %-2d hari | %-15s | %-15s%n", "ID", "Nama Wisata", "Harga", "Durasi", "Lokasi", "Kontak");
        for (paketWisata pkt : daftarPaket) {
            pkt.tampilDetail();
            System.out.println("\n");
        }
        InputHelper.pause();
    }

    public void cariPaket() {
        System.out.println("\n============================================== Cari Paket Wisata ====================================================");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        int id = InputHelper.readInt("Masukkan ID Paket: ");
        for (paketWisata pkt : daftarPaket) {
            if (pkt.getId() == id) {
                pkt.tampilDetail();
            } else {
                System.out.println("Paket dengan ID " + id + " tidak ditemukan");
            }
        }
        InputHelper.pause();
    }

    public void hapusPaket() {

        System.out.println("\n============================================= Hapus Paket Wisata ===================================================");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        int id = InputHelper.readInt("Masukkan ID Paket: ");
        paketWisata target = null;
        for (paketWisata pkt : daftarPaket) {
            if (pkt.getId() == id) {
                pkt.tampilDetail();
                target = pkt;
                break;
            } else {
                System.out.println("Paket dengan ID " + id + " tidak ditemukan");
            }
        }
        boolean hapus = InputHelper.readYT("Hapus paket? (y/t): ").equalsIgnoreCase("y");
        if (hapus) {
            if (target != null) {
                daftarPaket.remove(target);
                System.out.println("Paket berhasil dihapus dari daftar.");
            }
        } else {
            System.out.println("Paket tidak dihapus dari daftar.");
        }
        InputHelper.pause();
    }

    public void tambahPaket() {
        System.out.println("\n============================================= Tambah Paket Wisata ===================================================");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        System.out.println("1. Wisata Alam");
        System.out.println("2. Wisata Budaya");
        int t = InputHelper.readInt("Jenis: ", 1, 2);
        String nama = InputHelper.readString("Nama paket: ");
        double harga = InputHelper.readDouble("Harga: ");
        int durasi = InputHelper.readInt("Durasi (hari): ");
        String lokasi = InputHelper.readString("Lokasi: ");
        String kontak = InputHelper.readString("Kontak: ");

        if (t == 1) {
            String tingkat = InputHelper.readTingkatKesulitan("Tingkat kesulitan (mudah/sedang/sulit): ");
            boolean adaGuide = InputHelper.readString("Ada guide? (y/n): ").equalsIgnoreCase("y");
            String fasilitas = InputHelper.readString("Fasilitas: ");
            wisataAlam wa = new wisataAlam(paketId++, nama, harga, durasi, lokasi, kontak, tingkat, adaGuide, fasilitas);
            daftarPaket.add(wa);
            System.out.println("Wisata Alam ditambahkan.");
        } else {
            String budaya = InputHelper.readString("Budaya utama: ");
            String bahasa = InputHelper.readString("Bahasa pemandu: ");
            String kegiatan = InputHelper.readString("Kegiatan: ");
            wisataBudaya wb = new wisataBudaya(paketId++, nama, harga, durasi, lokasi, kontak, budaya, bahasa, kegiatan);
            daftarPaket.add(wb);
            System.out.println("Wisata Budaya ditambahkan.");
        }
        InputHelper.pause();
    }

    public void pesanPaket() {
        System.out.println("\n============================================= Pesan Paket Wisata ===================================================");
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        String nama = InputHelper.readString("Nama pelanggan: ");
        String kontak = InputHelper.readString("Kontak pelanggan: ");
        String alamat = InputHelper.readString("Alamat pelanggan: ");
        pelanggan plg = new pelanggan(pelangganId++, nama, kontak, alamat);
        daftarPelanggan.add(plg);

        tampilDataPaket();
        int id = InputHelper.readInt("Masukkan ID paket yang dipesan: ");
        paketWisata pkt = null;
        for (paketWisata p : daftarPaket) {
            if (p.getId() == id) {
                pkt = p;
                break;
            }
        }
        if (pkt == null) {
            System.out.println("Paket Wisata tidak ditemukan.");
            InputHelper.pause();
            return;
        }

        int jumlah = InputHelper.readInt("Jumlah orang: ");
        int kodePesanan = pesananId++;
        pesanan psn = new pesanan(kodePesanan, pkt, jumlah, "Dipesan");
        plg.tambahPesanan(psn);
        System.out.println("Pesanan berhasil dibuat dengan kode " + kodePesanan);
        InputHelper.pause();
    }

    public void cariPlg() {
        System.out.println("\n============================================= Cari Pelanggan ===================================================");
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        int ids = InputHelper.readInt("Masukkan ID Pelanggan: ");
        pelanggan target = null;
        for (pelanggan plgg : daftarPelanggan) {
            if (plgg.getId() == ids) {
                target = plgg;
                break;
            }
        }
        System.out.printf("ID:%-10s | %-15s | 15s | %-15s%n", "ID", "Nama Pelanggan", "Kontak","Alamat");
        target.tampilInfo();
        target.tampilPesanan();
    }

    public void lihatPlgPsn() {
        System.out.println("\n============================================= Pelanggan & Pesanan ===================================================");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        if (daftarPelanggan.isEmpty()) {
            System.out.println("Belum ada pelanggan.");
            InputHelper.pause();
            return;
        }
        System.out.printf("ID:%-10s | %-15s | 15s | %-15s%n", "ID", "Nama Pelanggan", "Kontak","Alamat");
        for (pelanggan plg : daftarPelanggan) {
            plg.tampilInfo();
            plg.tampilPesanan();
            System.out.printf("  Total: Rp %.2f%n", plg.totalPembayaran());
            System.out.println();
        }
        InputHelper.pause();
    }
}
