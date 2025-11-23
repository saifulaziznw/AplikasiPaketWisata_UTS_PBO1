package com.SaifulAzizNurWahid.aplikasipaketwisata.functions;

// Kelas wisataBudaya merupakan turunan dari paketWisata
// dan berisi atribut tambahan khusus paket wisata budaya.
public class wisataBudaya extends paketWisata {

    // Atribut khusus wisata budaya
    private String budayaUtama;      // Budaya yang menjadi fokus utama wisata
    private String bahasaPemandu;    // Bahasa yang digunakan oleh pemandu
    private String kegiatan;         // Kegiatan budaya yang dapat diikuti wisatawan

    // Constructor lengkap untuk mengisi seluruh data
    public wisataBudaya(int id, String nama, double harga, int durasiHari, String lokasi, String kontak,
            String budayaUtama, String bahasaPemandu, String kegiatan) {

        // Memanggil constructor dari kelas induk (paketWisata)
        super(id, nama, harga, durasiHari, lokasi, kontak);

        // Menginisialisasi atribut tambahan wisata budaya
        this.budayaUtama = budayaUtama;
        this.bahasaPemandu = bahasaPemandu;
        this.kegiatan = kegiatan;
    }

    // Getter untuk mengambil data atribut khusus
    public String getBudayaUtama() {
        return budayaUtama;
    }

    public String getBahasaPemandu() {
        return bahasaPemandu;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    // Method untuk memperbarui data khusus wisata budaya
    public void updateSpecificData(String newBudaya, String newBahasa, String newKegiatan) {
        this.budayaUtama = newBudaya;
        this.bahasaPemandu = newBahasa;
        this.kegiatan = newKegiatan;

        System.out.println("Data spesifik Wisata Budaya berhasil diperbarui.");
    }

    // Override dari method tampilDetail() untuk menampilkan info lengkap
    @Override
    public void tampilDetail() {
        // Menampilkan informasi dasar paket wisata (dari kelas induk)
        tampilInfo();

        // Menampilkan detail khusus wisata budaya
        System.out.printf(
                "  [WisataBudaya] Budaya: %s | Bahasa: %s | Kegiatan: %s%n",
                budayaUtama, bahasaPemandu, kegiatan
        );
    }
}
