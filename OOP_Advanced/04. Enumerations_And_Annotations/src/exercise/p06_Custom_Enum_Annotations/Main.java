package exercise.p06_Custom_Enum_Annotations;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console =  new Scanner(System.in);
        String info = console.nextLine();

        Class<Ranks> rank = Ranks.class;
        Class<Suits> suit = Suits.class;

        MyAnnotation annotationRank = rank.getAnnotation(MyAnnotation.class);
        MyAnnotation annotationSuit = suit.getAnnotation(MyAnnotation.class);

        System.out.println(
                annotationRank.category().equals(info) ?
                        "Type = " + annotationRank.type() + ", " +
                "Description = " + annotationRank.description() :
                        "Type = " + annotationSuit.type() + ", " +
                "Description = " + annotationSuit.description());
    }
}
