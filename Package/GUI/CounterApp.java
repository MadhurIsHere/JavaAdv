package GUI;
import java.awt.*;
import javax.swing.*;
public class CounterApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            JFrame jr=new JFrame();
            jr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            JLabel label=new JLabel("0",SwingConstants.CENTER);
            label.setHorizontalAlignment( SwingConstants.CENTER);
            label.setFont(label.getFont().deriveFont(36f));

            JButton inc=new JButton("Increment");
            inc.addActionListener(e->
                    {
                        int x=Integer.parseInt(label.getText());
                        label.setText(String.valueOf(x+1));
                    }
            );

            JPanel panel=new JPanel(new GridLayout(3,3));
            for(int i=0;i<9;i++)
            {
                panel.add(new JButton("o"));
            }

            jr.setLayout(new BorderLayout());
            jr.add(label,BorderLayout.CENTER);
            jr.add(panel);
            jr.add(inc,BorderLayout.SOUTH);
            jr.setSize(1000,750);
            jr.setLocationRelativeTo(null);
            jr.setVisible(true);
        });
    }
}
