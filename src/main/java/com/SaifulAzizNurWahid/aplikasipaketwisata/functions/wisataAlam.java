package com.SaifulAzizNurWahid.aplikasipaketwisata.functions;

// Kelas wisataAlam adalah turunan dari paketWisata dan menambahkan fitur khusus wisata alam.
public class wisataAlam extends paketWisata {

    // Atribut khusus untuk wisata alam
    private String tingkatKesulitan;  // Contoh: mudah, sedang, ekstrem
    private boolean adaGuide;         // Menunjukkan apakah ada pemandu wisata
    private String fasilitas;         // Fasilitas tambahan yang tersedia

    // Constructor lengkap untuk mengisi seluruh data wisata alam
    public wisataAlam(int id, String nama, double harga, int durasiHari, String lokasi, String kontak,
            String tingkatKesulitan, boolean adaGuide, String fasilitas) {

        // Memanggil constructor kelas induk untuk data umum paket wisata
        super(id, nama, harga, durasiHari, lokasi, kontak);

        // Mengisi data spesifik wisata alam
        this.tingkatKesulitan = tingkatKesulitan;
        this.adaGuide = adaGuide;
        this.fasilitas = fasilitas;
    }

    // Getter untuk mengambil nilai atribut tambahan
    public String getTingkatKesulitan() {
        return tingkatKesulitan;
    }

    public boolean isAdaGuide() {
        return adaGuide;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    // Method untuk memperbarui data khusus wisata alam
    public void updateSpecificData(String tingkatKesulitan, boolean adaGuide, String fasilitas) {
        this.tingkatKesulitan = tingkatKesulitan;
        this.adaGuide = adaGuide;
        this.fasilitas = fasilitas;

        System.out.println("Data spesifik Wisata Alam berhasil diperbarui.");
    }

    // Override method tampilDetail dari kelas induk untuk menampilkan detail lengkap
    @Override
    public void tampilDetail() {
        // Menampilkan info dasar paket wisata (dari kelas paketWisata)
        tampilInfo();

        // Menampilkan info spesifik wisata alam
        System.out.printf(
                "  [WisataAlam] Tingkat: %s | Guide: %s | Fasilitas: %s%n",
                tingkatKesulitan,
                adaGuide ? "Ya" : "Tidak", // Ternary untuk menampilkan teks lebih jelas
                fasilitas
        );
    }
}
