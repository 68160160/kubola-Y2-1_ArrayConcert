package view;

import model.Customer;
import javax.swing.*;
import java.awt.*;

/**
 * Class SeatForm
 * หน้าที่: เลือกระบุโซนที่นั่ง และสุ่มหมายเลขที่นั่ง
 */
public class SeatForm extends JFrame {

    private Customer customer;
    private int concertIndex;
    private String showDate;

    private JLabel titleLabel, zoneLabel, mapLabel;
    private JComboBox<String> zoneBox;
    private JButton confirmButton;
    private String seatNumber;
    private int ticketPrice;

    public SeatForm(Customer customer, int concertIndex, String showDate) {
        this.customer = customer;
        this.concertIndex = concertIndex;
        this.showDate = showDate;

        setTitle("Seat Selection");
        setSize(600, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        createComponent();
        registerEvent();  
        setVisible(true); 
    }

    private void createComponent() {
        titleLabel = new JLabel("SELECT SEAT", SwingConstants.CENTER);
        titleLabel.setBounds(0, 20, 584, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        add(titleLabel);

        // แสดงรูปผังคอนเสิร์ต
        ImageIcon icon = new ImageIcon("src/Img/Stage.png");
        Image img = icon.getImage().getScaledInstance(420, 250, Image.SCALE_SMOOTH);
        mapLabel = new JLabel(new ImageIcon(img));
        mapLabel.setBounds(82, 70, 420, 250);
        add(mapLabel);

        zoneLabel = new JLabel("Select Zone", SwingConstants.CENTER);
        zoneLabel.setBounds(0, 335, 584, 30);
        zoneLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(zoneLabel);

        // [Array 1 มิติ] รายการโซนและราคาสำหรับใส่ใน JComboBox
        String[] zone = {
                "VIP (20 Seats) - 5500 THB",
                "A (40 Seats) - 4500 THB",
                "B (60 Seats) - 3500 THB",
                "C (80 Seats) - 2500 THB"
        };

        zoneBox = new JComboBox<>(zone);
        zoneBox.setBounds(152, 375, 280, 35);
        zoneBox.setFont(new Font("Arial", Font.PLAIN, 16));
        add(zoneBox);

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(212, 430, 160, 42);
        confirmButton.setFont(new Font("Arial", Font.BOLD, 18));
        add(confirmButton);
    }

    private void registerEvent() {
        confirmButton.addActionListener(e -> {
            String selectedZone = (String) zoneBox.getSelectedItem();
            String zoneName = selectedZone.split(" ")[0]; // ตัดเอาเฉพาะชื่อโซน เช่น "VIP"

            // สุ่มหมายเลขที่นั่ง
            seatNumber = randomSeat(zoneName);

            // ตรวจสอบราคาตามโซนที่เลือก
            switch (zoneName) {
                case "VIP":
                    ticketPrice = 5500;
                    break;
                case "A":
                    ticketPrice = 4500;
                    break;
                case "B":
                    ticketPrice = 3500;
                    break;
                default:
                    ticketPrice = 2500;
                    break;
            }

            // เปิดหน้าออกตั๋ว TicketForm
            new TicketForm(customer, concertIndex, showDate, zoneName, seatNumber, ticketPrice);
            dispose();
        });
    }

    // ฟังก์ชันสุ่มหมายเลขที่นั่งในช่วง 1 - 20
    private String randomSeat(String zone) {
        int number = (int) (Math.random() * 20) + 1;
        return zone + "-" + String.format("%02d", number);
    }
}