package zlatopolsky.chapter_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringExerciseClass {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = reader.readLine();
            System.out.println(getEvenCharsOfString(str));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        String one = "АРГЕНТИНА МАНИТ НЕГРА";
        String two = "ПОТ КАК ПОТОП";
        String three = "А РОЗА УПАЛА НА ЛАПУ АЗОРА";
        System.out.println(isPalindrome(one));
        System.out.println(isPalindrome(two));
        System.out.println(isPalindrome(three));
    }

    // 9.43. Дано слово s1. Получить слово s2, образованное нечетными буквами слова s1.
    // Возвращает строку с четными с точки зрения программирования символами,
    // т.к. первый индекс символа в строке четный - 0
    // но в представлении пользователя возвращается строка из нечетных символов
    private static String getEvenCharsOfString(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) {
            builder.append(str.charAt(i));
        }
        return builder.toString();
    }

    // 9.116. Проверить, является ли "перевертышем" (см. задачу 9.78) следующая
    // символьная строка после удаления из нее всех пробелов:
    //  а) АРГЕНТИНА МАНИТ НЕГРА;
    //  б) ПОТ КАК ПОТОП;
    //  в) А РОЗА УПАЛА НА ЛАПУ АЗОРА.
    private static boolean isPalindrome(String str) {
        String string = str.replaceAll(" ", "");
        return new StringBuilder(string).reverse().toString().equals(string);
    }
}
