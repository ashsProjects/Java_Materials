import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

public class KeyBind {
    static JLabel label;
    static Action up;
    static Action down;
    static Action left;
    static Action right;

    public KeyBind() {
        Frames frame = new Frames();
        label = new JLabel("Move me");
        down = new Down();
        up = new Up();
        left = new Left();;
        right = new Right();

        label.setFont(new Font("Times New Roman", Font.BOLD, 30));
        label.setBackground(Color.white);
        label.setOpaque(true);
        label.setBounds(100,100,100,100);
        label.setBounds(frame.getBounds());

        label.getInputMap().put(KeyStroke.getKeyStroke("UP"), "upAction");
        label.getActionMap().put("upAction", up);
        
        label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "downAction");
        label.getActionMap().put("downAction", down);

        label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
        label.getActionMap().put("leftAction", left);

        label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
        label.getActionMap().put("rightAction", right);

        frame.add(label);
        frame.setVisible(true);
    }
    public class Up extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX(), label.getY() - 10);
        }     
    }
    public class Down extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX(), label.getY() + 10);
        }     
    }
    public class Left extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX() - 10, label.getY());
        }     
    }
    public class Right extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setLocation(label.getX() + 10, label.getY());
        }     
    }
    public static void main(String[] args) {
        KeyBind run = new KeyBind();
    }
}
