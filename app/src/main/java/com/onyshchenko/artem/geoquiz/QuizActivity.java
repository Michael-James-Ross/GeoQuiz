package com.onyshchenko.artem.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import model.Question;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private static final String CURRENT_INDEX_QUESTION_KEY = "CURRENT_INDEX_QUESTION_KEY";
    private Button trueBtn;
    private Button falseBtn;
    private ImageButton nextQuestionBtn;
    private ImageButton prevQuestionBtn;
    private TextView questionTextTxtView;
    private int currentQuestionIndex = 0;
    private Question [] questions = {new Question(R.string.question_capital, true),
                                     new Question(R.string.question_ocean, false),
                                     new Question(R.string.question_sea, false),
                                     new Question(R.string.question_country, false)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_quiz);
        gatherAllWidgets();

        if(savedInstanceState != null) {
            currentQuestionIndex = savedInstanceState.getInt(CURRENT_INDEX_QUESTION_KEY, 0);
        }

        updateQuestion();
        setEventListeners();
    }

    private void gatherAllWidgets() {
        questionTextTxtView = (TextView) findViewById(R.id.questionTextTxtView);
        trueBtn = (Button)findViewById(R.id.trueBtn);
        falseBtn = (Button)findViewById(R.id.falseBtn);
        nextQuestionBtn = (ImageButton)findViewById(R.id.nextBtn);
        prevQuestionBtn = (ImageButton)findViewById(R.id.prevBtn);
    }

    private void setEventListeners() {
        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        questionTextTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNextQuestionIndex();
                updateQuestion();
            }
        });

        nextQuestionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNextQuestionIndex();
                updateQuestion();
            }
        });

        prevQuestionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPrevQuestionIndex();
                updateQuestion();
            }
        });
    }

    private void setNextQuestionIndex() {
        currentQuestionIndex = (currentQuestionIndex + 1) % QuizActivity.this.questions.length;
    }

    private void setPrevQuestionIndex() {
        if(currentQuestionIndex - 1 >= 0) {
            currentQuestionIndex -= 1;
        } else {
            currentQuestionIndex = questions.length - 1;
        }
    }

    private void updateQuestion() {
        try{
            int question = questions[currentQuestionIndex].getQuestionTextResId();
            questionTextTxtView.setText(question);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Log.d(TAG, "Index was out of bounds", ex);
        }
    }

    private void checkAnswer(boolean userPressed) {
        boolean answer = questions[currentQuestionIndex].isAnswer();
        int toastResId;
        if(answer == userPressed) {
            toastResId = R.string.correct_toast;
        } else {
            toastResId = R.string.incorrect_toast;
        }
        Toast.makeText(QuizActivity.this, toastResId, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(CURRENT_INDEX_QUESTION_KEY, currentQuestionIndex);
    }
}
