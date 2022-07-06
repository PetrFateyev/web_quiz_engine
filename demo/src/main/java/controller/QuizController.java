package controller;

import model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.QuizService;
import validation.QuizResponse;
import validation.QuizValidator;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuizValidator quizValidator;

    @GetMapping
    public List<Quiz> showAll() {
        return quizService.findAll();
    }

    @GetMapping("/{id}")
    public Quiz show(@PathVariable Long id) {
        return quizService.findById(id);
    }

    @PostMapping
    public Quiz saveQuiz(@RequestBody @Valid Quiz quiz) {
        return quizService.saveOrUpdate(quiz);
    }

    @PostMapping("/{id}/solve")
    public QuizResponse processQuiz(@PathVariable Long id,
                                    @RequestBody Map<String, List<Integer>> answer) {

        Quiz quiz = quizService.findById(id);
        boolean isAnswerValid = quizValidator.isAnswerValid(quiz, answer);

        return QuizResponse.builder()
                .success(isAnswerValid)
                .feedback(isAnswerValid ? "Congratulations, you're right!" : "Wrong answer! Please, try again.")
                .build();
    }
}
