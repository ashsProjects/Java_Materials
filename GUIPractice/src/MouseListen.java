import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MouseListen implements MouseListener {
    static JLabel label;

    public static void main(String[] args) {
        Frames frame = new Frames();
        label = new JLabel("Label");

        label.setBackground(Color.white);
        label.setOpaque(true);
        label.setFont(new Font("Times New Roman", Font.BOLD, 40));
        label.addMouseListener(new MouseListen());

        frame.add(label);
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        label.setBackground(Color.yellow);
        System.out.println("Changed background color to yellow");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // System.out.println("Press");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // System.out.println("Release");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Enter");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Exit");
    }

}
