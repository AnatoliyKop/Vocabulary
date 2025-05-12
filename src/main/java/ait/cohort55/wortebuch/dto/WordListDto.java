package ait.cohort55.wortebuch.dto;

import lombok.Getter;

import java.util.List;
@Getter
public class WordListDto {
        private List<WordDto> newWords;
        private List<WordDto> learningWords;
        private List<WordDto> masteredWords;

}
