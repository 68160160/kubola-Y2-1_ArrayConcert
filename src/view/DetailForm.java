package view;

import model.Customer;
import javax.swing.*;
import java.awt.*;

/**
 * Class DetailForm
 * หน้าที่: แสดงรายละเอียดของคอนเสิร์ตที่เลือก โดยใช้อ้างอิงตำแหน่งด้วย concertIndex จาก Array
 */
public class DetailForm extends JFrame {

    private Customer customer;
    private int concertIndex; // Index ระบุคอนเสิร์ตที่ผู้ใช้เลือก

    // [Array 1 มิติ] เก็บข้อมูลรายละเอียดของคอนเสิร์ต
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

    private String[] imagePath = {
            "src/Img/Natori.jpg",
            "src/Img/BBS_Con.jpg",
            "src/Img/4Elements.jpg",
            "src/Img/LastSeason.jpg",
            "src/Img/lingorm.jpg"
    };

    // [Array 2 มิติ] เก็บข้อมูลรอบการแสดง (คอนเสิร์ตบางงานมี 1 รอบ บางงานมี 2 รอบ)
    private String[][] concertDate = {
            {"Tue 28 July 2026 18:00"},                            // index 0
            {"Sat 13 June 2026 17:00", "Sun 14 June 2026 18:00"},  // index 1 (2 รอบ)
            {"Sat 12 September 2026 12:00"},                       // index 2
            {"Sun 28 December 2026 13:00"},                        // index 3
            {"Sat 8 November 2026 16:00", "Sun 9 November 2026 16:00"} // index 4 (2 รอบ)
    };

    private JLabel titleLabel, posterLabel, concertNameLabel, placeLabel, dateLabel;
    private JRadioButton show1, show2;
    private ButtonGroup group;
    private JButton nextButton;

    public DetailForm(Customer customer, int concertIndex) {
        this.customer = customer;
        this.concertIndex = concertIndex; // รับ Index คอนเสิร์ตที่ถูกคลิก

        setTitle("Concert Detail");
        setSize(700, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        createComponent();
        registerEvent();  
        setVisible(true); 
    }

    private void createComponent() {
        titleLabel = new JLabel("CONCERT INFORMATION", SwingConstants.CENTER);
        titleLabel.setBounds(0, 20, 684, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        add(titleLabel);

        // ดึงโปสเตอร์จาก Array โดยใช้อินเด็กซ์ imagePath[concertIndex]
        ImageIcon icon = new ImageIcon(imagePath[concertIndex]);
        Image img = icon.getImage().getScaledInstance(230, 300, Image.SCALE_SMOOTH);
        posterLabel = new JLabel(new ImageIcon(img));
        posterLabel.setBounds(45, 80, 230, 300);
        posterLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        add(posterLabel);

        // ดึงชื่อคอนเสิร์ตจาก Array concertName[concertIndex]
        concertNameLabel = new JLabel("<html><body style='width: 280px;'>"
                + concertName[concertIndex] + "</body></html>");
        concertNameLabel.setBounds(310, 80, 340, 50);
        concertNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(concertNameLabel);

        // ดึงสถานที่จัดงานจาก Array concertPlace[concertIndex]
        placeLabel = new JLabel("<html><body style='width: 280px;'><b>Venue :</b>"
                + concertPlace[concertIndex] + "</body></html>");
        placeLabel.setBounds(310, 135, 340, 45);
        placeLabel.setFont(new Font("Sans Serif", Font.PLAIN, 15));
        add(placeLabel);

        dateLabel = new JLabel("Select Show Date");
        dateLabel.setBounds(310, 190, 200, 30);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 17));
        add(dateLabel);

        group = new ButtonGroup();

        // [จุดเน้น] ตรวจสอบความยาวของ Array 2 มิติ (concertDate[concertIndex].length)
        // เพื่อเช็คว่าคอนเสิร์ตนี้มี 1 หรือ 2 รอบการแสดง
        if (concertDate[concertIndex].length > 1) {
            // กรณีมี 2 รอบการแสดง ดึงข้อมูล Array แถวที่ concertIndex คอลัมน์ที่ 0 และ 1
            show1 = new JRadioButton("รอบที่ 1 " + concertDate[concertIndex][0]);
            show1.setBounds(310, 225, 340, 30);
            show1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            show1.setBackground(Color.WHITE);
            show1.setSelected(true);

            show2 = new JRadioButton("รอบที่ 2 " + concertDate[concertIndex][1]);
            show2.setBounds(310, 260, 340, 30);
            show2.setFont(new Font("Tahoma", Font.PLAIN, 14));
            show2.setBackground(Color.WHITE);

            group.add(show1);
            group.add(show2);
            add(show1);
            add(show2);
        } else {
            // กรณีมีรอบเดียว
            show1 = new JRadioButton("รอบที่ 1 " + concertDate[concertIndex][0]);
            show1.setBounds(310, 225, 340, 30);
            show1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            show1.setBackground(Color.WHITE);
            show1.setSelected(true);

            group.add(show1);
            add(show1);
        }

        // --- ส่วนหมายเหตุตามข้อกำหนด ---
        JLabel noteTitle = new JLabel("หมายเหตุ :");
        noteTitle.setBounds(45, 400, 200, 25);
        noteTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(noteTitle);

        JLabel note1 = new JLabel(" ผู้ใช้งานต้องมีอายุ 15 ปีขึ้นไป");
        note1.setBounds(55, 430, 400, 22);
        note1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        note1.setForeground(Color.DARK_GRAY);
        add(note1);

        JLabel note2 = new JLabel(" ระบบจำลองการซื้อบัตร 1 รายการต่อการใช้งานโปรแกรม");
        note2.setBounds(55, 455, 400, 22);
        note2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        note2.setForeground(Color.DARK_GRAY);
        add(note2);

        JLabel note3 = new JLabel(" ระบบจะสุ่มหมายเลขที่นั่งหลังจากเลือกโซน");
        note3.setBounds(55, 480, 400, 22);
        note3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        note3.setForeground(Color.DARK_GRAY);
        add(note3);

        nextButton = new JButton("Next");
        nextButton.setBounds(510, 520, 130, 42);
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        add(nextButton);
    }

    private void registerEvent() {
        nextButton.addActionListener(e -> {
            String selectedDate = "";
            if (show1 != null && show1.isSelected()) {
                selectedDate = show1.getText().replace("รอบที่ 1 ", "").trim();
            } else if (show2 != null && show2.isSelected()) {
                selectedDate = show2.getText().replace("รอบที่ 2 ", "").trim();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a show date.");
                return;
            }

            // เปิดหน้าเลือกที่นั่ง SeatForm
            new SeatForm(customer, concertIndex, selectedDate);
            dispose();
        });
    }
}