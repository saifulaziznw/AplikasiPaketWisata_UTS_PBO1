package com.SaifulAzizNurWahid.aplikasipaketwisata.functions;

public class wisataBudaya extends paketWisata {

    private String budayaUtama;
    private String bahasaPemandu;
    private String kegiatan;

    public wisataBudaya(int id, String nama, double harga, int durasiHari, String lokasi, String kontak,
            String budayaUtama, String bahasaPemandu, String kegiatan) {
        super(id, nama, harga, durasiHari, lokasi, kontak);
        this.budayaUtama = budayaUtama;
        this.bahasaPemandu = bahasaPemandu;
        this.kegiatan = kegiatan;
    }

    public String getBudayaUtama() {
        return budayaUtama;
    }

    public String getBahasaPemandu() {
        return bahasaPemandu;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public void updateSpecificData(String newBudaya, String newBahasa, String newKegiatan) {
        this.budayaUtama = newBudaya;
        this.bahasaPemandu = newBahasa;
        this.kegiatan= newKegiatan;
        System.out.println("Data spesifik Wisata Budaya berhasil diperbarui.");
    }

    @Override
    public void tampilDetail() {
        tampilInfo();
        System.out.printf("  [WisataBudaya] Budaya: %s | Bahasa: %s | Kegiatan: %s%n",
                budayaUtama, bahasaPemandu, kegiatan);
    }
}
