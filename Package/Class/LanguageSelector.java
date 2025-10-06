package Class;

import javax.swing.*;
import java.awt.event.*;

public class LanguageSelector {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Favorite Language");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField nameField = new JTextField(15);
        JComboBox<String> languageBox = new JComboBox<>(new String[]{"Java", "Python", "C++", "JavaScript"});
        JButton submitButton = new JButton("Submit");
        JLabel resultLabel = new JLabel();

        JPanel panel = new JPanel();
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Language:"));
        panel.add(languageBox);
        panel.add(submitButton);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String language = (String) languageBox.getSelectedItem();
                resultLabel.setText("Hello " + name + ", you love " + language + "!");
            }
        });
    }
}