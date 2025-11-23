/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SaifulAzizNurWahid.aplikasipaketwisata.functions;

public class pesanan {

    private int kodePesanan;
    private paketWisata paket;
    private int jumlahOrang;
    private String status;

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

    public void tampilRingkasan() {
        if (paket != null) {
            System.out.printf("Kode:%s | PaketID:%d - %s | Harga: Rp %.2f | Jumlah:%d | Status: %s%n",
                    kodePesanan, paket.getId(), paket.getNama(), paket.getHarga(), jumlahOrang, status);
        }
    }
    public void updatePesanan(int newJumlahOrang, String newStatus) {
        if (newJumlahOrang > 0) {
            this.jumlahOrang = newJumlahOrang;
        }
        this.status = newStatus;
        System.out.println("Pesanan dengan Kode " + kodePesanan + " berhasil diperbarui.");
    }
    public double getTotalHarga() {
        return paket != null ? paket.getHarga() * jumlahOrang : 0.0;
    }
}
