package com.ayush.truecitizen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.ayush.truecitizen.databinding.ActivityMainBinding;
import com.ayush.truecitizen.model.Question;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private int currentQuestionIndex=0;
    private ActivityMainBinding binding;
private Question[] questionsBank=new Question[]{
new Question(R.string.question_noble_prize,true),
        new Question(R.string.question_headquarters,false),
        new Question(R.string.question_sachin_tendulkar,false),
        new Question(R.string.question_mahabharata,false),
        new Question(R.string.question_roop_singh_stadium,false),
        new Question(R.string.question_seasons,false)
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.questionTextView.setText(questionsBank[currentQuestionIndex].getAnswerResId());
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentQuestionIndex<questionsBank.length-1){
                    currentQuestionIndex++;
                }
                binding.questionTextView.setText(questionsBank[currentQuestionIndex].getAnswerResId());
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentQuestionIndex>0) {
                    currentQuestionIndex--;
                }
                binding.questionTextView.setText(questionsBank[currentQuestionIndex].getAnswerResId());
            }
        });
        binding.buttonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionsBank[currentQuestionIndex].isAnswerTrue()){
                    Snackbar.make(binding.imageView2,R.string.correct_answer,Snackbar.LENGTH_SHORT).show();
                }else{
                    Snackbar.make(binding.imageView2,R.string.wrong_answer,Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        binding.buttonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!questionsBank[currentQuestionIndex].isAnswerTrue()){
                    Snackbar.make(binding.imageView2,R.string.correct_answer,Snackbar.LENGTH_SHORT).show();
                }else{
                    Snackbar.make(binding.imageView2,R.string.wrong_answer,Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}