package common;

import java.util.List;
import java.util.Scanner;

import static common.ExceptionUtils.printException;
import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class ScannerUtils {

  public static List<Integer> scanListOfIntegers() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please provide list of integers separated by spaces:");
    String listOfIntegers = scanner.nextLine();
    List<Integer> integers;
    try {
      integers = stream(listOfIntegers.split(" "))
          .map(Integer::parseInt)
          .sorted()
          .collect(toList());
    } catch (NumberFormatException ex) {
      printException(
          "Provided input contains other characters then integers and spaces! Please try again.");
      return emptyList();
    }
    return integers;
  }
}