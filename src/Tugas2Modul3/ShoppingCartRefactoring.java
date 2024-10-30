package Tugas2Modul3;

import java.util.Scanner;
import java.util.function.BiFunction;

/**
 * Kelas ini merepresentasikan aplikasi keranjang belanja sederhana
 * yang memungkinkan pengguna untuk memilih ukuran dan jenis pakaian,
 * serta menghitung total harga tiket berdasarkan pilihan tersebut.
 * Aplikasi ini juga mempertimbangkan diskon untuk pembelian pada hari tertentu.
 */

public class ShoppingCartRefactoring {

    /**
     * Metode utama yang dijalankan saat aplikasi dimulai.
     * Metode ini meminta pengguna untuk memasukkan nama dan hari pembelian,
     * kemudian memungkinkan pengguna memilih jenis pakaian dan ukuran.
     * Berdasarkan pilihan tersebut, total harga dihitung dan ditampilkan.
     *
     * @param args argumen baris perintah yang diterima saat menjalankan aplikasi.
     */

    public static void main(String[] args) {
        // Fungsi validasi input nama dan hari sebagai lambda expression
        BiFunction<String, String, Boolean> validateInput = (nama, hari) -> {
            if (nama == null || nama.isEmpty()) {
                System.out.println("Nama tidak boleh kosong.");
                return true;
            }
            if (hari == null || hari.isEmpty()) {
                System.out.println("Hari tidak boleh kosong.");
                return true;
            }
            return false;
        };

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan hari: ");
        String hari = scanner.nextLine();

        // Validasi input
        if (validateInput.apply(nama, hari)) return;

        System.out.println("Pilih Ukuran:");
        System.out.println("1. M");
        System.out.println("2. L");
        System.out.println("3. XL");
        System.out.print("Masukkan pilihan: ");
        int jenisUkuran = scanner.nextInt();

        int hargaTiket = 0;
        if (getPilihan(scanner) == 1) {
            if (jenisUkuran == 1) {
                hargaTiket = 100000;
            } else if (jenisUkuran == 2) {
                hargaTiket = 150000;
            } else {
                hargaTiket = 200000;
            }
        } else if (getPilihan(scanner) == 2) {
            if (jenisUkuran == 1) {
                hargaTiket = 70000;
            } else if (jenisUkuran == 2) {
                hargaTiket = 120000;
            } else {
                hargaTiket = 170000;
            }
        }

        hargaTiket=applyDiscount(hargaTiket, hari);

        System.out.println("Total Harga: Rp." + hargaTiket);
        System.out.println("Pembelian berhasil.");
    }

    /**
     * Metode untuk mendapatkan pilihan jenis pakaian dari pengguna.
     * Metode ini menampilkan opsi pilihan jenis pakaian dan meminta
     * pengguna untuk memilih salah satu opsi.
     *
     * @param scanner Scanner untuk mengambil input dari pengguna.
     * @return pilihan yang dimasukkan oleh pengguna.
     *         Nilai yang dikembalikan adalah angka yang menunjukkan
     *         pilihan jenis pakaian: 1 untuk Kemeja Putih, 2 untuk Rok Hitam.
     */

    private static int getPilihan(Scanner scanner) {
        System.out.println("Pilih Kemeja:");
        System.out.println("1. Kemeja Putih");
        System.out.println("2. Rok Hitam");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();
        return pilihan;
    }
    /**
     * Metode untuk menerapkan diskon pada harga tiket jika hari adalah Jumat.
     * Jika hari adalah "Jumat", diskon 20% akan diterapkan pada harga.
     *
     * @param harga harga asli sebelum diskon.
     * @param hari hari pembelian yang digunakan untuk memeriksa diskon.
     * @return harga setelah diskon jika berlaku.
     */
    private static int applyDiscount(int harga, String hari) {
        if (hari.equalsIgnoreCase("jumat")) {
            harga *= 0.8; // Diskon 20%
        }
        return harga;
    }
}