package com.SaifulAzizNurWahid.aplikasipaketwisata.functions;

public class pesanan {
    private int kodePesanan;       // Kode unik untuk pesanan
    private paketWisata paket;     // Objek paket wisata yang dipesan
    private int jumlahOrang;       // Jumlah orang dalam pesanan
    private String status;         // Status pesanan: "Pending", "Diproses", "Selesai", dll
    public pesanan(int kodePesanan, paketWisata paket, int jumlahOrang, String status) {
        this.kodePesanan = kodePesanan;
        this.paket = paket;
        this.jumlahOrang = jumlahOrang;
        this.status = status;
    }
    public int getKodePesanan() {
        return kodePesanan;
    }

    public paketWisata getPaket() {
        return paket;
    }

    public int getJumlahOrang() {
        return jumlahOrang;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public void setPaket(paketWisata paket) {
        this.paket = paket;
    }
    /**
     * Menampilkan ringkasan pesanan secara lengkap.
     * Jika paket sudah dihapus dari list paket, tetap tampilkan pesanan.
     */
    public void tampilRingkasan() {
        if (paket != null) {
            System.out.printf(
                "Kode:%s | PaketID:%d - %s | Harga: Rp %.2f | Jumlah:%d | Status: %s%n",
                kodePesanan,
                paket.getId(),
                paket.getNama(),
                paket.getHarga(),
                jumlahOrang,
                status
            );
        } else {
            // Jika paket null -> paket mungkin sudah dihapus
            System.out.printf(
                "Kode:%s | PaketID: Dihapus/Tidak tersedia | Nama: N/A | Jumlah:%d | Status: %s%n",
                kodePesanan,
                jumlahOrang,
                status
            );
        }
    }
    /**
     * Memperbarui jumlah orang dan status pesanan.
     * Hanya memperbarui jumlah orang jika nilainya valid (> 0).
     */
    public void updatePesanan(int newJumlahOrang, String newStatus) {
        if (newJumlahOrang > 0) {
            this.jumlahOrang = newJumlahOrang; // Update jumlah
        }

        this.status = newStatus; // Update status pesanan

        System.out.println("Pesanan dengan Kode " + kodePesanan + " berhasil diperbarui.");
    }
    /**
     * Menghitung total harga berdasarkan harga paket dan jumlah orang.
     * Jika paket null (misalnya sudah dihapus), total harga = 0.
     */
    public double getTotalHarga() {
        return paket != null ? paket.getHarga() * jumlahOrang : 0.0;
    }
}
