package com.onyshchenko.artem.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String TAG = "CheatActivity";
    public final static String EXTRA_ANSWER_IS_TRUE = "com.onyshchenko.artem.geoquiz.answer_is_true";
    public final static String EXTRA_ANSWER_SHOWN = "com.onyshchenko.artem.geoquiz.answer_shown";
    public final static String WAS_ANSWER_SHOWN = "WAS_ANSWER_SHOWN";
    private boolean wasAnswerShown;
    private boolean answerIsTrue;
    TextView answerTxtView;
    Button showAnswerBtn;

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    public static boolean wasAnswerShown(Intent intent) {
        return intent.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Log.d(TAG, "onCreate");
        answerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        gatherWidgets();
        setEventListeners();
        if(savedInstanceState != null) {
            wasAnswerShown = savedInstanceState.getBoolean(WAS_ANSWER_SHOWN, false);
            if(wasAnswerShown) {
                setAnswerTextIntoTxtView();
                setAnswerShownResult();
            }
        }
    }

    private void gatherWidgets() {
        answerTxtView = (TextView)findViewById(R.id.answerTxtView);
        showAnswerBtn = (Button)findViewById(R.id.showAnswerBtn);
    }

    private void setEventListeners() {
        showAnswerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnswerTextIntoTxtView();
                wasAnswerShown = true;
                setAnswerShownResult();
            }
        });
    }

    private void setAnswerTextIntoTxtView() {
        if(answerTxtView == null) {
            Log.d(TAG, "answerTxtView is null");
            return;
        }

        if(answerIsTrue) {
            answerTxtView.setText(R.string.correct_toast);
        } else {
            answerTxtView.setText(R.string.incorrect_toast);
        }
    }

    private void setAnswerShownResult() {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, wasAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "onSaveInstanceState");
        savedInstanceState.putBoolean(WAS_ANSWER_SHOWN, wasAnswerShown);
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
}
