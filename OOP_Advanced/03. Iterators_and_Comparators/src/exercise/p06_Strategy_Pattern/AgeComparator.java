package exercise.p06_Strategy_Pattern;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    public AgeComparator() {
    }

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getAge() - person2.getAge();
    }
}
