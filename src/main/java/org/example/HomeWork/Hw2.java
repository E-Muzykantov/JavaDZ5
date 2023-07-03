package org.example.HomeWork;


import java.util.*;
import java.util.stream.Collectors;

public class Hw2 {

    public static void main(String[] args) {
        String[] array = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова",
                "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};
        String[] firstNames = new String[array.length];
        Scanner scan = new Scanner(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            firstNames[i] = scan.next().replaceAll("\\p{Punct}", "");
            scan.next();
        }
        scan.close();
        System.out.println("firstNames = " + Arrays.toString(firstNames));

        Map<String, Integer> map = new HashMap<>();
        for (String s : firstNames) {
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }

        map.entrySet().stream().sorted(Comparator.comparingInt(e -> -e.getValue())).forEach(((x) ->
                System.out.println("Имя " + x.getKey() + " встретилось в списке: " + x.getValue() + " раз(а)")));

        System.out.println("--------------ВТОРОЙ СПОСОБ----------------");

        Map<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        for (Map.Entry<String, Integer> entity : sortedMap.entrySet()) {
            System.out.println("Имя " + entity.getKey() + " встретилось в списке: " + entity.getValue() + " раз(а)");
        }
    }
}