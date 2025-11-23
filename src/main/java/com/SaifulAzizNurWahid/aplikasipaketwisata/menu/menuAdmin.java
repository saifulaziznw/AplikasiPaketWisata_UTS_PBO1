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
            System.out.println("7. Cari Pelanggan");
            System.out.println("8. Ubah data Paket/Pesanan");
            System.out.println("0. Logout");

            pilih = InputHelper.readInt("Masukkan angka 0-8: ");

            switch (pilih) {
                case 1:
                    tampilDataPaket();
                    break;
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
                case 8:
                    menuUbahData();
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

    public void menuUbahData() {
        int pilih;
        do {
            System.out.println("\n===== Submenu Ubah Data =====");
            System.out.println("1. Ubah Data Paket Wisata");
            System.out.println("2. Ubah Data Pesanan");
            System.out.println("0. Kembali ke Menu Utama");

            pilih = InputHelper.readInt("Masukkan pilihan (0-2): ");

            switch (pilih) {
                case 1:
                    ubahDataPaket();
                    break;
                case 2:
                    ubahDataPesanan();
                    break;
                case 0:
                    System.out.println("Kembali ke Menu Utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 0);
    }

    public void ubahDataPesanan() {
        System.out.println("\n============================================= Ubah Data Pesanan ===================================================");

        int plgId = InputHelper.readInt("Masukkan ID Pelanggan yang memiliki pesanan: ");
        pelanggan plg = findPelangganById(plgId);

        if (plg == null) {
            System.out.println("Pelanggan dengan ID " + plgId + " tidak ditemukan.");
            InputHelper.pause();
            return;
        }

        System.out.println("Daftar Pesanan Pelanggan: ");
        plg.tampilPesanan();

        if (plg.getDaftarPesanan().isEmpty()) {
            System.out.println("Pelanggan ini tidak memiliki pesanan aktif.");
            InputHelper.pause();
            return;
        }

        int kodePsn = InputHelper.readInt("Masukkan Kode Pesanan yang ingin diubah: ");
        pesanan targetPesanan = null;
        for (pesanan psn : plg.getDaftarPesanan()) {
            if (psn.getKodePesanan() == kodePsn) {
                targetPesanan = psn;
                break;
            }
        }

        if (targetPesanan == null) {
            System.out.println("Kode Pesanan " + kodePsn + " tidak ditemukan pada pelanggan ID " + plgId);
            InputHelper.pause();
            return;
        }

        System.out.println("===== Data Pesanan Saat Ini =====");
        targetPesanan.tampilRingkasan();

        int newJumlah = targetPesanan.getJumlahOrang();
        String jumlahInput = InputHelper.readString("Jumlah Orang Baru (Lama: " + targetPesanan.getJumlahOrang() + ", Tekan Enter untuk skip): ").trim();
        if (!jumlahInput.isEmpty()) {
            try {
                newJumlah = Integer.parseInt(jumlahInput);
                if (newJumlah < 1) {
                    System.out.println("Jumlah orang minimal 1. Menggunakan jumlah lama.");
                    newJumlah = targetPesanan.getJumlahOrang();
                }
            } catch (NumberFormatException e) {
                System.out.println("Input Jumlah Orang tidak valid. Menggunakan jumlah lama.");
            }
        }

        String newStatus = InputHelper.readStringSkipable("Status Baru (e.g. Lunas, Pending, Batal)", targetPesanan.getStatus());
        targetPesanan.updatePesanan(newJumlah, newStatus);

        System.out.println("===== Data Pesanan Baru =====");
        targetPesanan.tampilRingkasan();
        InputHelper.pause();
    }

    public void ubahDataPaket() {
        System.out.println("\n============================================= Ubah Data Paket ===================================================");
        System.out.println("----------------------------------------------------------------------------------------------------------------");

        int id = InputHelper.readInt("Masukkan ID Paket yang ingin diubah: ");

        paketWisata target = findPaketById(id);

        if (target == null) {
            System.out.println("Paket dengan ID " + id + " tidak ditemukan.");
            InputHelper.pause();
            return;
        }

        System.out.println("===== Data Paket Saat Ini =====");
        target.tampilDetail();

        String newNama = InputHelper.readStringSkipable("Nama Baru", target.getNama());
        String newLokasi = InputHelper.readStringSkipable("Lokasi Baru", target.getLokasi());
        String newKontak = InputHelper.readStringSkipable("Kontak Baru", target.getKontak());

        double newHarga = target.getHarga();
        String hargaInput = InputHelper.readString("Harga Baru (Lama: " + target.getHarga() + ", Tekan Enter untuk skip): ").trim();
        if (!hargaInput.isEmpty()) {
            try {
                newHarga = Double.parseDouble(hargaInput);
            } catch (NumberFormatException e) {
                System.out.println("Input Harga tidak valid. Menggunakan harga lama.");
            }
        }

        int newDurasi = target.getDurasiHari();
        String durasiInput = InputHelper.readString("Durasi Hari Baru (Lama: " + target.getDurasiHari() + ", Tekan Enter untuk skip): ").trim();
        if (!durasiInput.isEmpty()) {
            try {
                newDurasi = Integer.parseInt(durasiInput);
            } catch (NumberFormatException e) {
                System.out.println("Input Durasi tidak valid. Menggunakan durasi lama.");
            }
        }

        target.updateData(newNama, newHarga, newDurasi, newLokasi, newKontak);

        if (target instanceof wisataAlam wa) {
            String newTingkat = wa.getTingkatKesulitan();
            String tingkatInput = InputHelper.readString("Tingkat Kesulitan Baru (Lama: " + wa.getTingkatKesulitan() + ", Ketik 'mudah'/'sedang'/'sulit' atau Enter untuk skip): ").trim();
            if (!tingkatInput.isEmpty()) {
                if (tingkatInput.equalsIgnoreCase("mudah") || tingkatInput.equalsIgnoreCase("sedang") || tingkatInput.equalsIgnoreCase("sulit")) {
                    newTingkat = tingkatInput;
                } else {
                    System.out.println("Input Tingkat Kesulitan tidak valid. Menggunakan nilai lama.");
                }
            }

            boolean newGuide = wa.isAdaGuide();
            String guideInput = InputHelper.readString("Ada Guide Baru (y/t, Lama: " + (wa.isAdaGuide() ? "y" : "t") + ", Tekan Enter untuk skip): ").trim();
            if (!guideInput.isEmpty()) {
                if (guideInput.equalsIgnoreCase("y")) {
                    newGuide = true;
                } else if (guideInput.equalsIgnoreCase("t")) {
                    newGuide = false;
                } else {
                    System.out.println("Input Guide tidak valid. Menggunakan nilai lama.");
                }
            }

            String newFasilitas = InputHelper.readStringSkipable("Fasilitas Baru", wa.getFasilitas());

            wa.updateSpecificData(newTingkat, newGuide, newFasilitas);

        } else if (target instanceof wisataBudaya wb) {

            String newBudaya = InputHelper.readStringSkipable("Budaya Utama Baru", wb.getBudayaUtama());
            String newBahasa = InputHelper.readStringSkipable("Bahasa Pemandu Baru", wb.getBahasaPemandu());
            String newKegiatan = InputHelper.readStringSkipable("Kegiatan Baru", wb.getKegiatan());

            wb.updateSpecificData(newBudaya, newBahasa, newKegiatan);
        }

        System.out.println("\n===== Data Setelah Perubahan =====");
        target.tampilDetail();
        InputHelper.pause();
    }

    public void tampilDataPaket() {
        System.out.println("\n============================================= Daftar Paket Wisata ===================================================");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        if (daftarPaket.isEmpty()) {
            System.out.println("Daftar Paket Wisata Kosong");
            InputHelper.pause();
            return;
        }
        System.out.printf("ID:%s | %s | Rp %s | %s hari | %s | %s%n", "ID", "Nama Wisata", "Harga", "Durasi", "Lokasi", "Kontak");
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
        paketWisata target = findPaketById(id);
        if (target == null) {
            System.out.println("Paket dengan ID " + id + " tidak ditemukan");
        } else {
            target.tampilDetail();
        }
        InputHelper.pause();
    }

    public void hapusPaket() {

        System.out.println("\n============================================= Hapus Paket Wisata ===================================================");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        int id = InputHelper.readInt("Masukkan ID Paket: ");
        paketWisata target = findPaketById(id);
        if (target == null) {
            System.out.println("Paket dengan ID " + id + " tidak ditemukan");
        } else {
            boolean hapus = InputHelper.readYT("Hapus paket? (y/t): ").equalsIgnoreCase("y");
            if (hapus) {
                daftarPaket.remove(target);
                for (pelanggan plg : daftarPelanggan) {
                    plg.handlePaketDihapus(id);
                    System.out.println("Paket berhasil dihapus dari daftar.");
                }
            } else {
                System.out.println("Paket tidak dihapus dari daftar.");
            }
            InputHelper.pause();
        }
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
        pelanggan target = findPelangganById(ids);
        for (pelanggan plgg : daftarPelanggan) {
            if (plgg.getId() == ids) {
                target = plgg;
                break;
            }
        }
        System.out.printf("ID:%s | %s | %s | %s%n", "ID", "Nama Pelanggan", "Kontak", "Alamat");
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
        System.out.printf("ID:%s | %s | %s | %s%n", "ID", "Nama Pelanggan", "Kontak", "Alamat");
        for (pelanggan plg : daftarPelanggan) {
            plg.tampilInfo();
            plg.tampilPesanan();
            System.out.printf("  Total: Rp %.2f%n", plg.totalPembayaran());
            System.out.println();
        }
        InputHelper.pause();
    }

    private paketWisata findPaketById(int id) {
        for (paketWisata pkt : daftarPaket) {
            if (pkt.getId() == id) {
                return pkt;
            }
        }
        return null;
    }

    private pelanggan findPelangganById(int id) {
        for (pelanggan plg : daftarPelanggan) {
            if (plg.getId() == id) {
                return plg;
            }
        }
        return null;
    }
}
