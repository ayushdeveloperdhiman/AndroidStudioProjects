package com.ayush.trivia.data;

import com.ayush.trivia.model.Question;

import java.util.ArrayList;

public interface AnswerListAsyncResponse {
    void processFinished(ArrayList<Question> questions);
}
