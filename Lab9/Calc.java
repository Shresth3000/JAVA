
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calc extends JFrame implements ActionListener {

    JTextField t1, t2, result;
    JButton ad, sub, mul, div;

    Calc() {

        setTitle("Simple Calculator");
        setSize(500,500);
        setLayout(new GridLayout(5,2,10,10));

        JLabel l1 = new JLabel("First Number:");
        JLabel l2 = new JLabel("Second Number:");
        JLabel l3 = new JLabel("Result:");

        t1 = new JTextField();
        t2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);

        ad = new JButton("Add");
        sub = new JButton("Subtract");
        mul = new JButton("Multiply");
        div = new JButton("Divide");

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(result);
        add(ad); add(sub);
        add(mul); add(div);

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
        new Calc();
    }
}