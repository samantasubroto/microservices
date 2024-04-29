package com.question.controller;

import com.question.entity.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question create(@RequestBody Question Question) {
        return questionService.add(Question);
    }

    @GetMapping
    public List<Question> get() {
        return questionService.get();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable Long id) {
        return questionService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        questionService.deleteById(id);
    }

    @GetMapping("/quiz/{quizId}")
    List<Question> findByQuizId(@PathVariable Long quizId) {
        return questionService.findByQuizId(quizId);
    }
}
