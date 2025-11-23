package com.SaifulAzizNurWahid.aplikasipaketwisata.functions;

// Kelas abstrak yang menjadi blueprint dasar untuk berbagai jenis paket wisata
public abstract class paketWisata {

    // Atribut dasar setiap paket wisata
    private int id;
    private String nama;
    private double harga;
    private int durasiHari;
    private String lokasi;
    private String kontak;

    // Constructor untuk mengisi data paket wisata
    public paketWisata(int id, String nama, double harga, int durasiHari, String lokasi, String kontak) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.durasiHari = durasiHari;
        this.lokasi = lokasi;
        this.kontak = kontak;
    }

    // Getter untuk mengambil data
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getDurasiHari() {
        return durasiHari;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getKontak() {
        return kontak;
    }

    // Menampilkan informasi singkat paket wisata
    public void tampilInfo() {
        System.out.printf(
            "ID:%d | %s | Rp %.2f /orang | Durasi: %d hari | Lokasi: %s | Kontak: %s%n",
            id, nama, harga, durasiHari, lokasi, kontak
        );
    }

    // Method untuk memperbarui data paket wisata
    public void updateData(String nama, double harga, int durasi, String lokasi, String kontak) {
        this.nama = nama;
        this.harga = harga;
        this.durasiHari = durasi;
        this.lokasi = lokasi;
        this.kontak = kontak;
    }

    // Method abstrak yang wajib diimplementasikan oleh subclass
    // untuk menampilkan informasi yang lebih detail sesuai jenis paket
    public abstract void tampilDetail();
}
