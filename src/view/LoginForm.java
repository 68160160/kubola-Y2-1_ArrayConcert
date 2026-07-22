package view;

import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class LoginForm extends JFrame {

    // ---------- Component ----------
    private JLabel titleLabel;

    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel birthLabel;

    private JTextField firstNameField;
    private JTextField lastNameField;

    private JComboBox<Integer> dayBox;
    private JComboBox<String> monthBox;
    private JComboBox<Integer> yearBox;

    private JButton loginButton;


    // ---------- Constructor ----------
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
    // ---------- GUI ----------
    private void createComponent(){

        titleLabel = new JLabel("CONCERT TICKET BOOKING");
        titleLabel.setBounds(170,40,500,40);
        titleLabel.setFont(new Font("Arial",Font.BOLD,28));
        add(titleLabel);


        // ---------- First Name ----------
        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(180,130,150,25);
        firstNameLabel.setFont(new Font("Arial",Font.PLAIN,18));
        add(firstNameLabel);


        firstNameField = new JTextField();
        firstNameField.setBounds(180,160,420,35);
        firstNameField.setFont(new Font("Arial",Font.PLAIN,18));
        add(firstNameField);



        // ---------- Last Name ----------
        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(180,220,150,25);
        lastNameLabel.setFont(new Font("Arial",Font.PLAIN,18));
        add(lastNameLabel);


        lastNameField = new JTextField();
        lastNameField.setBounds(180,250,420,35);
        lastNameField.setFont(new Font("Arial",Font.PLAIN,18));
        add(lastNameField);



        // ---------- Birth Date ----------
        birthLabel = new JLabel("Date of Birth");
        birthLabel.setBounds(180,310,150,25);
        birthLabel.setFont(new Font("Arial",Font.PLAIN,18));
        add(birthLabel);



        // Day
        Integer[] days = new Integer[31];

        for(int i = 0; i < 31; i++){
            days[i] = i + 1;
        }

        dayBox = new JComboBox<>(days);
        dayBox.setBounds(180,340,80,35);
        add(dayBox);



        // Month
        String[] months = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };


        monthBox = new JComboBox<>(months);
        monthBox.setBounds(280,340,150,35);
        add(monthBox);



        // Year
        Integer[] years = new Integer[80];

        int index = 0;

        for(int y = 2025; y >= 1946; y--){
            years[index] = y;
            index++;
        }


        yearBox = new JComboBox<>(years);
        yearBox.setBounds(450,340,150,35);
        add(yearBox);



        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBounds(300,430,180,45);
        loginButton.setFont(new Font("Arial",Font.BOLD,18));
        add(loginButton);

    }
    // ---------- Event ----------
    private void registerEvent(){

        loginButton.addActionListener(e -> login());

    }
    // ---------- Login ----------
    private void login(){

        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();


        if(firstName.isEmpty() || lastName.isEmpty()){

            JOptionPane.showMessageDialog(this,
                    "Please enter your name.");

            return;
        }



        int day = (Integer) dayBox.getSelectedItem();
        int month = monthBox.getSelectedIndex() + 1;
        int year = (Integer) yearBox.getSelectedItem();



        int age = calculateAge(day, month, year);



        if(age < 15){

            JOptionPane.showMessageDialog(this,
                    "This concert is restricted to age 15+");

            return;
        }



        Customer customer = new Customer();

        customer.setFullName(firstName + " " + lastName);
        customer.setAge(age);



        JOptionPane.showMessageDialog(this,
                "Welcome " + customer.getFullName());



        new ConcertForm(customer);

        dispose();

    }



    // ---------- Calculate Age ----------
    private int calculateAge(int day, int month, int year){

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();


        int age = today.getYear() - birthDate.getYear();


        if(today.getMonthValue() < birthDate.getMonthValue()
                ||
                (today.getMonthValue() == birthDate.getMonthValue()
                        && today.getDayOfMonth() < birthDate.getDayOfMonth())){

            age--;

        }


        return age;

    }

}
