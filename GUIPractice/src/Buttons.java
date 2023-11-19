import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Buttons {
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("standard.png");
        Frames frame = new Frames();
        JButton button = new JButton("Icon", icon);


        frame.add(button);
        frame.setVisible(true);
    }
}
