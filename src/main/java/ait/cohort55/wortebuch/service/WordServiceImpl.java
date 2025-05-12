package ait.cohort55.wortebuch.service;

import ait.cohort55.wortebuch.dao.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;



    }

