package ait.cohort55.wortebuch.dto.exeptions;

public class CanNotRegException extends RuntimeException {
  public CanNotRegException(String message) {
    super(message);
  }
}
