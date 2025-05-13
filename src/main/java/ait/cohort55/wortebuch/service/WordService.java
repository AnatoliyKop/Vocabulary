package ait.cohort55.wortebuch.service;

import ait.cohort55.wortebuch.dto.WordDto;

import java.util.List;

public interface WordService {

    WordDto addWord(WordDto wordDto);

    WordDto findWord(String word);

    List<WordDto> findAllWords();

    WordDto updateWord(WordDto wordDto);

    WordDto deleteWord(String wordDto);

    List<WordDto> training(List<WordDto> wordsDto);
    void updateAfterTraining(List<WordDto> wordsDto);
}
