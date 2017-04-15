package exercise.p02_Kings_Gambit;

import exercise.p02_Kings_Gambit.concreteObservers.Footman;
import exercise.p02_Kings_Gambit.concreteObservers.RoyalGuard;
import exercise.p02_Kings_Gambit.subject.King;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String kingName = console.readLine();
        King king = new King(kingName);

        String[] royalGuardNames = console.readLine().split("\\s+");
        for (String royalGuardName : royalGuardNames) {
            king.addDefender(royalGuardName, new RoyalGuard(royalGuardName));
        }

        String[] footmanNames = console.readLine().split("\\s+");
        for (String footmanName : footmanNames) {
            king.addDefender(footmanName, new Footman(footmanName));
        }

        while (true) {
            String[] input = console.readLine().split("\\s+");
            if ("End".equals(input[0])) {
                break;
            }

            if (input[0].equals("Attack")){
                king.kingIsUnderAttack();
            } else if (input[0].equals("Kill")){
                String name = input[1];
                king.removeDefender(name);
            }
        }
    }
}
