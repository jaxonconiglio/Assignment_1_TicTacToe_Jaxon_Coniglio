import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame {
    private TicTacToeButton[][] buttons;
    private char currentPlayer = 'X';
    private int moveCount = 0;

    public TicTacToeFrame() {
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new GridLayout(3, 3));

        buttons = new TicTacToeButton[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new TicTacToeButton(row, col);
                buttons[row][col].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        TicTacToeButton button = (TicTacToeButton) e.getSource();
                        if (button.isEmpty()) {
                            button.setPlayer(currentPlayer);
                            moveCount++;
                            if (checkForWin() || moveCount == 9) {
                                handledGameEnd();
                            } else {
                                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                            }
                        }
                    }
                });
                add(buttons[row][col]);
            }
        }

        setVisible(true);
    }

    private boolean checkForWin() {
        for (int row = 0; row < 3; row++) {
            if (buttons[row][0].getPlayer() == currentPlayer &&
                    buttons[row][1].getPlayer() == currentPlayer &&
                    buttons[row][2].getPlayer() == currentPlayer) {
                return true;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (buttons[0][col].getPlayer() == currentPlayer &&
                    buttons[1][col].getPlayer() == currentPlayer &&
                    buttons[2][col].getPlayer() == currentPlayer) {
                return true;
            }
        }
            if (buttons[0][0].getPlayer() == currentPlayer &&
                    buttons[1][1].getPlayer() == currentPlayer &&
                    buttons[2][2].getPlayer() == currentPlayer) {
                return true;
            }
            if (buttons[0][0].getPlayer() == currentPlayer &&
                    buttons[1][1].getPlayer() == currentPlayer &&
                    buttons[2][2].getPlayer() == currentPlayer) {
                return true;
            }
            return false;
        }
    private void handledGameEnd() {
        String message;
        if (checkForWin()) {
            message = currentPlayer + " wins";
        } else {
            message = "It's a tie";
        }
        JOptionPane.showMessageDialog(this, message);
        resetBoard();
    }
    private void resetBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
               buttons[row][col].clear();
            }
        }
        currentPlayer = 'X';
        moveCount = 0;
    }
}
