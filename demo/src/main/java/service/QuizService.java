package service;

import model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import repository.QuizRepository;
import java.util.List;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public Quiz findById(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }

    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    public Quiz saveOrUpdate(Quiz quiz) {
        return quizRepository.save(quiz);
    }

}
