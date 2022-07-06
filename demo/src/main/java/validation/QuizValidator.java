package validation;

import model.Quiz;

import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

public class QuizValidator {

    public boolean isAnswerValid(Quiz quiz, Map<String, List<Integer>> answer) {
        if (isNull(quiz.getAnswer())) {
            return isNull(answer.get("answer")) || answer.get("answer").isEmpty();
        }

        return quiz.getAnswer().equals(answer.get("answer"));
    }
}
