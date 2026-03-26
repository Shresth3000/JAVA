import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentRegistration extends JFrame implements ActionListener {

    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String DB_USER = "shresth";
    static final String DB_PASSWORD = "shresth";

    JTextField nameField = new JTextField(15);
    JPasswordField passField = new JPasswordField(15);
    JPasswordField confirmPassField = new JPasswordField(15);
    JCheckBox termsBox = new JCheckBox("Accept Terms");
    JButton submitButton = new JButton("Submit");

    public StudentRegistration() {
        setTitle("Registration");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Name:"));
        add(nameField);

        add(new JLabel("Password:"));
        add(passField);

        add(new JLabel("Confirm:"));
        add(confirmPassField);

        add(termsBox);
        add(new JLabel(""));

        add(submitButton);

        // 👉 ActionListener
        submitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String pass = new String(passField.getPassword());
        String confirm = new String(confirmPassField.getPassword());

        if (name.equals("") || pass.equals("") || !pass.equals(confirm) || !termsBox.isSelected()) {
            JOptionPane.showMessageDialog(this, "Invalid Input!");
            return;
        }

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            PreparedStatement ps = con.prepareStatement(
                "insert into RegForm values(?,?)"
            );

            ps.setString(1, name);
            ps.setString(2, pass);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Registered Successfully!");

            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public static void main(String[] args) {
        new StudentRegistration().setVisible(true);
    }
}