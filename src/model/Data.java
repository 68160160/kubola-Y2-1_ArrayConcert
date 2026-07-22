package model;

public class Data {

    // =========================
    // Concert Information
    // =========================

    public static String[] concertName = {
            "matori ONE-MAN LIVE TOUR",
            "Bluish Blossom Fan Fest 2026",
            "4 Elements Infinite Bonds",
            "LAST SEASON",
            "LINGORM HER & HERS"
    };

    public static String[] artistName = {
            "matori",
            "Bluish Blossom",
            "4 Elements",
            "LAST SEASON",
            "LINGORM"
    };

    public static String[] venue = {
            "UOB Live @ EMSPHERE",
            "BITEC Live",
            "Union Hall",
            "Centerpoint Studio",
            "IMPACT Arena"
    };

    // =========================
    // Show Date
    // =========================

    public static String[][] showDate = {

            {"28 July 2026"},

            {"13 June 2026", "14 June 2026"},

            {"12 September 2026"},

            {"28 December 2026"},

            {"8 November 2026", "9 November 2026"}

    };

    // =========================
    // Show Time
    // =========================

    public static String[][] showTime = {

            {"18:00"},

            {"17:00", "18:00"},

            {"12:00"},

            {"13:00"},

            {"16:00", "16:00"}

    };

    // =========================
    // Poster Image
    // (แก้ชื่อไฟล์ให้ตรงกับของคุณ)
    // =========================

    public static String[] poster = {

            "Img/natori.jpg",
            "Img/BBS_Con.jpg",
            "Img/4Elements.jpg",
            "Img/LastSeason.jpg",
            "Img/lingorm.jpg"

    };

    // =========================
    // Zone Price
    // =========================

    public static final int VIP_PRICE = 6500;
    public static final int A_PRICE = 4500;
    public static final int B_PRICE = 3000;
    public static final int C_PRICE = 2000;

    // =========================
    // Remaining Seats
    // =========================

    public static int vipRemain = 20;
    public static int aRemain = 50;
    public static int bRemain = 80;
    public static int cRemain = 120;

}