import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class CheckBox {
    public static void main(String[] args) {
        Frames frame = new Frames();

        JCheckBox checkBox = new JCheckBox();
        checkBox.setText("Confirm you are not a bot");
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        JButton button = new JButton("Submit");
        button.setFocusable(false);
        button.addActionListener(e -> {
            System.out.println(checkBox.isSelected());
        });

        frame.add(checkBox);
        frame.add(button);
        // frame.pack();
        frame.setVisible(true);

    }
}
