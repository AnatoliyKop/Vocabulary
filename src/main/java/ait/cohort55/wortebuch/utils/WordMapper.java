package ait.cohort55.wortebuch.utils;

import ait.cohort55.wortebuch.dto.WordDto;
import ait.cohort55.wortebuch.model.Word;

public class WordMapper {
    public static WordDto wordToDto(Word word) {
        return new WordDto(word.getOriginal(), word.getTranslation(), word.getUsageExample(),word.getStatus());
    }
    public static Word DtoToWord(WordDto wordDto) {
        return  new Word(wordDto.getWord(),wordDto.getTranslation(),wordDto.getUsageExample());
    }


}

