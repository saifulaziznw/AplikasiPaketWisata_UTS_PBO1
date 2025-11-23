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

    public static String readStringUbahData(String msg, String oldValue) {
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

    public static String readTKUbah(String msg, String oldValue) {
        System.out.print(msg + " (Lama: " + oldValue + ", Tekan Enter untuk skip): ");
        while (true) {
            String input = readString(msg).toLowerCase();
            if (input.isEmpty()) {
                return oldValue;
            } else if (input.equalsIgnoreCase("mudah") || input.equalsIgnoreCase("sedang") || input.equalsIgnoreCase("sulit")) {
                return input;
            }
            System.out.println("Input tidak valid! Harus mudah, sedang, sulit, atau skip untuk melewati.");
        }
    }
    public static String readStatusUbah(String msg, String oldValue) {
        System.out.print(msg + " (Lama: " + oldValue + ", Tekan Enter untuk skip atau ubah menjadi selesai/batal): ");
        while (true) {
            String input = readString(msg).toLowerCase();
            if (input.isEmpty()) {
                return oldValue;
            } else if (input.equalsIgnoreCase("selesai") || input.equalsIgnoreCase("batal")) {
                return input;
            }
            System.out.println("Input tidak valid! Harus mudah, sedang, sulit, atau skip untuk melewati.");
        }
    }

    public static String readYT(String msg) {
        while (true) {
            String input = readString(msg).toLowerCase();
            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("t")) {
                return input;
            }
            System.out.println("Input tidak valid! Harus 'y' atau 't'.");

        }
    }

    public static boolean readYTUbah(String msg, boolean oldValue) {
        System.out.print(msg + " (Lama: " + oldValue + ", Tekan Enter untuk skip): ");
        while (true) {
            String input = readString(msg).toLowerCase();
            if (input.isEmpty()) {
                return oldValue;
            } else if (input.equalsIgnoreCase("y")) {
                return true;
            } else if (input.equalsIgnoreCase("t")) {
                return false;
            }
            System.out.println("Input tidak valid! Harus 'y' atau 't'.");

        }
    }

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

    public static int readIntUbahJO(String msg, int oldValue, int min) {
        System.out.print(msg + " (Lama: " + oldValue + ", Tekan Enter untuk skip): ");
        while (true) {
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                return oldValue;
            }

            try {
                if (Integer.parseInt(input) > min) {
                    return Integer.parseInt(input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus minimal 1");
            }
        }
    }

    public static int readIntUbahData(String msg, int oldValue) {
        System.out.print(msg + " (Lama: " + oldValue + ", Tekan Enter untuk skip): ");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            return oldValue;
        }
        while (true) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus angka bulat! Coba lagi.");
            }
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

    public static double readDoubleUbahData(String msg, double oldValue) {
        System.out.print(msg + " (Lama: " + oldValue + ", Tekan Enter untuk skip): ");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            return oldValue;
        }
        while (true) {
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus angka desimal! Coba lagi.");
            }
        }
    }

    public static void pause() {
        System.out.print("Tekan ENTER untuk melanjutkan...");
        sc.nextLine();
    }

}
