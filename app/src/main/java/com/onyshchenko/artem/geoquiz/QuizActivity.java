package com.onyshchenko.artem.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button trueBtn;
    private Button falseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        trueBtn = (Button)findViewById(R.id.trueBtn);
        falseBtn = (Button)findViewById(R.id.falseBtn);

        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_LONG).show();
            }
        });

        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_LONG).show();
            }
        });
    }
}
