package com.quiz.services;


import com.quiz.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
//(url = "http://localhost:8079",value="Question-Client")
@FeignClient(name = "QUESTIONSERVICES")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
    List<Question> getQuestionOfQuiz(@PathVariable Long quizId);
}
