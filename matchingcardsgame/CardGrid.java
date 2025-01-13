/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardsgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
public class CardGrid {
  private JPanel gridPanel;
    private JButton[] cards;
    private String[] board;
    private CardLogic logic;

    public CardGrid() {
        gridPanel = new JPanel(new GridLayout(4, 4, 10, 10));
        cards = new JButton[16];
        logic = new CardLogic();

        for (int i = 0; i < cards.length; i++) {
            cards[i] = new JButton();
            cards[i].setFont(new Font("Arial", Font.PLAIN, 18));
            cards[i].setFocusPainted(false);
            cards[i].addActionListener(logic.createCardClickListener(i, cards));
            gridPanel.add(cards[i]);
        }
        board = logic.initializeBoard();
    }

    public JPanel getGridPanel() {
        return gridPanel;
    }

}
