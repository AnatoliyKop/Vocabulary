package ait.cohort55.wortebuch.dto;

import ait.cohort55.wortebuch.model.WordStatus;
import lombok.Getter;

import java.util.List;

@Getter
public class WordDto {
    private String word;
    private String translation;
    private List<String> usageExample;
    private List<WordStatus> status;
}