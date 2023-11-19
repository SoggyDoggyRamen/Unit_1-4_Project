import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
public class GameWindow extends JFrame implements ActionListener, Runnable {

    private JFrame j;
    private JPanel p;
    private JLabel textLabel;
    private JLabel bottomLabel;
    private Image image;
    private int x;
    private int y;
    private int clickerCounter;
    private Thread windowThread;
    private long startTime;

    /**
     * Constructor for the PointSimulator class. This creates a new instance of a PointSimulator
     */

    public GameWindow(String display) {
        startTime = System.currentTimeMillis();
        x = 100;
        y = 100;
        int frameWidth = 500;
        int frameHeight = 500;
        j = new JFrame(display);
        textLabel = new JLabel("Counter: " + clickerCounter);
        bottomLabel = new JLabel("Time: " + clickerCounter);
        clickerCounter = 0;
        j.add(textLabel, BorderLayout.NORTH);
        j.add(bottomLabel, BorderLayout.SOUTH);
        j.addKeyListener(new KeyTracker());

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize(frameWidth, frameHeight);
        j.setLocation(5, 5);
        j.setVisible(true);
        startThread();

    }
    /**
     * startThread method
     */

    public void startThread() {
        windowThread = new Thread(this);
        windowThread.start();
    }


    public void run() {
        boolean reset = true;
        while (true) {
            long currentTime = System.currentTimeMillis();
            long timeElapsed = (currentTime - startTime) / 1000;
            bottomLabel.setText("Time: " + timeElapsed + "s");
            if (timeElapsed == 2 && reset == true) {
                double points = PointSimulator.pointsPerClick;
                if ((int) (Math.random() * 100 + 1) <= PointSimulator.critChance) {
                    points *= 2;
                    PointSimulator.total += points;
                    System.out.println("\nCRITICAL! + " + points + " points!");
                }
                else {
                    PointSimulator.total += points;
                    System.out.println("\n+ " + points + " points!");
                }
                startTime = System.currentTimeMillis();
                reset = false;
            }
            if (timeElapsed == 1 && reset == false) {
                reset = true;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action performed!");
    }

    public class KeyTracker extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                clickerCounter++;
                textLabel.setText("Counter: " + clickerCounter);
            }
        }
    }
}
