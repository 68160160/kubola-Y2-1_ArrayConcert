package model;

/**
 * Class Data[cite: 2]
 * หน้าที่: คลังข้อมูลกลางของระบบที่ใช้โครงสร้างข้อมูลแบบ Array เป็นหลักในการจัดเก็บข้อมูล[cite: 1, 2]
 */
public class Data {
    // ===================================================
    // [Array 1 มิติ] เก็บข้อมูลทั่วไปที่เป็นรายการเดี่ยว 5 คอนเสิร์ต[cite: 2]
    // Index 0 ถึง 4 จะตรงกับคอนเสิร์ตแต่ละงาน[cite: 2]
    // ===================================================

    // เก็บชื่อคอนเสิร์ตทั้ง 5 งาน[cite: 2]
    public static String[] concertName = {
            "Natori ONE-MAN LIVE TOUR",    // Index 0[cite: 2]
            "Blush Blossom Fan Fest 2026", // Index 1[cite: 2]
            "4 Elements Infinite Bonds",   // Index 2[cite: 2]
            "LAST SEASON",                 // Index 3[cite: 2]
            "LINGORM HER & HERS"           // Index 4[cite: 2]
    };

    // เก็บชื่อศิลปิน[cite: 2]
    public static String[] artistName = {
            "Natori", "Blush Blossom", "4 Elements", "LAST SEASON", "LINGORM"
    };

    // เก็บสถานที่จัดแสดง[cite: 2]
    public static String[] venue = {
            "UOB Live @ EMSPHERE",
            "BITEC Live",
            "Union Hall",
            "Centerpoint Studio",
            "IMPACT Arena"
    };

    // เก็บ Path ของรูปภาพโปสเตอร์[cite: 2]
    public static String[] poster = {
            "Img/natori.jpg",
            "Img/BBS_Con.jpg",
            "Img/4Elements.jpg",
            "Img/LastSeason.jpg",
            "Img/lingorm.jpg"
    };

    // ===================================================
    // [Array 2 มิติ] เก็บข้อมูลรอบการแสดงเนื่องจากบางคอนเสิร์ตมีหลายรอบ[cite: 2]
    // แถว (Row = concertIndex) / คอลัมน์ (Column = roundIndex)[cite: 2]
    // ===================================================

    // เก็บวันที่แสดง[cite: 2]
    public static String[][] showDate = {
            {"28 July 2026"},                   // Index 0: มี 1 รอบ[cite: 2]
            {"13 June 2026", "14 June 2026"},   // Index 1: มี 2 รอบ[cite: 2]
            {"12 September 2026"},              // Index 2: มี 1 รอบ[cite: 2]
            {"28 December 2026"},               // Index 3: มี 1 รอบ[cite: 2]
            {"8 November 2026", "9 November 2026"} // Index 4: มี 2 รอบ[cite: 2]
    };

    // เก็บเวลาแสดง[cite: 2]
    public static String[][] showTime = {
            {"18:00"},
            {"17:00", "18:00"},
            {"12:00"},
            {"13:00"},
            {"16:00", "16:00"}
    };

    // ราคาแต่ละโซน[cite: 2]
    public static final int VIP_PRICE = 6500;
    public static final int A_PRICE = 4500;
    public static final int B_PRICE = 3000;
    public static final int C_PRICE = 2000;

    // จำนวนที่นั่งคงเหลือแต่ละโซน[cite: 2]
    public static int vipRemain = 20;
    public static int aRemain = 50;
    public static int bRemain = 80;
    public static int cRemain = 120;
}