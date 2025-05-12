package ait.cohort55.wortebuch.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "words")
@Getter
@Setter
public class Word {
    @Id
    private String id;
    private String original;
    private String translation;
    private String userId;
    private WordStatus status = WordStatus.NEW;
    private LocalDateTime nextReview;
}
