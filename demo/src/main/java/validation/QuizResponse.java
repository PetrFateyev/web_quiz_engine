package validation;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author
 * @since
 */
@Getter
@Setter
@Builder
public class QuizResponse {

    private boolean success;
    private String feedback;
}
