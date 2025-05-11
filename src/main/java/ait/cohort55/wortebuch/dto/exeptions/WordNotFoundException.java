package ait.cohort55.wortebuch.dto.exeptions;

public class WordNotFoundException extends RuntimeException {
    public WordNotFoundException(String message) {
        super(message);
    }
}
