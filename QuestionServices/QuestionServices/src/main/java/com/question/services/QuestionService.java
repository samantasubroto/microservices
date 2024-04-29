package com.question.services;

import com.question.entity.Question;

import java.util.List;

public interface QuestionService {
    Question add(Question question);
    List<Question> get();

    Question getById(Long id);

    void deleteById(Long id);

    List<Question> findByQuizId(Long id);
}
