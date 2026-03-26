import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegForm extends JFrame implements ActionListener {

    JTextField nameField, emailField;
    JRadioButton male, female;
    JCheckBox music, sports;
    JButton submit;

    RegForm() {
        setTitle("Registration Form");
        setSize(400, 300);
        setLayout(new GridLayout(6,2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        genderPanel.add(male);
        genderPanel.add(female);
        add(genderPanel);

        add(new JLabel("Hobbies:"));
        JPanel hobbyPanel = new JPanel();
        music = new JCheckBox("Music");
        sports = new JCheckBox("Sports");
        hobbyPanel.add(music);
        hobbyPanel.add(sports);
        add(hobbyPanel);

        submit = new JButton("Submit");
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String gender = male.isSelected() ? "Male" : "Female";
        String hobbies = "";
        if (music.isSelected()) hobbies += "Music ";
        if (sports.isSelected()) hobbies += "Sports";

        JOptionPane.showMessageDialog(this,
            "Name: " + nameField.getText() +
            "\nEmail: " + emailField.getText() +
            "\nGender: " + gender +
            "\nHobbies: " + hobbies);
    }

    public static void main(String[] args) {
        new RegForm();
    }
}