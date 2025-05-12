package ait.cohort55.wortebuch.service;

import ait.cohort55.wortebuch.dto.DeleteWordDto;
import ait.cohort55.wortebuch.dto.TrainingDto;
import ait.cohort55.wortebuch.dto.WordDto;

import java.util.List;

public interface WordService {

    boolean addWord(WordDto wordDto);
    WordDto findWord(DeleteWordDto word);
    List<WordDto> findAllWords();
    WordDto updateWord(WordDto wordDto);
    WordDto deleteWord(DeleteWordDto wordDto);
    void training(TrainingDto trainingDto);
}
