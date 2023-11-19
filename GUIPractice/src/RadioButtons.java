import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class RadioButtons {
    public static void main(String[] args) {
       Frames frame = new Frames();
       JRadioButton radio1 = new JRadioButton("Hamburger");
       JRadioButton radio2 = new JRadioButton("Hot Dog");
       JRadioButton radio3 = new JRadioButton("Pizza");
       
       radio1.setFocusable(false);
       radio2.setFocusable(false);
       radio3.setFocusable(false);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1); group.add(radio2); group.add(radio3);
        radio1.addActionListener(x -> JOptionPane.showMessageDialog(radio1, "You pressed Hamburger", null, JOptionPane.INFORMATION_MESSAGE));


       frame.add(radio1);
       frame.add(radio2);
       frame.add(radio3);
       frame.pack();
       frame.setVisible(true);
    }
}
