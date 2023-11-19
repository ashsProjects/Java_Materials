import java.awt.Color;
import java.lang.reflect.Constructor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JLayeredPane;

public class LayreredPanes {
    LayreredPanes() {
        Frames frames = new Frames();
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,500);
        layeredPane.setBackground(Color.cyan);
        layeredPane.setAlignmentX(JLayeredPane.CENTER_ALIGNMENT);
        layeredPane.setAlignmentY(JLayeredPane.CENTER_ALIGNMENT);
        
        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground(Color.red);
        label1.setBounds(50, 50, 150, 200);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBackground(Color.blue);
        label2.setBounds(200, 50, 150, 200);

        JLabel label3 = new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.orange);
        label3.setBounds(300, 50, 150, 200);

        layeredPane.add(label1, Integer.valueOf(0));
        layeredPane.add(label2, Integer.valueOf(3));
        layeredPane.add(label3, Integer.valueOf(1));

        frames.add(layeredPane);
        frames.setVisible(true);


    }
}
