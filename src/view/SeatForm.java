package view;

import model.Customer;

import javax.swing.*;
import java.awt.*;

public class SeatForm extends JFrame {

    private Customer customer;
    private int concertIndex;
    private String showDate;

    // Component
    private JLabel titleLabel;
    private JLabel zoneLabel;

    private JLabel mapLabel;

    private JComboBox<String> zoneBox;

    private JButton confirmButton;
    private String seatNumber;
    private int ticketPrice;

    public SeatForm(Customer customer, int concertIndex, String showDate) {

        this.customer = customer;
        this.concertIndex = concertIndex;
        this.showDate = showDate;

        setTitle("Seat Selection");
        // ปรับขนาดหน้าต่างให้พอดีเนื้อหา
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

        // หัวข้อเรื่อง จัดกึ่งกลางหน้าต่าง
        titleLabel = new JLabel("SELECT SEAT", SwingConstants.CENTER);
        titleLabel.setBounds(0, 20, 584, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        add(titleLabel);

        // รูปผังที่นั่ง
        ImageIcon icon = new ImageIcon("src/Img/Stage.png");
        Image img = icon.getImage().getScaledInstance(
                420,
                250,
                Image.SCALE_SMOOTH
        );

        // จัดวางรูปภาพไว้ตรงกลาง (584 - 420) / 2 = 82
        mapLabel = new JLabel(new ImageIcon(img));
        mapLabel.setBounds(82, 70, 420, 250);
        add(mapLabel);

        // ข้อความ Select Zone (จัดกึ่งกลาง)
        zoneLabel = new JLabel("Select Zone", SwingConstants.CENTER);
        zoneLabel.setBounds(0, 335, 584, 30);
        zoneLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(zoneLabel);

        String[] zone = {
                "VIP (20 Seats) - 5500 THB",
                "A (40 Seats) - 4500 THB",
                "B (60 Seats) - 3500 THB",
                "C (80 Seats) - 2500 THB"
        };

        // กล่องเลือกโซน จัดกึ่งกลาง (584 - 280) / 2 = 152
        zoneBox = new JComboBox<>(zone);
        zoneBox.setBounds(152, 375, 280, 35);
        zoneBox.setFont(new Font("Arial", Font.PLAIN, 16));
        add(zoneBox);

        // ปุ่ม Confirm จัดกึ่งกลาง (584 - 160) / 2 = 212
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(212, 430, 160, 42);
        confirmButton.setFont(new Font("Arial", Font.BOLD, 18));
        add(confirmButton);

    }

    private void registerEvent() {

        confirmButton.addActionListener(e -> {

            String selectedZone = (String) zoneBox.getSelectedItem();

            String zone = selectedZone.split(" ")[0];

            seatNumber = randomSeat(zone);

            switch (zone) {

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

            }

            new TicketForm(
                    customer,
                    concertIndex,
                    showDate,
                    zone,
                    seatNumber,
                    ticketPrice
            );

            dispose();

        });

    }

    private String randomSeat(String zone) {

        int number = (int) (Math.random() * 20) + 1;

        return zone + "-" + String.format("%02d", number);

    }
}