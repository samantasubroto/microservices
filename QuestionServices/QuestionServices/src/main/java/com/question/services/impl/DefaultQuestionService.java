package com.question.services.impl;

import com.question.entity.Question;
import com.question.repositories.QuestionRepository;
import com.question.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultQuestionService implements QuestionService {

    private QuestionRepository questionRepository;

    public DefaultQuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question getById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("question not found"));
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }

    public List<Question> findByQuizId(Long id) {
        return questionRepository.findByQuizId(id);
    }
}
