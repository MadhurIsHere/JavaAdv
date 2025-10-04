package My2DGame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window=new JFrame(); //object of JFrame (structure of window)
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on press the cross
//        window.setSize(500,500);// size of the window
        window.setResizable(false); // cant be resize;
        window.setTitle("2D Adventure"); // title of the window
        GamePanel gamePanel=new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null); // location of the window
        window.setVisible(true);
        gamePanel.StartGameThread();
    }
}

