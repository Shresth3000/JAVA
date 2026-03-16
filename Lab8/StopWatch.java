import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StopWatch extends JFrame implements ActionListener {

    // ── UI Components ──────────────────────────────────────────────
    private JLabel titleLabel;
    private JLabel timeLabel;
    private JButton startBtn, resetBtn, lapBtn;
    private JTextArea lapArea;
    private JScrollPane lapScroll;

    // ── Timer State ────────────────────────────────────────────────
    private Thread timerThread;
    private volatile boolean running = false;
    private long startTime    = 0;   // System.nanoTime() snapshot when started/resumed
    private long elapsedNanos = 0;   // accumulated nanos from previous runs (for pause/resume)
    private int  lapCount     = 0;
    private ArrayList<String> laps = new ArrayList<>();

    // ──────────────────────────────────────────────────────────────
    public StopWatch() {
        buildUI();
    }

    // ── Build UI ───────────────────────────────────────────────────
    private void buildUI() {
        setTitle("Stop Watch");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        getContentPane().setBackground(Color.WHITE);

        // Title
        titleLabel = new JLabel("Stop Watch");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        titleLabel.setForeground(Color.BLUE);

        // Time display  ── HH : MM : SS : mmm
        timeLabel = new JLabel("00 : 00 : 00 : 000");
        timeLabel.setFont(new Font("Monospaced", Font.BOLD, 36));
        timeLabel.setForeground(new Color(0, 0, 180));

        // Buttons
        startBtn = styledButton("Start", new Color(34, 139, 34));
        resetBtn = styledButton("Reset", new Color(200, 40,  40));
        lapBtn   = styledButton("Lap",   new Color(30,  100, 200));

        startBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        lapBtn  .addActionListener(this);

        // Lap area
        lapArea = new JTextArea(8, 50);
        lapArea.setEditable(false);
        lapArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        lapArea.setBackground(new Color(245, 245, 255));
        lapArea.setBorder(BorderFactory.createTitledBorder("Laps"));
        lapScroll = new JScrollPane(lapArea);
        lapScroll.setPreferredSize(new Dimension(560, 180));

        add(titleLabel);
        add(timeLabel);
        add(startBtn);
        add(resetBtn);
        add(lapBtn);
        add(lapScroll);

        setVisible(true);
    }

    private JButton styledButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(100, 36));
        return btn;
    }

    // ── Timer Thread ───────────────────────────────────────────────
    /**
     * A dedicated Runnable that reads System.nanoTime() on every iteration.
     * Accuracy depends on the system clock, NOT on loop-counting.
     */
    private class TimerTask implements Runnable {
        @Override
        public void run() {
            while (running) {
                // Total elapsed time = saved past runs + current run
                long totalNanos = elapsedNanos + (System.nanoTime() - startTime);

                long totalMillis = totalNanos / 1_000_000;
                long ms   =  totalMillis % 1000;
                long secs = (totalMillis / 1000)   % 60;
                long mins = (totalMillis / 60_000)  % 60;
                long hrs  =  totalMillis / 3_600_000;

                final String display = String.format(
                        "%02d : %02d : %02d : %03d", hrs, mins, secs, ms);

                // Always update Swing components on the Event Dispatch Thread
                SwingUtilities.invokeLater(() -> timeLabel.setText(display));

                try {
                    Thread.sleep(8); // ~120 fps refresh — plenty for a stopwatch
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    // ── Button Actions ─────────────────────────────────────────────
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startBtn) {
            if (!running) {
                // ── START / RESUME ────────────────────────────
                running   = true;
                startTime = System.nanoTime();   // snapshot NOW
                timerThread = new Thread(new TimerTask(), "StopWatch-Thread");
                timerThread.setDaemon(true);     // won't block JVM shutdown
                timerThread.start();
                startBtn.setText("Pause");
                startBtn.setBackground(new Color(200, 130, 0));
            } else {
                // ── PAUSE ─────────────────────────────────────
                running      = false;
                elapsedNanos += System.nanoTime() - startTime; // save progress
                startBtn.setText("Resume");
                startBtn.setBackground(new Color(34, 139, 34));
            }
        }

        if (e.getSource() == resetBtn) {
            // ── RESET ─────────────────────────────────────────
            running      = false;
            elapsedNanos = 0;
            lapCount     = 0;
            laps.clear();
            SwingUtilities.invokeLater(() -> {
                timeLabel.setText("00 : 00 : 00 : 000");
                lapArea.setText("");
                startBtn.setText("Start");
                startBtn.setBackground(new Color(34, 139, 34));
            });
        }

        if (e.getSource() == lapBtn && running) {
            // ── LAP ───────────────────────────────────────────
            long totalNanos  = elapsedNanos + (System.nanoTime() - startTime);
            long totalMillis = totalNanos / 1_000_000;
            long ms   =  totalMillis % 1000;
            long secs = (totalMillis / 1000)   % 60;
            long mins = (totalMillis / 60_000)  % 60;
            long hrs  =  totalMillis / 3_600_000;

            lapCount++;
            String lapText = String.format("Lap %2d  ->  %02d : %02d : %02d : %03d",
                    lapCount, hrs, mins, secs, ms);
            laps.add(lapText);

            SwingUtilities.invokeLater(() -> {
                lapArea.setText("");
                for (String l : laps) lapArea.append(l + "\n");
                lapArea.setCaretPosition(lapArea.getDocument().getLength());
            });
        }
    }

    // ── Entry Point ────────────────────────────────────────────────
    public static void main(String[] args) {
        // Launch UI on the Event Dispatch Thread — Swing is not thread-safe
        SwingUtilities.invokeLater(StopWatch::new);
    }
}