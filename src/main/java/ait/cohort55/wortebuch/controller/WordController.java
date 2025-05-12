package ait.cohort55.wortebuch.controller;

import ait.cohort55.wortebuch.dto.TrainingDto;
import ait.cohort55.wortebuch.dto.WordDto;
import ait.cohort55.wortebuch.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/words")
public class WordController {
    private final WordService wordService;

    @PostMapping
    public boolean addWord(@RequestBody WordDto wordDto) {
        return wordService.addWord(wordDto);
    }

    @GetMapping("/find/{word}")
    public WordDto findWord(@PathVariable("word") String word) {
        return  wordService.findWord(word) ;
    }

    @GetMapping("/find")
    public List<WordDto> findAllWords() {
        return wordService.findAllWords() ;
    }

    @PatchMapping("/{word}")
    public WordDto updateWord(@PathVariable String word,@RequestBody WordDto wordDto) {
        return wordService.updateWord(word,wordDto) ;
    }

    @DeleteMapping("/{word}")
    public WordDto deleteWord(@PathVariable("word") String wordDto) {
        return wordService.deleteWord(wordDto) ;
    }

    @PostMapping("training")
    public void training(@RequestBody TrainingDto trainingDto) {
        wordService.training(trainingDto);

    }
}

