package task2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.ScannerUtils.scanListOfIntegers;

public class Main {

  private static final int THIRTEEN = 13;
  private static final int ONE_OCCURRENCE = 1;

  public static void main(String[] args) {
    List<Integer> integers = scanListOfIntegers();
    Map<Integer, Integer> mapOfPairs = new HashMap<>();

    for (int integer : integers) {
      if (mapOfPairs.containsKey(integer))
        mapOfPairs.put(integer, mapOfPairs.get(integer) + ONE_OCCURRENCE);
      else
        mapOfPairs.put(integer, ONE_OCCURRENCE);
    }

    mapOfPairs.forEach((integer, occurrences) -> {
      int pair = THIRTEEN - integer;
      if (integer <= THIRTEEN / 2 && mapOfPairs.containsKey(pair)) {
        int totalOccurrences = occurrences * mapOfPairs.get(pair);
        for (int i = 1; i <= totalOccurrences; i++)
          System.out.println(integer + " " + (THIRTEEN - integer));
      }
    });
  }
}