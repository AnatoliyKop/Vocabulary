package ait.cohort55.wortebuch.dto;

import ait.cohort55.wortebuch.model.WordStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class WordDto {
    private String word;
    private String translation;
    private Set<String> usageExample;
    private WordStatus status;
}