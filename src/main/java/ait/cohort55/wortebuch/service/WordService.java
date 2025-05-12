package ait.cohort55.wortebuch.service;

import ait.cohort55.wortebuch.dto.TrainingDto;
import ait.cohort55.wortebuch.dto.WordDto;

import java.util.List;

public interface WordService {

    boolean addWord(WordDto wordDto);
    WordDto findWord(String word);
    List<WordDto> findAllWords();
    WordDto updateWord(String idWord,WordDto wordDto);
    WordDto deleteWord(String wordDto);
    void training(TrainingDto trainingDto);
}
