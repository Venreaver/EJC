package zlatopolsky.chapter_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The StringExerciseClass program implements an application that
 * displays solution for tasks 9.43 and 9.116 from Zlatopolsky book
 *
 * @author  Irina Vasileva
 */
public class StringExerciseClass {
    public static void main(String[] args) {
        // 9.43 task solution
        // Дано слово s1. Получить слово s2, образованное нечетными буквами слова s1.
        // метод getEvenCharsOfString возвращает строку
        // с четными с точки зрения программирования символами,
        // т.к. первый индекс символа в строке четный - 0
        // но в представлении пользователя возвращается строка из нечетных символов
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = reader.readLine();
            System.out.println(getEvenCharsOfString(str));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // 9.116 task solution
        // Проверить, является ли "перевертышем" следующая
        // символьная строка после удаления из нее всех пробелов:
        //  а) АРГЕНТИНА МАНИТ НЕГРА;
        //  б) ПОТ КАК ПОТОП;
        //  в) А РОЗА УПАЛА НА ЛАПУ АЗОРА.
        String stringFirst = "АРГЕНТИНА МАНИТ НЕГРА";
        String stringSecond = "ПОТ КАК ПОТОП";
        String stringThird = "А РОЗА УПАЛА НА ЛАПУ АЗОРА";
        System.out.println(isPalindrome(stringFirst));
        System.out.println(isPalindrome(stringSecond));
        System.out.println(isPalindrome(stringThird));
    }

    /**
     * This is the getEvenCharsOfString method which returns
     * String with only even characters from input String
     * @param inputString represents input string
     * @return String with even characters
     */
    private static String getEvenCharsOfString(String inputString) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < inputString.length(); i += 2) {
            builder.append(inputString.charAt(i));
        }
        return builder.toString();
    }

    /**
     * This is the isPalindrome method which returns
     * boolean whether the string is a palindrome
     * @param inputString represents input string
     * @return boolean whether the string is a palindrome
     */
    private static boolean isPalindrome(String inputString) {
        String stringWithoutSpaces = inputString.replaceAll(" ", "");
        return new StringBuilder(stringWithoutSpaces).reverse().toString().equals(stringWithoutSpaces);
    }
}
