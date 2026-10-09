# 🏦 Bank ABC - Terminal Console Application

Program simulasi perbankan berbasis CLI (Command Line Interface) yang dibuat menggunakan bahasa pemrograman Java. Program ini dibuat untuk memenuhi tugas **Exercise B: Bank Account**.

---

## 📌 Fitur Utama

* **Manajemen Akun Berbasis Array (`ArrayList`)**:
  * Nomor Rekening dihasilkan secara otomatis berdasarkan indeks/urutan akun.
  * Tambah akun baru & lihat daftar seluruh akun.
* **Transaksi Perbankan**:
  * 💰 **Deposit (Setor Tunai)**: Menambah saldo ke akun yang dipilih.
  * 💸 **Withdraw (Tarik Tunai)**: Memotong saldo dengan validasi kecukupan saldo.
  * 🔍 **Cek Saldo**: Menampilkan informasi pemilik dan saldo saat ini.
* **Antarmuka Interaktif**:
  * Fitur *Clear Screen* dan *"Press Enter to continue"* untuk simulasi perpindahan halaman menu yang bersih.

---

## 🛠️ Struktur File

```text
├── Bank.java       # Model class (Encapsulation, Constructor, Getter & Methods)
├── BankDemo.java   # Main class (Menu loop, ArrayList, CLI Interaction)
└── README.md       # Dokumentasi proyek

## 💻 Output Program

Berikut adalah tampilan hasil saat program dijalankan:

<img width="1920" height="1200" alt="image" src="https://github.com/user-attachments/assets/1e0c6e6c-64e7-4713-9e35-67d6d8202970" />
