import java.awt.Color;
import java.awt.Font;

import javax.swing.JProgressBar;

public class ProgressBar {
    public static void main(String[] args) throws InterruptedException {
        Frames frame = new Frames();
        JProgressBar progress = new JProgressBar(0, 100);

        progress.setValue(0);
        progress.setBounds(frame.getWidth() / 2, frame.getHeight() / 2, 250, 250);
        progress.setStringPainted(true);
        progress.setFont(new Font("Times New Roman", Font.BOLD, 25));
        progress.setForeground(Color.gray);
        progress.setBackground(Color.white);

        frame.add(progress);
        frame.setVisible(true);

        for (int i = 0; i < 101; i++) {
            progress.setValue(i);
            Thread.sleep(50);
            i++;
        }
        progress.setString("Done!");
    }
}
