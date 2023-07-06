package task1;

import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.stream;
import static java.util.Collections.min;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.Collections.max;

public class Main {
  private static final String RED_COLOR = "\u001B[31m";
  private static final String RESET_COLOR = "\u001B[0m";

  public static void main(String[] args) {
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
      System.out.println(RED_COLOR +
          "Provided input contains other characters then integers and spaces! Please try again."
          + RESET_COLOR);
      return;
    }

    List<Integer> distinctIntegers = integers
        .stream()
        .distinct()
        .collect(toList());

    String outputString = distinctIntegers
        .stream()
        .map(String::valueOf)
        .collect(joining(" "));

    String output = String.format(
        "%s \ncount: %d \ndistinct: %d \nmin: %d \nmax: %d",
        outputString,
        integers.size(),
        distinctIntegers.size(),
        min(distinctIntegers),
        max(distinctIntegers));

    System.out.println(output);
  }
}
