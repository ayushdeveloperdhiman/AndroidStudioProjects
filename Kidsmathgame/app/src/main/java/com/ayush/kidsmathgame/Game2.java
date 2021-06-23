package com.ayush.kidsmathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class Game2 extends AppCompatActivity {
    TextView score, life, time, question;
    EditText answer;
    Button ok, nextQuestion;
    Random random = new Random();
    boolean check = false;
    int number1, number2, userAnswer, realAnswer, userScore = 0, userLife = 3;
    CountDownTimer timer;
    public final long START_TIME_IN_MILES = 60000;
    boolean timerRunning;
    long time_left_in_miles = START_TIME_IN_MILES;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        score = findViewById(R.id.textViewScore);
        life = findViewById(R.id.textViewLife);
        time = findViewById(R.id.textViewTime);
        question = findViewById(R.id.textViewQuestion);
        answer = findViewById(R.id.textViewAnswer);
        ok = findViewById(R.id.buttonOk);
        nextQuestion = findViewById(R.id.buttonNextQuestion);
        gameContinue();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userLife <= 0) {
                    Toast.makeText(Game2.this, "Game Over", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Game2.this, Result.class);
                    i.putExtra("score",userScore);
                    startActivity(i);
                    finish();
                }else{
                    if (timerRunning == false) {
                        answer.setText("");
                        gameContinue();
                    } else {
                        if (TextUtils.isEmpty(answer.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "Answer required", Toast.LENGTH_LONG).show();
                        } else {
                            pauseTimer();
                            check = true;
                            userAnswer = Integer.parseInt(answer.getText().toString());
                            if (userAnswer == realAnswer) {
                                userScore += 10;
                                score.setText("" + userScore);
                                question.setText("Congratulations, Your answer is correct.");

                            } else {
                                userLife -= 1;
                                life.setText("" + userLife);
                                question.setText("Sorry, Your answer is wrong.");

                            }

                        }


                    }
                }

            }
        });

        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userLife <= 0) {
                    Toast.makeText(Game2.this, "Game Over", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Game2.this, Result.class);
                    i.putExtra("score",userScore);
                    startActivity(i);
                    finish();
                } else {
                    if (check == true || timerRunning == false) {
                        restTimer();
                        answer.setText("");
                        gameContinue();
                        check = false;
                    } else {
                        Toast.makeText(getApplicationContext(), "Give answer first.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }


    public void gameContinue() {
        number1 = random.nextInt(100);
        number2 = random.nextInt(100);
        realAnswer = number1 * number2;
        question.setText(number1 + " * " + number2);
        startTimer();
    }

    public void startTimer() {
        timer = new CountDownTimer(time_left_in_miles, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                time_left_in_miles = millisUntilFinished;
                updateText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                pauseTimer();
                restTimer();
                updateText();
                userLife -= 1;
                life.setText("" + userLife);
                question.setText("Time is up!");

            }
        }.start();
        timerRunning = true;
    }

    public void updateText() {
        int seconds = (int) (time_left_in_miles / 1000) % 60;
        time.setText(String.format(Locale.getDefault(), "%2d", seconds));
    }

    public void pauseTimer() {
        timer.cancel();
        timerRunning = false;
    }

    public void restTimer() {
        time_left_in_miles = START_TIME_IN_MILES;
        updateText();
    }

}