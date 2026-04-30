package com.pluralsight;

public class InterfaceStyle {
    public static void main(String[] args) {
        // --- ANSI COLORS ---
        String RESET   = "\u001B[0m";
        String BLACK   = "\u001B[30m";
        String CYAN    = "\u001B[36m";
        String RED     = "\u001B[31m";
        String GREEN   = "\u001B[32m";
        String MAGENTA = "\u001B[35m";
        String BOLD    = "\u001B[1m";

        // --- BORDER CHARACTERS ---
        final String TL = "╔";  // top-left
        final String TR = "╗";  // top-right
        final String BL = "╚";  // bottom-left
        final String BR = "╝";  // bottom-right
        final String H  = "═";  // horizontal
        final String V  = "║";  // vertical

        // --- BORDER WIDTH ---
        int WIDTH = 50;

        // --- TEST ---
        System.out.println(BLACK + BOLD + TL + H.repeat(WIDTH) + TR + RESET);
        System.out.println(BLACK + BOLD + V  + RESET + CYAN + "  » View Balance" + RESET);
        System.out.println(BLACK + BOLD + V  + RESET + GREEN + "  + Deposit $500" + RESET);
        System.out.println(BLACK + BOLD + V  + RESET + RED + "  - Payment $200" + RESET);
        System.out.println(BLACK + BOLD + V  + RESET + MAGENTA + "  ← Go Back" + RESET);
        System.out.println(BLACK + BOLD + BL + H.repeat(WIDTH) + BR + RESET);
    }
}
