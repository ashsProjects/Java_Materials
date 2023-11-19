import java.util.Arrays;

import javax.swing.JComboBox;

public class ComboBoxes {
    public static void main(String[] args) {
        Frames frame = new Frames();

        String[] names = { "Ayush", "Ash", "John", "Isabelle", "Ryan", "Justin" };
        JComboBox<String> combo1 = new JComboBox<>(names);
        combo1.addActionListener(e -> {
            if (combo1.getSelectedItem().equals("Ayush")) System.out.println("Ayush");
            else System.out.println("Not Ayush");
        });
        combo1.setSelectedIndex(1);
        
        
        frame.add(combo1);
        // frame.pack();
        frame.setVisible(true);

    }
}
