package ait.cohort55.wortebuch.dao;

import ait.cohort55.wortebuch.dto.WordDto;
import ait.cohort55.wortebuch.model.Word;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WordRepository extends CrudRepository<Word, String> {
    Word findWordByOriginal(String original);

}
