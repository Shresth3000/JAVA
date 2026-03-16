import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calc2 extends JFrame implements ActionListener {

    JTextField t1, t2, result;
    JButton ad, sub, mul, div;

    Calc2() {

        setTitle("Simple Calculator");
        setSize(400,300);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3,2,5,5));
        JPanel buttonPanel = new JPanel(new GridLayout(2,2,5,5));

        JLabel l1 = new JLabel("First Number:");
        JLabel l2 = new JLabel("Second Number:");
        JLabel l3 = new JLabel("Result:");

        t1 = new JTextField();
        t2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        inputPanel.add(l1);
        inputPanel.add(t1);
        inputPanel.add(l2);
        inputPanel.add(t2);
        inputPanel.add(l3);
        inputPanel.add(result);

        ad = new JButton("Add");
        sub = new JButton("Subtract");
        mul = new JButton("Multiply");
        div = new JButton("Divide");

        buttonPanel.add(ad);
        buttonPanel.add(sub);
        buttonPanel.add(mul);
        buttonPanel.add(div);

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        ad.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        double num1 = Double.parseDouble(t1.getText());
        double num2 = Double.parseDouble(t2.getText());
        double res = 0;

        if(e.getSource() == ad)
            res = num1 + num2;
        else if(e.getSource() == sub)
            res = num1 - num2;
        else if(e.getSource() == mul)
            res = num1 * num2;
        else if(e.getSource() == div)
            res = num1 / num2;

        result.setText(String.valueOf(res));
    }

    public static void main(String[] args) {
        new Calc2();
    }
}