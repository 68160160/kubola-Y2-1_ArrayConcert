package view;

import model.Customer;

import javax.swing.*;
import java.awt.*;

public class DetailForm extends JFrame {

    // ---------------- Data ----------------
    private Customer customer;
    private int concertIndex;

    // ---------------- Concert Data ----------------

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

    private String[][] concertDate = {

            {"Tue 28 July 2026   18:00"},

            {
                    "Sat 13 June 2026   17:00",
                    "Sun 14 June 2026   18:00"
            },

            {"Sat 12 September 2026   12:00"},

            {"Sun 28 December 2026   13:00"},

            {
                    "Sat 8 November 2026   16:00",
                    "Sun 9 November 2026   16:00"
            }

    };

    // ---------------- Component ----------------
    private JLabel titleLabel;
    private JLabel posterLabel;
    private JLabel concertNameLabel;
    private JLabel placeLabel;
    private JLabel dateLabel;

    private JRadioButton show1;
    private JRadioButton show2;

    private ButtonGroup group;

    private JButton nextButton;

    // ---------------- Constructor ----------------
    public DetailForm(Customer customer, int concertIndex){

        this.customer = customer;
        this.concertIndex = concertIndex;

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

    // ---------------- GUI ----------------
    private void createComponent(){

        // 1. Title (จัดกึ่งกลาง)
        titleLabel = new JLabel("CONCERT INFORMATION", SwingConstants.CENTER);
        titleLabel.setBounds(0, 20, 684, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        add(titleLabel);

        // 2. Poster Image (ฝั่งซ้าย)
        ImageIcon icon = new ImageIcon(imagePath[concertIndex]);

        Image img = icon.getImage().getScaledInstance(
                230,
                300,
                Image.SCALE_SMOOTH
        );

        posterLabel = new JLabel(new ImageIcon(img));
        posterLabel.setBounds(45, 80, 230, 300);
        posterLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        add(posterLabel);

        // 3. Concert Name (ใช้ HTML ป้องกันตัวอักษรล้น)
        concertNameLabel = new JLabel("<html><body style='width: 280px;'>"
                + concertName[concertIndex]
                + "</body></html>");
        concertNameLabel.setBounds(310, 80, 340, 50);
        concertNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(concertNameLabel);

        // 4. Venue (ใช้ HTML เพื่อตัดขึ้นบรรทัดใหม่อัตโนมัติหากชื่อสถานที่ยาว)
        placeLabel = new JLabel("<html><body style='width: 280px;'><b>Venue :</b> "
                + concertPlace[concertIndex]
                + "</body></html>");
        placeLabel.setBounds(310, 135, 340, 45);
        placeLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
        add(placeLabel);

        // 5. Select Show Header
        dateLabel = new JLabel("Select Show Date");
        dateLabel.setBounds(310, 190, 200, 30);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 17));
        add(dateLabel);

        // 6. Radio Buttons (รอบการแสดง)
        group = new ButtonGroup();

        if (concertDate[concertIndex].length > 1) {
            // กรณีมี 2 รอบ
            show1 = new JRadioButton("รอบที่ 1  " + concertDate[concertIndex][0]);
            show1.setBounds(310, 225, 340, 30);
            show1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            show1.setBackground(Color.WHITE);
            show1.setSelected(true); // เลือกให้อัตโนมัติ

            show2 = new JRadioButton("รอบที่ 2  " + concertDate[concertIndex][1]);
            show2.setBounds(310, 260, 340, 30);
            show2.setFont(new Font("Tahoma", Font.PLAIN, 14));
            show2.setBackground(Color.WHITE);

            group.add(show1);
            group.add(show2);
            add(show1);
            add(show2);
        } else {
            // กรณีมีรอบเดียว
            show1 = new JRadioButton("รอบที่ 1  " + concertDate[concertIndex][0]);
            show1.setBounds(310, 225, 340, 30);
            show1.setFont(new Font("Tahoma", Font.PLAIN, 14));
            show1.setBackground(Color.WHITE);
            show1.setSelected(true); // เลือกให้อัตโนมัติ

            group.add(show1);
            add(show1);
        }

        // 7. ส่วนหมายเหตุ (Notes Section) ตามข้อกำหนดในโจทย์
        JLabel noteTitle = new JLabel("หมายเหตุ :");
        noteTitle.setBounds(45, 400, 200, 25);
        noteTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(noteTitle);

        JLabel note1 = new JLabel("• ผู้ใช้งานต้องมีอายุ 15 ปีขึ้นไป");
        note1.setBounds(55, 430, 400, 22);
        note1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        note1.setForeground(Color.DARK_GRAY);
        add(note1);

        JLabel note2 = new JLabel("• ระบบจำลองการซื้อบัตร 1 รายการต่อการใช้งานโปรแกรม");
        note2.setBounds(55, 455, 400, 22);
        note2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        note2.setForeground(Color.DARK_GRAY);
        add(note2);

        JLabel note3 = new JLabel("• ระบบจะสุ่มหมายเลขที่นั่งหลังจากเลือกโซน");
        note3.setBounds(55, 480, 400, 22);
        note3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        note3.setForeground(Color.DARK_GRAY);
        add(note3);

        // 8. Next Button (จัดไว้มุมขวาล่าง)
        nextButton = new JButton("Next");
        nextButton.setBounds(510, 520, 130, 42);
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        add(nextButton);

    }

    // ---------------- Event ----------------
    private void registerEvent(){
        nextButton.addActionListener(e -> {

            String selectedDate = "";

            if (show1 != null && show1.isSelected()){
                // ดึงเฉพาะส่วนวันที่ (ตัดคำว่า "รอบที่ X  " ออกเพื่อส่งต่อไปหน้า SeatForm)
                selectedDate = show1.getText().replace("รอบที่ 1  ", "").trim();
            } else if (show2 != null && show2.isSelected()){
                selectedDate = show2.getText().replace("รอบที่ 2  ", "").trim();
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Please select a show date."
                );
                return;
            }

            new SeatForm(
                    customer,
                    concertIndex,
                    selectedDate
            );

            dispose();

        });

    }

}