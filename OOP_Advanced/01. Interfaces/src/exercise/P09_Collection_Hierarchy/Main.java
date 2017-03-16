package exercise.P09_Collection_Hierarchy;

import exercise.P09_Collection_Hierarchy.interfaces.Addable;
import exercise.P09_Collection_Hierarchy.interfaces.Removable;
import exercise.P09_Collection_Hierarchy.interfaces.Usable;
import exercise.P09_Collection_Hierarchy.models.AddCollection;
import exercise.P09_Collection_Hierarchy.models.AddRemoveCollection;
import exercise.P09_Collection_Hierarchy.models.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Addable addable = new AddCollection();
        Removable removable = new AddRemoveCollection();
        Usable usable = new MyList();

        String[] input = console.readLine().split("\\s+");
        for (String element : input) {
            System.out.print(addable.add(element) + " ");
        }
        System.out.println();

        for (String element : input) {
            System.out.print(removable.add(element) + " ");
        }
        System.out.println();

        for (String element : input) {
            System.out.print(usable.add(element) + " ");
        }
        System.out.println();

        int lines = Integer.parseInt(console.readLine());

        for (int i = 0; i < lines; i++) {
            System.out.print(removable.remove() + " ");
        }
        System.out.println();

        for (int i = 0; i < lines; i++) {
            System.out.print(usable.remove() + " ");
        }
    }
}
