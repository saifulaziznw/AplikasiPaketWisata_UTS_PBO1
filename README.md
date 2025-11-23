# 👨‍💻 Aplikasi Manajemen Paket Wisata Berbasis Konsol (Java)

Proyek ini adalah implementasi sistem manajemen data paket wisata, pelanggan, dan pesanan berbasis konsol (Command Line Interface) menggunakan bahasa pemrograman Java. Dibuat sebagai tugas Ujian Tengah Semester (UTS) untuk mata kuliah Pemrograman Berorientasi Objek (PBO).



---

## 🚀 Fitur Utama Aplikasi

Aplikasi ini mengimplementasikan prinsip-prinsip dasar CRUD (Create, Read, Update, Delete) serta konsep **Polimorfisme** dan **Inheritance** dalam OOP:

### 1. Manajemen Paket Wisata (CRUD & Polimorfisme)
* **Tambah Data (Create):** Menambahkan dua jenis paket wisata: `WisataAlam` dan `WisataBudaya` (implementasi Inheritance).
* **Tampil Data (Read):** Menampilkan daftar lengkap atau detail paket berdasarkan ID.
* **Hapus Data (Delete):** Menghapus paket wisata dan secara otomatis memperbarui status pesanan yang terkait (cascading update).
* **Ubah Data (Update):** Memungkinkan perubahan data paket umum dan data spesifik paket (tingkat kesulitan/budaya utama) dengan fitur **Partial Update** (skip input).
* **Pencarian:** Mencari paket,pesanan, dan pelanggan berdasarkan ID.

### 2. Manajemen Pelanggan dan Pesanan
* **Pemesanan:** Membuat pesanan baru untuk pelanggan yang sudah ada atau menambahkan pelanggan baru secara otomatis.
* **Lihat Status Data (UTS):** Memungkinkan pengguna mencari dan melihat status pesanan (e.g., Pending, Lunas, Batal) berdasarkan Kode Pesanan.
* **Ubah Data Pesanan:** Mengubah jumlah orang dan status pesanan.
* **Lihat Data Pelanggan:** Menampilkan semua data pelanggan beserta daftar pesanan dan total pembayaran.

---

## ⚙️ Struktur dan Konsep OOP

Proyek ini dirancang menggunakan beberapa *class* utama yang merepresentasikan entitas bisnis:

| Class | Tipe | Konsep OOP | Deskripsi |
| :--- | :--- | :--- | :--- |
| `paketWisata` | **Abstract** | Inheritance | Kelas dasar untuk properti umum paket (harga, durasi, lokasi). |
| `wisataAlam` | Concrete | Polimorfisme | Kelas turunan dari `paketWisata` dengan properti spesifik (`tingkatKesulitan`, `adaGuide`). |
| `wisataBudaya` | Concrete | Polimorfisme | Kelas turunan dari `paketWisata` dengan properti spesifik (`budayaUtama`, `bahasaPemandu`). |
| `pelanggan` | Concrete | Composition | Mengandung daftar (`List`) objek `pesanan` (relasi *has-a*). |
| `pesanan` | Concrete | Encapsulation | Menyimpan detail pesanan dan memiliki referensi ke objek `paketWisata`. |
| `menuAdmin` | Utility/Main | SRP/Encapsulation | Bertanggung jawab atas *flow* menu, *business logic* (CRUD), dan menyimpan data (`List` statis). |
| `InputHelper` | Utility | SRP | Menangani semua proses input pengguna (validasi dan *skip* input untuk *update*). |

## 👤 Identitas Mahasiswa

Proyek ini dikerjakan oleh:

| Detail | Informasi |
| :--- | :--- |
| **NIM** | **24552011160** |
| **Nama** | **Saiful Aziz Nur Wahid** |
| **Kelas** | **TIF RP 24E** |
| **Mata Kuliah** | Pemrograman Berorientasi Objek (PBO) 1 |
