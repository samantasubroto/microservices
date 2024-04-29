package com.quiz.services.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultQuizService implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;


    public DefaultQuizService(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizs = quizRepository.findAll();
        return quizs.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
    }

    @Override
    public Quiz getById(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Quiz not found!!!")
        );
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }

    @Override
    public void deleteById(Long id) {
        quizRepository.deleteById(id);
    }


}
