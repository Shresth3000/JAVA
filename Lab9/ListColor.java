import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
class ListColor extends JFrame implements ActionListener{
    JButton b1;
    JList<String> colorList;
    ListColor(){
        setTitle("Color Changer");
        setSize(500,500);
        setLayout(new FlowLayout());
        String colors[]={"RED","BLUE","GREEN","YELLOW"};
        colorList=new JList<>(colors);
        b1=new JButton("Change Color");
        b1.addActionListener(this);
        add(b1);
         add(new JScrollPane(colorList));
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
        String selected = colorList.getSelectedValue();
          if (selected != null) {
            switch(selected) {
                case "RED": getContentPane().setBackground(Color.RED); break;
                case "GREEN": getContentPane().setBackground(Color.GREEN); break;
                case "BLUE": getContentPane().setBackground(Color.BLUE); break;
                case "YELLOW": getContentPane().setBackground(Color.YELLOW); break;
            }
    }
}
public static void main(String[] args) {
        new ListColor();
}
}