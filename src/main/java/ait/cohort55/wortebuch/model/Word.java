package ait.cohort55.wortebuch.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Document(collection = "words")
@Getter
@Setter

public class Word {
    @Id
    @Setter(AccessLevel.NONE)
    private String id;
    private String original;
    private String translation;
    @Setter(AccessLevel.NONE)
    private WordStatus status;
    private LocalDateTime nextReview;
    private Set<String> usageExample;


    public Word(String original, String translation, Set<String> usageExample) {
        this.original = original;
        this.translation = translation;
        status = WordStatus.NEW;
        nextReview = LocalDateTime.now().plusMinutes(1);
        this.usageExample = usageExample;
    }


    public void changeStatus(WordStatus newStatus) {
        this.status = newStatus;
        switch (newStatus) {
            case LEARNING -> nextReview = LocalDateTime.now().plusMinutes(5);
            case MASTERED -> nextReview = LocalDateTime.now().plusDays(10);
            default -> nextReview = LocalDateTime.now().plusMinutes(1);
        }

    }
}
