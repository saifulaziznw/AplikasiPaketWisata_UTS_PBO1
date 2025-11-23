package com.SaifulAzizNurWahid.aplikasipaketwisata.functions;

public abstract class paketWisata {

    private int id;
    private String nama;
    private double harga;
    private int durasiHari;
    private String lokasi;
    private String kontak;

    public paketWisata(int id, String nama, double harga, int durasiHari, String lokasi, String kontak) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.durasiHari = durasiHari;
        this.lokasi = lokasi;
        this.kontak = kontak;
    }

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

    public void tampilInfo() {
        System.out.printf("ID:%-10d | %-15s | Rp %-10.2f | %-2d hari | %-15s | %-15s%n", id, nama, harga, durasiHari, lokasi,kontak);
    }

    public void updateData(String nama, double harga, int durasi, String lokasi,String kontak) {
        this.nama = nama;
        this.harga = harga;
        this.durasiHari = durasi;
        this.lokasi = lokasi;
        this.kontak = kontak;
    }
    public abstract void tampilDetail();
}
