package com.pluralsight;

public class InterfaceStyle {

    // --- ANSI COLORS ---
    public static final String RESET   = "\u001B[0m"; // reset so colors won't bleed into next line
    public static final String WHITE   = "\u001B[37m";
    public static final String BLACK   = "\u001B[30m";
    public static final String CYAN    = "\u001B[36m";
    public static final String RED     = "\u001B[31m";
    public static final String GREEN   = "\u001B[32m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String YELLOW  = "\u001B[33m";
    public static final String BLUE    = "\u001B[34m";
    public static final String BOLD    = "\u001B[1m";

    // --- ANSI BRIGHT COLORS ---
    public static final String BRIGHT_BLACK   = "\u001B[90m";
    public static final String BRIGHT_RED     = "\u001B[91m";
    public static final String BRIGHT_GREEN   = "\u001B[92m";
    public static final String BRIGHT_YELLOW  = "\u001B[93m";
    public static final String BRIGHT_BLUE    = "\u001B[94m";
    public static final String BRIGHT_MAGENTA = "\u001B[95m";
    public static final String BRIGHT_CYAN    = "\u001B[96m";
    public static final String BRIGHT_WHITE   = "\u001B[97m";

    // --- BORDER CHARACTERS ---
    public static final String TL = WHITE + BOLD + "╔"+ RESET;
    public static final String TR = WHITE + BOLD + "╗"+ RESET;
    public static final String BL = WHITE + BOLD + "╚"+ RESET;
    public static final String BR = WHITE + BOLD + "╝"+ RESET;
    public static final String ML = "╠"; // middle-left
    public static final String MR = "╣"; // middle-right
    public static final String H  = "═"; // RULE: Don't put colors on repeated thing
    public static final String WALL = WHITE + BOLD + "║" + RESET;
    // --- BORDER WIDTH ---
    public static final int WIDTH = 40;
    public static final int OUTPUTWIDTH = 60;

    // --- TEST --- add main to test again
    //System.out.println(WHITE + BOLD + TL + H.repeat(WIDTH) + TR + RESET);
    //System.out.println(WHITE + BOLD + V  + RESET + CYAN + "  » View Balance" + RESET);
    //System.out.println(WHITE + BOLD + V  + RESET + GREEN + "  + Deposit $500" + RESET);
    //System.out.println(WHITE + BOLD + V  + RESET + RED + "  - Payment $200" + RESET);
    //System.out.println(WHITE + BOLD + V  + RESET + MAGENTA + "  ← Go Back" + RESET);
    //System.out.println(WHITE + BOLD + BL + H.repeat(WIDTH) + BR + RESET);

}
