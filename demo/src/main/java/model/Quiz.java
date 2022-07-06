package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Fetch;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;
import static javax.persistence.GenerationType.SEQUENCE;
import static org.hibernate.annotations.FetchMode.JOIN;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String text;

    @NotEmpty
    @Size(min = 2)
    @ElementCollection
    @OrderColumn
    @Fetch(JOIN)
    private List<String> options;

    @JsonProperty(access = WRITE_ONLY)
    @ElementCollection
    @OrderColumn
    @Fetch(JOIN)
    private List<Integer> answer;
}
