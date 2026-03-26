import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
class Rgb extends JFrame implements ActionListener{
    JButton b1;
    JComboBox<Integer> redBox,greenBox,blueBox;
    Rgb(){
        setTitle("Color Changer");
        setSize(500,500);
        setLayout(new FlowLayout());
        Integer values[] = new Integer[256];
        for (int i = 0; i < 256; i++) {
            values[i] = i;
        }
        
       JLabel rLabel = new JLabel("Red");
        rLabel.setForeground(Color.RED);

        JLabel gLabel = new JLabel("Green");
        gLabel.setForeground(Color.GREEN);

        JLabel bLabel = new JLabel("Blue");
        bLabel.setForeground(Color.BLUE);
        redBox = new JComboBox<>(values);
        greenBox = new JComboBox<>(values);
        blueBox = new JComboBox<>(values);

      
        b1=new JButton("Change Color");
        b1.addActionListener(this);

        
        add(rLabel); add(redBox);
        add(bLabel); add(blueBox);
        add(gLabel); add(greenBox);
        add(b1);
        

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        int r=(Integer) redBox.getSelectedItem();
        int g=(Integer) greenBox.getSelectedItem();
        int b=(Integer) blueBox.getSelectedItem();
        getContentPane().setBackground(new Color(r, g, b));

    }

public static void main(String[] args) {
        new Rgb();
}
}