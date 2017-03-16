package exercise.P08_Military_Elite;

import exercise.P08_Military_Elite.interfaces.iSoldier;
import exercise.P08_Military_Elite.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<iSoldier> soldiers = new LinkedList<>();
        HashMap<Integer, Private> privates = new HashMap<>();
        while (true) {
            String[] split = console.readLine().split("\\s+");
            if ("End".equals(split[0])) {
                break;
            }

            String rank = split[0];

            switch (rank){
                case "Private":
                    putPrivate(privates, soldiers, split);
                    break;
                case "Engineer":
                    putEngineer(soldiers, split);
                    break;
                case "Commando":
                    putCommando(soldiers, split);
                    break;
                case "LeutenantGeneral":
                    addLeutenant(soldiers, privates, split);
                    break;
                case "Spy":
                    putSpy(soldiers, split);
                    break;
            }
        }

        soldiers.forEach(System.out::print);
    }

    private static void addLeutenant(LinkedList<iSoldier> soldiers, HashMap<Integer, Private> privates, String[] split) {
        int id = Integer.parseInt(split[1]);
        String firsName = split[2];
        String lastName = split[3];
        double salary = Double.parseDouble(split[4]);
        LeutenantGeneral leutenantGeneral = new LeutenantGeneral(id, firsName, lastName, salary);
        for (int i = 5; i < split.length; i++) {
            int privateId = Integer.parseInt(split[i]);
            if (privates.containsKey(privateId)){
                leutenantGeneral.addPrivate(privates.get(privateId));
            }
        }

        soldiers.add(leutenantGeneral);
    }

    private static void putCommando(LinkedList<iSoldier> soldiers, String[] split) {
        int id = Integer.parseInt(split[1]);
        String firsName = split[2];
        String lastName = split[3];
        double salary = Double.parseDouble(split[4]);
        String corp = split[5];
        try {
            Commando commando = new Commando(id,firsName, lastName, salary, corp);
            for (int i = 6; i < split.length; i+=2) {
                String name = split[i];
                String status = split[i + 1];
                try {
                    commando.addMission(name, new Mission(name, status));
                } catch (IllegalArgumentException ex){

                }
            }
            soldiers.add(commando);
        } catch (IllegalArgumentException ex){

        }

    }

    private static void putEngineer(LinkedList<iSoldier> soldiers, String[] split) {
        int id = Integer.parseInt(split[1]);
        String firsName = split[2];
        String lastName = split[3];
        double salary = Double.parseDouble(split[4]);
        String corp = split[5];
        try {
            Engineer engineer = new Engineer(id, firsName, lastName, salary, corp);
            for (int i = 6; i < split.length; i += 2) {
                String part = split[i];
                int hours = Integer.parseInt(split[i + 1]);
                engineer.addRepiredThing(new Repaired(part, hours));
            }

            soldiers.add(engineer);
        } catch (IllegalArgumentException ex){

        }
    }

    private static void putSpy(LinkedList<iSoldier> soldiers, String[] split) {
        int id = Integer.parseInt(split[1]);
        String firsName = split[2];
        String lastName = split[3];
        int codeNumber = Integer.parseInt(split[4]);
        soldiers.add(new Spy(id, firsName, lastName, codeNumber));
    }

    private static void putPrivate(
            HashMap<Integer, Private> privates, LinkedList<iSoldier> soldiers, String[] split) {
        int id = Integer.parseInt(split[1]);
        String firsName = split[2];
        String lastName = split[3];
        double salary = Double.parseDouble(split[4]);
        soldiers.add(new Private(id, firsName, lastName, salary));
        privates.put(id, new Private(id, firsName, lastName, salary));
    }
}
