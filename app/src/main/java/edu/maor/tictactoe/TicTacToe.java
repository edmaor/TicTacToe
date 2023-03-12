package edu.maor.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TicTacToe extends AppCompatActivity {
    int turn = 0;
    String w = "X";
    private int p = 0;
    private TextView textTurn;

    private final ImageView[][] board = new ImageView[3][3];
    int[][] boardV;
    int[][] imgViews = {
            {R.id.ttt_00, R.id.ttt_01, R.id.ttt_02},
            {R.id.ttt_10, R.id.ttt_11, R.id.ttt_12},
            {R.id.ttt_20, R.id.ttt_21, R.id.ttt_22}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tic_tac_toe);

        handleInit();
    }

    private void handleInit() {
        boardV = new int[][]{
                {-1, -1, -1},
                {-1, -1, -1},
                {-1, -1, -1}};

        textTurn = findViewById(R.id.ttt_turn);
        textTurn.setText("X");
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = findViewById(imgViews[r][c]);
                int finalR = r;
                int finalC = c;
                board[r][c].setOnClickListener(v -> handleClick(finalR, finalC));
            }
        }
    }

    private void handleClick(int r, int c) {
        if (boardV[r][c] == -1) {
            turn++;
            if (p == 0) {
                board[r][c].setImageResource(R.drawable.val_x);
                boardV[r][c] = 0;
                if (checkWin( r, c)) win();
                p++;
                w = "O";
            } else if (p == 1){
                board[r][c].setImageResource(R.drawable.val_o);
                boardV[r][c] = 1;
                if (checkWin( r, c)) win();
                p--;
                w = "X";
            }
            textTurn.setText(w);
            if (turn == 9) draft();
        }

    }

    private boolean checkWin(int r, int c) {
        return checkRow(r) || checkColumn(c) || checkDiagonal(r, c);
    }
    private boolean checkRow(int r) {
        return p == boardV[r][0] && p == boardV[r][1] && p == boardV[r][2];
    }

    private boolean checkColumn(int c) {
        return p ==boardV[0][c] && p == boardV[1][c] && p == boardV[2][c];
    }

    private boolean checkDiagonal(int r, int c) {
        if (((r+1)%2) == 0 || ((c+1)%2) == 0 ) return false;
        else if (p == boardV[0][0] && p == boardV[1][1] && p == boardV[2][2]) return true;
        else return p == boardV[0][2] && p == boardV[1][1] && p == boardV[2][0];
    }

    private void win(){
        DialogFragment dialog = new WinDialogFragment();

        Bundle bundle = new Bundle();
        bundle.putString("MESSAGE",String.format(getResources().getString(R.string.winner),w));
        dialog.setArguments(bundle);
        dialog.show(getSupportFragmentManager(), "WIN");

        textTurn.setText(w);
    }

    private void draft() {
        DialogFragment dialog = new WinDialogFragment();

        Bundle bundle = new Bundle();
        bundle.putString("MESSAGE", getResources().getString(R.string.draft));
        dialog.setArguments(bundle);
        dialog.show(getSupportFragmentManager(), "WIN");

        textTurn.setText(w);
    }
}