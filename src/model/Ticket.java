package model;

public class Ticket {

    // ==========================================
    // 1. Instance Variables (ตัวแปรเก็บข้อมูลประจำตั๋ว)
    // ทุกตัวแปรเป็น private เพื่อป้องกันไม่ให้ภายนอกแก้ไขโดยตรง
    // ==========================================
    private String concertName; // เก็บชื่อคอนเสิร์ต
    private String concertDate; // เก็บวันที่แสดง
    private String concertTime; // เก็บเวลาที่แสดง
    private String venue;       // เก็บสถานที่จัดงาน

    private String zone;        // เก็บโซนที่นั่ง (เช่น VIP, A, B, C)
    private String seatNumber;  // เก็บหมายเลขที่นั่ง (เช่น VIP-05)

    private int price;          // เก็บราคาตั๋ว (ตัวเลขเต็ม)

    private String bookingID;   // เก็บหมายเลขการจอง/ไอดีตั๋ว

    // ==========================================
    // 2. Constructor (คอนสตรัคเตอร์)
    // ==========================================
    // Default Constructor: สำหรับสร้างวัตถุ (Object) ตั๋วแบบเปล่าๆ ขึ้นมาก่อน
    public Ticket() {

    }

    // ==========================================
    // 3. Getter and Setter Methods (เมธอดเข้าถึงและแก้ไขข้อมูล)
    // - Getter (get...): สำหรับดึงข้อมูลออกไปใช้งาน
    // - Setter (set...): สำหรับกำหนดหรือเปลี่ยนแปลงข้อมูล
    // ==========================================

    // ชื่อคอนเสิร์ต
    public String getConcertName() {
        return concertName; // ดึงชื่อคอนเสิร์ต
    }

    public void setConcertName(String concertName) {
        this.concertName = concertName; // บันทึก/แก้ไขชื่อคอนเสิร์ต
    }

    // วันที่แสดง
    public String getConcertDate() {
        return concertDate; // ดึงวันที่แสดง
    }

    public void setConcertDate(String concertDate) {
        this.concertDate = concertDate; // บันทึก/แก้ไขวันที่แสดง
    }

    // เวลาแสดง
    public String getConcertTime() {
        return concertTime; // ดึงเวลาแสดง
    }

    public void setConcertTime(String concertTime) {
        this.concertTime = concertTime; // บันทึก/แก้ไขเวลาแสดง
    }

    // สถานที่จัดงาน
    public String getVenue() {
        return venue; // ดึงสถานที่จัดงาน
    }

    public void setVenue(String venue) {
        this.venue = venue; // บันทึก/แก้ไขสถานที่จัดงาน
    }

    // โซนที่นั่ง
    public String getZone() {
        return zone; // ดึงชื่อโซน
    }

    public void setZone(String zone) {
        this.zone = zone; // บันทึก/แก้ไขชื่อโซน
    }

    // หมายเลขที่นั่ง
    public String getSeatNumber() {
        return seatNumber; // ดึงหมายเลขที่นั่ง
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber; // บันทึก/แก้ไขหมายเลขที่นั่ง
    }

    // ราคาตั๋ว
    public int getPrice() {
        return price; // ดึงราคาตั๋ว
    }

    public void setPrice(int price) {
        this.price = price; // บันทึก/แก้ไขราคาตั๋ว
    }

    // รหัสการจอง
    public String getBookingID() {
        return bookingID; // ดึงรหัสการจอง
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID; // บันทึก/แก้ไขรหัสการจอง
    }

}