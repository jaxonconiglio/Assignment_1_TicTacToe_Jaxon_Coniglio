import javax.swing.*;

public class TicTacToeButton extends JButton {
    private int row;
    private int col;
    private char player = ' ';

    public TicTacToeButton(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public boolean isEmpty(){
        return player == ' ';
    }
    public void setPlayer(char player){
        this.player = player;
        setText(String.valueOf(player));
    }
    public void clear() {
        player = ' ';
        setText("");
    }
    public char getPlayer(){return player;}

    public int getRow() {return row;}

    public int getCol() {return col;}
}
