package interviewCodingTasks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TopSymbolsTests {

    /*
    Нужно вернуть топ 3 символа по количеству вхождений в строку, если в топ 3 попадут несколько символов с одинаковым
    количеством вхождений - вернуть их все.
    Пример, abbcccdddd -> abc; abcd -> abcd (у всех 4-х символов одинаковый вес, они все топ 1)
     */

    public static String findMostFrequentChars(String input) {
        if (input == null) {
            return "There are null value!";
        }
        if (input.isEmpty()) {
            return "There are 0 length!";
        }
        Comparator<Integer> reverseComparator = Collections.reverseOrder();
        Map<Integer, String> treeMap = new TreeMap<>(reverseComparator);

        boolean completed = false;
        while (!completed) {
            char symbol = input.charAt(0);
            int initialSize = input.length();
            input = input.replace(String.valueOf(symbol), "");
            int afterRemoveSize = input.length();
            int count = initialSize - afterRemoveSize;
            System.out.println("Char " + symbol + " has occurences " + count + "!");
            if (afterRemoveSize == 0) {
                completed = true;
            }
            treeMap.put(count, treeMap.getOrDefault(count, "") + symbol);
        }
        int maxOccurences = 3;
        int currentOccurences = 0;
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue() + ", Length: " + entry.getValue().length());
            currentOccurences += entry.getValue().length();
            result.append(entry.getValue());
            if (currentOccurences >= maxOccurences) {
                break;
            }
        }
        return String.valueOf(result);
    }

    public static String findMostFrequentCharsViaStream(String input) {
        if (input == null) {
            return "There are null value!";
        }
        if (input.isEmpty()) {
            return "There are 0 length!";
        }
        List<String> list = Arrays.stream(input.split("")).toList();

        List<String> result = list.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.groupingBy(me -> me.getValue(), Collectors.toList()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getValue)
                .flatMap(lst -> lst.stream().map(Map.Entry::getKey))
                .toList();

        System.out.println(result);
        return result.toString();
    }



    @Test
    void testRun() {
        findMostFrequentChars("abbcccdddd");
        findMostFrequentCharsViaStream("abbcccdddd");
    }
}
