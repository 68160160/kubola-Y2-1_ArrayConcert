package view;

import model.Customer;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

/**
 * Class LoginForm
 * หน้าที่: รับข้อมูลชื่อ นามสกุล และวันเกิด เพื่อคำนวณอายุและตรวจสอบเงื่อนไข 15+ ปี
 */
public class LoginForm extends JFrame {

    private JLabel titleLabel, firstNameLabel, lastNameLabel, birthLabel;
    private JTextField firstNameField, lastNameField;

    // JComboBox ที่สร้างจาก Array ข้อมูลวันที่ เดือน ปี
    private JComboBox<Integer> dayBox;
    private JComboBox<String> monthBox;
    private JComboBox<Integer> yearBox;
    private JButton loginButton;

    public LoginForm() {
        setTitle("Concert Ticket Booking");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        createComponent();
        registerEvent();  
        setVisible(true); 
    }

    private void createComponent() {
        titleLabel = new JLabel("CONCERT TICKET BOOKING");
        titleLabel.setBounds(170, 40, 500, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        add(titleLabel);

        // --- ส่วนรับชื่อ ---
        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(180, 130, 150, 25);
        firstNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(180, 160, 420, 35);
        firstNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        add(firstNameField);

        // --- ส่วนรับนามสกุล ---
        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(180, 220, 150, 25);
        lastNameLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(180, 250, 420, 35);
        lastNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        add(lastNameField);

        // --- ส่วนเลือกวันเกิด (สาธิตการสร้าง Dynamic Array) ---
        birthLabel = new JLabel("Date of Birth");
        birthLabel.setBounds(180, 310, 150, 25);
        birthLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        add(birthLabel);

        // [ตัวอย่างการใช้ Array 1 มิติ] สร้าง Array เก็บตัวเลข 1-31 ด้วย For Loop
        Integer[] days = new Integer[31]; // ประกาศ Array ขนาด 31 ช่อง
        for (int i = 0; i < 31; i++) {
            days[i] = i + 1; // นำค่า 1 ถึง 31 ใส่ลงใน Array ตาม Index
        }
        dayBox = new JComboBox<>(days); // ส่ง Array เข้า JComboBox
        dayBox.setBounds(180, 340, 80, 35);
        add(dayBox);

        // [ตัวอย่างการใช้ Array 1 มิติ] สร้าง Array เก็บชื่อเดือนทั้ง 12 เดือน
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        monthBox = new JComboBox<>(months);
        monthBox.setBounds(280, 340, 150, 35);
        add(monthBox);

        // [ตัวอย่างการใช้ Array 1 มิติ] สร้าง Array เก็บปี ค.ศ. ถอยหลัง (2025 ถึง 1946)
        Integer[] years = new Integer[80]; // Array ขนาด 80 ช่อง
        int index = 0;
        for (int y = 2025; y >= 1946; y--) {
            years[index] = y; // ใส่ปีลงใน Array ตามตำแหน่ง Index
            index++;
        }
        yearBox = new JComboBox<>(years);
        yearBox.setBounds(450, 340, 150, 35);
        add(yearBox);

        // ปุ่ม Login
        loginButton = new JButton("Login");
        loginButton.setBounds(300, 430, 180, 45);
        loginButton.setFont(new Font("Arial", Font.BOLD, 18));
        add(loginButton);
    }

    private void registerEvent() {
        loginButton.addActionListener(e -> login());
    }

    private void login() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();  

        if (firstName.isEmpty() || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name.");
            return;
        }

        // ดึงข้อมูลจาก JComboBox
        int day = (Integer) dayBox.getSelectedItem();
        int month = monthBox.getSelectedIndex() + 1; // +1 เพราะ Index เริ่มจาก 0
        int year = (Integer) yearBox.getSelectedItem();

        // คำนวณอายุ
        int age = calculateAge(day, month, year);

        // เงื่อนไขตรวจสอบอายุตามโจทย์ (ต้องอายุ 15 ปีขึ้นไป)
        if (age < 15) {
            JOptionPane.showMessageDialog(this, "This concert is restricted to age 15+");
            return;
        }

        // หากผ่านเงื่อนไข ให้สร้าง Object Customer แล้วไปยังหน้าเลือกคอนเสิร์ต
        Customer customer = new Customer();
        customer.setFullName(firstName + " " + lastName);
        customer.setAge(age);

        JOptionPane.showMessageDialog(this, "Welcome " + customer.getFullName());
        new ConcertForm(customer); // เปิดหน้า ConcertForm
        dispose(); // ปิดหน้าต่างปัจจุบัน
    }

    // ฟังก์ชันคำนวณอายุจริงจากวันเกิด
    private int calculateAge(int day, int month, int year) {
        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        int age = today.getYear() - birthDate.getYear();

        // หากยังไม่ถึงวันเกิดของปีปัจจุบัน ให้ลบอายุออก 1 ปี
        if (today.getMonthValue() < birthDate.getMonthValue() ||
                (today.getMonthValue() == birthDate.getMonthValue() && today.getDayOfMonth() < birthDate.getDayOfMonth())) {
            age--;
        }
        return age;
    }
}