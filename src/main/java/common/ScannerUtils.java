package common;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

import static common.ExceptionUtils.printException;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class ScannerUtils {

  public static List<Integer> scanListOfIntegers() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please provide list of integers separated by spaces:");
    String stringWithIntegers = scanner.nextLine();
    List<Integer> integers;
    try {
      integers = stream(stringWithIntegers.split(" "))
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

  public static Stack<List<Integer>> scanSetOfPairs() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please provide number of vertices pairs:");
    int numberOfPairs = parseInt(scanner.nextLine());
    Stack<List<Integer>> stackOfPairs = new Stack<>();
    System.out.println("Please provide " + numberOfPairs +
        " pairs of vertices separated by space. Every pair in new line:");
    for (int i = 0; i < numberOfPairs; i++) {
      String stringWithIntegers = scanner.nextLine();
      List<Integer> integers = stream(stringWithIntegers.split(" "))
          .map(Integer::parseInt)
          .collect(Collectors.toList());
      stackOfPairs.add(integers);
    }
    return stackOfPairs;
  }
}