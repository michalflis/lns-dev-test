package common;

public class ExceptionUtils {

  private static final String RED_COLOR = "\u001B[31m";
  private static final String RESET_COLOR = "\u001B[0m";

  public static void printException(String message) {
    System.out.println(RED_COLOR + message + RESET_COLOR);
  }
}