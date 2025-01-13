/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardsgame;

import javax.swing.*;
import java.awt.*;

public class GameUI {
    private JFrame frame;
    private JLabel logoLabel;
    private CardGrid cardGrid;

    public GameUI() {
        frame = new JFrame("Matching Cards Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        logoLabel = new JLabel("Matching Cards: Animales", JLabel.CENTER);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(logoLabel, BorderLayout.NORTH);

        cardGrid = new CardGrid();
        frame.add(cardGrid.getGridPanel(), BorderLayout.CENTER);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }

}
