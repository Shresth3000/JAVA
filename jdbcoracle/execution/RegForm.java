import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegForm extends JFrame implements ActionListener {

    JTextField email, username;
    JPasswordField password, confirm;
    JButton submit;

    public RegForm() {

        setTitle("Registration Page");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(180, 220, 170));

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(350, 350));
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel title = new JLabel("Registration Page");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(title);
        card.add(Box.createVerticalStrut(25));

        email = createField("ENTER EMAIL", card);
        username = createField("ENTER USERNAME", card);
        password = createPasswordField("ENTER PASSWORD", card);
        confirm = createPasswordField("CONFIRM PASSWORD", card);

        submit = new JButton("Submit");
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        submit.setBackground(new Color(220, 220, 220));
        submit.setFocusPainted(false);
        submit.addActionListener(this);

        card.add(Box.createVerticalStrut(15));
        card.add(submit);

        mainPanel.add(card);
        add(mainPanel);

        setVisible(true);
    }

    private JTextField createField(String text, JPanel panel) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField field = new JTextField();
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        field.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        panel.add(label);
        panel.add(field);
        panel.add(Box.createVerticalStrut(15));

        return field;
    }

    private JPasswordField createPasswordField(String text, JPanel panel) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 12));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPasswordField field = new JPasswordField();
        field.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        field.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));

        panel.add(label);
        panel.add(field);
        panel.add(Box.createVerticalStrut(15));

        return field;
    }

    public void actionPerformed(ActionEvent e) {

        String em = email.getText();
        String user = username.getText();
        String pass = new String(password.getPassword());
        String conf = new String(confirm.getPassword());

        if (em.isEmpty() || user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
            return;
        }

        if (!pass.equals(conf)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!");
            return;
        }

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "shresth",
                    "shresth"
            );

            String query = "INSERT INTO Form VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, em);
            ps.setString(2, user);
            ps.setString(3, pass);

            ps.executeUpdate();

            con.close();

            new SuccessFrame();
            dispose();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Error!");
        }
    }

    public static void main(String[] args) {
        new RegForm();
    }
}

class SuccessFrame extends JFrame {

    public SuccessFrame() {

        setTitle("Success");
        setSize(300, 150);
        setLayout(new FlowLayout());

        JLabel msg = new JLabel("Student has registered successfully");
        msg.setFont(new Font("Arial", Font.BOLD, 14));

        add(msg);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}