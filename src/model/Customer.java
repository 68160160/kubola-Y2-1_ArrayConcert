package model;
/**
 * Class Customer[cite: 2]
 * หน้าที่: เป็น Model สำหรับเก็บข้อมูลส่วนตัวของลูกค้าที่เข้าใช้งานระบบ
 */
public class Customer {

    private String fullName;    // เก็บชื่อ-นามสกุล
    private int age;            // เก็บอายุที่คำนวณได้

    // Constructor แบบไม่รับพารามิเตอร์
    public Customer() {

    }

    // Constructor แบบรับข้อมูลเริ่มต้น
    public Customer(String fullName, int age) {

        this.fullName = fullName;
        this.age = age;

    }

    // Getter & Setter สำหรับจัดการข้อมูล
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}