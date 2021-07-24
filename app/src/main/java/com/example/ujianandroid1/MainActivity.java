package com.example.ujianandroid1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView btnUp, btnDown, btnRight, btnLeft;
    ImageView[][] tiles = new ImageView[5][5];
    int[][] array = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
    int[] position = {0, 0};
    int[] temp = {0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUp = findViewById(R.id.btnUp);
        btnDown = findViewById(R.id.btnDown);
        btnRight = findViewById(R.id.btnRight);
        btnLeft = findViewById(R.id.btnLeft);

        init();
        startGame();

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position[1] > 0) {
                    for (int i = 0; i < position.length; i++)
                        temp[i] = position[i];
                    position[1]--;
                    move();
                    color();
                }
            }
        });

        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position[1] < 4) {
                    for (int i = 0; i < position.length; i++)
                        temp[i] = position[i];
                    position[1]++;
                    move();
                    color();
                }
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position[0] < 4) {
                    for (int i = 0; i < position.length; i++)
                        temp[i] = position[i];
                    position[0]++;
                    move();
                    color();
                }
            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position[0] > 0) {
                    for (int i = 0; i < position.length; i++)
                        temp[i] = position[i];
                    position[0]--;
                    move();
                    color();
                }
            }
        });
    }

    private void init() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String tilesId = "tiles_" + i + j;
                tiles[i][j] = findViewById(getResources().getIdentifier(tilesId,
                        "id", getPackageName()));
            }
        }
    }

    private void move() {
        if (array[position[1]][position[0]] == 0) {
            array[position[1]][position[0]]++;
        }
        else if (array[position[1]][position[0]] == 1) {
            array[position[1]][position[0]]--;
        }
    }

    private void color() {
        if (array[position[1]][position[0]] == 1) {
            tiles[position[1]][position[0]].setImageResource(R.drawable.black_square);
        }
        else if (array[position[1]][position[0]] == 0) {
            tiles[position[1]][position[0]].setImageResource(R.drawable.white_square);
        }
    }

    private void startGame() {
        for (int i = 0; i < position.length; i++) {
            temp[i] = position[i];
        }
        move();
        color();
    }
}