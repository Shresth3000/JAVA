import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame implements ActionListener {

    JTextField display;
    String operator = "";
    double num1 = 0, num2 = 0, result = 0;

    CalculatorGUI() {

        setTitle("Calculator");
        setSize(300, 400);
        setLayout(new BorderLayout());

        
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

       
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "1","2","3","+",
            "4","5","6","-",
            "7","8","9","*",
            "/","0","%","=",
            "OFF"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            display.setText(display.getText() + cmd);
        }

       
        else if (cmd.matches("[+\\-*/%]")) {
            num1 = Double.parseDouble(display.getText());
            operator = cmd;
            display.setText("");
        }

        
        else if (cmd.equals("=")) {
            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/": result = num1 / num2; break;
                case "%": result = num1 % num2; break;
            }

            display.setText(String.valueOf(result));
        }

      
        else if (cmd.equals("OFF")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}