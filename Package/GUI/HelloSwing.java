package GUI;
import javax.swing.*;
import java.awt.*;

public class HelloSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->
        {
            JFrame fr=new JFrame("Hello Swing");                            // OBJECT for JFrame
            fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                   // for using the cross button as exit
            fr.setSize(500,500);                                    // set the size of the window
            JLabel label=new JLabel("Hello swing",SwingConstants.CENTER);   // object of JLabel with swingconstants
            label.setVerticalAlignment(SwingConstants.CENTER);                   // set vertical alignment/ set horizontal alignment
            fr.setLocationRelativeTo(null);
            fr.setVisible(true);

        });
    }
}
