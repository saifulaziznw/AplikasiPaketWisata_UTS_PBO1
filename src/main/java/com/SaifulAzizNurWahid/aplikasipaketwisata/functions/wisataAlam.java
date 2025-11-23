package com.SaifulAzizNurWahid.aplikasipaketwisata.functions;

public class wisataAlam extends paketWisata {

    private String tingkatKesulitan;
    private boolean adaGuide;
    private String fasilitas;

    public wisataAlam(int id, String nama, double harga, int durasiHari, String lokasi, String kontak,
            String tingkatKesulitan, boolean adaGuide, String fasilitas) {
        super(id, nama, harga, durasiHari, lokasi, kontak);
        this.tingkatKesulitan = tingkatKesulitan;
        this.adaGuide = adaGuide;
        this.fasilitas = fasilitas;
    }

    public String getTingkatKesulitan() {
        return tingkatKesulitan;
    }

    public boolean isAdaGuide() {
        return adaGuide;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void updateSpecificData(String tingkatKesulitan, boolean adaGuide, String fasilitas) {
        this.tingkatKesulitan = tingkatKesulitan;
        this.adaGuide = adaGuide;
        this.fasilitas = fasilitas;
        System.out.println("Data spesifik Wisata Alam berhasil diperbarui.");
    }

    @Override
    public void tampilDetail() {
        tampilInfo();
        System.out.printf("  [WisataAlam] Tingkat: %s | Guide: %s | Fasilitas: %s%n",
                tingkatKesulitan, adaGuide ? "Ya" : "Tidak", fasilitas);
    }
}
