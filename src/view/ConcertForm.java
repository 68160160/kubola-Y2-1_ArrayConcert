package view;

import model.Customer;

import javax.swing.*;
import java.awt.*;

public class ConcertForm extends JFrame {

    private Customer customer;

    // ---------- Component ----------
    private JLabel titleLabel;
    private JButton[] posterButton = new JButton[5];
    private JLabel[] concertLabel = new JLabel[5];

    // กำหนดจุดตัดขึ้นบรรทัดใหม่ด้วย <br> ตามที่ต้องการเป๊ะๆ
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

    // ---------- Constructor ----------
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

    // ---------- GUI ----------
    private void createComponent() {

        // หัวข้อเรื่อง
        titleLabel = new JLabel("SELECT CONCERT", SwingConstants.CENTER);
        titleLabel.setBounds(0, 20, 884, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        add(titleLabel);

        int startX = 31;
        int gap = 18;

        for (int i = 0; i < 5; i++) {

            int posX = startX + i * (150 + gap);

            ImageIcon icon = new ImageIcon(imagePath[i]);
            Image img = icon.getImage().getScaledInstance(150, 220, Image.SCALE_SMOOTH);

            posterButton[i] = new JButton(new ImageIcon(img));
            posterButton[i].setBounds(posX, 75, 150, 220);
            posterButton[i].setBorderPainted(false);
            posterButton[i].setContentAreaFilled(false);
            posterButton[i].setFocusPainted(false);
            posterButton[i].setCursor(new Cursor(Cursor.HAND_CURSOR));

            add(posterButton[i]);

            // ใช้ <html><center>... เพื่อบังคับให้ข้อความขึ้นบรรทัดใหม่และจัดกึ่งกลางพอดี
            concertLabel[i] = new JLabel(
                    "<html><center>" + concertName[i] + "</center></html>",
                    SwingConstants.CENTER
            );
            // ขยายกล่องข้อความความกว้างเป็น 170px และความสูงเป็น 50px
            concertLabel[i].setBounds(posX - 10, 302, 170, 50);
            concertLabel[i].setFont(new Font("Arial", Font.BOLD, 13));

            add(concertLabel[i]);

        }

    }

    // ---------- Event ----------
    private void registerEvent() {

        for (int i = 0; i < 5; i++) {

            int index = i;

            posterButton[i].addActionListener(e -> {

                new DetailForm(customer, index);

                dispose();

            });

        }

    }

}