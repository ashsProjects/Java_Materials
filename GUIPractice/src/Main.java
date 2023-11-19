import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet.ColorAttribute;

public class Main implements ActionListener{
    static JLabel label1;
    public static void main(String[] args) {
        JLabel label = new JLabel();// creates a lable that is a display area for a string of text or image
        label1 = new JLabel();
        
        Border border = BorderFactory.createLineBorder(Color.black);
        JPanel redPanel = new JPanel();
        JPanel bluePanel = new JPanel();
        JPanel greenPanel = new JPanel();
        JPanel blackPanel = new JPanel();

        //-------------------------------------------------------------------------------------------------------
        JButton button = new JButton();
        button.setBounds(125, 125, 300, 50);
        button.addActionListener(e -> System.out.println("Hi"));
        button.setText("Press me to say Hi");
        button.setFocusable(false);// removes the border around the text
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setFont(new Font("Arial", Font.PLAIN, 25));
        button.setIconTextGap(10);
        button.setForeground(Color.blue);
        button.setBackground(Color.lightGray);
        button.setBorder(BorderFactory.createDashedBorder(null));
        //button.setEnabled(false);//disables a buton


        // ---------------------------------------------------------------------------------------------------------
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 0, 250, 250);

        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250, 0, 250, 250);

        blackPanel.setBackground(Color.black);
        blackPanel.setBounds(0, 250, 250, 250);

        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(250, 250, 250, 250);
        greenPanel.setLayout(null);

        // ------------------------------------------------------------------------------------------------------
        label.setText("Hello World");// set text of label
        // label.setIcon(image);//sets the logo
        label.setHorizontalTextPosition(JLabel.RIGHT);// set text to LEFT, CENTER, or RIGHT
        label.setVerticalTextPosition(JLabel.CENTER);
        // sets the text of the text to TOP, CENTER, or BOTTOM
        label.setForeground(new Color(0, 0, 0));// set font color of text
        label.setFont(new Font("Time New Roman", Font.BOLD, 40));// set font of text
        // label.setIconTextGap(-10);//set gapp of text to image
        // label.setBackground(Color.gray);// set background color
        // label.setOpaque(true);// display background color
        // label.setBorder(border);// sets the border of the label
        label.setHorizontalAlignment(JLabel.RIGHT);// sets where the text appears LEFT, CENTER, or RIGHT
        label.setVerticalAlignment(JLabel.TOP);// sets where the text appears in the label TOP, CENTER, or BOTTOM
        label.setBounds(0, 0, 250, 250);// set x and y positions within frame as well
        // as dimensions
        //label.setVisible(false);//sets the lable to be invisible
        // --------------------------------------------------------------------------------------------------------

        Frames frame = new Frames();// creates a frame
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);
        frame.add(blackPanel);
        greenPanel.add(label);
        frame.add(button);
        // frame.pack();// need to place after adding everything else
        frame.setVisible(true);// makes frame visible

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}
