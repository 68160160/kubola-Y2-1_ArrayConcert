package view;

import model.Customer;
import javax.swing.*;
import java.awt.*;

/**
 * Class TicketForm
 * หน้าที่: หน้าจอบัตรคอนเสิร์ต (Ticket) สรุปรายละเอียดการจอง และแสดง QR Code
 */
public class TicketForm extends JFrame {

    private Customer customer;
    private int concertIndex;
    private String showDate;
    private String zone;
    private String seatNumber;
    private int price;

    // [Array 1 มิติ] อ้างอิงชื่อและสถานที่จัดแสดงจาก Index
    private String[] concertName = {
            "Natori ONE-MAN LIVE TOUR",
            "Blush Blossom Fan Fest 2026",
            "4 Elements Infinite Bonds",
            "LAST SEASON",
            "LINGORM HER & HERS"
    };

    private String[] concertPlace = {
            "UOB Live @ EMSPHERE, Bangkok",
            "BITEC LIVE, Bangkok",
            "Union Hall, Bangkok",
            "Centerpoint Studio, Bangkok",
            "IMPACT Arena, Bangkok"
    };

    private JLabel titleLabel;
    private JPanel ticketPanel;
    private JLabel customerLabel, concertLabel, placeLabel, dateLabel, zoneLabel, seatLabel, priceLabel, qrLabel;
    private JButton finishButton;

    public TicketForm(Customer customer, int concertIndex, String showDate, String zone, String seatNumber, int price) {
        this.customer = customer;
        this.concertIndex = concertIndex;
        this.showDate = showDate;
        this.zone = zone;
        this.seatNumber = seatNumber;
        this.price = price;

        setTitle("Concert Ticket");
        setSize(650, 660);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        createComponent();
        registerEvent();  
        setVisible(true); 
    }

    private void createComponent() {
        titleLabel = new JLabel("CONCERT TICKET", SwingConstants.CENTER);
        titleLabel.setBounds(0, 20, 634, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        add(titleLabel);

        // กรอบการ์ดตั๋วคอนเสิร์ต
        ticketPanel = new JPanel();
        ticketPanel.setLayout(null);
        ticketPanel.setBounds(37, 75, 560, 430);
        ticketPanel.setBackground(Color.WHITE);
        ticketPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(ticketPanel);

        // แสดงชื่อลูกค้า
        customerLabel = new JLabel("Customer: " + customer.getFullName());
        customerLabel.setBounds(30, 25, 480, 30);
        customerLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        ticketPanel.add(customerLabel);

        // แสดงชื่อคอนเสิร์ต โดยดึงจาก Array ตาม concertIndex
        concertLabel = new JLabel("Concert: " + concertName[concertIndex]);
        concertLabel.setBounds(30, 70, 480, 30);
        concertLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        ticketPanel.add(concertLabel);

        // แสดงสถานที่จัดแสดง
        placeLabel = new JLabel("Venue: " + concertPlace[concertIndex]);
        placeLabel.setBounds(30, 115, 480, 30);
        placeLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        ticketPanel.add(placeLabel);

        // แสดงวันเวลาที่เลือก
        dateLabel = new JLabel("Show : " + showDate);
        dateLabel.setBounds(30, 160, 480, 30);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        ticketPanel.add(dateLabel);

        // แสดงโซน
        zoneLabel = new JLabel("Zone : " + zone);
        zoneLabel.setBounds(30, 205, 300, 30);
        zoneLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        ticketPanel.add(zoneLabel);

        // แสดงหมายเลขที่นั่ง
        seatLabel = new JLabel("Seat: " + seatNumber);
        seatLabel.setBounds(30, 250, 300, 30);
        seatLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        ticketPanel.add(seatLabel);

        // แสดงราคาบัตร
        priceLabel = new JLabel("Price: " + price + " THB");
        priceLabel.setBounds(30, 320, 300, 35);
        priceLabel.setFont(new Font("Arial", Font.BOLD, 22));
        ticketPanel.add(priceLabel);

        // แสดง QR Code
        ImageIcon qrIcon = new ImageIcon("src/Img/QR.png");
        Image qrImage = qrIcon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        qrLabel = new JLabel(new ImageIcon(qrImage));
        qrLabel.setBounds(380, 210, 130, 130);
        ticketPanel.add(qrLabel);

        // ปุ่ม Finish
        finishButton = new JButton("Finish");
        finishButton.setBounds(227, 530, 180, 45);
        finishButton.setFont(new Font("Arial", Font.BOLD, 18));
        add(finishButton);
    }

    private void registerEvent() {
        finishButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Thank you for your purchase!\n\nEnjoy the concert.");
            System.exit(0);
        });
    }
}