import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;

public class Sliders {
    public static void main(String[] args) {
        Frames frame = new Frames();
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel();

        JSlider slider = new JSlider(JSlider.VERTICAL, 0, 100, 50);
        slider.setPreferredSize(new Dimension(400, 200));
        slider.setPaintTicks(true);
        // slider.setCursor(new Cursor(1));
        slider.setMinorTickSpacing(10);// how often are the ticks
        slider.setMajorTickSpacing(25);
        slider.setPaintLabels(true);
        slider.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        slider.addChangeListener(e -> label.setText("Current Temperature: " + slider.getValue() + " °C"));

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);

        panel.add(slider, BorderLayout.NORTH);
        panel.add(label, BorderLayout.SOUTH);

        frame.add(panel);
        // frame.pack();
        frame.setVisible(true);
    }
}
