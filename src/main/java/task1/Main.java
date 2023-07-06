package task1;

import java.util.List;

import static common.ScannerUtils.scanListOfIntegers;
import static java.util.Collections.min;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.Collections.max;

public class Main {

  public static void main(String[] args) {
    List<Integer> integers = scanListOfIntegers();
    if (integers.isEmpty())
      return;

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