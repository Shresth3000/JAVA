import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField display;
    double num1, num2, result;
    String operator = "";

    public Calculator() {
        setTitle("Calculator");
        setSize(320, 260);
        getContentPane().setBackground(new Color(0, 210, 210));
        setLayout(new BorderLayout(5, 5));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 4));
        topPanel.setBackground(new Color(0, 210, 210));

        JLabel titleLabel = new JLabel("CALCULATOR");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(180, 220, 255));
        topPanel.add(titleLabel);

        display = new JTextField("", 10);
        display.setFont(new Font("SansSerif", Font.PLAIN, 14));
        display.setEditable(false);
        topPanel.add(display);

        add(topPanel, BorderLayout.NORTH);

        JPanel gridPanel = new JPanel(new GridLayout(4, 4, 4, 4));
        gridPanel.setBackground(new Color(0, 210, 210));

        String[] labels = {
            "1", "2", "3", "+",
            "4", "5", "6", "-",
            "7", "8", "9", "*",
            "/", "0", "%", "="
        };

        for (int i = 0; i < labels.length; i++) {
            JButton btn = new JButton(labels[i]);
            btn.setFont(new Font("SansSerif", Font.PLAIN, 14));
            btn.setBackground(new Color(220, 220, 220));
            btn.addActionListener(this);
            gridPanel.add(btn);
        }

        add(gridPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 4));
        bottomPanel.setBackground(new Color(0, 210, 210));

        JButton offBtn = new JButton("OFF");
        offBtn.setFont(new Font("SansSerif", Font.BOLD, 13));
        offBtn.setBackground(new Color(220, 220, 220));
        offBtn.setPreferredSize(new Dimension(120, 28));
        offBtn.addActionListener(this);
        bottomPanel.add(offBtn);

        add(bottomPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("OFF")) {
            System.exit(0);
        } 
        else if (cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/") || cmd.equals("%")) {
            try {
                num1 = Double.parseDouble(display.getText());
            } catch (Exception ex) {
                num1 = 0;
            }
            operator = cmd;
            display.setText("");
        } 
        else if (cmd.equals("=")) {
            try {
                num2 = Double.parseDouble(display.getText());
            } catch (Exception ex) {
                display.setText("Error");
                return;
            }

            if (operator.equals("+")) result = num1 + num2;
            else if (operator.equals("-")) result = num1 - num2;
            else if (operator.equals("*")) result = num1 * num2;
            else if (operator.equals("/")) {
                if (num2 == 0) {
                    display.setText("Div/0!");
                    return;
                }
                result = num1 / num2;
            }
            else if (operator.equals("%")) result = num1 % num2;
            else result = num2;

            if (result == (long) result)
                display.setText(String.valueOf((long) result));
            else
                display.setText(String.valueOf(result));

            operator = "";
        } 
        else {
            display.setText(display.getText() + cmd);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}