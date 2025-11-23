package com.SaifulAzizNurWahid.aplikasipaketwisata.helper;

import java.util.Scanner;

public class InputHelper {

    private static final Scanner sc = new Scanner(System.in);

    public static String readString(String msg) {
        String input;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input tidak boleh kosong! Coba lagi.");
        }
    }

    public static String readString(String msg, boolean skip) {
        String input;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            } else {
                if (skip) {
                    return "";
                }
            }
            System.out.println("Input error! Coba lagi.");
        }
    }

    public static String readStringSkipable(String msg, String oldValue) {
        System.out.print(msg + " (Lama: " + oldValue + ", Tekan Enter untuk skip): ");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            return oldValue;
        }
        return input;
    }

    public static String readTingkatKesulitan(String msg) {
        while (true) {
            String input = readString(msg).toLowerCase();
            if (input.equalsIgnoreCase("mudah") || input.equalsIgnoreCase("sedang") || input.equalsIgnoreCase("sulit")) {
                return input;
            }
            System.out.println("Input tidak valid! Harus mudah, sedang, atau sulit.");
        }
    }

    public static String readYT(String msg) {
        while (true) {
            String input = readString(msg).toLowerCase();
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("t")) {
                return input;
            }
            // FIX KRITIS: Pesan error yang benar
            System.out.println("Input tidak valid! Harus 'y' atau 't'.");
        }
    }

    // NOTE: Method readInt dan readDouble reguler TIDAK DIUBAH karena sudah benar
    // (Mereka berfungsi untuk input wajib, bukan untuk input yang bisa di-skip).
    public static int readInt(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus angka bulat! Coba lagi.");
            }
        }
    }

    public static int readInt(String msg, int min, int max) {
        while (true) {
            int val = readInt(msg);
            if (val >= min && val <= max) {
                return val;
            }
            System.out.println("Input harus antara " + min + " - " + max + ".");
        }
    }

    public static double readDouble(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus angka desimal! Coba lagi.");
            }
        }
    }

    // Method yang menyebabkan infinite loop (readIntUbahData, readDoubleUbahData, etc.) telah dihapus.
    // Logic parsing dan skip untuk UPDATE harus ditangani di menuAdmin.java.
    public static void pause() {
        System.out.print("Tekan ENTER untuk melanjutkan...");
        sc.nextLine();
    }
}
