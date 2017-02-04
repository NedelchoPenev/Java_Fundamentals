package exercise;

import java.util.*;

public class P8_HandsOfCards {

    public static void main(String[] args) {

        Scanner console =  new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> map = new LinkedHashMap<>();
        List<Character> cardsValue = Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', '1', 'J', 'Q', 'K', 'A');
        List<Character> suits = Arrays.asList('C', 'D', 'H', 'S');

        while (true){
            String[] input = console.nextLine().trim().split(": ");
            if (input[0].equals("JOKER")){
                break;
            }
            String name = input[0];
            String[] cards = input[1].split(", ");

            if (!map.containsKey(name)){
                map.put(name, new HashSet<>());
            }
            for (int i = 0; i < cards.length; i++) {
                map.get(name).add(cards[i]);
            }
        }


        for (String nameOfPlayer : map.keySet()) {
            System.out.printf("%s: ", nameOfPlayer);
            HashSet<String> cardss = map.get(nameOfPlayer);
            int points = 0;
            for (String cr : cardss) {
                int cv = cardsValue.indexOf(cr.charAt(0)) + 2;
                int suitsPower = suits.indexOf(cr.charAt(cr.length() - 1)) + 1;
                points += cv * suitsPower;
            }
            System.out.println(points);
        }
    }
}
