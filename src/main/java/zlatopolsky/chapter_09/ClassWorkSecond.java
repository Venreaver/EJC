package zlatopolsky.chapter_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Program displays solution for tasks 9.153 and 9.154 from Zlatopolsky book.
 *
 * @author Irina Vasileva
 */
public class ClassWorkSecond {
    public static void main(String[] args) {
        ClassWorkSecond classWorkSecond = new ClassWorkSecond();
        classWorkSecond.printSolution();
    }

    /**
     * Solution for tasks № 9.153, 9.154
     * <p>Successively Get input strings from console and print result in console for each task
     * <p>Task № 9.153: Дан текст. Найти наибольшее количество идущих подряд одинаковых символов.
     * <p>Task № 9.154: Дано слово. Определить, сколько различных букв в нем (латинский алфавит).
     */
    private void printSolution() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(getMaxLengthWithSameChars(reader.readLine()));
            System.out.println(countDifferentLatinLetters(reader.readLine()));
        } catch (IOException e) {
            System.err.println(ClassWorkFirst.ERROR + e.getMessage());
        }
    }

    /**
     * Count maximum length of a sequence of same symbols
     *
     * @param inputString represents input string
     * @return maximum length of a sequence of same symbols
     */
    private int getMaxLengthWithSameChars(String inputString) {
        int resultLength = 0;
        if (inputString != null) {
            int currentLength = 1;
            for (int i = 0, stringSize = inputString.length() - 1; i < stringSize; ++i) {
                if (inputString.charAt(i) == inputString.charAt(i + 1)) {
                    ++currentLength;
                    if (resultLength < currentLength) {
                        resultLength = currentLength;
                    }
                } else {
                    currentLength = 1;
                }
            }
        }
        return resultLength;
    }

    /**
     * Count number of different characters in string
     *
     * @param inputString represents input string
     * @return number of different characters in string
     */
    private int countDifferentLatinLetters(String inputString) {
        if (inputString != null) {
            inputString = inputString.replaceAll("[^a-zA-Z]", "");
            Set<Character> charsSet = new HashSet<>();
            for (int i = 0; i < inputString.length() - 1; ++i) {
                charsSet.add(inputString.charAt(i));
            }
            return charsSet.size();
        }
        return 0;
    }
}
