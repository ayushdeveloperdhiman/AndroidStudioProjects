package com.ayush.trivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.ayush.trivia.data.AnswerListAsyncResponse;
import com.ayush.trivia.data.Repository;
import com.ayush.trivia.databinding.ActivityMainBinding;
import com.ayush.trivia.model.Question;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int currentCounter=0;
    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        questionList=new Repository().getQuestions(new AnswerListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Question> questions) {
                updateQuestion();
            }
        });
        binding.buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentCounter<questionList.size()){
                    currentCounter++;
                }
                updateQuestion();
            }
        });
        binding.buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        binding.buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

    }

    private void checkAnswer(boolean userChoice) {
        int snackMessageId=0;
        if (userChoice==questionList.get(currentCounter).getAnswerTrue()){
            fadeAnimation();
            snackMessageId=R.string.correct_answer;
        }else{
            shakeAnimation();
            snackMessageId=R.string.wrong_answer;
        }
        Snackbar.make(binding.cardView,snackMessageId,Snackbar.LENGTH_SHORT).show();
    }

    private void updateQuestion() {
        binding.questionTextview.setText(questionList.get(currentCounter).getAnswer());
        updateCounter();
    }

    @SuppressLint("DefaultLocale")
    private void updateCounter() {
        binding.textViewOutOf.setText(String.format("Question: %d/%d", currentCounter, questionList.size()));
    }
    private void fadeAnimation(){
        AlphaAnimation alphaAnimation=new AlphaAnimation(1.0f,0.0f);
        alphaAnimation.setDuration(150);
        alphaAnimation.setRepeatCount(1);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        binding.cardView.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                binding.questionTextview.setTextColor(Color.GREEN);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                binding.questionTextview.setTextColor(Color.WHITE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    private void shakeAnimation(){
        Animation shake= AnimationUtils.loadAnimation(MainActivity.this,R.anim.shake_animation);
        binding.cardView.startAnimation(shake);
        shake.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                binding.questionTextview.setTextColor(Color.RED);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                binding.questionTextview.setTextColor(Color.WHITE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}