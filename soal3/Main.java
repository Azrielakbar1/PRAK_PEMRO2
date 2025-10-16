package soal3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Mahasiswa> banyakMahasiswa = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int pilihan = -1;

        while (pilihan != 0) {
            tampilkanMenu();
            try { 
                System.out.print("Pilihan: ");
                pilihan = scan.nextInt();
                scan.nextLine();

                switch (pilihan) {
                    case 1:
                        tambahMahasiswa(scan, banyakMahasiswa);
                        break;
                    case 2:
                        hapusMahasiswa(scan, banyakMahasiswa);
                        break;
                    case 3:
                        cariMahasiswa(scan, banyakMahasiswa);
                        break;
                    case 4:
                        tampilkanDaftarMahasiswa(banyakMahasiswa);
                        break;
                    case 0:
                        System.out.println("Terima kasih!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        break;
                }
            } 
            catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scan.nextLine();
                pilihan = -1;
            }
            System.out.println();
        }
    }

    private static void tampilkanMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa berdasarkan NIM");
        System.out.println("3. Cari Mahasiswa berdasarkan NIM");
        System.out.println("4. Tampilkan Daftar Mahasiswa");
        System.out.println("0. Keluar");
    }

    private static void tambahMahasiswa(Scanner scan, ArrayList<Mahasiswa> daftar) {
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scan.nextLine();
        System.out.print("Masukkan NIM Mahasiswa (harus unik): ");
        String nim = scan.nextLine();

        if (nama.trim().isEmpty() || nim.trim().isEmpty()) {
            System.out.println("Nama dan NIM tidak boleh kosong.");
            return;
        }

        for (Mahasiswa mhs : daftar) {
            if (mhs.getNIM().equals(nim)) {
                System.out.println("NIM sudah terdaftar. Mahasiswa tidak dapat ditambahkan.");
                return;
            }
        }

        daftar.add(new Mahasiswa(nama, nim));
        System.out.println("Mahasiswa " + nama + " ditambahkan."); 
    }

    private static void hapusMahasiswa(Scanner scan, ArrayList<Mahasiswa> daftar) {
        System.out.print("Masukkan NIM Mahasiswa yang akan dihapus: ");
        String nim = scan.nextLine();

        Mahasiswa mahasiswaUntukDihapus = null;
        boolean ditemukan = false;

        for (Mahasiswa mhs : daftar) {
            if (mhs.getNIM().equals(nim)) {
                mahasiswaUntukDihapus = mhs;
                ditemukan = true;
                break;
            }
        }

        if (ditemukan) {
            daftar.remove(mahasiswaUntukDihapus);
            System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus."); 
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan."); 
        }
    }

    public static void cariMahasiswa(Scanner scan, ArrayList<Mahasiswa> daftar) {
        System.out.print("Masukkan NIM Mahasiswa yang dicari: ");
        String nim = scan.nextLine();

        boolean ditemukan = false;
        for (Mahasiswa mhs : daftar) {
            if (mhs.getNIM().equals(nim)) {
                System.out.println("Data Mahasiswa Ditemukan:");
                System.out.println("NIM: " + mhs.getNIM() + ", Nama: " + mhs.getNama());
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    private static void tampilkanDaftarMahasiswa(ArrayList<Mahasiswa> daftar) {
        if (daftar.isEmpty()) {
            System.out.println("Daftar Mahasiswa kosong.");
            return;
        }

        System.out.println("Daftar Mahasiswa:");
        for (Mahasiswa mhs : daftar) {
            System.out.println("NIM: " + mhs.getNIM() + ", Nama: " + mhs.getNama());
        }
    }
}