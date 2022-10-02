package main;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setTitle("ShootACrow");

        Dimension Size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        window.setSize(Size);

        window.setLocationRelativeTo(null);

        window.setResizable(false);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        gamePanel.setUp();

        window.pack();
        gamePanel.startGameTread();


        window.setVisible(true);



    }
}
