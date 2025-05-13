package ait.cohort55.wortebuch.service;

import ait.cohort55.wortebuch.dao.WordRepository;
import ait.cohort55.wortebuch.dto.WordDto;
import ait.cohort55.wortebuch.dto.exeptions.WordNotFoundException;
import ait.cohort55.wortebuch.model.Word;
import ait.cohort55.wortebuch.utils.WordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static ait.cohort55.wortebuch.model.WordStatus.MASTERED;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;


    @Override
    public WordDto addWord(WordDto wordDto) {
        Word word = wordRepository.save(new Word(wordDto.getWord(), wordDto.getTranslation(), wordDto.getUsageExample()));
        return WordMapper.wordToDto(word);
    }

    @Override
    public WordDto findWord(String word) {
        Word res = wordRepository.findWordByOriginal(word);
        return WordMapper.wordToDto(res);
    }

    @Override
    public List<WordDto> findAllWords() {
        return StreamSupport.stream(wordRepository.findAll().spliterator(), false)
                .map(WordMapper::wordToDto)
                .collect(Collectors.toList());

    }

    @Override
    public WordDto updateWord(WordDto wordDto) {
        Word word = wordRepository.findWordByOriginal(wordDto.getWord());
        if (word != null) {
            word.setOriginal(wordDto.getWord());
            word.setTranslation(wordDto.getTranslation());
            if (wordDto.getUsageExample() != null) {
                wordDto.getUsageExample()
                        .forEach(w -> word.getUsageExample().add(w));

            }
            return WordMapper.wordToDto(wordRepository.save(word));
        }
        throw new WordNotFoundException();
    }

    @Override
    public WordDto deleteWord(String wordDto) {
        Word word = wordRepository.findWordByOriginal(wordDto);
        if (word != null) {
            wordRepository.delete(word);
            return WordMapper.wordToDto(word);

        }

        throw new WordNotFoundException();
    }

    @Override
    public List<WordDto> training(List<WordDto> wordsDto) {
        List<Word> trainingWords =new ArrayList<>() ;
        wordRepository.findAll().forEach(trainingWords::add);

       return trainingWords.stream()
                .filter(w->w.getStatus()!= MASTERED)
                .map(WordMapper::wordToDto)
                .toList();


    }

    @Override
    public void updateAfterTraining(List<WordDto> wordsDto) {
        for (WordDto wordDto : wordsDto) {
            Word word = wordRepository.findWordByOriginal(wordDto.getWord());
            if (word == null) {
                throw new WordNotFoundException();
            }
            word.changeStatus(wordDto.getStatus());
            wordRepository.save(word);
        }


    }
}

