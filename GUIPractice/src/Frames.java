import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.BorderLayout;

public class Frames extends JFrame implements ActionListener{
    Frames() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exits the app when X is pressed
        //HIDE_ON_CLOSE will hide the frame and DO_NOTHING_ON_CLOSE will do nothing
        this.setResizable(false);//prevents frame from being resized
        this.setTitle("Frame Title");// sets the title of frame
        this.setSize(520, 520);// sets the x and y dimensions of the frame
        this.getContentPane().setBackground(Color.WHITE);//change backgrounf color
        this.setBounds(new Rectangle(0,0,500,500));
        this.setLocationRelativeTo(null);
        //frame.getContentPane().setBackground(new Color(255, 255, 0)); //create a custom color
        this.setLayout(new FlowLayout());
        //this.pack();//adjusts the frame to the contents
        
        /* To replace the image icon of the frame; regular is java logo
         * ImageIcon image = new ImageIcon("logo.png");
         * frame.setIconImage(image.getImage());
         */
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
