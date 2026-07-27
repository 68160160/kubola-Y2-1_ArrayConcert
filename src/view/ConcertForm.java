package view;

import model.Customer;
import javax.swing.*;
import java.awt.*;

/**
 * Class ConcertForm
 * หน้าที่: แสดงรายการคอนเสิร์ตทั้งหมดให้เลือก โดยใช้ Array ในการวนลูปสร้าง GUI Component แบบอัตโนมัติ
 */
public class ConcertForm extends JFrame {

    private Customer customer;
    private JLabel titleLabel;

    // [ตัวอย่างการใช้ Object Array] ประกาศ Array ของ Swing Component
    private JButton[] posterButton = new JButton[5]; // เก็บปุ่มรูปภาพ 5 ปุ่ม
    private JLabel[] concertLabel = new JLabel[5];   // เก็บ Label ชื่อคอนเสิร์ต 5 อัน

    // [Array 1 มิติ] ข้อมูลชื่อและ Path รูปภาพสำหรับหน้าจอนี้
    private String[] concertName = {
            "Natori ONE-MAN<br>LIVE TOUR",
            "Blush Blossom<br>Fan Fest 2026",
            "4 Elements<br>Infinite Bonds",
            "LAST SEASON",
            "LINGORM<br>HER & HERS"
    };

    private String[] imagePath = {
            "src/Img/Natori.jpg",
            "src/Img/BBS_Con.jpg",
            "src/Img/4Elements.jpg",
            "src/Img/LastSeason.jpg",
            "src/Img/lingorm.jpg"
    };

    public ConcertForm(Customer customer) {
        this.customer = customer;
        setTitle("Select Concert");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        createComponent();
        registerEvent();  
        setVisible(true); 
    }

    private void createComponent() {
        titleLabel = new JLabel("SELECT CONCERT", SwingConstants.CENTER);
        titleLabel.setBounds(0, 20, 884, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        add(titleLabel);

        int startX = 31;
        int gap = 18;

        // [จุดเน้นในการนำเสนอ] การใช้วงลูป For เข้าถึง Array เพื่อสร้างปุ่มคอนเสิร์ตแบบไดนามิก
        for (int i = 0; i < 5; i++) {
            int posX = startX + i * (150 + gap); // คำนวณตำแหน่ง X ของแต่ละคอนเสิร์ต

            // ดึง Path รูปจาก Array ตาม Index i
            ImageIcon icon = new ImageIcon(imagePath[i]);
            Image img = icon.getImage().getScaledInstance(150, 220, Image.SCALE_SMOOTH);

            // สร้าง Object JButton เก็บไว้ใน Array posterButton[i]
            posterButton[i] = new JButton(new ImageIcon(img));
            posterButton[i].setBounds(posX, 75, 150, 220);
            posterButton[i].setBorderPainted(false);
            posterButton[i].setContentAreaFilled(false);
            posterButton[i].setFocusPainted(false);
            posterButton[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            add(posterButton[i]);

            // สร้าง Object JLabel เก็บไว้ใน Array concertLabel[i]
            concertLabel[i] = new JLabel(
                    "<html><center>" + concertName[i] + "</center></html>",
                    SwingConstants.CENTER
            );
            concertLabel[i].setBounds(posX - 10, 302, 170, 50);
            concertLabel[i].setFont(new Font("Arial", Font.BOLD, 13));
            add(concertLabel[i]);
        }
    }

    private void registerEvent() {
        // วนลูปเพื่อผูก Event Listener ให้กับปุ่มทั้ง 5 ปุ่มใน Array
        for (int i = 0; i < 5; i++) {
            int index = i; // บันทึก Index ปัจจุบันไว้ใช้ใน Lambda Expression
            posterButton[i].addActionListener(e -> {
                // ส่ง index คอนเสิร์ตที่ถูกเลือกไปยังหน้า DetailForm
                new DetailForm(customer, index);
                dispose();
            });
        }
    }
}