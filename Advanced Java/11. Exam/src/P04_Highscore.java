import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class P04_Highscore {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, BigInteger> players = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedList<TreeMap<String, Integer>>> opponents = new LinkedHashMap<>();

        while (true) {
            String input = console.readLine();
            if ("osu!".equals(input)) {
                break;
            }

            String[] currentPoints = input.split("\\s+");
            String[] currentPlayers = currentPoints[1].split("<->");
            String playerOne = currentPlayers[0];
            int playerOnePoints = Integer.parseInt(currentPoints[0]);
            String playerTwo = currentPlayers[1];
            int playerTwoPoints = Integer.parseInt(currentPoints[2]);

            int result = Math.abs(playerTwoPoints - playerOnePoints);

            if (playerOnePoints > playerTwoPoints){
                playerOnePoints = result;
                playerTwoPoints = -result;
            } else {
                playerTwoPoints = result;
                playerOnePoints = -result;
            }

            if (players.containsKey(playerOne)){
                players.put(playerOne, players.get(playerOne).add(BigInteger.valueOf(playerOnePoints)));
            } else {
                players.put(playerOne, BigInteger.valueOf(playerOnePoints));
            }

            if (players.containsKey(playerTwo)){
                players.put(playerTwo, players.get(playerTwo).add(BigInteger.valueOf(playerTwoPoints)));
            } else {
                players.put(playerTwo, BigInteger.valueOf(playerTwoPoints));
            }

            opponents.putIfAbsent(playerOne, new LinkedList<>());
            opponents.putIfAbsent(playerTwo, new LinkedList<>());

            TreeMap<String, Integer> playerOneMap = new TreeMap<>();
            TreeMap<String, Integer> playerTwoMap = new TreeMap<>();

            playerOneMap.put(playerTwo, playerOnePoints);
            playerTwoMap.put(playerOne, playerTwoPoints);

            opponents.get(playerOne).add(playerOneMap);
            opponents.get(playerTwo).add(playerTwoMap);
        }

        players.entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .forEach(player -> {
                    System.out.printf("%s - (%d)%n", player.getKey(), player.getValue());
                    LinkedList<TreeMap<String, Integer>> op = opponents.get(player.getKey());
                    for (TreeMap<String, Integer> opponent : op) {
                        for (String name : opponent.keySet()) {
                            System.out.printf("*   %s <-> %d%n", name, opponent.get(name));
                        }

                    }
                });
    }
}
