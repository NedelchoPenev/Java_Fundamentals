package exercise.P06_Football_Team_Generator;

import java.util.*;

public class Team {

    private String name;
    private HashMap<String, Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new HashMap();
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.isEmpty() && name.trim().length() == 0){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private int getRating(){
        OptionalDouble rating = players.values().stream().mapToDouble(Player::getAverageSkill).average();
        if (rating.isPresent()){
            return (int) Math.round(rating.getAsDouble());
        }

        return 0;
    }

    public void addPlayer(Player player){
        this.players.put(player.getName(), player);
    }

    public void removePlayer(String name){
        if (players.containsKey(name)){
            players.remove(name);
        } else {
            throw new IllegalArgumentException(
                    String.format("Player %s is not in %s team.", name, this.getName()));
        }
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.getName(), this.getRating());
    }
}
