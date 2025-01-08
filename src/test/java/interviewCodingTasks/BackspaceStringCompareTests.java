package interviewCodingTasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BackspaceStringCompareTests {
    //https://docs.google.com/document/d/1odwyexzXU4jWIl-cpo1z2NN-mqgSLfjN33ziTBO7lpg/edit?tab=t.0#heading=h.47vadxk8ih9g

    private static boolean compareStrings(String first, String second) {
        first = applyBackspace(first);
        second = applyBackspace(second);

        return first.equals(second);
    }

    private static String applyBackspace(String text) {
        while(text.contains("#")) {
            System.out.println("Before removal: " + text);
            int indexOfBackspace = text.indexOf("#");
            String start;
            if (indexOfBackspace != 0) {
                start = text.substring(0, indexOfBackspace - 1);
            } else {
                start = text.substring(0, indexOfBackspace);
            }
            String end = text.substring(indexOfBackspace + 1);
            text = start + end;
            System.out.println("After removal: " + text);
        }

        return text;
    }

    @Test
    void checkBackspace() {
        String res = applyBackspace("axx#bb#c");
        Assertions.assertEquals("axbc", res);
    }

    @Test
    void checkCompare() {
        Assertions.assertTrue(compareStrings("axx#bb#c", "axbd#c#c"));
        Assertions.assertFalse(compareStrings("axx#bb#c", "axbd##c#c"));
        Assertions.assertTrue(compareStrings("abc", "abc"));
        Assertions.assertTrue(compareStrings("###", "###"));
        Assertions.assertTrue(compareStrings("a###", "a###"));
    }
}
