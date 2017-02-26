package exercise.P06_Football_Team_Generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Team> teams = new TreeMap<>();
        while (true) {
            String[] input = console.readLine().split(";");
            if ("END".equals(input[0])) {
                break;
            }

            String command = input[0];

            switch (command){
                case "Add":
                    addPlayerToTeam(teams, input);
                    break;
                case "Remove":
                    removePlayer(teams, input);
                    break;
                case "Rating":
                    getRating(teams, input[1]);
                    break;
                default:
                    String newTeam = input[1];
                    teams.put(newTeam, new Team(newTeam));
                    break;
            }
        }
    }

    private static void removePlayer(TreeMap<String, Team> teams, String[] input) {
        String teamName = input[1];
        String playerNameR = input[2];
        try {
            if (teams.containsKey(teamName)) {
                teams.get(teamName).removePlayer(playerNameR);
            }
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void addPlayerToTeam(TreeMap<String, Team> teams, String[] input) {
        String inTeam = input[1];
        String playerNameA = input[2];
        double endurance = Double.parseDouble(input[3]);
        double sprint = Double.parseDouble(input[4]);
        double dribble = Double.parseDouble(input[5]);
        double passing = Double.parseDouble(input[6]);
        double shooting = Double.parseDouble(input[7]);
        if (teams.containsKey(inTeam)){
            try {
                Player player = new Player(playerNameA, endurance, sprint, dribble, passing, shooting);
                teams.get(inTeam).addPlayer(player);
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

        } else {
            System.out.printf("Team %s does not exist.%n", inTeam);
        }
    }

    private static void getRating(TreeMap<String, Team> teams, String ratingFor) {
        if (teams.containsKey(ratingFor)){
            System.out.println(teams.get(ratingFor));
        } else {
            System.out.printf("Team %s does not exist.%n", ratingFor);
        }
    }
}


