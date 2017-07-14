package zlatopolsky.chapter_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Program displays solution for tasks 9.43 and 9.116 from Zlatopolsky book.
 *
 * @author Irina Vasileva
 */
public class ClassWorkFirst {
    static final String ERROR = "Error: ";
    private static final String GAP = " - ";
    private static final String PALINDROME = "палиндром";
    private static final String NOT_PALINDROME = "не палиндром";

    public static void main(String[] args) {
        ClassWorkFirst classWorkFirst = new ClassWorkFirst();
        classWorkFirst.printOddChars();
        classWorkFirst.printPalindromeInfo();
    }

    /**
     * Get input string from console and print in console odd characters from user's input string
     * <p>Task № 9.43: Дано слово s1. Получить слово s2, образованное нечетными буквами слова s1.</p>
     * <p>Замечание: метод getEvenCharsOfString возвращает строку
     * с четными с точки зрения программирования символами, т.к. первый индекс символа в строке четный - 0,
     * но в представлении пользователя возвращается строка из нечетных символов</p>
     */
    private void printOddChars() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(getEvenCharsOfString(reader.readLine()));
        } catch (IOException ex) {
            System.err.println(ERROR + ex.getMessage());
        }
    }

    /**
     * Print in console input string with info whether input string is a palindrome
     * <p>Task № 9.116: Проверить, является ли "перевертышем" следующая
     * символьная строка после удаления из нее всех пробелов:</p>
     * <p>а) АРГЕНТИНА МАНИТ НЕГРА;</p>
     * <p>б) ПОТ КАК ПОТОП;</p>
     * <p>в) А РОЗА УПАЛА НА ЛАПУ АЗОРА;</p>
     */
    private void printPalindromeInfo() {
        String testPalindromeString = "АРГЕНТИНА МАНИТ НЕГРА";
        System.out.println(testPalindromeString + GAP + (isPalindrome(testPalindromeString) ? PALINDROME : NOT_PALINDROME));
        testPalindromeString = "ПОТ КАК ПОТОП";
        System.out.println(testPalindromeString + GAP + (isPalindrome(testPalindromeString) ? PALINDROME : NOT_PALINDROME));
        testPalindromeString = "А РОЗА УПАЛА НА ЛАПУ АЗОРА";
        System.out.println(testPalindromeString + GAP + (isPalindrome(testPalindromeString) ? PALINDROME : NOT_PALINDROME));
    }

    /**
     * Get string with only even characters from input string.
     *
     * @param inputString represents input string
     * @return string with even characters
     */
    private String getEvenCharsOfString(String inputString) {
        if (inputString != null) {
            StringBuilder evenCharsOfString = new StringBuilder();
            for (int i = 0; i < inputString.length(); i += 2) {
                evenCharsOfString.append(inputString.charAt(i));
            }
            return evenCharsOfString.toString();
        }
        return "";
    }

    /**
     * Find out whether the string is a palindrome.
     *
     * @param inputString represents input string
     * @return true if input string is palindrome otherwise false
     */
    private boolean isPalindrome(String inputString) {
        inputString = inputString.replaceAll(" ", "");
        return new StringBuilder(inputString).reverse().toString().equals(inputString);
    }
}
