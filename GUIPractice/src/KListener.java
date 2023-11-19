import javax.swing.*;
import javax.swing.border.Border;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.*;

public class KListener implements KeyListener {
    static JLabel label;
    static JLabel label2;

    public static void main(String[] args) {
        Frames frame = new Frames();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        label = new JLabel();
        label.setText("Press WASD to move this");
        label.setBackground(Color.white);
        label.setOpaque(true);
        label.setForeground(Color.blue);
        label.setBounds(0,0,500,250);


        label2 = new JLabel();
        label2.setText("Press the arrow keys to move this");
        label2.setBackground(Color.white);
        label2.setOpaque(true);
        label2.setForeground(Color.red);
        label2.setBounds(0,250,500,250);
        label2.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        
        panel1.add(label);
        panel2.add(label2);
        panel1.addKeyListener(new KListener());
        panel2.addKeyListener(new KListener());

        frame.add(panel1);
        frame.add(panel2);
        frame.setLayout(new GridLayout(2,1));
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                label.setLocation(label.getX(), label.getY() - 10);
                break;
            case 'a':
                label.setLocation(label.getX() - 10, label.getY());
                break;
            case 's':
                label.setLocation(label.getX(), label.getY() + 10);
                break;
            case 'd':
                label.setLocation(label.getX() + 10, label.getY());
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                label2.setLocation(label.getX() - 10, label.getY());
                break;
            case 38:
                label2.setLocation(label.getX(), label.getY() - 10);
                break;
            case 39:
                label2.setLocation(label.getX() + 10, label.getY());
                break;
            case 40:
                label2.setLocation(label.getX(), label.getY() + 10);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
