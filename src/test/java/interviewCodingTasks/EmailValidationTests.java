package interviewCodingTasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailValidationTests {
    //https://docs.google.com/document/d/1odwyexzXU4jWIl-cpo1z2NN-mqgSLfjN33ziTBO7lpg/edit?tab=t.0#heading=h.2zopjy7v00r4
    private static boolean validate(String email) {
        if (!email.contains("@")) {
            System.out.println("The string must contain @ character.");
            return false;
        }
        if (!email.contains(".")) {
            System.out.println("The string must contain . character.");
            return false;
        }
        if (email.indexOf("@") == 0) {
            System.out.println("The @ must have at least one character in front of it.");
            return false;
        }
        if (email.indexOf("@") > lastIndexOfDot(email)) {
            System.out.println("The . and @ must be in the appropriate places.");
            return false;
        }
        return true;
    }

    private static int lastIndexOfDot(String email) {
        int index = -1;
        int count = -1;
        while (email.contains(".")) {
            index = email.indexOf(".");
            String begin = email.substring(0, index);
            String end = email.substring(index + 1);
            email = begin + end;
            count++;
        }
        return index + count;
    }

    @Test
    void test() {
        Assertions.assertTrue(validate("gena@gmail.com"));
        Assertions.assertFalse(validate("genagmail.com"));
        Assertions.assertFalse(validate("gena@gmailcom"));
        Assertions.assertFalse(validate("@gmail.com"));
        Assertions.assertFalse(validate("gena.chursov@gmailcom"));
    }

    @Test
    void testIndex() {
        int index = lastIndexOfDot("1.@gmail.com");
        System.out.println(index);
    }
}
