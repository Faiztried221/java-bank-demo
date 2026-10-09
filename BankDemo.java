import java.util.ArrayList;
import java.util.Scanner;

public class BankDemo {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pressEnterToContinue(Scanner input) {
        System.out.print("\nPress Enter to continue...");
        input.nextLine();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Bank> accountList = new ArrayList<>();

        // Akun bawaan (Indeks 0 = Rekening 1, Indeks 1 = Rekening 2)
        accountList.add(new Bank("Budi", 100000));
        accountList.add(new Bank("Siti", 500000));

        boolean running = true;

        while (running) {
            clearScreen();
            System.out.println("=================================");
            System.out.println("        WELCOME TO BANK ABC      ");
            System.out.println("=================================");
            System.out.println("1. Tambah Akun Baru");
            System.out.println("2. Lihat Semua Akun");
            System.out.println("3. Transaksi (Pilih Akun)");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            int pilihanUtama = input.nextInt();
            input.nextLine();

            clearScreen();

            switch (pilihanUtama) {
                case 1:
                    System.out.println("=== TAMBAH AKUN BARU ===");
                    System.out.print("Masukkan Nama Pemilik : ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan Saldo Awal   : Rp ");
                    int saldoAwal = input.nextInt();
                    input.nextLine();

                    accountList.add(new Bank(nama, saldoAwal));
                    
                    // Nomor rekening otomatis berasal dari urutan/ukuran ArrayList
                    int noRekBaru = accountList.size(); 
                    System.out.println("\n[Sukses] Akun berhasil dibuat!");
                    System.out.println("Nomor Rekening Anda adalah: " + noRekBaru);
                    pressEnterToContinue(input);
                    break;

                case 2:
                    System.out.println("=== DAFTAR SEMUA AKUN ===");
                    if (accountList.isEmpty()) {
                        System.out.println("Belum ada akun yang terdaftar.");
                    } else {
                        // Indeks + 1 digunakan sebagai Nomor Rekening
                        for (int i = 0; i < accountList.size(); i++) {
                            Bank acc = accountList.get(i);
                            System.out.println("No. Rekening [" + (i + 1) + "] | Nama: " + acc.getOwner() + " | Saldo: Rp " + acc.getBalance());
                        }
                    }
                    pressEnterToContinue(input);
                    break;

                case 3:
                    System.out.println("=== TRANSAKSI ===");
                    if (accountList.isEmpty()) {
                        System.out.println("Belum ada akun yang terdaftar.");
                        pressEnterToContinue(input);
                        break;
                    }

                    System.out.print("Masukkan Nomor Rekening (1 - " + accountList.size() + "): ");
                    int noRek = input.nextInt();
                    input.nextLine();

                    // Konversi Nomor Rekening ke Indeks ArrayList (dikurang 1)
                    int index = noRek - 1;

                    // Validasi apakah indeks tersedia
                    if (index < 0 || index >= accountList.size()) {
                        System.out.println("\n[Gagal] Nomor rekening tidak ditemukan!");
                        pressEnterToContinue(input);
                    } else {
                        Bank selectedAccount = accountList.get(index);
                        boolean inAccountMenu = true;

                        while (inAccountMenu) {
                            clearScreen();
                            System.out.println("=== MENU AKUN NO. REK [" + noRek + "] - " + selectedAccount.getOwner() + " ===");
                            System.out.println("1. Cek Saldo");
                            System.out.println("2. Deposit (Setor Tunai)");
                            System.out.println("3. Withdraw (Tarik Tunai)");
                            System.out.println("4. Kembali ke Menu Utama");
                            System.out.print("Pilih opsi (1-4): ");

                            int subPilihan = input.nextInt();
                            input.nextLine();

                            clearScreen();

                            switch (subPilihan) {
                                case 1:
                                    System.out.println("=== CEK SALDO ===");
                                    System.out.println("Nama Pemilik    : " + selectedAccount.getOwner());
                                    System.out.println("Current balance : Rp " + selectedAccount.getBalance());
                                    pressEnterToContinue(input);
                                    break;

                                case 2:
                                    System.out.println("=== DEPOSIT ===");
                                    System.out.print("Masukkan nominal deposit: Rp ");
                                    int dep = input.nextInt();
                                    input.nextLine();

                                    selectedAccount.deposit(dep);
                                    System.out.println("\n[Berhasil] Deposit: Rp " + dep);
                                    System.out.println("Current balance: Rp " + selectedAccount.getBalance());
                                    pressEnterToContinue(input);
                                    break;

                                case 3:
                                    System.out.println("=== WITHDRAW ===");
                                    System.out.print("Masukkan nominal withdraw: Rp ");
                                    int wd = input.nextInt();
                                    input.nextLine();

                                    if (wd > selectedAccount.getBalance()) {
                                        System.out.println("\n[Gagal] Saldo tidak mencukupi!");
                                    } else {
                                        selectedAccount.withdraw(wd);
                                        System.out.println("\n[Berhasil] Withdraw: Rp " + wd);
                                        System.out.println("Current balance: Rp " + selectedAccount.getBalance());
                                    }
                                    pressEnterToContinue(input);
                                    break;

                                case 4:
                                    inAccountMenu = false;
                                    break;

                                default:
                                    System.out.println("Pilihan tidak valid.");
                                    pressEnterToContinue(input);
                                    break;
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan Bank ABC.");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu 1-4.");
                    pressEnterToContinue(input);
                    break;
            }
        }

        input.close();
    }
}