package ait.cohort55.wortebuch.controller;
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
    public WordDto  addWord(@RequestBody WordDto wordDto) {
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

    @PatchMapping
    public WordDto updateWord(@RequestBody WordDto wordDto) {
        return wordService.updateWord(wordDto) ;
    }

    @DeleteMapping("/{word}")
    public WordDto deleteWord(@PathVariable("word") String wordDto) {
        return wordService.deleteWord(wordDto) ;
    }

    @PostMapping("/training")
    public List<WordDto> training(@RequestBody List<WordDto> wordsDto) {
        return wordService.training(wordsDto);

    }
    @PatchMapping("/training/result")
    public void updateAfterTraining(@RequestBody List<WordDto> wordsDto) {}
}

