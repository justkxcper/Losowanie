package com.example.losowanie;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int licznik = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Random random = new Random();

        int wylosowanaLiczba;

        Button[] przyciski = {
                findViewById(R.id.button),
                findViewById(R.id.button2),
                findViewById(R.id.button3),
                findViewById(R.id.button4),
                findViewById(R.id.button5),
                findViewById(R.id.button6),
                findViewById(R.id.button7),
                findViewById(R.id.button8),
                findViewById(R.id.button9),
                findViewById(R.id.button10),
                findViewById(R.id.button11),
                findViewById(R.id.button12),
        };
        TextView wynik = findViewById(R.id.textView);

        wylosowanaLiczba = random.nextInt(12) +1;

        for (int i = 0; i < 12; i++) {
            int liczba = i + 1;
            int j = i;
            przyciski[i].setOnClickListener(
                    view -> {
                        if (liczba == wylosowanaLiczba) {
                            przyciski[liczba-1].setBackgroundColor(Color.GREEN);
                            wynik.setText("Dobrze zgadłeś/aś!");
                            licznik++;
                        } else {
                            przyciski[liczba-1].setBackgroundColor(Color.RED);
                            wynik.setText("Źle zgadłeś/aś.");
                            licznik++;
                        }
                        if (j < wylosowanaLiczba){

                        } else if (j > wylosowanaLiczba) {

                        }
                    }
            );
        }
    }
}