import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class Stop extends JFrame implements ActionListener,Runnable
{
    JLabel timeLabel;
    JButton start,reset,lap;
    Thread t;
    int hours = 0, minutes = 0, seconds = 0, milliseconds = 0;
    long startTime=0;
    long elapsedTime=0;
    boolean running=false;
    Stop(){
        setTitle("Stop Watch");
        setSize(700,500);
        setLayout(new FlowLayout());
        JLabel title=new JLabel("Stop Watch");
        title.setForeground(Color.BLUE);
        timeLabel = new JLabel("00 : 00 : 00 : 000");
        start=new JButton("Start");
        reset=new JButton("Stop");
        lap=new JButton("Lap");
        start.addActionListener(this);
        reset.addActionListener(this);
        lap.addActionListener(this);
        add(title);
        add(timeLabel);
        add(start);
        add(reset);
        add(lap);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void run(){
        try{
            while(running){
                milliseconds++;
                if (milliseconds == 100) {
                    milliseconds = 0;
                    seconds++;
                }

                if (seconds == 60) {
                    seconds = 0;
                    minutes++;
                }

                if (minutes == 60) {
                    minutes = 0;
                    hours++;
                }

                timeLabel.setText(
                        String.format("%02d : %02d : %02d : %02d",
                                hours, minutes, seconds, milliseconds));
            }
        } catch (Exception e) {}
    }

   public void actionPerformed(ActionEvent e) {

    if (e.getSource() == start) {
        if (!running) {
            running = true;
            t = new Thread(this);
            t.start();
            start.setText("Stop");
        } else {
            running = false;
            start.setText("Start");
        }
    }

    if (e.getSource() == reset) {
        running = false;
        hours = minutes = seconds = milliseconds = 0;
        timeLabel.setText("00 : 00 : 00 : 000");
        start.setText("Start");
    }

    if(e.getSource() == lap){
        JOptionPane.showMessageDialog(this,
            String.format("Lap Time: %02d : %02d : %02d : %03d",
            hours, minutes, seconds, milliseconds));
    }
    if(e.getSource() == lap){
    JOptionPane.showMessageDialog(this,
        String.format("Lap Time: %02d : %02d : %02d : %03d",
        hours, minutes, seconds, milliseconds));
}
}
            public static void main(String[] args) {
        new Stop();
            }
        }


