import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewWindow implements ActionListener {
    static JFrame frame = new JFrame();
    JButton button = new JButton("New Window");

    NewWindow() {
        button.setBounds(100, 150, 200, 40);
        button.setFocusCycleRoot(false);
        button.addActionListener(this);
        

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        frame.add(button);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            LayreredPanes newWindow = new LayreredPanes();

        }
    }

    public static void main(String[] args) {
        NewWindow window = new NewWindow();

    }
}
