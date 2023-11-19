import javax.swing.JOptionPane;

public class OptionPanes {
    public static void main(String[] args) {
        //JOptionPane.showMessageDialog(null, "Hello!", "Title", JOptionPane.PLAIN_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Hello!", "Title", JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Hello!", "Title", JOptionPane.QUESTION_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Hello!", "Title", JOptionPane.WARNING_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Hello!", "Title", JOptionPane.ERROR_MESSAGE);

        //JOptionPane.showConfirmDialog(null, "Yes or no?", "This is my title", JOptionPane.YES_NO_CANCEL_OPTION);

        //String name = JOptionPane.showInputDialog("What is your name?");
        //JOptionPane.showMessageDialog(null, "You name is " + name);

        //JOptionPane.showOptionDialog(null, "You are awesome!", "Secret Message", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        String[] str = {"Yes", "No", "Sod off!"};

        JOptionPane.showOptionDialog(null, "You are awesome!", "Secret Message", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, str, null);

    }
}
