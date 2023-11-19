import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class FlowLayoutPractice {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));// must import java.awt.FlowLayout
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
        panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        // panel.setPreferredSize(new Dimension(250,250));
        panel.setBackground(Color.lightGray);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(new JButton("0"));

        frame.add(panel);

        frame.setVisible(true);
    }
}
