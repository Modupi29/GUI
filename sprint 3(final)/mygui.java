package HOPE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class mygui extends JFrame {
    private static List<User> users = new ArrayList<>();
    private static JLabel nameLabel;
    private static JTextField nameText;
    private static JLabel surnameLabel;
    private static JTextField surnameText;
    private static JLabel studentNumberLabel;
    private static JTextField studentNumberText;
    private static JLabel contactsLabel;
    private static JTextField contactsText;
    private static JLabel emailLabel;
    private static JTextField emailText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JLabel loginLabel;
    private static JTextField loginText;
    private static JLabel loginPasswordLabel;
    private static JPasswordField loginPasswordText;
    private static JButton loginButton;
    private static JButton registerButton;
    private static JButton goToRegisterButton;

    private static JPanel registrationPanel;
    private static JPanel loginPanel;
    private CardLayout cardLayout;

    public mygui() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        registrationPanel = new JPanel();
        loginPanel = new JPanel();

        createRegistrationPanel(registrationPanel);
        createLoginPanel(loginPanel);

        add(loginPanel, "Login");
        add(registrationPanel, "Registration");

        cardLayout.show(this.getContentPane(), "Login");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createRegistrationPanel(JPanel panel) {
        panel.setLayout(null);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        nameText = new JTextField(20);
        nameText.setBounds(120, 20, 165, 25);
        panel.add(nameText);

        surnameLabel = new JLabel("Surname");
        surnameLabel.setBounds(10, 50, 80, 25);
        panel.add(surnameLabel);

        surnameText = new JTextField(20);
        surnameText.setBounds(120, 50, 165, 25);
        panel.add(surnameText);

        studentNumberLabel = new JLabel("Student Number");
        studentNumberLabel.setBounds(10, 80, 100, 25);
        panel.add(studentNumberLabel);

        studentNumberText = new JTextField(20);
        studentNumberText.setBounds(120, 80, 165, 25);
        panel.add(studentNumberText);

        contactsLabel = new JLabel("Contacts");
        contactsLabel.setBounds(10, 110, 80, 25);
        panel.add(contactsLabel);

        contactsText = new JTextField(20);
        contactsText.setBounds(120, 110, 165, 25);
        panel.add(contactsText);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 140, 80, 25);
        panel.add(emailLabel);

        emailText = new JTextField(20);
        emailText.setBounds(120, 140, 165, 25);
        panel.add(emailText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 170, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(120, 170, 165, 25);
        panel.add(passwordText);

        registerButton = new JButton("Register");
        registerButton.setBounds(85, 210, 165, 25);
        panel.add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String surname = surnameText.getText();
                String studentNumber = studentNumberText.getText();
                String contacts = contactsText.getText();
                String email = emailText.getText();
                String password = new String(passwordText.getPassword());

                User newUser = new User(name, surname, studentNumber, contacts, email, password);
                users.add(newUser);

                writeUserDetailsToFile(newUser);

                cardLayout.show(mygui.this.getContentPane(), "Login");
            }
        });
    }

    private void createLoginPanel(JPanel panel) {
        panel.setLayout(null);

        loginLabel = new JLabel("Email");
        loginLabel.setBounds(10, 20, 80, 25);
        panel.add(loginLabel);

        loginText = new JTextField(20);
        loginText.setBounds(120, 20, 165, 25);
        panel.add(loginText);

        loginPasswordLabel = new JLabel("Password");
        loginPasswordLabel.setBounds(10, 50, 80, 25);
        panel.add(loginPasswordLabel);

        loginPasswordText = new JPasswordField(20);
        loginPasswordText.setBounds(120, 50, 165, 25);
        panel.add(loginPasswordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(85, 100, 165, 25);
        panel.add(loginButton);

        goToRegisterButton = new JButton("Register");
        goToRegisterButton.setBounds(85, 130, 165, 25);
        panel.add(goToRegisterButton);

        goToRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mygui.this.getContentPane(), "Registration");
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = loginText.getText();
                String password = new String(loginPasswordText.getPassword());

                User matchedUser = null;
                for (User user : users) {
                    if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                        matchedUser = user;
                        break;
                    }
                }

                if (matchedUser != null) {
                    JOptionPane.showMessageDialog(mygui.this, "Login successful");
                } else {
                    JOptionPane.showMessageDialog(mygui.this, "Login failed");
                }
            }
        });
    }

    private void writeUserDetailsToFile(User user) {
        try {
            FileWriter writer = new FileWriter("PersonalDetails.txt", true);
            writer.write(user.getEmail() + ", " + user.getPassword() + "\n");
            writer.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new mygui();
            }
        });
    }
}




