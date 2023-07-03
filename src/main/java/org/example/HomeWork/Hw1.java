package org.example.HomeWork;

import java.util.*;

public class Hw1 {
    public static void main(String[] args) {
        String text = "Россия идет вперед всей планеты. Планета — это не Россия.";
        String searchWord = "Россия";
        text = text.replaceAll("[-|–|—]|\\p{Punct}", " ");
        System.out.println(text);
        String[] array = text.split(("\\s+"));
        System.out.println(Arrays.toString(array));
        findSearchWord(searchWord, array);
    }

    /**
     * @apiNote Подсчет искогомого слова
     * @param searchWord искомое слово
     * @param array массив слов
     */
    private static void findSearchWord(String searchWord, String[] array) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : array) {
            if (s.toLowerCase().contains(searchWord.toLowerCase())) {
                map.putIfAbsent(s, 0);
                map.put(s, map.get(s) + 1);
            }
        }
        for (Map.Entry<String, Integer> entity : map.entrySet()) {
            System.out.println("Слово " + entity.getKey() + " встретилось в тексте: " + entity.getValue() + " раз(а)");
        }
    }
}
