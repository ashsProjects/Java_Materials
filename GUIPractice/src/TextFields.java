import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

public class TextFields {
    public static void main(String[] args) {
        Frames frame = new Frames();

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
        textField.setForeground(Color.green);
        textField.setBackground(Color.black);
        textField.setCaretColor(Color.green);
        //textField.setCaret(null);
        String startingStr = "username";
        textField.setText(startingStr);
        textField.setSelectionEnd(startingStr.length());//highlights the starting message
        textField.setEditable(true);

        JButton button = new JButton("Submit");

        frame.add(textField);
        frame.add(button);
        button.addActionListener(e -> System.out.println(textField.getText()));

        frame.pack();
        frame.setVisible(true);
    }
}
