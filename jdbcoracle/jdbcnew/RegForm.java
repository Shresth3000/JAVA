import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegForm extends JFrame implements ActionListener {

    JTextField name = new JTextField(15);
    JTextField dob = new JTextField(15);
    JTextField email = new JTextField(15);
    JTextField address = new JTextField(15);
    JTextField mobile = new JTextField(15);

    JComboBox<String> school = new JComboBox<>(new String[]{"Select","Engineering","Science"});
    JComboBox<String> dept = new JComboBox<>(new String[]{"CSE","ECE","ME"});
    JComboBox<String> course = new JComboBox<>(new String[]{"B.Tech","M.Tech"});

    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");

    JButton submit = new JButton("Submit");
    JButton reset = new JButton("Reset");

    public RegForm() {

        setTitle("Student Registration Form");
        setSize(400, 500);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        getContentPane().setBackground(new Color(153,0,0));

        JLabel title = new JLabel("SOME UNIVERSITY");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title);

        JLabel sub = new JLabel("Student Registration Form");
        sub.setForeground(Color.WHITE);
        add(sub);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        male.setBackground(new Color(153,0,0));
        female.setBackground(new Color(153,0,0));

        add(label("Name:")); add(name);
        add(label("DOB:")); add(dob);

        add(label("Sex:"));
        add(male);
        add(female);

        add(label("Email:")); add(email);
        add(label("Address:")); add(address);
        add(label("School:")); add(school);
        add(label("Department:")); add(dept);
        add(label("Course:")); add(course);
        add(label("Mobile:")); add(mobile);

        add(reset);
        add(submit);

        submit.addActionListener(this);
        reset.addActionListener(this);

        setVisible(true);
        
    }

    JLabel label(String text){
        JLabel l = new JLabel(text);
        l.setForeground(Color.WHITE);
        return l;
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==reset){
            name.setText("");
            dob.setText("");
            email.setText("");
            address.setText("");
            mobile.setText("");
            male.setSelected(false);
            female.setSelected(false);
            return;
        }

        String gender = male.isSelected() ? "Male" : "Female";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "shresth",
                "shresth"
            );

            PreparedStatement ps = con.prepareStatement(
                "insert into student43(name,dob,gender) values(?,?,?)"
            );

            ps.setString(1, name.getText());
            ps.setString(2, dob.getText());
            ps.setString(3, gender);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Inserted!");

            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    public static void main(String[] args) {
        new RegForm();
    }
}