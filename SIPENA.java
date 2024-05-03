/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ashar
 */

import java.util.ArrayList;

import java.util.Scanner;

// Class Pengguna
class Pengguna {
    private String username;
    private String password;

    public Pengguna(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

// Class Penerima Beasiswa
class PenerimaBeasiswa {
    private String nama;
    private String nim;
    private String programStudi;
    private String fakultas;
    private double ipk;
    private int usia;
    private String alamat;

    public PenerimaBeasiswa(String nama, String nim, String programStudi, String fakultas, double ipk, int usia, String alamat) {
        this.nama = nama;
        this.nim = nim;
        this.programStudi = programStudi;
        this.fakultas = fakultas;
        this.ipk = ipk;
        this.usia = usia;
        this.alamat = alamat;
    }

    // Nama
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Nim
    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }

    // Program Studi
    public String getProgramStudi() {
        return programStudi;
    }
    public void setProgramStudi(String programStudi) {
        this.programStudi = programStudi;
    }

    // Fakultas
    public String getFakultas() {
        return fakultas;
    }
    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    // IPK
    public double getIpk() {
        return ipk;
    }
    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    // Usia
    public int getUsia() {
        return usia;
    }
    public void setUsia(int usia) {
        this.usia = usia;
    }

    // Alamat
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}

public class SIPENA {

    // buat objek baru menampung penerima arraylist
    private static ArrayList<PenerimaBeasiswa> daftarPenerima = new ArrayList<>();

    // buat objek baru menampung pengguna arraylist
    private static ArrayList<Pengguna> daftarPengguna = new ArrayList<>();

    // buat objek scanner
    private static Scanner scanner = new Scanner(System.in);

    // buat objek penggunaAktif
    private static Pengguna penggunaAktif;

    public static void tambahPenerima() {
        // Nama
        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();
        // Nim
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        // Program Studi
        System.out.print("Masukkan program studi: ");
        String programStudi = scanner.nextLine();
        // Fakultas
        System.out.print("Masukkan fakultas: ");
        String fakultas = scanner.nextLine();
        // IPK
        System.out.print("Masukkan IPK: ");
        double ipk = Double.parseDouble(scanner.nextLine());
        // Cek IPK Memenuhi
        if (ipk < 3.0) {
            System.out.println("Maaf, IPK minimal harus 3.0");
            return;
        }
        // Usia
        System.out.print("Masukkan usia: ");
        int usia = Integer.parseInt(scanner.nextLine());
        // Alamat
        System.out.print("Masukkan alamat: ");
        String alamat = scanner.nextLine();

        daftarPenerima.add(new PenerimaBeasiswa(nama, nim, programStudi, fakultas, ipk, usia, alamat));
        System.out.println();
        System.out.println("Penerima beasiswa berhasil ditambahkan!");
        System.out.println();
    }

    public static void tampilkanPenerima() {
        // Cek Data Kosong
        if (daftarPenerima.isEmpty()) {
            System.out.println();
            System.out.println("Tidak ada data penerima beasiswa!");
            System.out.println();
            return;
        }

        // Print Tabel
        System.out.println("\nData Penerima Beasiswa:");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-20s | %-15s | %-30s | %-20s | %-5s | %-5s | %-50s |\n", "Nama", "NIM", "Program Studi", "Fakultas", "IPK", "Usia", "Alamat");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (PenerimaBeasiswa penerima : daftarPenerima) {
            System.out.printf("| %-20s | %-15s | %-30s | %-20s | %-5.2f | %-5d | %-50s |\n", penerima.getNama(), penerima.getNim(), penerima.getProgramStudi(), penerima.getFakultas(), penerima.getIpk(), penerima.getUsia(), penerima.getAlamat());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void updatePenerima() {
        // Cek Data Kosong
        if (daftarPenerima.isEmpty()) {
            System.out.println();
            System.out.println("Tidak ada data penerima beasiswa!");
            System.out.println();
            return;
        }

        // Cek Nim untuk update
        System.out.print("Masukkan NIM penerima yang ingin diupdate: ");
        String nimUpdate = scanner.nextLine();

        // Nim ditemukan!
        boolean ditemukan = false;
        for (PenerimaBeasiswa penerima : daftarPenerima) {
            if (penerima.getNim().equalsIgnoreCase(nimUpdate)) {
                ditemukan = true;
                System.out.print("Masukkan nama: ");
                penerima.setNama(scanner.nextLine());
                System.out.print("Masukkan NIM: ");
                penerima.setNim(scanner.nextLine());
                System.out.print("Masukkan program studi: ");
                penerima.setProgramStudi(scanner.nextLine());
                System.out.print("Masukkan fakultas: ");
                penerima.setFakultas(scanner.nextLine());
                System.out.print("Masukkan IPK: ");
                double ipk = Double.parseDouble(scanner.nextLine());
                if (ipk < 3.0) {
                    System.out.println("Maaf, IPK minimal harus 3.0");
                    return;
                }
                penerima.setIpk(ipk);
                System.out.print("Masukkan usia: ");
                penerima.setUsia(Integer.parseInt(scanner.nextLine()));
                System.out.print("Masukkan alamat: ");
                penerima.setAlamat(scanner.nextLine());
                System.out.println("Data penerima beasiswa berhasil diupdate.");
                break;
            }
        }

        // Nim tidak ditemukan
        if (!ditemukan) {
            System.out.println();
            System.out.println("Penerima dengan NIM '" + nimUpdate + "' tidak ditemukan.");
            System.out.println();
        }
    }

    public static void hapusPenerima() {
        // Cek Data Kosong
        if (daftarPenerima.isEmpty()) {
            System.out.println();
            System.out.println("Tidak ada data penerima beasiswa.");
            System.out.println();
            return;
        }

        // Cek Nim untuk hapus
        System.out.print("Masukkan NIM penerima yang ingin dihapus: ");
        String nimHapus = scanner.nextLine();

        // Nim ditemukan!
        boolean ditemukan = false;
        for (int i = 0; i < daftarPenerima.size(); i++) {
            if (daftarPenerima.get(i).getNim().equalsIgnoreCase(nimHapus)) {
                ditemukan = true;
                daftarPenerima.remove(i);
                System.out.println();
                System.out.println("Data penerima beasiswa berhasil dihapus.");
                System.out.println();
                break;
            }
        }

        // Nim tidak ditemukan
        if (!ditemukan) {
            System.out.println();
            System.out.println("Penerima dengan NIM '" + nimHapus + "' tidak ditemukan.");
            System.out.println();
        }
    }

    public static void cariPenerima() {
        // Cek Data Kosong
        if (daftarPenerima.isEmpty()) {
            System.out.println();
            System.out.println("Tidak ada data penerima beasiswa...");
            System.out.println();
            return;
        }

        // Cek Nim untuk dicari
        System.out.print("Masukkan NIM penerima yang ingin dicari: ");
        String nimCari = scanner.nextLine();

        // Nim ditemukan!
        boolean ditemukan = false;
        for (PenerimaBeasiswa penerima : daftarPenerima) {
            if (penerima.getNim().equalsIgnoreCase(nimCari)) {
                ditemukan = true;
                System.out.println("\nData Penerima Beasiswa:");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-20s | %-15s | %-30s | %-20s | %-5s | %-5s | %-50s |\n", "Nama", "NIM", "Program Studi", "Fakultas", "IPK", "Usia", "Alamat");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %-20s | %-15s | %-30s | %-20s | %-5.2f | %-5d | %-50s |\n", penerima.getNama(), penerima.getNim(), penerima.getProgramStudi(), penerima.getFakultas(), penerima.getIpk(), penerima.getUsia(), penerima.getAlamat());
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
                break;
            }
        }

        // Nim tidak ditemukan
        if (!ditemukan) {
            System.out.println();
            System.out.println("Penerima dengan NIM '" + nimCari + "' tidak ditemukan.");
            System.out.println();
        }
    }

    // Main Code
    public static void main(String[] args) {

        // Membuat pengguna awal
        daftarPengguna.add(new Pengguna("admin", "admin"));
        daftarPengguna.add(new Pengguna("ashari", "ashari"));

        // Berjalan di Awal Login
        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\nMenu Login |> SIPENA");
            System.out.println("1. Masuk");
            System.out.println("2. Daftar Akun");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");

            // Input Opsi
            int opsi = Integer.parseInt(scanner.nextLine());

            // Kondisi Opsi
            switch (opsi) {
                case 1:
                    masuk();
                    break;
                case 2:
                    daftarAkun();
                    break;
                case 3:
                    berjalan = false;
                    System.out.println();
                    System.out.println("Terima kasih Memakai Aplikasi ini. Selamat datang Kembali...");
                    break;
                default:
                    System.out.println();
                    System.out.println("Opsi tidak valid!");
                    System.out.println();
            }
        }
    }

    // Method Masuk Pengguna
    public static void masuk() {

        // Isi data Pengguna
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        // Sesuaikan Username dan Password
        boolean authenticated = false;
        for (Pengguna pengguna : daftarPengguna) {
            if (pengguna.getUsername().equals(username) && pengguna.getPassword().equals(password)) {
                authenticated = true;
                penggunaAktif = pengguna;

                // Berhasil Masuk
                System.out.println();
                System.out.println("Selamat datang di SIPENA, " + username + "!");
                menuUtama();
                break;
            }
        }
        // Username atau password salah
        if (!authenticated) {
            System.out.println();
            System.out.println("Username atau password salah!");
            System.out.println();
        }
    }

    // Method Daftar Akun
    public static void daftarAkun() {

        // Isi data Pengguna
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        // Tambahkan Akun
        daftarPengguna.add(new Pengguna(username, password));
        System.out.println();
        System.out.println("Akun berhasil didaftarkan!");
        System.out.println();
    }

    // Menu Utama Sistem
    public static void menuUtama() {
        boolean berjalan = true;
        while (berjalan) {
            System.out.println("[Sistem Informasi Pendaftaran Beasiswa (SIPENA) V0.1]");
            System.out.println("\nMenu Utama:");
            System.out.println("1. Tambah Penerima Beasiswa");
            System.out.println("2. Tampilkan Penerima Beasiswa");
            System.out.println("3. Update Penerima Beasiswa");
            System.out.println("4. Hapus Penerima Beasiswa");
            System.out.println("5. Cari Penerima Beasiswa");
            System.out.println("6. Keluar");
            System.out.print("Pilih opsi: ");

            // Input Opsi
            int opsi = Integer.parseInt(scanner.nextLine());

            // Kondisi Opsi
            switch (opsi) {
                case 1:
                    tambahPenerima();
                    break;
                case 2:
                    tampilkanPenerima();
                    break;
                case 3:
                    updatePenerima();
                    break;
                case 4:
                    hapusPenerima();
                    break;
                case 5:
                    cariPenerima();
                    break;
                case 6:
                    berjalan = false;
                    System.out.println();
                    System.out.println("Terima kasih telah memakai SIPENA. Sampai jumpa Kembali...");
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    System.out.println("Opsi tidak valid! Masukkan angka yang tersedia...");
                    System.out.println();
            }
        }
    }
}
