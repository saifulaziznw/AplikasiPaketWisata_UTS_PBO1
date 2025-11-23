package com.SaifulAzizNurWahid.aplikasipaketwisata.helper;
//IMPORT PACKAGE UNTUK HANDLE INPUT
import java.util.Scanner;

public class InputHelper {

    private static final Scanner sc = new Scanner(System.in);
    //METHODE UNTUK MEMBACA INPUT STRING
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
    //METHODE UNTUK MEMBACA INPUT STRING DAN MEMPERBOLEHKAKN EMPTY STRING
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
    //METHODE UNTUK MEMBACA INPUT STRING DAN MEMPERBOLEHKAKN EMPTY STRING
    public static String readStringSkipable(String msg, String oldValue) {
        System.out.print(msg + " (Lama: " + oldValue + ", Tekan Enter untuk skip): ");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            return oldValue;
        }
        return input;
    }
    //METHODE UNTUK MEMBACA INPUT STRING PILIHAN MUDAH, SEDANG, DAN SULIT
    public static String readTingkatKesulitan(String msg) {
        while (true) {
            String input = readString(msg).toLowerCase();
            if (input.equalsIgnoreCase("mudah") || input.equalsIgnoreCase("sedang") || input.equalsIgnoreCase("sulit")) {
                return input;
            }
            System.out.println("Input tidak valid! Harus mudah, sedang, atau sulit.");
        }
    }
    //METHODE UNTUK MEMBACA INPUT STRING PILIHAN Y ATAU T 
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

    // METHODE readInt dan readDouble BERFUNGSI UNTUK MENGHANDLE INPUT INTEGER DAN DOUBLE
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

    //METHODE KHUSUS UNTUK PAUSE TERMINAL
    public static void pause() {
        System.out.print("Tekan ENTER untuk melanjutkan...");
        sc.nextLine();
    }
}
