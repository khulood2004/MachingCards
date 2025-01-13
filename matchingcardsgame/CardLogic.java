/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matchingcardsgame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class CardLogic {
  private String[] animalsSpanish = {"Perro", "Gato", "Pájaro", "Caballo", "Vaca", "Oveja", "Pato", "Cerdo"};
    private String[] animalsEnglish = {"Dog", "Cat", "Bird", "Horse", "Cow", "Sheep", "Duck", "Pig"};
    private String[] sounds = {"bark", "meow", "chirp", "neigh", "moo", "baa", "quack", "oink"};
    private String[] board;
    private boolean firstCardFlipped = false;
    private int firstCardIndex = -1;
    private int matchesFound = 0;

    public String[] initializeBoard() {
        ArrayList<String> tempBoard = new ArrayList<>();
        for (int i = 0; i < animalsSpanish.length; i++) {
            tempBoard.add(animalsSpanish[i]);
            tempBoard.add(animalsEnglish[i]);
        }
        Collections.shuffle(tempBoard);
        board = tempBoard.toArray(new String[0]);
        return board;
    }

    public ActionListener createCardClickListener(int index, JButton[] cards) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cards[index].getText().isEmpty() && cards[index].isEnabled()) {
                    cards[index].setText(board[index]);
                    playSound(index);

                    if (!firstCardFlipped) {
                        firstCardFlipped = true;
                        firstCardIndex = index;
                    } else {
                        if (isMatch(firstCardIndex, index)) {
                            cards[firstCardIndex].setEnabled(false);
                            cards[index].setEnabled(false);
                            matchesFound++;

                            if (matchesFound == animalsSpanish.length) {
                                JOptionPane.showMessageDialog(null, "¡Felicidades! Has encontrado todos los pares.");
                            }
                        } else {
                            Timer timer = new Timer(1000, event -> {
                                cards[firstCardIndex].setText("");
                                cards[index].setText("");
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }
                        firstCardFlipped = false;
                    }
                }
            }
        };
    }

    private boolean isMatch(int firstIndex, int secondIndex) {
        String firstCard = board[firstIndex];
        String secondCard = board[secondIndex];

        for (int i = 0; i < animalsSpanish.length; i++) {
            if ((firstCard.equals(animalsSpanish[i]) && secondCard.equals(animalsEnglish[i])) ||
                (firstCard.equals(animalsEnglish[i]) && secondCard.equals(animalsSpanish[i]))) {
                return true;
            }
        }
        return false;
    }

    private void playSound(int index) {
        int animalIndex = (index < animalsSpanish.length) ? index : index - animalsSpanish.length;
        System.out.println("Playing sound: " + sounds[animalIndex]);
    }

}
