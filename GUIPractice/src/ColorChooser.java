import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;

public class ColorChooser {
    public static void main(String[] args) {
        Frames frame = new Frames();
        JLabel label = new JLabel("This is a panel", JLabel.CENTER);
        JButton button = new JButton("Foreground Color");
        JButton button2 = new JButton("Background Color");

        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        label.setText("Panel color");
        label.setFont(new Font("Times New Roman", Font.PLAIN, 30));

        button.addActionListener(e -> {
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(button, "Pick a color for the foreground", Color.BLACK);
            label.setForeground(color);
        });
        button2.addActionListener(e -> {
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(button, "Pick a color for the Background", Color.WHITE);
            label.setBackground(color);
        });
        
        frame.add(button2);
        frame.add(button);
        frame.add(label);
        // frame.pack();
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);
    }
}
