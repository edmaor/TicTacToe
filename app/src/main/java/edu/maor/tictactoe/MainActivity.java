package edu.maor.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button single, local, onlineFriendly, onlineRanked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        handleInit();
    }

    private void handleInit(){
        single = findViewById(R.id.btn_single);
        single.setOnClickListener(v -> startActivity(new Intent(this, TicTacToe.class)));

        local = findViewById(R.id.btn_local);
        local.setOnClickListener(v -> startActivity(new Intent(this, TicTacToe.class)));

        onlineFriendly = findViewById(R.id.btn_online_friendly);
        onlineFriendly.setOnClickListener(v -> startActivity(new Intent(this, TicTacToe.class)));

        onlineRanked = findViewById(R.id.btn_online_ranked);
        onlineRanked.setOnClickListener(v -> startActivity(new Intent(this, TicTacToe.class)));

    }
}